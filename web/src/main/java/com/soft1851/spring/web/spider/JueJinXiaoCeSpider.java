package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Brochure;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName JueJinXiaoCeSpider
 * @Description TODO
 * @date 2020-03-27 17:50
 **/
public class JueJinXiaoCeSpider {
    private static final Integer SUCCESS = 200;

    public static List<Brochure> getBrochure(int page) {
        List<Brochure> brochures = new ArrayList<>();
        String url = "https://xiaoce-timeline-api-ms.juejin.im/v1/getListByLastTime?uid=5dc985d9f265da4d2b350fa9&client_id=1585185008570&token=eyJhY2Nlc3NfdG9rZW4iOiJpNlBwdHI1SE91dldtZmcyIiwicmVmcmVzaF90b2tlbiI6IjNTRjk2NEJLbE5VZ3o1azgiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&alias=&pageNum=" + page;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        HttpClientContext context = HttpClientContext.create();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get, context);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        此处已经测通   HTTP/1.1 200 OK
//        System.out.println(response.getStatusLine());


        if (response.getStatusLine().getStatusCode() == SUCCESS) {
            HttpEntity entity = response.getEntity();
            //内容类型
//            System.out.println("***************************" + entity.getContentType());
            String res = null;
            try {
                res = EntityUtils.toString(entity, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
//            将字符串转为JSON对象
            JSONObject jsonObject = JSONObject.parseObject(res);
//            System.out.println(jsonObject);

            JSONArray list = jsonObject.getJSONArray("d");
            String msg = jsonObject.getString("m");
            if ("ok".equals(msg)) {
                list.forEach(o -> {
                    JSONObject json = JSONObject.parseObject(o.toString());

                    Brochure brochure = Brochure.builder()
                            .title(json.getString("title"))
                            .desc(json.getString("desc"))
                            .userName(JSONObject.parseObject(json.get("userData").toString()).getString("username"))
                            .profile(json.getString("profile"))
                            .price(json.getDouble("price"))
                            .lastSectionCount(json.getInteger("lastSectionCount"))
                            .buyCount(json.getInteger("buyCount"))
                            .cover(json.getString("img"))
                            .avatar(JSONObject.parseObject(json.get("userData").toString()).getString("avatarLarge"))
                            .build();
                    brochures.add(brochure);
                    System.out.println(brochure);
                });
            }
        } else {
            System.out.println("请求失败");
        }
        try {
            response.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return brochures;
    }

    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 5; i++) {
            System.out.println(getBrochure(i));
        }
    }
}

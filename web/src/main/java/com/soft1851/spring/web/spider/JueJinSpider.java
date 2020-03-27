package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Topic;
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
 * @ClassName JueJinSpider
 * @Description TODO
 * @date 2020-03-27 12:44
 **/
public class JueJinSpider {
    private static final Integer SUCCESS = 200;

    public static List<Topic> getTopics(){
        List<Topic> topics = new ArrayList<>();
        //目标地址
        String url = "https://short-msg-ms.juejin.im/v1/topicList?uid=5dc985d9f265da4d2b350fa9&device_id=1585185008570&token=eyJhY2Nlc3NfdG9rZW4iOiJpNlBwdHI1SE91dldtZmcyIiwicmVmcmVzaF90b2tlbiI6IjNTRjk2NEJLbE5VZ3o1azgiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&sortType=hot&page=0&pageSize=100";
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建get对象
        HttpGet get = new HttpGet(url);
        //创建context对象
        HttpClientContext context = HttpClientContext.create();
        //创建response对象
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get,context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 测试输出状态行
        // System.out.println(response.getStatusLine());

        //如果请求成功，则获取网页源码
        if(response.getStatusLine().getStatusCode() == SUCCESS){
            //获取相应对象实体，并转换成UTF-8字符串
            HttpEntity entity = response.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(res);


            JSONObject jsonObject = JSONObject.parseObject(res);
            JSONArray list = jsonObject.getJSONObject("d").getJSONArray("list");
            list.forEach(o ->{
                JSONObject json = JSONObject.parseObject(o.toString());
                Topic topic = Topic.builder()
                        .id(json.getString("objectId"))
                        .topicName(json.getString("title"))
                        .topicIcon(json.getString("icon"))
                        .description(json.getString("description"))
                        .msgCount(json.getInteger("msgsCount"))
                        .followersCount(json.getInteger("followersCount"))
                        .followed(json.getBoolean("followed"))
                        .build();
                topics.add(topic);
            });
        }else {
            System.out.println("请求失败");
        }
        try {
            response.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return topics;
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(getTopics());
        getTopics();
    }
}

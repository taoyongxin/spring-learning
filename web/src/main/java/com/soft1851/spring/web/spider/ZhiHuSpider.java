package com.soft1851.spring.web.spider;

import com.soft1851.spring.web.entity.HotList;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName ZhiHuSpider
 * @Description TODO
 * @date 2020-03-27 22:29
 **/
public class ZhiHuSpider {
    private static final Integer SUCCESS = 200;

    public  static List<HotList> getHotList(){
        List<HotList> lists = new ArrayList<>();
        String userAgent = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Mobile Safari/537.36";
        String url = "https://www.zhihu.com/special/all";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            Thread.sleep(2000);
            HttpGet httpget  =new HttpGet(url);
            httpget.setHeader("User-Agent",userAgent);
            HttpClientContext context = HttpClientContext.create();
            CloseableHttpResponse response = httpClient.execute(httpget,context);
//            System.out.println(response.getStatusLine().getStatusCode());
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == SUCCESS){
                HttpEntity entity = response.getEntity();
                if(entity != null){
                    String res = EntityUtils.toString(entity);
                    System.out.println(res);
                    Document document = Jsoup.parse(res);
//                    System.out.println(document);

                    Elements elements = document.getElementsByClass("SpecialListCard SpecialListPage-specialCard");
//                    System.out.println("*************"+elements.size());
                    int i = 0;
                    for (Element element : elements){
                        Element bodyEle = element.child(1);
                        int id = i++;
                        String title = bodyEle.select(".SpecialListCard-title").text();
                        Element relatedInfoEle = bodyEle.child(0).child(0).child(1);
                        String releaseTime = relatedInfoEle.child(0).text();
                        String visits = relatedInfoEle.child(1).text();
                        String brief = bodyEle.child(1).text();
                        Element img = element.child(0).child(0);
                        String picture = img.attr("src");
                        HotList hotList = HotList.builder()
                                .id(id)
                                .title(title)
                                .releaseTime(releaseTime)
                                .visits(visits)
                                .brief(brief)
                                .picture(picture)
                                .build();
                        lists.add(hotList);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    public static void main(String[] args) throws Exception{
//        for (HotList hotList:getHotList()){
//            System.out.println(hotList);
//        }
        getHotList();
    }
}

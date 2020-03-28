package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.soft1851.spring.web.entity.Rank;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tao
 */
public class BiLiBiLiSpider {
    private static final Integer SUCCESS = 200;

    /**
     *
     * @throws Exception
     */
    public  static void getItems() throws  Exception{
        WebClient webClient =new WebClient(BrowserVersion.BEST_SUPPORTED);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.waitForBackgroundJavaScript(600*1000);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        HtmlPage page=webClient.getPage("https://list.jd.com/list.html?cat=9987,653,655");
        List<HtmlDivision> divs=page.getByXPath("//div[@id='plist']//ul//li[@class='gl-item']//div[@class='gl-i-wrap j-sku-item']");
        for (HtmlDivision div:divs){
            DomNodeList<DomNode> childs=div.getChildNodes();
            String name="";
            String price="";
            String comments="";
            for (DomNode dn:childs){
                NamedNodeMap map=dn.getAttributes();
                Node node =map.getNamedItem("class");
                if(node !=null){
                    String value=node.getNodeValue();
                    if(value.contains("p-name")){
                        name=dn.asText();
                    }else if(value.contains("p-price")){
                        price =dn.asText();
                    }else if(value.contains("p-commit")){
                        comments=dn.asText();
                    }
                }
            }
            System.out.println(name + "//" + price + "//" + comments);
        }
    }

    public static List<Rank> getRanks(){
        List<Rank> ranks = new ArrayList<>();
        String userAgent = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Mobile Safari/537.36";
        String url = "https://www.bilibili.com/ranking?spm_id_from=333.158.b_7072696d61727950616765546162.3";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            Thread.sleep(4000);
            HttpGet httpget  =new HttpGet(url);
            httpget.setHeader("User-Agent",userAgent);
            HttpClientContext context = HttpClientContext.create();
            CloseableHttpResponse response = httpclient.execute(httpget,context);
            int statusCode = response.getStatusLine().getStatusCode();

            if(statusCode == SUCCESS){
                HttpEntity entity = response.getEntity();
                if(entity != null){
                    String res = EntityUtils.toString(entity);
                    Document document = Jsoup.parse(res);
                    Elements scripts=document.getElementsByTag("script");
//                    System.out.println(scripts.size());

                    String wholeData=scripts.get(5).html();
//                    System.out.println("*********************************"+wholeData+"*****************************");
                    String data=wholeData.substring(wholeData.indexOf("rankList")+10,wholeData.indexOf("rankRouteParams")-2);
                    JSONArray jsonArray=JSONArray.parseArray(data);
                    jsonArray.forEach(o -> {
                        JSONObject json=JSONObject.parseObject(o.toString());
                        Rank rank =Rank.builder()
                                .title(json.getString("title"))
                                .author(json.getString("author"))
                                .pic(json.getString("pic"))
                                .duration(json.getString("duration"))
                                .build();
                        ranks.add(rank);
                    });
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ranks;
    }



    public static void main(String[] args) throws Exception {
//        for (Rank rank : getRanks()) {
//            System.out.println(rank);
//        }
//        getRanks();
        getItems();
    }

}


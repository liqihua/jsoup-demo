import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

/**
 * @author liqihua
 * @date 2021/7/13
 *
 */
public class Test1 {

    public static void main(String[] args) throws IOException {
        String url = "https://search.jd.com/Search?keyword=java";
        Document document = Jsoup.parse(new URL(url), 10000);
        //
        Element element = document.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");
        for(Element e : elements) {
            System.out.println("============================================");
            if(e.attr("class").equalsIgnoreCase("gl-item")) {
                String img = e.getElementsByTag("img").eq(0).attr("data-lazy-img");
                String name = e.getElementsByClass("p-name").eq(0).text();
                String price = e.getElementsByClass("p-price").eq(0).text();
                String detail = e.getElementsByClass("p-name").get(0).getElementsByTag("a").eq(0).attr("href");
                System.out.println(img);
                System.out.println(name);
                System.out.println(price);
                System.out.println(detail);
            }
        }

    }

}


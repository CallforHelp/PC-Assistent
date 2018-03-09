package prototype;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;


/**
 * 
 * @author AmazingCode.de
 *
 */

public class Login2 {
	
	public static String loginAndGetHTML() throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String html = "";
		
		HttpPost httpPost = new HttpPost("http://tutorials.amazingcode.de/login/");
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("username", "admin"));
		nvps.add(new BasicNameValuePair("password", "1234"));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		httpPost.addHeader("Referer", "http://tutorials.amazingcode.de/login/index.php");
		httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:28.0) Gecko/20100101 Firefox/28.0");
		CloseableHttpResponse response = httpclient.execute(httpPost);

		try {
		    HttpEntity entity = response.getEntity();
		    html = EntityUtils.toString(entity);
		    EntityUtils.consume(entity);
		} finally {
		    response.close();
		}
		
		if(html.contains("Falsche Nutzerdaten")) {
			throw new Exception("Login fehlgeschlagen");
		}
		
		return html;
	}
	
	public static String parseHTML(String html) throws Exception {
		//Document doc = Jsoup.parse(html);
		//String zahl = doc.getElementById("zahl").text();
		return "zahl";
	}
	
	public static void main(String[] args) {
		try {
			String html = loginAndGetHTML();
			
			String zahl = parseHTML(html);
			System.out.println(html);
			System.out.println(zahl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

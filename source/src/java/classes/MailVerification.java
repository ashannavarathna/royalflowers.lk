package classes;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MailVerification {

    HttpClient client = new DefaultHttpClient();
    String Email = "ashanzero@gmail.com";
    String ApiKey = "your API key";
    String APIURL = "http://api.email-validator.net/api/verify";

    public void validate() {
        try {
            HttpPost request = new HttpPost(APIURL);
            List<NameValuePair> Input = new ArrayList<NameValuePair>();
            Input.add(new BasicNameValuePair("EmailAddress", Email));
            Input.add(new BasicNameValuePair("APIKey", ApiKey));
            request.setEntity(new UrlEncodedFormEntity(Input));
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            String Output = EntityUtils.toString(entity, "UTF-8");
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(Output);
            JSONObject jsonObject = (JSONObject) obj;
            String result = (String) jsonObject.get("status");
            // result code 200, 207, 215 - valid
            // result code 114 - greylisting, wait 5min and retry
            // result code 118 - api rate limit, wait 5min and retry
            // result code 3xx/4xx - bad
            String info = (String) jsonObject.get("info");
            String details = (String) jsonObject.get("details");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.getConnectionManager().shutdown();
        }
    }

}

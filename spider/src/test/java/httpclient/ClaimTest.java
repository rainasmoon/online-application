package httpclient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClaimTest {

    private static Logger log = LoggerFactory.getLogger(ClaimTest.class);

    @Test
    public void test() throws IOException {
        URL postUrl = new URL("http://10.196.21.31:6901/CarClaimQueryService");

        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "text/xml");
        connection.connect();

        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        String content = "<?xml version=\"1.0\" encoding=\"GBK\"?>" + "<PACKET>" + "<HEAD>" + "  <TRANSRNO>1508725524980</TRANSRNO>" + "  <REQUESTCODE>CX01</REQUESTCODE>" + "</HEAD>" + "<BODY>" + "  <CASENO>173160030523</CASENO>" + "  <THIRDPOLICYID></THIRDPOLICYID>" + "  <BIZPOLICYID></BIZPOLICYID>" + "</BODY>" + "</PACKET>";
        out.writeBytes(URLEncoder.encode(content, "GBK"));
        out.flush();
        out.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GBK"));
        String line = reader.readLine();
        while (line != null) {
            log.info(":" + line);
            line = reader.readLine();
        }

        reader.close();
        connection.disconnect();

    }
}

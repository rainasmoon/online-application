package com.rainasmoon.weixin;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClient {

	/**
	 * post
	 * 
	 * @param url
	 * @param requestXml
	 * @return
	 * @throws Exception
	 */
	public static String httpclientpost(String url, String param, int requestType) throws Exception {
		String responseXml = "";
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost(url);
		try {
			byte[] sendBuffer = param.getBytes("UTF-8");
			ByteArrayEntity sendContent = new ByteArrayEntity(sendBuffer);
			if (requestType == 1) {
				sendContent.setContentType("text/xml");
			} else {
				sendContent.setContentType("application/json");
			}

			sendContent.setContentEncoding("UTF-8");
			httppost.setEntity(sendContent);

			CloseableHttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseXml = EntityUtils.toString(entity, "UTF-8");
			}
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			httpclient.close();
		}
		return responseXml;
	}

	/**
	 * 下载文件
	 * 
	 * @param url
	 *            http://www.xxx.com/img/333.jpg
	 * @param fileName
	 *            xxx.jpg/xxx.png/xxx.txt
	 * 
	 * 
	 */
	public static byte[] getFileStreamPost(String url, String jsonStr) {
		// 生成一个httpclient对象
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost(url);
		InputStream in = null;
		byte[] buffer = new byte[1024 * 1024 * 10];
		byte[] sendBuffer;

		try {
			sendBuffer = jsonStr.getBytes("UTF-8");
			ByteArrayEntity sendContent = new ByteArrayEntity(sendBuffer);

			sendContent.setContentEncoding("UTF-8");
			httppost.setEntity(sendContent);
			CloseableHttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			in = entity.getContent();

			int count = 0;
			int len = -1;
			while ((len = in.read(buffer, count, 1024)) != -1) {
				count += len;

			}

			in.close();
			response.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return buffer;

	}

}
package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class WebToolKit {

	private static final String USER_AGENT_PROPERTY = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36";
	private static final String USER_AGENT = "User-Agent";

	public static String getPageCode(String siteURL) throws IOException{
		URL url = new URL(siteURL);
		URLConnection connection = url.openConnection();
		connection.addRequestProperty(USER_AGENT, USER_AGENT_PROPERTY);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
		String inputLine;
		StringBuilder code = new StringBuilder();
		while ((inputLine = buffer.readLine()) != null){
			code.append(inputLine);
		}
		buffer.close();
		return code.toString();
	}
}
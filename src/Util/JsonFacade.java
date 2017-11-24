package Util;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

public class JsonFacade {
	public static String makeJSon(HttpServletRequest request) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append('\n');
			}
		} finally {
			reader.close();
		}
		
		return sb.toString();
	}

	public static String ToJSon(Object lista) {
		Gson gson = new Gson();
		String json = gson.toJson(lista);

		return json;
	}

	@SuppressWarnings("unchecked")
	public static <T> T FromJson(String json, Object obj) {
		Gson gson = new Gson();

		return (T) gson.fromJson(json, obj.getClass());
	}
}
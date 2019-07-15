package ljtao.javase.http;

import java.awt.font.GlyphJustificationInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import com.alibaba.fastjson.JSON;

/**
 * 测试HttpURLConnection 用法，连接servlet，传递参数
 * @author ljtao3
 *
 */
public class TestHttpConnection {
	public static void main(String[] args) {
		Map<String,Object> map=new HashMap<>();
		String[] obj=new String[3];
		map.put("id", 2);
		map.put("provinceId", 1);
		map.put("cityName", "揭阳市");
		map.put("description", "人很多..");
		String json = JSON.toJSONString(map);
		fun2("http://localhost:8081/api/city/","PUT",json);
	}
	//eos官方提供对接BIZ的方法
	public static void fun1(){
		String urlStr="http://127.0.0.1:8080/default/com.vpuls.oacallmodular.businessOpportunityComponent.createGroupWithUser.biz.ext";
		String response="";
		String brLine="";
		OutputStreamWriter out=null;
		BufferedReader br=null;
		HttpURLConnection conn=null;
		String json="";
		try {
		URL url=new URL(urlStr);
		conn=(HttpURLConnection) url.openConnection();
		conn.setRequestProperty("user-agent", "mozilla/4.7 [en] (win98; i)");
		conn.setRequestProperty("X-Forwarded-For", "127.0.0.1");
		conn.setConnectTimeout(300000);
		conn.setReadTimeout(300000);
		conn.setRequestMethod("POST");
		conn.setUseCaches(false);
		conn.setDoOutput(true);
		conn.setDoInput(true);
		out = new OutputStreamWriter(conn.getOutputStream());
		//不能传递json数据，只能按照下面这样传递
		out.write("groupName=aaaa");
		out.flush();
		out.close();
		br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while((brLine=br.readLine())!=null){
			response=(new StringBuilder(String.valueOf(response))).append(brLine).toString();
		}
		System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn.disconnect();
		}
		
	}
	//网上寻找资料，改写对接BIZ的方法
	public static void fun2(String urlStr,String method,String jsonData){
		String response="";
		String brLine="";
		OutputStreamWriter out=null;
		BufferedReader br=null;
		HttpURLConnection conn=null;
		String json="";
		try {
		URL url=new URL(urlStr);
		conn=(HttpURLConnection) url.openConnection();
		conn.setUseCaches(false);
		conn.setDoOutput(true);
		conn.setDoInput(true);
	    conn.setRequestMethod(method);
//	    conn.setConnectTimeout(300000);
//		conn.setReadTimeout(300000);
	    conn.setRequestProperty("Connection", "Keep-Alive");//设置长连接
        conn.setRequestProperty("Charset", "UTF-8");
        conn.setRequestProperty("Content-Type","application/json; charset=UTF-8");
        conn.setRequestProperty("accept","application/json");

		
		out = new OutputStreamWriter(conn.getOutputStream());
		
		/*
		{
			"param":"test",
			"users":[{
			"id":1,
			"username":"jack"
			},{
			"id":2,
			"username":"jack2"
			}]
			}
		 */
		out.write(jsonData.toString());
		out.flush();
		out.close();
		br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while((brLine=br.readLine())!=null){
			response=(new StringBuilder(String.valueOf(response))).append(brLine).toString();
		}
		System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn.disconnect();
		}
		
	}
	//网上HttpURLConnection连接servlet传递json数据方法
	public static String fun3() {
		String urlPath="http://127.0.0.1:8080/default/com.vpuls.oacallmodular.businessOpportunityComponent.createGroupWithUser.biz.ext";
		String Json ="{\"groupName\":\"222\"}";
		
        // HttpClient 6.0被抛弃了
        String result = "";
        BufferedReader reader = null;
        try {
            URL url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            // 设置文件类型:
            conn.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            // 设置接收类型否则返回415错误
            //conn.setRequestProperty("accept","*/*")此处为暴力方法设置接受所有类型，以此来防范返回415;
          conn.setRequestProperty("accept","application/json");
            // 往服务器里面发送数据
            
            byte[] writebytes = Json.getBytes();
            // 设置文件长度
            conn.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
            OutputStream outwritestream = conn.getOutputStream();
            outwritestream.write(Json.getBytes());
            outwritestream.flush();
            outwritestream.close();
            
            if (conn.getResponseCode() == 200) {
                reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                result = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
	public static  void fun4(){
		Map<String,Object> map=new HashMap<>();
		String[] obj=new String[3];
		obj[0]="G0700419";
		obj[1]="G3060137";
		obj[2]="G0107199";
		map.put("userCodes", obj);
		map.put("userCode", "G0700419");
		map.put("gooupId", 286);
		String json = JSON.toJSONString(map);
		
		System.out.println(json);
	}
}

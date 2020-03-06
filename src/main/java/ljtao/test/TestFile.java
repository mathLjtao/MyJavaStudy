package ljtao.test;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;

/**
 * @author ljtao3 on 2020/3/6
 */
public class TestFile {
    public static void main(String[] args) throws Exception{
        new TestFile().fun1();
    }
    public void fun1() throws Exception {
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader()
                .getResources("ljtao.springaop.mycode".replace(".", "/"));
        while(urls.hasMoreElements()){
            URL url = urls.nextElement();
            if (url != null) {
                String protocol = url.getProtocol();//获得URL的协议
                if (protocol.equals("file")) {
                    //转码
                    String packagePath = URLDecoder.decode(url.getFile(), "UTF-8");//转码为utf-8的格式
                    System.out.println(packagePath);
                }
            }
        }
    }
}

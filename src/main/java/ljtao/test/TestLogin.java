package ljtao.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestLogin {
	public static void main(String[] args) {
		//i=ljtao3&p=a0295560426167026&t=1553070071&e=a98e2e926794bba8693bdde470012005
		System.out.println(CheckLoginInfo("ljtao3","a0295560426167026","1553070071","a98e2e926794bba8693bdde470012005"));
	}
	public static String CheckLoginInfo(String i,String p,String t,String e){
		String key="oagold";
		if(i==null||p==null||t==null||e==null){
			//return "T";
			return "N";//N:登录信息错误
		}
		else 
		{
			TestLogin login =new TestLogin();
			String encryption = login.encryption(i+p+t+key);
			
			if((encryption).equals(e)){
				return "T";
			}
			else{
				//return "T";
				return "F";//F:登录信息不匹配
			}
		}
	}
	
	private  String encryption(String OrderNo) {
        //String result = OrderNo+"354039456123789"+"andriod"; 
		String result=OrderNo;
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(result.getBytes());
            byte b[] = md.digest();
 
            int i;
 
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
 
            re_md5 = buf.toString();
 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
        //return re_md5.toUpperCase();//变成大写
    }
}

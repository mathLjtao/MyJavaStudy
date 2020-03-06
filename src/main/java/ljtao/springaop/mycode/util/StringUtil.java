package ljtao.springaop.mycode.util;

/**
 * @author ljtao3 on 2020/3/6
 */
public class StringUtil {
    public static boolean isNotBlank(String str){
        if(str!=null && str.trim().length()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean isBlank(String str){
        return !isNotBlank(str);
    }
}

package ljtao.javase.exception.ex3;

/**
 * @author ljtao3 on 2020/5/11
 */
public class ExceptionSilencer {
    public static void main(String[] args) {
        try{
            throw new RuntimeException("....");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            return;
        }
    }
}

package ljtao.springioc.example;

import org.junit.Before;
import org.junit.Test;

public class IoCTest {
    private IoCController ioCController=new IoCController();
    @Before
    public void before() throws Exception {
        ioCController.setBean(Audi.class,"audi");
        ioCController.setBean(Buick.class,"buick");
        ioCController.setBean(Zhangsan.class,"zhangsan",new String[]{"audi"});
        ioCController.setBean(Lisi.class,"lisi",new String[]{"buick"});
    }
    @Test
    public void test(){
        Human zhangsan = (Human)ioCController.getBean("zhangsan");
        zhangsan.gohome();
        zhangsan.shopping();
        Human lisi = (Human)ioCController.getBean("lisi");
        lisi.gohome();
        lisi.shopping();
    }
}

package ljtao.springaop.mycode.service;

import ljtao.springaop.mycode.annotion.Aspect;
import ljtao.springaop.mycode.annotion.PointCut;
import ljtao.springaop.mycode.proxy.AbsMethodAdvance;

/**
 * @author ljtao3 on 2020/3/6
 */
@Aspect
public  class TestAspect extends AbsMethodAdvance {
    @PointCut("ljtao.springaop.mycode.service.Test_doWithProxy")
    public void aspectMethod(){

    }

    @PointCut("ljtao.springaop.mycode.service.UserService_doWithProxy")
    public void aspectMethod2(){

    }

    @Override
    public void doBefore() {
        System.out.println("do before");
    }

    @Override
    public void doAfter() {
        System.out.println("do after");
    }
}

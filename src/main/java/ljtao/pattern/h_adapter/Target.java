package ljtao.pattern.h_adapter;
/*
 * 目标角色：这就是所期待得到的接口
 */
public interface Target {
	//原先源类也有的方法
	public void simpleDemo1();
	//原先源类没有的方法
	public void simpleDemo2();
}

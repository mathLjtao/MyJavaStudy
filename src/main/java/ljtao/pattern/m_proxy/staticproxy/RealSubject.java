package ljtao.pattern.m_proxy.staticproxy;

public class RealSubject extends Subject{

	@Override
	public void request() {
		// TODO Auto-generated method stub
		System.out.println("真实的主题");
	}
}

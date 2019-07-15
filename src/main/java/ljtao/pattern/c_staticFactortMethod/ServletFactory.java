package ljtao.pattern.c_staticFactortMethod;


//模拟一个接口
interface Servlet{}

class HttpServlet implements Servlet{}
class LoginServlet extends HttpServlet{}
class RegisterServlet extends HttpServlet{}
//注销
class LoginoutServlet extends HttpServlet{}
class SimpleServlet extends HttpServlet{}
public class ServletFactory {
	public static Servlet getServlet(String method){
		if("login".equals(method)) {
			return new LoginServlet();
		}
		else if("register".equals(method)) {
			return new RegisterServlet();
		}
		else if("loginout".equals(method)) {
			return new LoginoutServlet();
		}
		return new SimpleServlet();
	}
}

package ljtao.pattern.n_flyweight;
/*
 * 员工报表具体享元类
 */

public class EmployeeReportManager implements IReportManager{
	protected String tenantId;
	EmployeeReportManager(String tenantId){
		this.tenantId= tenantId;
	}
	@Override
	public String createReport() {
		System.out.println("employeeReport");
		return "employeeReport";
	}

}

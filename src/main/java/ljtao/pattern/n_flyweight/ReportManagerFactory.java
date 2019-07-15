package ljtao.pattern.n_flyweight;

import java.util.HashMap;
import java.util.Map;

public class ReportManagerFactory {
	Map<String,IReportManager> financial=new HashMap<>();
	Map<String,IReportManager> employee=new HashMap<>();
	IReportManager getFinancialReportManager(String tenantId){
		IReportManager r=financial.get(tenantId);
		if(r==null){
			r=new FinancialReportManager(tenantId);
			//维护已创建的享元对象
			financial.put(tenantId, r);
		}
		return r;
	}
	IReportManager getEmployeeReportManager(String tenantId){
		IReportManager r=employee.get(tenantId);
		if(r==null){
			r=new EmployeeReportManager(tenantId);
			employee.put(tenantId, r);
		}
		return r;
	}
}

package ljtao.pattern.n_flyweight;
/*
 * 财务报表具体享元类
 */
public class FinancialReportManager implements IReportManager{
	String tenantId;
	FinancialReportManager(String tenantId){
		this.tenantId= tenantId;
	}
	@Override
	public String createReport() {
		System.out.println("financialReport:"+this.tenantId);
		return "financialReport";
	}

}

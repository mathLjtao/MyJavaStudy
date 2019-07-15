package ljtao.pattern.n_flyweight;

public class Client {
	public static void main(String[] args) {
		String id1="A";
		String id2="B";
		ReportManagerFactory rf=new ReportManagerFactory();
		IReportManager employeeReportManager = rf.getFinancialReportManager(id1);
		IReportManager employeeReportManager2 = rf.getFinancialReportManager(id2);
		employeeReportManager.createReport();
		employeeReportManager2.createReport();
	}
}

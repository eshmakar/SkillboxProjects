public class Manager extends EmployeeBase {

    public static final double MANAGER_PERCENT = 0.05;
    public static final int LOW_EDGE_OF_EARNINGS = 115_000;
    public static final int HIGH_EDGE_OF_EARNINGS = 140_000;
    private int earningsForCompany;

    public Manager(Company company) {
        super(company);
        earningsForCompany = LOW_EDGE_OF_EARNINGS + (int)(Math.random() * (HIGH_EDGE_OF_EARNINGS - LOW_EDGE_OF_EARNINGS) + 1);
        setMonthSalary(getBaseSalary() + earningsForCompany * MANAGER_PERCENT);
    }

    public int getEarningsForCompany() {
        return earningsForCompany;
    }
}
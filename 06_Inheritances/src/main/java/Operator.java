public class Operator extends EmployeeBase {

    public Operator(Company company) {
        super(company);
        setMonthSalary(getBaseSalary());
    }
}
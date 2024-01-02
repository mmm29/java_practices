//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Employee employee = new Employee("Bill", "Gates");
            employee.setSalary(1);

            employee.setName("ABCDEFABCDEF");
            employee.setSalary(-1);
        } catch (IncorrectSalaryException e) {
            System.out.printf("Incorrect salary: %s", e);
        }
        catch (FieldLengthLimitException e) {
            System.out.printf("Reached field length limit: %s", e);
        }
    }
}
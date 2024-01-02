import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class EmployeeTest {
    @Test
    public void testEmployeeIdAssignment() throws FieldLengthLimitException {
        Employee employee_0 = new Employee("Bill", "Gates");
        Employee employee_1 = new Employee("Elon", "Musk");
        Employee employee_2 = new Employee("Warren", "Buffet");
        Employee employee_3 = new Employee("Ken", "Thompson");

        assertEquals(employee_0.getId(), 0);
        assertEquals(employee_1.getId(), 1);
        assertEquals(employee_2.getId(), 2);
        assertEquals(employee_3.getId(), 3);
    }

    @Test
    public void newEmployeeTest() throws FieldLengthLimitException, IncorrectSalaryException {
        Employee employee = new Employee("Leonardo", "DiCaprio");

        assertThrows(FieldLengthLimitException.class, () -> {
            employee.setName("ABCDEFABCDEF");
        });
        assertEquals(employee.getName(), "Leonardo");
        assertEquals(employee.getSurname(), "DiCaprio");

        assertThrows(FieldLengthLimitException.class, () -> {
            employee.setSurname("ABCDEFABCDEF");
        });
        assertEquals(employee.getSurname(), "DiCaprio");

        assertEquals(employee.getSurname(), "DiCaprio");

        employee.setSalary(0);
        assertEquals(employee.getSalary(), 0, 1e-5);

        employee.setSalary(5);
        assertEquals(employee.getSalary(), 5, 1e-5);

        assertThrows(IncorrectSalaryException.class, () -> {
            employee.setSalary(-5);
        });

        assertEquals(employee.getSalary(), 5, 1e-5);

        assertThrows(FieldLengthLimitException.class, () -> {
            new Employee("ABCDEFABCDEF", "a");
        });

        assertThrows(FieldLengthLimitException.class, () -> {
            new Employee("a", "ABCDEFABCDEF");
        });
    }
}
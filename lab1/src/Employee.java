public class Employee {
    final int NAME_MAX_LENGTH = 10;

    private int id;
    static private int nextId = 0;
    private String name;
    private String surname;
    private double salary = 0;

    public Employee(String name, String surname) throws FieldLengthLimitException {
        this.id = nextId;
        nextId++;


        this.setName(name);
        this.setSurname(surname);
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws FieldLengthLimitException {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new FieldLengthLimitException("Name is too long");
        }

        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws FieldLengthLimitException {
        if (surname.length() > NAME_MAX_LENGTH) {
            throw new FieldLengthLimitException("Surname is too long");
        }

        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws IncorrectSalaryException {
        if (salary < 0) {
            throw new IncorrectSalaryException("Negative salary");
        }

        this.salary = salary;
    }
}

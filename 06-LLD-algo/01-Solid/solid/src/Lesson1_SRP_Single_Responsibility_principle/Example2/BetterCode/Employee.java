package Lesson1_SRP_Single_Responsibility_principle.Example2.BetterCode;

public class Employee {

    private final int employeeId;

    public Employee(int id) {
        this.employeeId = id;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }
}

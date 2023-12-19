package Lesson1_SRP_Single_Responsibility_principle.Example2.ProblamaticCode;

//violates SRP
//->  multiple reason to change the code in this file
public class Employee {

    private int id;

    public int getId() {
        return this.id;
    }

    public String fetchBioData() {
        return "Some bio data";
    }

    public double calculateSalary() {
        return 0;
    }

    public void printPerformanceData() {
        System.out.println("Some performance related data");
    }

}

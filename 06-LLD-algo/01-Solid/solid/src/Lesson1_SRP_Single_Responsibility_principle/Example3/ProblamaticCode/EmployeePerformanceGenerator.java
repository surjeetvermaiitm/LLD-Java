package Lesson1_SRP_Single_Responsibility_principle.Example3.ProblamaticCode;

import Lesson1_SRP_Single_Responsibility_principle.Example2.BetterCode.Employee;

// It follows SRP
// It violates OCP -> Open close principle

public class EmployeePerformanceGenerator {
    public String generateReport(String reportType, Employee employee) {
        if (reportType.equals("PDF")) {
            return "Generating PDF report.";
        } else if (reportType.equals("Word")) {
            return "Generating Word report.";
        }
        return "Report type not supported.";
    }
}

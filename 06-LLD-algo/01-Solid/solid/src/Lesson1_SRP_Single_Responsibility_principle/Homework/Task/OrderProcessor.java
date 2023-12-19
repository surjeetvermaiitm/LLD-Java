package Lesson1_SRP_Single_Responsibility_principle.Homework.Task;

// Read the code and try to figure out whether it complies to SRP or not ? And If not then how can we refactor ?
class Order{
    // .. some properties
}

class User {
    // .. some properties
}

public class OrderProcessor {
    public void processOrder(Order order) {
        // Code to process the order
    }

    public void calculateTotalSum(Order order) {
        // Code to calculate total sum
    }

    public void sendEmailNotification(User user) {
        // Code to send email notifications
    }
}

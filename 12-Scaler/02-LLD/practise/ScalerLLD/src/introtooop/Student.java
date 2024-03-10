package introtooop;

public class Student {
    String name;
    String address;
    String email;
    String batch;
    double psp;
    String state;

    Student(){

    }

    //copy constructor -> shalow copy because internal state will have same address
    Student(Student other){
        name=other.name;
        address=other.address;
        batch=other.batch;
        email=other.email;
        psp=other.psp;
        state=other.state;
    }

    void changeBatch(String newBatch) {
        this.batch = newBatch;
    }

    void pauseCourse() {
        this.state = "PAUSED";
    }

    void karthik() {
        System.out.println("Karthik");
    }
}

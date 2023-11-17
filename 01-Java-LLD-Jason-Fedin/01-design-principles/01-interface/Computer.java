
interface displayModule {
    public void display();
}

class Monitor implements displayModule {
    public void display()
    {
        System.out.println("Display through Monitor");
    }
}

class Project implements displayModule {
    public void display()
    {
        System.out.println("Display through projector");
    }
}

public class Computer {
    displayModule dm;

    public void setDisplayModule(displayModule dm)
    {
        this.dm=dm;
    }

    public void display()
    {
        dm.display();
    }

    public static void main(String args[])
    {
        Computer cm = new Computer();
        displayModule dm = new Monitor();
        displayModule dm1 = new Project();

        cm. setDisplayModule(dm);
        cm. display();
        cm. setDisplayModule(dm1);
        cm. display();
    }
}
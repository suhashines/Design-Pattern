public class Employee {
    private String name ;

    Employee(String name){
        this.name = name ;
    }

    public String getName(){return name;}



}

class ManagingDirector extends Employee{

    ManagingDirector(String name){
        super(name);
    }
}

class Officer extends Employee{
    Officer(String name){
        super(name);
    }
}

class Cashier extends Employee{

    Cashier(String name){
        super(name);
    }
}

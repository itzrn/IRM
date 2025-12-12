class Employee{
    String detailName;
    int id;// Attribute1
    String name;// Attribute 2
    double salary;//Attribute 3
    public void printDetails(){
        System.out.println(detailName);
        System.out.println("My id is ---> "+id);
        System.out.println("My name is ---> "+name);
        System.out.println("My Salary ---> "+salary);
    }
    public double getSalary(){
        return salary;
    }
}
public class T001_Class {
    public static void main(String[] args) {
        System.out.println("This is our Custom_Class");
        System.out.println();
        Employee aryan = new Employee();// Instantiating a new Employee object
        Employee joy = new Employee();// adding one more Employee
        // setting Attributes
        aryan.id = 12;
        aryan.name = "CodeWithAryan";
        aryan.salary = 123456;
        joy.id = 13;
        joy.name = "Joy Singh";
        joy.salary = 98765;
        aryan.detailName = "Aryan Detail --->";
        joy.detailName = "Joy Detail --->";
        /*
        System.out.println(aryan.id);
        System.out.println(aryan.name);
        this two line is same as ---> aryan.printDetails();
        means directly calling the method to print the same things, and it allows us to code(to write less) less
         */
        // printing the properties
        aryan.printDetails();//printing aryan details
        System.out.println();
        joy.printDetails();//printing joy details
        System.out.println();
        System.out.println("Printing just salary --->");
        double salary = joy.getSalary();
        System.out.println("Joy Salary ---> " + salary);
        System.out.println("Aryan Salary ---> " + aryan.getSalary());
    }
}
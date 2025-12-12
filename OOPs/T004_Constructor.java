import java.util.Scanner;

class MyMainEmployee{
    /*
    Dot Operator means --->
    making object of class and using dot operator to call
    properties or function of the particular class
     */
    private int id1;
    private String name1;
    public MyMainEmployee(){
        id1=45;
        name1="Aryan";
    }
    public MyMainEmployee(String myName,int myId){// Arguments can also be passed to a constructor
        id1=myId;
        name1=myName;
    }
    public String getName(){
        return name1;
    }
    public void setName(String n){
        name1=n;
    }
    public int getId(){
        return id1;
    }
    public void setId(int i){
        id1=i;
    }
}
public class T004_Constructor {
    public static void main(String[] args) {// Constructor get invoke automatically
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your name ---> ");
        String s= sc.next();
        System.out.print("Enter your Id ---> ");
        int s1= sc.nextInt();
        System.out.println("\nUsing Constructor with Two parameter --------");
        MyMainEmployee MME=new MyMainEmployee(s,s1);
        System.out.println(MME.getName());
        System.out.println(MME.getId());
        System.out.println();
        MyMainEmployee ME=new MyMainEmployee();
        ME.setId(89);
        ME.setName("Ashmit");
        System.out.println("Using Constructor with no parameter --------");
        System.out.println("Your Id ---> "+ME.getId());
        System.out.println("Your Name ---> "+ ME.getName());
    }
}

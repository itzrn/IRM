package OOPS;

//How Java does supports multiple inheritance indirectly through inferfaces?
/*
What is an interface?
Different types of members in a class?
i)data members/ attributes [static/non-static, final/non-final]
ii)methods [static/non-static, final/non-final]
iii)constructors
Note: We can declare and create instances for a class
Different types of members in abstract class?
i)data members/ attributes [static/non-static, final/non-final]
ii)methods [abstract(non-static,non-final))/non-abstract (static /non-static, final/non-final)]
iii)constructors
Note: We can declare objects of an abstract to make a reference to one of its sub class instance
An interface is purely an abstract class (only abstract methods)
i) data members (but by default they are final and static)
ii) No constructors
iii) Methods ( by default they are abstract,non-static,public)
Note: We can't declare objects
Interfaces gives information about what should be implemented.
But never gives info about how it should be implemented
Syntax: interface Interface_Name{
set of final data members
set of abstract methods;
}
at least there should be one class which implements an interface
class class_name implements interface_name{
}
*/
interface Inf{
    int a=10;// it is also same as static final int a=5
    void m1();//here it is equivalent to public void m1();
    void m2(int x);//here it is equivalent to public void m2(int x);
}
class T54_A implements Inf{
    //final int t=10;
    public void m1(){
        System.out.println("Method m1 is implemented in A");
    }
    public void m2(int x){
        System.out.println("Method m2 is implementedin A with x="+x);
    }
}
public class T018_Exe {
    public static void main(String []args){
        T54_A ob1=new T54_A();
        ob1.m1();
        ob1.m2(10);
        //ob1.a=5;//invalid
    }
}

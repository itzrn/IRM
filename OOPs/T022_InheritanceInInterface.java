package OOPS;

interface  SampleInterfaceT58{
    void meth1();
    void meth2();
}
interface ChildSampleInterface extends SampleInterfaceT58{
    // let if we want meth1() and meth2() of above interface then we inherit one interface to another interface
    //we can not make a class by extending an interface
    // we can also make an interface by extending an interface
    //In a class we can only implement an interface
    //object can not be created of abstract and Interface
    void meth3();
    void meth4();
}
class MySampleClass implements ChildSampleInterface{
    public void meth3(){
        System.out.println("meth3!!");
    }
    public void meth4(){
        System.out.println("meth4!!");
    }
    public void meth1(){
        System.out.println("meth1!!");
    }
    public void meth2(){
        System.out.println("meth2!!");
    }
}
public class T022_InheritanceInInterface {
    public static void main(String[] args) {
        MySampleClass mySampleClass=new MySampleClass();
        mySampleClass.meth1();
        mySampleClass.meth2();
        mySampleClass.meth3();
        mySampleClass.meth4();
    }
}

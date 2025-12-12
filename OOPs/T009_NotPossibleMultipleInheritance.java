//Multiple Inheritance: Creation of a sub class from two or more immediate super classes
//Java does not support directly multiple inheritance(why?look at the following example)

//class A{
//
//    int t1,s1;
//    A()// constructor
//    {
//        t1=a;
//        s1=b;
//    }
//    void m1()
//    {
//        System.out.println(t1+s1);
//    }
//}
//
//class B{
//
//    int t1,s2;
//    B()// constructor
//    {
//        t1=10;
//        s2=15;
//    }
//    void m1()
//    {
//        System.out.println(t1+s2);
//    }
//}
//public class C extends A,B{//compile time error , Java does not support multiple inheritance

//    //t1 of A, s1, m1(), t1 of B,s2,m1() of B
//    int t1,s1,s2;//four data members are overridden
//    C()
//    {
//        super();// matching with class A's constructor and class B's constructor, then how compiler
//        // will understand which constructor is needed to call, this is bcz we cannot use multiple inheritance ,but we can achieve multiple inheritance using interface
//        t1=1;
//        s1=1;
//        s2=1;
//    }
//    void m2()
//    {
//        super.m1();// it leads to ambiguity
//        System.out.println(t1+s1+s2);//O/P:3
//        System.out.println(super.t1+super.s1+super.s2);//    super.t1 --> leads to ambiguity
//    }
//}
public class T009_NotPossibleMultipleInheritance{
    public static void main(String[] args) {
        System.out.println("we cannot use multiple inheritance ,but we can achieve multiple inheritance using interface");
    }
}

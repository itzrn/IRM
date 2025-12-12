package OOPS;

class A{
    public int a;
    public int aryan(){
        return 1;
    }

    public void meth2(){
        System.out.println("a ---> "+a);
        System.out.println("I am method 2 of class A!!");
    }
}

class B1 extends A{

    public void meth3(){
        System.out.println("I am method 3 of class A!!");
    }
}

class B2 extends A{

    @Override// to write override is recommended
    public void meth2(){
        super.a=4;
        System.out.println("I am method 2 of class B!!");
        super.meth2();
    }

    public void meth3(){
        System.out.println("I am method 3 of class B!!");
    }
}
public class T024_MethodOverriding {
    public static void main(String[] args) {
        A a=new A();
        a.meth2();

        B1 b=new B1();
        b.meth2();
        /*
        let if we want to inherit class B from class A
        n even, as the above two objects are printing  |I am method 2 of class A!!|
        we too want to that those methods print
        I am method 2 of class B!!
        to do this we use the concept of overriding
        this we are doing by using class B2
         */
        System.out.println();
        a.meth2();
        B2 b2=new B2();
        b2.meth2();// now this will access its own method 2
        System.out.println();
        /*
        let we want to call meth2 of class B2by overriding
        but at the same time we also want to call the meth2 of class A
        then we will use the keyword super
        then the syntax of meth2 in class B2 will be like
            @Override
    public void meth2(){
        super.meth2();
        System.out.println("I am method 2 of class B!!");
    }
    OR, super.meth2(); can be before or after some statements in meth2() of class B2 according to your convenient
    so, basically we use super to represent same attribute or same function of super class
                @Override
    public void meth2(){
        System.out.println("I am method 2 of class B!!");
        super.meth2();
    }
    Access modifier, return type, method name are same in method overriding
         */
    }
}
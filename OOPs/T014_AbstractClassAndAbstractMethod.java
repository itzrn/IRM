package OOPS;


abstract class ParentT53{
    public ParentT53(){
        System.out.println("I am the Constructor of BaseT53 class!!");
    }
    public void sayHello(){
        System.out.println("Hello!!");
    }
    abstract  public void great();
    abstract  public int great_02(int a);
}

class ChileT53 extends ParentT53{//making a class which exist actually


    @Override
    public void great() {
        System.out.println("Good Morning!");
    }
    @Override
    public int great_02(int a){
        System.out.println(a);
        System.out.println("Good Afternoon!");
        return a;
    }
}

abstract class Child_02T53 extends ParentT53{
    public void th(){
        System.out.println("I am Good Boi!");
    }
}
class Child_03T53 extends Child_02T53{
    @Override
    public void great(){

    }
    @Override
    public int great_02(int b){
        return b;
    }
}
public class T014_AbstractClassAndAbstractMethod {
    /*
    ek abstract method puri class ko abstract bna deta h
    abstract class ka object nhi bnta, vo bs shayta krti h
    so....
    abstract class ke sara abstract method ko override krna pdega ek concrete class
    bnane ke liya, or concrete class bna ke hi hm object bna skte hai.
     */
    public static void main(String[] args) {
        ChileT53 chileT53=new ChileT53();// its possible to make object here, bcz its a concrete class here
        chileT53.sayHello();
        chileT53.great();
        chileT53.great_02(3);
        Child_03T53 child_03T53=new Child_03T53();
        child_03T53.great();
        System.out.println(child_03T53.great_02(90));

    }
}

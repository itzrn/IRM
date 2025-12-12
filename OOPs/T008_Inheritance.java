import java.util.Scanner;

class BaseT45{
    int x;

    public int getX() {
        System.out.println("I am getting 'x' now");
        System.out.print("'x' ---> ");
        return x;
    }

    public void setX(int x) {
        System.out.println("I am in BaseT45 and setting 'x' now");
        this.x = x;
    }

    void printMe(){
        System.out.println("I am a Constructor");
    }
}
/*
like if we want to add some property of a class to another class
then we use the concept of inheritance
like,here we want to add the getter and setter of 'x' of
class 'BaseT45' in another class named 'Derived'
let for some reason you want to print something in getX and setX
then you have to change the getX and setX of every class, so to make work more easy
the concept come inheritance
 */
class DerivedT45 extends BaseT45{
    // here DerivedT45(son/daughter class) is a subclass and BaseT45(parent class) is a superclass
    int y;
    /*
        int x;
    public int getX(){
        return x;
    }
    public void setX(int x){
        System.out.println("I am setting x now");
        this.x=x;
    }
     we use extends keyword to make some property of a class available to another class
     like here we use the property of x
     */
    public int getY() {
        System.out.print("'y' ---> ");
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
public class T008_Inheritance {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        BaseT45 baseT45=new BaseT45();
        System.out.println("Using getX and setX by BaseT45 class object ===>>");
        System.out.print("Enter the number of 'x' to set it's value ---> ");
        baseT45.setX(sc.nextInt());
        System.out.println(baseT45.getX());
        System.out.println();

        System.out.println("Using getX and setX by DerivedT45 class object ===>>");
        DerivedT45 derivedT45=new DerivedT45();
        System.out.print("Enter the number of 'x' to set it's value ---> ");
        derivedT45.setX(sc.nextInt());
        System.out.println(derivedT45.getX());
        System.out.println();
        /*
        from BaseT45 class we can not excess the 'y', which is in DerivedT45 class,
        So, we can only excess 'y' from DerivedT45 class
         */
        System.out.println("Using getY and setY by DerivedT45 class object ===>>");
        System.out.print("Enter the number of 'y' to set it's value ---> ");
        derivedT45.setY(sc.nextInt());
        System.out.println(derivedT45.getY());
        /*
        all property of base class will get available in derived class using inheritance
        but
        will all property of base class get accessible in derived class or not?
        it will be accessible or not, this thing will tell access modifier
        for time being just keep in mind
        whatever thing are public in bse class, those things will get accessible in derived class
         */
    }
}
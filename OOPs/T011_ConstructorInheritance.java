class BaseT46{
    public int x;

    BaseT46(){
        System.out.println("I am a Constructor of 'BaseT46' class!");
    }
    BaseT46(int x){
        System.out.println("I am a overloaded constructor of 'BaseT46 class! with value of 'x' ---> "+x);
    }
    public void setX(int x){
        this.x=x;
    }
    public int getX(){
        return x;
    }
}

class DerivedT46 extends BaseT46{
    public int y;

    DerivedT46(){
        super(0);
        System.out.println("I am a constructor of 'DerivedT46' class");
    }
    DerivedT46(int x,int y){
        super(x);
        System.out.println("I am a Overloaded constructor of 'DerivedT46' with value of 'y' ---> "+y);
    }
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class ChildOfDerivedT46 extends DerivedT46{
    ChildOfDerivedT46(){
        super();
        System.out.println("I am a constructor of 'ChildOfDerivedT46' constructor");
    }
}
public class T011_ConstructorInheritance {
    public static void main(String[] args) {
        System.out.println("Constructor getting invoke by the object of 'BaseT46' class ---> ");
        BaseT46 baseT46=new BaseT46();// it will automatically invoke the constructor of BaseT46 class
        System.out.println();
        System.out.println("Constructor of class 'BaseT46' getting automatically invoke by 'DerivedT46' class ---> ");
        DerivedT46 derivedT46=new DerivedT46();// even this will invoke the constructor of class BaseT46
        /*
        Let if we call just DerivedT46 class...
        it will first call the BaseT46 class Constructor then it will call its own constructor
        DerivedT46 derivedT46=new DerivedT46();
        The above line will call the BaseT46() constructor of class 'BaseT46'
        let if we want to call the constructor BaseT46(int a) of 'BaseT46' class
        then we will use the keyword super();
         */
        System.out.println();
        DerivedT46 Derived=new DerivedT46(12,14);// this will choose the constructor with two argument
        System.out.println();
        ChildOfDerivedT46 childOfDerivedT46=new ChildOfDerivedT46();
    }
}

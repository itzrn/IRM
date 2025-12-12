class EkClassT47{
    int a;

    public int getA() {
        return a;
    }
    EkClassT47(int a){
        this.a=a;
    }
    public int returnOne(){
        return 1;
    }
}

class DoClassT47 extends EkClassT47{
    DoClassT47(int a){
        super(a);
        System.out.println("I am a constructor of class 'DoClassT47'");
//        super(a); , call to super() must be a first statement in a constructor
    }
}
public class T012_ThisSuperKeyword {
    public static void main(String[] args) {
        EkClassT47 ekClassT47=new EkClassT47(5);
        System.out.println(ekClassT47.getA());
        DoClassT47 doClassT47=new DoClassT47(54);
        System.out.println(doClassT47.getA());
    }
}

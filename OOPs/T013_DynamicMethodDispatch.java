package OOPS;

class Phone{
    public void name(){
        System.out.println("My name is Java in class Phone!!");
    }

    public void great(){
        System.out.println("Good morning Class Phone");
    }
}

class SmartPhone extends Phone{
    @Override
    public void name(){
        System.out.println("My name is Java in class SmartPhone");
    }

    public void swagat(){
        System.out.println("Aapka Swagat hai class SmartPhone");
    }
}
public class T013_DynamicMethodDispatch {
    public static void main(String[] args) {
        System.out.println("Calling One");
        Phone obj=new Phone();//Allowed
        SmartPhone smobj=new SmartPhone();//Allowed
        obj.name();
        System.out.println();
        System.out.println("Using ---> Phone obj1 = new SmartPhone();");
        Phone obj1 = new SmartPhone();// allowed
        /*
        Phone ---> reference(Super class ka)
        SmartPhone ---> object(Sub class ka)
        SmartPhone obj2=new Phone(); ---> not Allowed
         */

        obj1.great();// greta ek hi h to vahi ek run hoga
        // but name to do h, jo ki override hua pada hai, to konsa run hoga??
        //Ans ---> SmartPhone ka run hoga, means object ka run hoga n ki reference ka, overriden function hi run hoga sub class ka its a runtime polymorphism
        obj1.name();
        // obj1.swagat(); ---> not allowed, bcz only overriden function of sub class can only run
    }
}

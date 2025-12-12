package OOPS;

interface CameraT57{
    void takeSnap();
    void recordVideo();
    private void great(){
        // this method cannot be use by the class which contain thi interface,
        // bcz its private, Then what's the use of this??
        // like if any default method get too long then this private method
        // can be use in that default method to make that default method short
        // this method can not be used in the main method or in another class
        System.out.println("Good morning");
    }
    default void record4kVideo(){// need not to be implemented
        // everywhere, that's what default means, available everywhere
        // we can override the method if anywhere we have to change something anywhere
        great();
        System.out.println("Recording in 4k....");
    }
}
interface Wifi{
    String[] getNetwork();
    void connectToNetwork(String network);
}
class MyCellPhoneT57{
    public void callNumber(int phoneNumber){
        System.out.println("Calling ---> "+phoneNumber);
    }
    public void pickCall(){
        System.out.println("Connecting... ");
    }
}

class MySmartPhone extends MyCellPhoneT57 implements Wifi,CameraT57{
    public void takeSnap(){
        System.out.println("Taking Snap!!");
    }
    //    @Override
//    public void record4kVideo(){
//        System.out.println("Recording 4k video.....and taking snap!!");
//    }
    public void recordVideo(){
        System.out.println("Recording Video!!");
    }
    public String[] getNetwork(){
        System.out.println("Getting List of Network ---> ");
        String[] networkList={"Aryan","Ashmit","Dharmendra","Manoj"};
        return networkList;
    }
    public void connectToNetwork(String netWork){
        System.out.println("Connecting to ---> "+netWork);
    }
}
public class T021_InterfaceDefaultMethod {
    public static void main(String[] args) {
        MySmartPhone smartPhone=new MySmartPhone();
        String[]ar=smartPhone.getNetwork();
        for(String item:ar){
            System.out.println(item);
        }
//        smartPhone.pickCall();
        System.out.println();
        smartPhone.record4kVideo();//it will override the method if the commented method get un-comment
        System.out.println();
        smartPhone.callNumber(88402198);
    }
}

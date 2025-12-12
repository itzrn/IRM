package OOPS;

interface CameraT59{
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
interface WifiT59{
    String[] getNetwork();
    void connectToNetwork(String network);
}
class MyCellPhoneT59{
    public void callNumber(int phoneNumber){
        System.out.println("Calling ---> "+phoneNumber);
    }
    public void pickCall(){
        System.out.println("Connecting... ");
    }
}

class MySmartPhoneT59 extends MyCellPhoneT59 implements WifiT59,CameraT59{
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
    public void sampleMet(){
        System.out.println("meth!!");
    }
}
public class T023_PolymorphismInInterface {
    public static void main(String[] args) {
        CameraT59 cameraT59=new MySmartPhoneT59();//this is a smartphone, use it as a camera
//        reference can be taken of class, abstract class, interface but object can only be created for class
        cameraT59.record4kVideo();
        cameraT59.takeSnap();
        cameraT59.recordVideo();
//        cameraT59.getNumber(); ---> not allowed
//        cameraT59.sampleMeth(); ---> not allowed
    }
}

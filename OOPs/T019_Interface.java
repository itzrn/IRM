
interface Bicycle_T54T55{
    //we can even put the property here
    int a=10;// by default, it is final,can't be change anywhere in the class or java file
    void applyBrake(int decrement);
    void speedUp(int increment);
}
interface HornBicycle{
    void blowHorn();
    void blowLight();
}
class AvonCycle implements Bicycle_T54T55,HornBicycle{
    int a=45;
    public void blowhorn(){
        System.out.println("Pee Pee Poo Poo");
    }
    public void applyBrake(int decrement){
        System.out.println("Applying Break");
    }
    public void speedUp(int increment){
        System.out.println("Applying speedUp");
    }
    public void blowHorn(){
        System.out.println("Kabhi kuchi kabhi gum PE PE PE");
    }
    public void blowLight(){
        System.out.println("Red light");
    }
}
/*
A class can implements multiple interface class,
whereas A class can extends only one Abstract class or inherit
 */
public class T019_Interface {
    // see notes
    public static void main(String[] args) {
        AvonCycle avonCycle=new AvonCycle();
        avonCycle.applyBrake(5);
        avonCycle.blowhorn();
        System.out.println(avonCycle.a);
        /*
        property of interface can not be modified, bcz they are final, but can be modified in the class which
        implementing the particular class ny overriding that property and its type cast, that property will be treated as
        a new property
         */
        avonCycle.blowHorn();
        avonCycle.blowLight();
    }
}

import java.util.Scanner;

class CircleGetterSetter{
    private float radius;

    public void setRadius(float r){
        radius=r;
    }

    public void checkArea(float cA){
        float area = 3.14f * (float) (Math.pow(radius, 2));
        if(cA== area)
            System.out.println("You calculated correct Area ---> "+cA);
        else
            System.out.println("Your Entered Area is Wrong!!");
    }
    public void checkPerimeter(float cP){
        float perimeter = 2 * 3.14f * radius;
        if(perimeter ==cP)
            System.out.println("You calculated correct Perimeter ---> "+cP);
        else
            System.out.println("Your Entered perimeter is wrong!!");
    }
}
public class T003_Encapsulation {
    public static void main(String[] args) {
        System.out.println("CIRCLE ===>>");
        CircleGetterSetter CGS=new CircleGetterSetter();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of radius ---> ");
        CGS.setRadius(sc.nextFloat());
        System.out.print("Enter your Calculated area ---> ");
        CGS.checkArea(sc.nextFloat());
        System.out.print("Enter your Calculated Perimeter ---> ");
        CGS.checkPerimeter(sc.nextFloat());
    }
}

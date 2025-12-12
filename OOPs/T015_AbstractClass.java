import java.util.Scanner;

abstract class Shape_T53{
    abstract public float area(int a);
    abstract public float perimeter(int p);// square and circle
//    abstract public int perimeter(int l,int b);
}
class Circle_T53 extends Shape_T53{
    Circle_T53(){
        System.out.println("CIRCLE --->");
    }
    @Override
    public float area(int radius){
        return (float) (Math.PI*Math.pow(radius,2));
    }

    @Override
    public float perimeter(int radius){
        return (float) (2*Math.PI*radius);
    }
}
class Square_T53 extends Shape_T53{
    Square_T53(){
        System.out.println("SQUARE --->");
    }
    @Override
    public float area(int side){
        return side*side;
    }

    @Override
    public float perimeter(int side){
        return 4*side;
    }
}
public class T015_AbstractClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle_T53 circle_t53=new Circle_T53();
        System.out.print("Enter Radius of Circle ---> ");
        int radius= sc.nextInt();
        System.out.println("Area of Circle ---> "+circle_t53.area(radius));
        System.out.println("Perimeter of Circle ---> "+circle_t53.perimeter(radius));
        System.out.println();
        Square_T53 square_t53=new Square_T53();
        System.out.print("Enter Side of Square ---> ");
        int side= sc.nextInt();
        System.out.println("Area of Square ---> "+square_t53.area(side));
        System.out.println("Perimeter of Square --->"+square_t53.perimeter(side));
    }
}

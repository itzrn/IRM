/*Binding: Connecting a method call to the method body is known as binding.
    1)Static Binding (also known as Early Binding).
    2)Dynamic Binding (also known as Late Binding).
Static binding:
When type of the object is determined at compiled time(by the compiler), it is known as static binding.
If there is any private, final or static method in a class, there is static binding.
	*/

// this is static binding
public class T006_StaticBinding
{
    int a;
    private void eat()
    {
        System.out.println("dog is eating...");
    }

    public static void main(String[] args){
        T006_StaticBinding d1=new T006_StaticBinding();
        d1.eat();
//        System.out.println(a);
        System.out.println(d1);// this line will tell ---> Dog_01 with some reference
        System.out.println(d1.a);// it will print the value of 'a' 0, bcz 'a' is not initialized yet, and it gets initialize
        // default as 0 by default constructor
    }
}

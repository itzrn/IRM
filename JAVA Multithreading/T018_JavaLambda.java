
public class T018_JavaLambda {

    public static void main(String[] args) {
        // Runnable is an functional interface that's y we can use here as lambda function
        Runnable runnable = () -> System.out.println("Hello"); // this is a lambda expression


        Thread t1 = new Thread(()->{ // now we can  directly create Thread using runnable like this
            for(int i=0; i<10; i++) {
                System.out.println("Aryan");
            }
        });

        t1.start();
    }

}


// An interface having single abstract method is called functionalInterface
// @FunctionalInterface -> there is an annotation which is used to mark then as FunctionInterface


// Lambda expression is an anonymous function

// Lambda expression can be assigned to any functional interface



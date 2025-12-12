package OOPS;


//an interface is defined by someone else, but its implementation is provided by different implementation providers.
//Moreover, it is used by someone else.
//The implementation part is hidden by the user who uses the interface.


interface Bank {
    float rateOfInterest();
}

class SBI implements Bank {
    @Override
    public float rateOfInterest() {
        return 9.15f;
    }
}

class PNB implements Bank
{
    @Override
    public float rateOfInterest() {
        return 9.7f;
    }
}

public class T016_BankInterface {
    public static void main(String[] args)
    {
        Bank b=new SBI();
        System.out.println("ROI: "+b.rateOfInterest());
        b=new PNB();
        System.out.println("ROI: "+b.rateOfInterest());
    }
}


// Multiple inheritance: creation a subclass from two or more super classes
//Define an interface to give abstract details about set and get details of students
//Define a class to mention attributes of students
//Define another class implement aforesaid interface.
interface Student{
    void set_name(String s);
    void set_rno(String s);
    String get_name();
    String get_rno();
}
class Student_Attributes{
    String name;
    String rno;
}

class Student_Details extends Student_Attributes implements Student{//An example for multiple inheritance

    @Override
    public void set_name(String s) {
        name=s;
    }

    @Override
    public void set_rno(String s) {
        rno=s;
    }

    @Override
    public String get_name(){
        return name;
    }

    @Override
    public String get_rno() {
        return rno;
    }
}
public class T017_Exe {
    public static void main(String []args){
        // Student_Details ob1=new Student_Details();
        Student ob1=new Student_Details();
        ob1.set_name("Raju");
        ob1.set_rno("18BCI7045");
        System.out.println(ob1.get_name());
        System.out.println(ob1.get_rno());
    }
}


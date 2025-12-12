class MyEmployee{
    int id;
    String name;
    public void withoutPrivate(){
        System.out.println("Id ---> "+id);
        System.out.println("Name ---> "+name);
    }
    private int id1;
    private String name1;
    public String getName(){
        return name1;
    }
    public void setName(String n){
        this.name1=n;
    }
    public int getId(){
        return id1;
    }
    public void setId(int i){
        this.id1=i;
    }
}
public class T002_AccessModifier {
    public static void main(String[] args) {
        MyEmployee aryan=new MyEmployee();
        System.out.println("Without using private --->");
        aryan.id=90;
        aryan.name="Aryan";
        aryan.withoutPrivate();
        /*
        agar MyEmployee class ma, name is private then, name
        can not be access in any other class
        private ko access krne ke liya hmlog methods ki sahayat lenga,
        nhi to error throw krega as---> private access modifier
        we will use the method getter and setter
         */
        System.out.println();
        System.out.println("Using Private --->");
        aryan.setName("CodeWithAryan");
        System.out.println("Name ---> "+aryan.getName());
        aryan.setId(78);
        System.out.println("Id ---> "+aryan.getId());
    }
}
// link ---> https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html

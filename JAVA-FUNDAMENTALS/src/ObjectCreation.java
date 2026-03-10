class Student {
    int id;
    String name;
    int age;


    void sleep() {
        System.out.println("Student  is sleeping");
    }

    void study() {
        System.out.println("Student  is studying");
    }

}

class Dog{
     String name;                            //instance variable , takes default value
     int cost;

     void barks(){
         String color="brown";               //local variable, must give value
         System.out.println(color);
     }

}

public class ObjectCreation {
    public static void main(String[] args) {
        Student st = new Student();           //object creation with new keyword & class name
        st.sleep();
        Dog dg= new Dog();
        dg.barks();
    }
}

package reflectionApi;

import java.lang.reflect.Field;

class Employee {
    String name = "Sumit Khanna";
    int age = 22;
    String email = "sumitkhanna@gmail.com";
}

public class Main {
    public static void main(String[] args) throws Exception {

        Employee emp = new Employee();

        Class<?> obj = emp.getClass(); 

        Field[] fields = obj.getDeclaredFields();  

        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName() + " = " + field.get(emp));
        }
    }
}
package capgemini;

import java.io.Serializable;

import com.dk.String1;
//LOMBOK @AllArgConstructor @NoArgConstructor
public class Employee implements Serializable {

    private int id;
    private String1 name;

    public Employee(int id, String1 name) {
        this.id = id;
        this.name = name;
    }

    public String1 toString() {
        return id + " " + name;
    }
}
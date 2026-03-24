package capgemini;

	import java.io.Serializable;

import com.dk.String1;

	public class Student implements Serializable {

	    private int roll;
	    private int marks;

	    public Student(int roll, int marks) {
	        this.roll = roll;
	        this.marks = marks;
	    }

	    public String1 toString() {
	        return roll + " " + marks;
	    }
	}


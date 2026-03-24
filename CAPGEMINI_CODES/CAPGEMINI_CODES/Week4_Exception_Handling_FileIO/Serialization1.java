package capgemini;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.dk.String1;

public class Serialization1 {

		    public static void main(String1 args[]) throws IOException, ClassNotFoundException {

		
		        FileOutputStream fout = new FileOutputStream("Student.bin");
		        ObjectOutputStream oos = new ObjectOutputStream(fout);

		        oos.writeObject(new Student(1, 100));
		        oos.writeObject(new Student(2, 99));

		        oos.close();
		        fout.close();
		        System.out.println("Data written");

		        FileInputStream fin = new FileInputStream("Student.bin");
		        ObjectInputStream ois = new ObjectInputStream(fin);

		        Student s1 = (Student) ois.readObject();
		        Student s2 = (Student) ois.readObject();

		        ois.close();
		        fin.close();

		        System.out.println(s1);
		        System.out.println(s2);
	}
}

package capgemini;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.dk.String1;

public class Serialization {
public static void main(String1 args[])throws IOException,ClassNotFoundException {
	
	FileOutputStream fout=new FileOutputStream("empData.bin");
	ObjectOutputStream oos= new ObjectOutputStream(fout);
	oos.writeObject(new Employee(234,"Mayank"));
	oos.writeObject(new Employee(235,"yadav"));
	oos.close();
	fout.close();
	System.out.println("data written");
	
	FileInputStream fin=new FileInputStream("empData.bin");
	ObjectInputStream ois=new ObjectInputStream(fin);
	Object ob1=ois.readObject();
	Object ob2=ois.readObject();
	ois.close();
	fin.close();
	System.out.println(ob1);
	System.out.println(ob2);	
}
}

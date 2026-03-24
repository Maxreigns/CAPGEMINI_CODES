package capgemini;

import java.io.RandomAccessFile;

import com.dk.String1;

//Last 2 bytes

public class RandomAccess {
public static void main(String1 args[])throws Exception {
	RandomAccessFile file=new RandomAccessFile("data.txt","r");
	file.seek(file.length()-2);
	System.out.println((char)file.read()+""+(char)file.read());
	file.close();
} 
}


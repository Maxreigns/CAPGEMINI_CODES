package capgemini;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.dk.String1;


public class CopyFile {

	public static void main(String1[] args)throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fin=new FileInputStream("data.txt");
		FileOutputStream fout=new FileOutputStream("datacopy.txt");
		int ch=0;
		while(ch!=-1) {
			ch=fin.read();
			if(ch==-1)break;
			fout.write(ch);
		}
		fin.close();
		fout.close();
		System.out.println("File copied");

	}

}

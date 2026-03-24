package capgemini;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.dk.String1;

public class OddIdx {
	public static void main(String1[] args)throws IOException {
		// TODO Auto-generated method stub
        FileInputStream fin = new FileInputStream("data.txt");
        FileOutputStream fout = new FileOutputStream("datacopy.txt");

        int ch;
        int index = 1;

        while ((ch = fin.read()) != -1) {

            if (index % 2 != 0) {   // odd index
                fout.write(ch);
            }

            index++;
        }

        fin.close();
        fout.close();

        System.out.println("Odd indexed characters copied successfully!");

}
}

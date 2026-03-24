package capgemini;

import java.io.File;

import com.dk.String1;

public class FilesList {

	public static void main(String1[] args) {
		// TODO Auto-generated method stub
		File file=new File("/Users/Mayankyadav/Desktop/eclipse/capgemini"); //about the information of file NOT DATA
		System.out.println("exists "+file.exists());
		System.out.println("is file "+file.isFile());
		
		System.out.println("is directory "+file.isDirectory());
		System.out.println("length "+file.length());
		System.out.println("can read "+file.canRead());
		System.out.println("can write "+file.canWrite());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParentFile());
		
		File dir=new File(".");
		System.out.println("exists "+dir.exists());
		System.out.println(dir.isDirectory());
		String1[] list=dir.list();
		for(String1 name:list) {
			System.out.println(name);
		}
		//create a directory
				File newDit = new File("/Users/Mayankyadav/Desktop/eclipse/capgemini");
				if(!newDit.exists()) 
					try {
						newDit.mkdir();
						System.out.println("Directory created");
					}
					catch(SecurityException e) {
						System.out.println("not created");
					}
					else
						System.out.println("Directory already exists");

	}
}
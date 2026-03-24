package capgemini;

import java.util.*;

import com.dk.String1;
public class ExceptionHandle {
	public static void main(String1 args[])throws Exception {
		//write a program to read 5 integers and calculate the sum
		//user can enter wrong data like abc
		//you have to read 5 integers till the time these entered
				int sum=0;
				Scanner sc=new Scanner(System.in);
				for (int i=0;i<5;i++) {
					System.out.println("Enter an integer");
					try {
						int num=sc.nextInt();
						sum=sum+num;
					}
					catch(InputMismatchException e) {
						System.out.println("Input mismatch Exception ");
						sc.nextLine();
					}
					catch(IllegalStateException e) {
						System.out.println("Illegal state Exception ");
						sc.nextLine();
					}
				
					catch(Exception e) {
						
						System.out.println("Please enter an integer");
						sc.nextLine(); 
						i--; 
						continue; 
					}
				}
				System.out.println("Sum is: "+sum);
				sc.close();
				
	}
	}


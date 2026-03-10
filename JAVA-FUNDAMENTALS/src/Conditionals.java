
public class Conditionals
{
    public static void main(String[] args)
    {
        int age=22;

//		if(age>=18)  //false
//			System.out.println("You're adult now");
//		else
//			System.out.println("Bruh! little more hold on");

//		if(age>18)
//		{
//			System.out.println("You're adult now");
//		}
//		else if(age==18)
//		{
//			System.out.println("Bruh! just turned 18! Don't rush");
//		}
//		else
//		{
//			System.out.println("Bruhhhhhh! Kiddo");
//		}
        //  true && true  ==> true
//		if(age>=18  && age <= 60)
//		{
//			if(age> 20)
//			{
//				if(age > 30)
//				{
//				    System.out.println("I Hope you;re married");
//				}
//				else
//				{
//					System.out.println("Still acting like a teen? ");
//				}
//			}
//			else
//			{
//				System.out.println("You're legal but still a teen");
//			}
//		}
//		else if(age>60)
//		{
//			System.out.println("Uncle! Please be carefull!");
//		}
//		else
//		{
//			System.out.println("Bruhhhhhh! Kiddo");
//		}

        
//		ternary
//		=======

        //(condition)? value if true : value if its false   ;

        int number = 4 ;

        // 4 % 2 ==> 0
//		String result=(number % 2 == 0)? "Even" : "ODD";
//		System.out.println(result);

//		int n1= 5;
//		int n2 = 10;
//		int n3=15;
//
//		int maxNum=(n1>n2) ? (n1>n3)? n1 : n3   :   (n2>n3)? n2 : n3;
//		System.out.println(maxNum);

        int n1 = 5;
        int n2 = 10;
        int n3 = 15;
        int maxNum;

        if (n1 > n2)
        {
            if (n1 > n3)
            {
                maxNum = n1;
            } else
            {
                maxNum = n3;
            }
        }
        else
        {
            if (n2 > n3)
            {
                maxNum = n2;
            }
            else
            {
                maxNum = n3;
            }
        }

        System.out.println(maxNum);




    }

}

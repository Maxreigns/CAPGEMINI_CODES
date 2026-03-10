public class DataTypes{
    public static void main(String[] args){

        System.out.println("Hello Java!!");

        //primitive-datatypes

        // range: { -2^(n-1)  to  2^(n-1)-1 }

        byte b=23;               //1 byte        (-128 to 127)

        // byte b1=130;          //out of range

        short s=45;              //2 bytes       (-32768 to 32767)

        int age=14;              //4 bytes       (default)

        long l= -1243L;           //8 bytes

        float f= 123.0f;         //4 bytes

        double d=1245.098;       //8 bytes       (default)



        boolean bl= true;        //1 byte

        char ch= 'a';            //2 bytes
        char ch1='4';
        char ch2='@';
       // char ch3='ab';        (single character only allowed)




        //naming conventions

        // class name => upper camelcase:   'AverageSalary'

        // variables name => lowercase: salary, age;
        //                => averageOfMarks , average_of_marks ;

        //method name => camelcase: mainMethod, listTheAverage;

    }
}
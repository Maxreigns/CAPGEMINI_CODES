class Calc {
    int n1;
    int n2;

    int add(int a, int b) {
        n1 = a;
        n2 = b;
        int res = n1 + n2;
        return res;

    }

    //method overloading (by changing type of datatype)

    float add(float a, int b) {
       float n1 = a;
        float n2 = b;
        float res = n1 + n2;
        return res;
    }

//    ambigous method => jvm gets confuse which function to give priority
//    float add(int a, int b) {
//        float n1 = a;
//        float n2 = b;
//        float res = n1 + n2;
//        return res;
//    }

    //method overloading (by changing no of datatype)

    int add(int a, int b, int c) {
        n1 = 5;
        n2 = 5;
        int res = n1 + n2;
        return res;
    }



    //method overloading (not by  changing datatype variable)

//  int add(int x,int y){
//        n1=5;
//        n2=5;
//        int res=n1+n2;
//        return res;
//    }

}





public class MethodOverloading {

    //main method overloading

    public static void main(int a){
        System.out.println("only integer in main");
    }

    public static void main(int a,String s){
        System.out.println("string and integer in main");
    }

    public static void main(String[] args) {
        Calc c = new Calc();
        float xyz = c.add(4, 4);      // => ambigous function
        System.out.println(xyz);

        main(5,"Rahul");


    }
}
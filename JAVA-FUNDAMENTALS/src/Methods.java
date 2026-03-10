class Calc{
    int n1;
    int n2;
    int res;             //instance variable

    void sum(){
        n1=5;
        n2=10;
        res=n1+n2;
        System.out.println("Sum:"+res);
        // no return type =>void
    }

    int multiply(int a ,int b){              //parameters

        n1=a;
        n2=b;
        res=a*b;

        return res;      // return type =>int
    }

}


public class Methods {
    public static void main(String[] args) {

        Calc c=new Calc();       //object creation

        c.sum();
        int mul=c.multiply(4,7);  //arguments
        System.out.println("Product:"+mul);


    }
}

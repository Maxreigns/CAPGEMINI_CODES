import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaInBuilt {
    public static void main(String[] args){
        Consumer<String> consumer = (str) -> {
            System.out.println("This is a consumer");
            System.out.println("This is a consuming" + str);
        };
        consumer.accept("Spring framework");
        List<Integer> list = List.of(4,5,6,7,23,45,56,4);
        list.forEach((x) -> System.out.println("Consuming " + x));
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println("Consuming again " + t);
            }
        });
        list.forEach(System.out::println);
        Function<String, Integer> fun1 = (str) -> str.length();
        Function<String, Integer> fun2 = new Function<>(){
            @Override
            public Integer apply(String t) {
                return null;
            }
        };
        Integer len = fun1.apply("Hello");
        //write a lambda to get first 2 chars in upper case of the string

        Function<String , String> fun3 = (str) -> str.substring(0,2).toUpperCase() + str.substring(2,str.length());
        String nick = fun3.apply("Utkarsh Bhola");
        System.out.println(nick);

        Supplier<Integer> supplier = new Supplier<>() {
            @Override
            public Integer get() {
                return new Random().nextInt(100);
            }
        };
        System.out.println(supplier.get());
        supplier = () -> new Random().nextInt(100);
        for(int i=1;i<= 10; i++){
            System.out.println(supplier.get());
        }


        Predicate<Integer> pred = x->x >= 100;
        Integer[] arr = {34,46, 25,57,66,78,450,204,45,455};
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList(arr));
        list2.removeIf(pred);
        System.out.println(list2);

        //remove all the elements that are grater than 100
    }
}

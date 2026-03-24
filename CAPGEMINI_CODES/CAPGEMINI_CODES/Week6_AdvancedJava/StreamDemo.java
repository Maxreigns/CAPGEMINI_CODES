import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = List.of(23,23,45,56,23,3,345,543,6,5423,4);
        Stream<Integer> stream = list.stream();
        boolean allmatch = stream.allMatch(x -> x >= 40);
        System.out.println("all greater than 40" + allmatch);

        list.stream().distinct().forEach(System.out::println);
        list.stream().filter(x -> x >= 40).distinct().forEach(System.out::println);
        Stream<Integer> filter = list.stream().filter(x->x>=40);
        Optional<Integer> any = filter.findAny();
        list.stream().map(null);//function T->
    }
}

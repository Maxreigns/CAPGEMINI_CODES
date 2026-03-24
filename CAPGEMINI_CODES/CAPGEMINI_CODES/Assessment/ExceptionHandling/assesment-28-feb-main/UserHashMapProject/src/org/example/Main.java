package src.org.example;

public class Main {

    public static void main(String[] args) {

        UserMap userMap = new UserMap();

        userMap.put("mayank", "1234");
        userMap.put("rahul", "5678");

        // This should throw exception
        userMap.put("mayank", "9999");
    }
}
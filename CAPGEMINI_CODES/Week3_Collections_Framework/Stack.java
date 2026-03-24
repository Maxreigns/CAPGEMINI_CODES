package capgemeini_training;

import java.util.Stack;
import java.util.Scanner;

public class Assignment_6Feb_Stack {

    // valid parenthesis
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if ((ch == ')' && top != '(')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // decimal to binary
    public static void decimalToBinary(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n % 2);
            n = n / 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    // Reverse polish Notation
    public static int Rpn(String[] exp) {
        Stack<Integer> s = new Stack<>();
        for (String str : exp) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int b = s.pop();
                int a = s.pop();
                switch (str) {
                    case "+":
                        s.push(a + b);
                        break;
                    case "-":
                        s.push(a - b);
                        break;
                    case "*":
                        s.push(a * b);
                        break;
                    case "/":
                        s.push(a / b);
                        break;
                }
            } else {
                s.push(Integer.parseInt(str));
            }
        }
        return s.pop();
    }
    public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
        System.out.println("enter number of test cases");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("enter parenthesis");
            String str = sc.nextLine();
            System.out.println(isValid(str));
            
            System.out.println("Enter decimal number");
            int num = sc.nextInt();
            decimalToBinary(num);
            sc.nextLine();
            
            System.out.println("Enter expression- ");
            String exp = sc.nextLine();
            String[] tokens = exp.split(" ");
            System.out.println(Rpn(tokens));
        }
    }
    }

}

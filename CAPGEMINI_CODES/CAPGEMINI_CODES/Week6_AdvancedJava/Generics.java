package capgemini;

import com.dk.String1;

class StkGeneral<T> {

    Object[] a = new Object[10];
    int top = -1;

    public void push(T x) {
        a[++top] = x;
    }

    T pop() {
        return (T) a[top--];
    }
}

public class Generics {

    public static void main(String1 args[]) {

        StkGeneral<Integer> stack = new StkGeneral<>();

        stack.push(10);
        stack.push(20);

        System.out.println(stack.pop());  // 20
        System.out.println(stack.pop());  // 10
    }
}
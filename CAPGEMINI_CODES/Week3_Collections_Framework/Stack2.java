package capgemeini_training;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Assignment_9Feb_Stack {
    // stack wth push, pop, min, max op
    Stack<Integer> s = new Stack<>();
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    boolean isEmpty(){
      return s.isEmpty();
    }
    void push(int x) {
        if (isEmpty()) {
            min = x;
            max = x;
        } else {
            if (x < min)
                 min = x;
            if (x > max)
                 max = x;
        }
        s.push(x);
    }

    int pop() {
        int top = s.pop();

        if (top == min) {
            min = Integer.MAX_VALUE;
            for (int i : s)
                if (i < min) min = i;
        }

        if (top == max) {
            max = Integer.MIN_VALUE;
            for (int i : s)
                if (i > max) max = i;
        }
        return top;
    }

    int getMin() { 
        return min;
     }
    int getMax() { 
        return max; 
    }

    //Decode Nested Encoded String
   public static void decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> str = new Stack<>();

        String curr = "";
        int n = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch))
                n = n * 10 + (ch - '0');

            else if (ch == '[') {
                num.push(n);
                str.push(curr);
                n = 0;
                curr = "";
            }

            else if (ch == ']') {
                int t = num.pop();
                String p = str.pop();
                String temp = "";
                for (int i = 0; i < t; i++)
                    temp += curr;
                curr = p + temp;
            } else {
                curr += ch;
            }
        }
        System.out.println(curr);
    }
// laregst Rectangle in histogram
    static void rectangle(int[] arr) {
        Stack<Integer> s2 = new Stack<>();
        int max = 0, i = 0;

        while (i < arr.length) {
            if (s2.isEmpty() || arr[s2.peek()] <= arr[i])
                s2.push(i++);
            else {
                int h = arr[s2.pop()];
                int w = s2.isEmpty() ? i : i - s2.peek() - 1;
                max = Math.max(max, h * w);
            }
        }

        while (!s2.isEmpty()) {
            int h = arr[s2.pop()];
            int w = s2.isEmpty() ? i : i - s2.peek() - 1;
            max = Math.max(max, h * w);
        }
        System.out.println(max);
    }
// celebrity identification problem
    static void celebrity(int[][] m) {
        Stack<Integer> st = new Stack<>();
        int n = m.length;

        for (int i = 0; i < n; i++) st.push(i);

        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            if (m[a][b] == 1) st.push(b);
            else st.push(a);
        }

        int c = st.pop();
        for (int i = 0; i < n; i++) {
            if (i != c && (m[c][i] == 1 || m[i][c] == 0)) {
                System.out.println("0 celebrity");
                return;
            }
        }
        System.out.println("Celebrity is " + c);
    }

   // Implememnt stack using 2 queues

    static class StackQueue {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        void push(int x) {
            q2.add(x);
            while (!q1.isEmpty())
                q2.add(q1.remove());
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        int pop() {
            return q1.remove();
        }
    }

   //remove invalid parentheses

    static void removeInvalid(String s) {
        Stack<Integer> st = new Stack<>();
        boolean[] rem = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') st.push(i);
            else if (c == ')') {
                if (st.isEmpty()) rem[i] = true;
                else st.pop();
            }
        }

        while (!st.isEmpty())
            rem[st.pop()] = true;

        String ans = "";
        for (int i = 0; i < s.length(); i++)
            if (!rem[i]) ans += s.charAt(i);

        System.out.println(ans);
    }

   //Online stock span problem

    static void stockSpan(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i])
                st.pop();
            res[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        for (int x : res)
            System.out.print(x + " ");
        System.out.println();
    }

    //sort stack without using loops

    static void sortStack(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int x = st.pop();
            sortStack(st);
            insert(st, x);
        }
    }

    static void insert(Stack<Integer> st, int x) {
        if (st.isEmpty() || st.peek() <= x)
            st.push(x);
        else {
            int y = st.pop();
            insert(st, x);
            st.push(y);
        }
    }

    //expression evaluation 
    static int evalPostfix(String s) {
        Stack<Integer> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                st.push(c - '0');
            else {
                int b = st.pop();
                int a = st.pop();
                if (c == '+') st.push(a + b);
                if (c == '-') st.push(a - b);
                if (c == '*') st.push(a * b);
                if (c == '/') st.push(a / b);
            }
        }
        return st.pop();
    }

    //JVM call stack simulation

    static void callStack() {
        Stack<String> st = new Stack<>();
        st.push("main");
        System.out.println(st);
        st.push("login");
        System.out.println(st);
        st.push("validate");
        System.out.println(st);
        st.pop();
        System.out.println(st);
        st.pop();
        System.out.println(st);
    }

    public static void main(String[] args) {

        Assignment_9Feb_Stack ans = new Assignment_9Feb_Stack();

        ans.push(3);
        ans.push(5);
        ans.push(2);
        System.out.println("min is- "+ans.getMin());
        System.out.println("max is-"+ans.getMax());

        decodeString("3[a2[b]]");

        rectangle(new int[]{6,2,5,4,5,1,6});

        celebrity(new int[][]{{0,1,1},{0,0,1},{0,0,0}});

        removeInvalid("a)b(c)d");

        stockSpan(new int[]{100,80,60,70,60,75,85});

        Stack<Integer> st = new Stack<>();
        st.push(3); st.push(1); st.push(2);
        sortStack(st);
        System.out.println(st);

        System.out.println(evalPostfix("(10+5)*2"));

        callStack();
    }
}

package capgemeini_training;

public class Assignment_28Jan_Arr {
    public static void main(String[] args) {
        // returning array from method
        char ch[] = returnChar();
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i] + " ");
        }
        System.out.println("------------");

        // printing array using for loop
        int num[] = { 10, 20, 30 };
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println("------------");

        // for-each loop
        for (int i : num) {
            System.out.print(i + " ");
        }
        System.out.println("------------");

        // Ques1. sum of array elements
        int sum = 0;
        for (int i : num) {
            sum += i;
        }
        System.out.println("Sum is: " + sum);
        System.out.println("------------");

        // Ques2. min element in array
        int min = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] < min) {
                min = num[i];
            }
        }
        System.out.println("Min is: " + min);
        System.out.println("------------");

        // Ques3. max element in array
        int max = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }
        System.out.println("Max is: " + max);
        System.out.println("------------");

        // Ques4. second max element in array
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i : num) {
            if (i > firstMax) {
                secondMax = firstMax;
                firstMax = i;
            } else if (i > secondMax && i != firstMax) {
                secondMax = i;
            }
        }
        System.out.println("Second Max is: " + secondMax);
        System.out.println("------------");

        // Ques6. average of array elements
        double average = (double) sum / num.length;
        System.out.println("Average is: " + average);
        System.out.println("------------");

        // Ques 7. sum of all even indexed elements
        int evenInd = 0;
        for (int i = 0; i < num.length; i += 2) {
            evenInd += num[i];
        }
        System.out.println("Sum of even indexed elements is: " + evenInd);
        System.out.println("------------");

        // Ques8. sum of all odd indexed elements
        int oddInd = 0;
        for (int i = 1; i < num.length; i += 2) {
            oddInd += num[i];
        }
        System.out.println("Sum of odd indexed elements is: " + oddInd);
        System.out.println("------------");

        // Ques9. find min value of all even indexed elem
        int minEvenInd = num[0];
        for (int i = 0; i < num.length; i += 2) {
            if (num[i] < minEvenInd) {
                minEvenInd = num[i];
            }
        }
        System.out.println("Min of even indexed elements is: " + minEvenInd);
        System.out.println("------------");

        // Ques10. find max value of all odd indexed elem
        int maxOddInd = Integer.MIN_VALUE;
        for (int i = 1; i < num.length; i += 2) {
            if (num[i] > maxOddInd) {
                maxOddInd = num[i];
            }
        }
        System.out.println("Max of odd indexed elements is: " + maxOddInd);
        System.out.println("------------");

        // Ques11.avg alue from all even indexed elem
        double avgEvenInd = (double) evenInd / (num.length / 2 + num.length % 2);
        System.out.println("Avg of even indexed elements is: " + avgEvenInd);
        System.out.println("------------");

        //Ques12. avg alue from all odd indexed elem
        double avgOddInd = (double) oddInd / (num.length / 2);
        System.out.println("Avg of odd indexed elements is: " + avgOddInd);
         System.out.println("------------");

        // Ques13.sum of all elements from a first half of an array
        int sumFirstHalf = 0;
        for (int i = 0; i < num.length / 2; i++) {
            sumFirstHalf += num[i];
        }
        System.out.println("Sum of first half elements is: " + sumFirstHalf);
        System.out.println("------------");

        //Ques 14. sum of all elements from a second half of an array
        int secondHalf=0;
        for(int i=num.length/2;i<num.length;i++) {
            secondHalf+=num[i];
        }
        System.out.println("Sum of second half elements is: " + secondHalf);
         System.out.println("------------");

         //Ques 15. min value from first half of an array
         int minFirstHalf=num[0];
            for(int i=1;i<num.length/2;i++) {
                if(num[i]<minFirstHalf) {
                    minFirstHalf=num[i];
                }
            }
            System.out.println("Min of first half elements is: " + minFirstHalf);
             System.out.println("------------");

             //Ques 16. min value from second half of an array
                int minSecondHalf=num[num.length/2];    
                for(int i=num.length/2+1;i<num.length;i++) {
                    if(num[i]<minSecondHalf) {
                        minSecondHalf=num[i];
                    }
                }
                System.out.println("Min of second half elements is: " + minSecondHalf);
                 System.out.println("------------");

                 // 


    }

    public static char[] returnChar() {
        char ch[] = { 'a', 'b', 'c', 'd', 'e' };
        return ch;
    }
}

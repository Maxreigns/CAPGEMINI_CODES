package capgemeini_training;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment_4Feb_Collection1 {
    public static void main(String[] args) {
        ArrayList<String> foodName = new ArrayList<>();    ArrayList<Integer> price = new ArrayList<>();
        price.add(100);
        price.add(200);
        price.add(300);
        price.add(400);
        System.out.println("Prices are- " + price);
        foodName.add("Paneer");
        foodName.add("Rice");
        foodName.add("Noodles");
        foodName.add("Dosa");
        System.out.println("Food Items are- " + foodName);
        for (String a : foodName) {
            System.out.println(a);
        }
        System.out.println("size is- " + foodName.size());
        foodName.remove("Rice");
        System.out.println("After removing Rice- " + foodName);
        foodName.contains("Rice");
        System.out.println(" Rice present? - " + foodName.contains("Rice"));
        foodName.removeAll(foodName);
        System.out.println(" removing all elements- " + foodName);
        System.out.println("is empty?-" + foodName.isEmpty());

        // Scenario-For college Addmission
      Scanner sc = new Scanner(System.in);
      ArrayList<String> Name = new ArrayList<>();
     System.out.println("Enter name to add-");
     String n = sc.nextLine();
     Name.add(n);
     System.out.println("List is- " + Name);
     System.out.println("Enter name to delete-");
     String d = sc.nextLine();
     Name.remove(d);
     System.out.println("List after delete- " + Name);
     System.out.println("Enter index to update-");
     int u = sc.nextInt();
       System.out.println("Enter data to update-");
       String u1 = sc.nextLine();
       Name.set(u, u1);
       System.out.println("List after update- " + Name);
    

        // dice game - for 2 players- there should be two option stop start for roll from user

        System.out.println("Dice game result-");
        ArrayList<Integer> roll = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            System.out.println("choose 1 to start roll and 2 to stop");
            int option=sc.nextInt();
            if(option==1){
            int dice = (int)(Math.random() * 6) + 1;
            roll.add(dice);
             System.out.println("Player"+i+"rolled-"+dice);
        }
    }
        if (roll.get(0) > roll.get(1)) {
            System.out.println("Player1 wins");
        } else {
            System.out.println("Player2 wins");
        }

    //snake game
    int posx=0;
    int posy=0;
    int foodx= (int)(Math.random()*10)+1;
    int foody=(int)(Math.random()*10)+1;
     System.out.println("Up -U, Down-D, Left-L, right-R");
    while(true){
       char step=sc.next().charAt(0);
       if(step=='U'){
        posy++;
       }
       else if(step=='D'){
        posy--;
       }
       else if(step=='L'){
        posx--;
       }
       else if(step=='R'){
        posx++;
       }
else{
    System.out.println("write correct step");
}
if(posx<0 || posx>10 || posy<0 || posy>10){
    System.out.println("finish");
    break;
    }
    int score=0;
    if(posx==foodx && posy==foody){
        score++;
        System.out.println("food eaten");
        foodx= (int)(Math.random()*10)+1;
        foody=(int)(Math.random()*10)+1;
    }
   System.out.println("score is "+score);
    }
      sc.close();
}
}

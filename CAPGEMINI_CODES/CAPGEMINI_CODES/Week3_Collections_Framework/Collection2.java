package capgemeini_training;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment_5Feb_Collection2 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

        ArrayList<String> mobileCart = new ArrayList<>();
        String customerName = "";

        while (true) {
            System.out.println("1 Add Customer Name");
            System.out.println("2 Add Mobile to Cart");
            System.out.println("3 View Cart Size");
            System.out.println("4 Remove Mobile from Cart");
            System.out.println("5 View Mobile at Index");
            System.out.println("6 Exit");
            System.out.print("Choose option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("number only");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter customer name: ");
                    customerName = sc.nextLine();
                    break;

                case 2:
                    System.out.print("Enter mobile name to add- ");
                    String mobileName = sc.nextLine();
                    mobileCart.add(mobileName);
                    break;

                case 3:
                    System.out.println("size of cart is- " + mobileCart.size());
                    break;

                case 4:
                    System.out.print("Enter mobile name to remove: ");
                    String removeMobile = sc.nextLine();
                    if (mobileCart.remove(removeMobile)) {
                        System.out.println("Updated Cart: " + mobileCart);
                    } else {
                        System.out.println("Mobile not found in cart");
                    }
                    break;

                case 5:
                    System.out.print("Enter index: ");
                    int index;
                    try {
                        index = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Invalid index");
                        break;
                    }

                    if (index >= 0 && index < mobileCart.size()) {
                        System.out.println("Mobile at index " + index + ": " + mobileCart.get(index));
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case 6:
                    System.out.println("Customer Name: " + customerName);
                    System.out.println("Mobiles in Cart: " + mobileCart);
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
        }
    }

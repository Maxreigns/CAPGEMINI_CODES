package capgemeini_training;

import java.util.ArrayList;
import java.util.Scanner;
       //task- customer detail, product detail, delivery details, product is delivered or not

class Customer {
    int customerId;
    String name;
    String address;
    long mobile;

    Customer(int customerId, String name, String address, long mobile) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }
}

class Product {
    int productId;
    String productName;
    double price;
    boolean delivered;
    int deliveredToCustomer;

    Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.delivered = false;
        this.deliveredToCustomer = -1;
    }
}

public class Logistic_Management_System {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();

        while (true) {
            System.out.println("1 add customer");
            System.out.println("2 add product");
            System.out.println("3 deliver product");
            System.out.println("4 view details");
            System.out.println("5 Exit");
            System.out.print("Enter yur choice- ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Customer ID- ");
                    int cid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name- ");
                    String cname = sc.nextLine();

                    System.out.print("Enter Address- ");
                    String address = sc.nextLine();

                    System.out.print("Enter Mobile- ");
                    long mobile = sc.nextLong();

                    customers.add(new Customer(cid, cname, address, mobile));
                    break;

                case 2:
                    System.out.print("Enter Product ID- ");
                    int pid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product Name- ");
                    String pname = sc.nextLine();

                    System.out.print("Enter Price- ");
                    double price = sc.nextDouble();

                    products.add(new Product(pid, pname, price));
                    break;

                case 3:
                    System.out.print("Enter Product ID to deliver- ");
                    int deliverPid = sc.nextInt();

                    System.out.print("Enter Customer ID- ");
                    int deliverCid = sc.nextInt();

                    boolean delivered = false;

                    for (Product p : products) {
                        if (p.productId == deliverPid && !p.delivered) {
                            p.delivered = true;
                            p.deliveredToCustomer = deliverCid;
                            delivered = true;
                            break;
                        }
                    }

                    if (!delivered) {
                        System.out.println("Invalid Product ID or already delivered");
                    }
                    break;

                case 4:
                    for (Customer c : customers) {
                        System.out.println("ID- " + c.customerId +
                                ", Name- " + c.name +
                                ", Address- " + c.address +
                                ", Mobile- " + c.mobile);
                    }
                    for (Product p : products) {
                        System.out.println("ID- " + p.productId +
                                ", Name- " + p.productName +
                                ", Price- " + p.price +
                                ", Delivered- " + (p.delivered ? "Yes" : "No") +
                                (p.delivered ? ", Customer ID- " + p.deliveredToCustomer : ""));
                    }
                    break;

                case 5:
                    System.out.println("Exit");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}


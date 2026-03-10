import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class LMS {

    static class Customer {
        String id;
        String name;
        String address;
        String phone;

        Customer(String name, String address, String phone) {
            this.id = "C-" + UUID.randomUUID().toString().substring(0, 8);
            this.name = name;
            this.address = address;
            this.phone = phone;
        }

        public String toString() {
            return id + " | " + name + " | " + address + " | " + phone;
        }
    }

    static class Product {
        String id;
        String name;
        int qty;

        Product(String name, int qty) {
            this.id = "P-" + UUID.randomUUID().toString().substring(0, 8);
            this.name = name;
            this.qty = qty;
        }

        public String toString() {
            return id + " | " + name + " | Qty: " + qty;
        }
    }

    static class DeliveryPerson {
        String id;
        String name;
        String phone;
        String currentLocation; // freeform address or description

        DeliveryPerson(String name, String phone, String currentLocation) {
            this.id = "DP-" + UUID.randomUUID().toString().substring(0, 8);
            this.name = name;
            this.phone = phone;
            this.currentLocation = currentLocation;
        }

        public String toString() {
            return id + " | " + name + " | " + phone + " | Location: " + currentLocation;
        }
    }

    static class Delivery {
        String id;
        String customerId;
        ArrayList<String> productIds;
        String status; // Pending, Dispatched, Delivered
        String assignedPersonId; // optional
        String deliveryLocation; // snapshot (could be customer's address or overridden)

        Delivery(String customerId, ArrayList<String> productIds, String deliveryLocation) {
            this.id = "D-" + UUID.randomUUID().toString().substring(0, 8);
            this.customerId = customerId;
            this.productIds = new ArrayList<>(productIds);
            this.status = "Pending";
            this.assignedPersonId = null;
            this.deliveryLocation = deliveryLocation;
        }

        public String toString() {
            return id
                    + " | Customer: " + customerId
                    + " | Products: " + productIds
                    + " | Status: " + status
                    + " | Person: " + (assignedPersonId == null ? "None" : assignedPersonId)
                    + " | Location: " + deliveryLocation;
        }
    }

    // Collections to store data
    static HashMap<String, Customer> customers = new HashMap<>();
    static HashMap<String, Product> products = new HashMap<>();
    static HashMap<String, Delivery> deliveries = new HashMap<>();
    static HashMap<String, DeliveryPerson> deliveryPersons = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        seedSampleData();

        while (true) {
            System.out.println("\nMenu: 1) Add Customer 2) Add Product 3) Create Delivery 4) Update Delivery Status 5) List All 6) Exit 7) Add Delivery Person 8) Assign Person to Delivery");
            System.out.print("Choose: ");
            String choice = in.nextLine().trim();
            switch (choice) {
                case "1": addCustomer(in); break;
                case "2": addProduct(in); break;
                case "3": createDelivery(in); break;
                case "4": updateDeliveryStatus(in); break;
                case "5": listAll(); break;
                case "6": System.out.println("Exiting."); in.close(); return;
                case "7": addDeliveryPerson(in); break;
                case "8": assignPersonToDelivery(in); break;
                default: System.out.println("Invalid choice."); break;
            }
        }
    }

    static void addCustomer(Scanner in) {
        System.out.print("Name: ");
        String name = in.nextLine().trim();
        System.out.print("Address: ");
        String address = in.nextLine().trim();
        System.out.print("Phone: ");
        String phone = in.nextLine().trim();
        if (name.isEmpty()) { System.out.println("Name required."); return; }
        Customer c = new Customer(name, address, phone);
        customers.put(c.id, c);
        System.out.println("Added customer: " + c.id);
    }

    static void addProduct(Scanner in) {
        System.out.print("Product name: ");
        String name = in.nextLine().trim();
        System.out.print("Quantity: ");
        String qline = in.nextLine().trim();
        try {
            int qty = Integer.parseInt(qline);
            if (qty < 0) { System.out.println("Quantity must be >= 0."); return; }
            Product p = new Product(name, qty);
            products.put(p.id, p);
            System.out.println("Added product: " + p.id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity.");
        }
    }

    static void addDeliveryPerson(Scanner in) {
        System.out.print("Name: ");
        String name = in.nextLine().trim();
        System.out.print("Phone: ");
        String phone = in.nextLine().trim();
        System.out.print("Current location (address/description): ");
        String loc = in.nextLine().trim();
        if (name.isEmpty()) { System.out.println("Name required."); return; }
        DeliveryPerson dp = new DeliveryPerson(name, phone, loc);
        deliveryPersons.put(dp.id, dp);
        System.out.println("Added delivery person: " + dp.id);
    }

    static void createDelivery(Scanner in) {
        if (customers.isEmpty()) { System.out.println("No customers available."); return; }
        if (products.isEmpty()) { System.out.println("No products available."); return; }

        System.out.println("Customers:");
        for (Customer c : customers.values()) System.out.println(c);
        System.out.print("Enter customer id: ");
        String cid = in.nextLine().trim();
        Customer chosenCustomer = customers.get(cid);
        if (chosenCustomer == null) { System.out.println("Invalid customer id."); return; }

        ArrayList<String> chosen = new ArrayList<>();
        while (true) {
            System.out.println("Products:");
            for (Product p : products.values()) System.out.println(p);
            System.out.print("Enter product id to add (or blank to finish): ");
            String pid = in.nextLine().trim();
            if (pid.isEmpty()) break;
            Product prod = products.get(pid);
            if (prod == null) { System.out.println("Invalid product id."); continue; }
            System.out.print("Quantity required: ");
            String qline = in.nextLine().trim();
            try {
                int need = Integer.parseInt(qline);
                if (need <= 0) { System.out.println("Must be >0."); continue; }
                if (need > prod.qty) { System.out.println("Not enough stock. Available: " + prod.qty); continue; }
                prod.qty -= need;
                for (int i = 0; i < need; i++) chosen.add(prod.id);
                System.out.println("Added " + need + " of " + prod.name);
            } catch (NumberFormatException e) { System.out.println("Invalid number."); }
        }

        if (chosen.isEmpty()) { System.out.println("No products chosen. Delivery not created."); return; }

        // use customer's address as default delivery location
        Delivery d = new Delivery(cid, chosen, chosenCustomer.address);
        // optionally assign a delivery person now
        if (!deliveryPersons.isEmpty()) {
            System.out.println("Delivery persons:");
            for (DeliveryPerson dp : deliveryPersons.values()) System.out.println(dp);
            System.out.print("Enter delivery person id to assign now (or blank to skip): ");
            String dpId = in.nextLine().trim();
            if (!dpId.isEmpty()) {
                if (deliveryPersons.containsKey(dpId)) {
                    d.assignedPersonId = dpId;
                } else {
                    System.out.println("Invalid delivery person id. Skipping assignment.");
                }
            }
        }

        deliveries.put(d.id, d);
        System.out.println("Created delivery: " + d.id);
    }

    static void assignPersonToDelivery(Scanner in) {
        if (deliveries.isEmpty()) { System.out.println("No deliveries."); return; }
        if (deliveryPersons.isEmpty()) { System.out.println("No delivery persons."); return; }
        System.out.println("Deliveries:");
        for (Delivery d : deliveries.values()) System.out.println(d);
        System.out.print("Enter delivery id: ");
        String did = in.nextLine().trim();
        Delivery d = deliveries.get(did);
        if (d == null) { System.out.println("Invalid delivery id."); return; }

        System.out.println("Delivery persons:");
        for (DeliveryPerson dp : deliveryPersons.values()) System.out.println(dp);
        System.out.print("Enter delivery person id to assign (or blank to unassign): ");
        String dpId = in.nextLine().trim();
        if (dpId.isEmpty()) {
            d.assignedPersonId = null;
            System.out.println("Unassigned person from delivery.");
            return;
        }
        if (!deliveryPersons.containsKey(dpId)) { System.out.println("Invalid delivery person id."); return; }
        d.assignedPersonId = dpId;
        System.out.println("Assigned " + dpId + " to delivery " + did);
    }

    static void updateDeliveryStatus(Scanner in) {
        if (deliveries.isEmpty()) { System.out.println("No deliveries."); return; }
        System.out.println("Deliveries:");
        for (Delivery d : deliveries.values()) System.out.println(d);
        System.out.print("Enter delivery id: ");
        String did = in.nextLine().trim();
        Delivery d = deliveries.get(did);
        if (d == null) { System.out.println("Invalid delivery id."); return; }
        System.out.println("Current status: " + d.status);
        System.out.print("Enter new status (Pending/Dispatched/Delivered): ");
        String ns = in.nextLine().trim();
        if (!ns.equals("Pending") && !ns.equals("Dispatched") && !ns.equals("Delivered")) {
            System.out.println("Invalid status."); return;
        }
        d.status = ns;
        System.out.println("Updated.");
    }

    static void listAll() {
        System.out.println("\n--- Customers ---");
        if (customers.isEmpty()) System.out.println("None");
        else for (Customer c : customers.values()) System.out.println(c);

        System.out.println("\n--- Products ---");
        if (products.isEmpty()) System.out.println("None");
        else for (Product p : products.values()) System.out.println(p);

        System.out.println("\n--- Deliveries ---");
        if (deliveries.isEmpty()) System.out.println("None");
        else for (Delivery d : deliveries.values()) System.out.println(d);

        System.out.println("\n--- Delivery Persons ---");
        if (deliveryPersons.isEmpty()) System.out.println("None");
        else for (DeliveryPerson dp : deliveryPersons.values()) System.out.println(dp);
    }

    static void seedSampleData() {
        Customer c1 = new Customer("Alice", "12 Baker St", "555-0101");
        Customer c2 = new Customer("Bob", "99 Sunset Blvd", "555-0202");
        customers.put(c1.id, c1);
        customers.put(c2.id, c2);

        Product p1 = new Product("Laptop", 5);
        Product p2 = new Product("Phone", 10);
        products.put(p1.id, p1);
        products.put(p2.id, p2);

        DeliveryPerson dp1 = new DeliveryPerson("Sam Driver", "555-1000", "Warehouse A");
        deliveryPersons.put(dp1.id, dp1);
    }
}
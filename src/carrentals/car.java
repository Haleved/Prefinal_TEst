package carrentals;

import java.util.Scanner;


public class car {
    public void addcar() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Brand: ");
        String brand = sc.nextLine();
        while (brand.isEmpty()) {
            System.out.print("Brand cannot be empty. Please enter a valid Brand: ");
            brand = sc.nextLine();
        }

        System.out.print("Model: ");
        String model = sc.nextLine();
        while (model.isEmpty()) {
            System.out.print("Model cannot be empty. Please enter a valid Model: ");
            model = sc.nextLine();
        }

        System.out.print("Quantity: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid numeric Quantity: ");
            sc.next();
        }
        int qtty = sc.nextInt();
        while (qtty < 0) {
            System.out.print("Quantity cannot be negative. Please enter a valid Quantity: ");
            qtty = sc.nextInt();
        }

        System.out.print("Price: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid numeric Price: ");
            sc.next();
        }
        int price = sc.nextInt();
        while (price <= 0) {
            System.out.print("Price must be greater than zero. Please enter a valid Price: ");
            price = sc.nextInt();
        }

        String sql = "INSERT INTO cars (car_brand, car_model, car_qtty, car_price) VALUES (?, ?, ?, ?)";
        conf.addRecord(sql, brand, model, qtty, price);
    }

    public void viewcar() {
        String qry = "SELECT car_id, car_brand, car_model, " +
                     "CASE WHEN car_qtty = 0 THEN 'Unavailable' ELSE 'Available' END AS Availability, " +
                     "car_price FROM cars";

        String[] hdrs = {"ID", "Brand", "Model", "Availability", "Price"};
        String[] clmns = {"car_id", "car_brand", "car_model", "Availability", "car_price"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clmns);
    }

    public void updatecar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID to update: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid numeric ID: ");
            sc.next();
        }
        int id = sc.nextInt();

        System.out.print("New Quantity: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid numeric Quantity: ");
            sc.next();
        }
        int nqtty = sc.nextInt();
        while (nqtty < 0) {
            System.out.print("Quantity cannot be negative. Please enter a valid Quantity: ");
            nqtty = sc.nextInt();
        }

        System.out.print("New Price: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid numeric Price: ");
            sc.next();
        }
        int nprice = sc.nextInt();
        while (nprice <= 0) {
            System.out.print("Price must be greater than zero. Please enter a valid Price: ");
            nprice = sc.nextInt();
        }

        String qry = "UPDATE cars SET car_qtty = ?, car_price = ? WHERE car_id = ?";
        config conf = new config();
        conf.updateRecord(qry, nqtty, nprice, id);
    }

    public void deletecar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID to delete: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid numeric ID: ");
            sc.next();
        }
        int id = sc.nextInt();

        String qry = "DELETE FROM cars WHERE car_id = ?";
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}

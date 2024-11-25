package carrentals;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class rental {
    public void addRental() {
        config conf = new config();
        Scanner sc = new Scanner(System.in);

        String customerQuery = "SELECT cst_id AS ID, cst_fname AS 'First Name', cst_lname AS 'Last Name', cst_email AS 'Email', cst_status AS 'Status' FROM customer";
        String[] customerHeaders = {"ID", "First Name", "Last Name", "Email", "Status"};
        String[] customerColumns = {"ID", "First Name", "Last Name", "Email", "Status"};
        conf.viewRecords(customerQuery, customerHeaders, customerColumns);

        String carQuery = "SELECT car_id AS ID, car_brand AS Brand, car_model AS Model, car_qtty AS Availability, car_price AS Price FROM cars";
        String[] carHeaders = {"ID", "Brand", "Model", "Availability", "Price"};
        String[] carColumns = {"ID", "Brand", "Model", "Availability", "Price"};
        conf.viewRecords(carQuery, carHeaders, carColumns);

        System.out.println("==== Add Rental ====");
        
        
        System.out.print("Add Customer ID: ");
        int customerId = validateInteger(sc, "Customer ID");

        
        System.out.print("Add Car ID: ");
        int carId = validateInteger(sc, "Car ID");

        
        LocalDate rentalDate = validateDate(sc, "Rental Date (YYYY-MM-DD)");

        
        LocalDate returnDate = null;
        while (returnDate == null || !returnDate.isAfter(rentalDate)) {
            returnDate = validateDate(sc, "Return Date (YYYY-MM-DD)");
            if (!returnDate.isAfter(rentalDate)) {
                System.out.println("Return date must be after the rental date.");
            }
        }

        
        System.out.print("Paid Amount: ");
        double paidAmount = validateDouble(sc, "Paid Amount");

        
        System.out.print("Status (Active/Inactive): ");
        String status;
        while (true) {
            status = sc.next().trim();
            if (status.equalsIgnoreCase("Active") || status.equalsIgnoreCase("Inactive")) {
                break;
            } else {
                System.out.print("Invalid status. Enter 'Active' or 'Inactive': ");
            }
        }

        String addRentalQuery = "INSERT INTO rentals (cst_id, car_id, rnt_rentdate, rnt_ddate, rnt_pcash, rnt_status) " +
                                "VALUES (?, ?, ?, ?, ?, ?)";

        conf.addRecord(addRentalQuery, customerId, carId, rentalDate.toString(), returnDate.toString(), paidAmount, status);
    }

    public void viewRental() {
        String qry = "SELECT r.rnt_id, r.cst_id, r.car_id, r.rnt_rentdate, r.rnt_ddate, r.rnt_pcash, r.rnt_status, " +
                     "(c.car_price * (julianday(r.rnt_ddate) - julianday(r.rnt_rentdate)) - r.rnt_pcash) AS rnt_dues, " +
                     "(julianday(r.rnt_ddate) - julianday(r.rnt_rentdate)) AS rented_days " +
                     "FROM rentals r " +
                     "JOIN cars c ON r.car_id = c.car_id";

        String[] hdrs = {"ID", "Customer ID", "Car ID", "Rental Date", "Return Date", "Paid Amount", "Status", "Due Amount", "Rented Days"};
        String[] clmns = {"rnt_id", "cst_id", "car_id", "rnt_rentdate", "rnt_ddate", "rnt_pcash", "rnt_status", "rnt_dues", "rented_days"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clmns);
    }

    public void updateRental() {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter Rental ID to update: ");
        int id = validateInteger(sc, "Rental ID");

        
        LocalDate newReturnDate = validateDate(sc, "New Return Date (YYYY-MM-DD)");

        
        System.out.print("New Paid Amount: ");
        double newPaidAmount = validateDouble(sc, "New Paid Amount");

        
        System.out.print("New Status (Active/Inactive): ");
        String newStatus;
        while (true) {
            newStatus = sc.next().trim();
            if (newStatus.equalsIgnoreCase("Active") || newStatus.equalsIgnoreCase("Inactive")) {
                break;
            } else {
                System.out.print("Invalid status. Enter 'Active' or 'Inactive': ");
            }
        }

        String qry = "UPDATE rentals SET rnt_ddate = ?, rnt_pcash = ?, rnt_status = ? WHERE rnt_id = ?";
        config conf = new config();
        conf.updateRecord(qry, newReturnDate.toString(), newPaidAmount, newStatus, id);
    }

    public void deleteRental() {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter Rental ID to delete: ");
        int id = validateInteger(sc, "Rental ID");

        String qry = "DELETE FROM rentals WHERE rnt_id = ?";
        config conf = new config();
        conf.deleteRecord(qry, id);
    }

    
    private int validateInteger(Scanner sc, String prompt) {
        int value;
        while (true) {
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                break;
            } else {
                System.out.print("Invalid input. Please enter a valid numeric value for " + prompt + ": ");
                sc.next();
            }
        }
        return value;
    }

    
    private double validateDouble(Scanner sc, String prompt) {
        double value;
        while (true) {
            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
                break;
            } else {
                System.out.print("Invalid input. Please enter a valid numeric value for " + prompt + ": ");
                sc.next();
            }
        }
        return value;
    }

    
    private LocalDate validateDate(Scanner sc, String prompt) {
        LocalDate date = null;
        while (date == null) {
            System.out.print(prompt + ": ");
            String input = sc.next();
            try {
                date = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
            }
        }
        return date;
    }
}

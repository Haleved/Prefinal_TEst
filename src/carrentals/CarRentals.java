package carrentals;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class CarRentals {

   
    public static void main(String[] args) {
        CarRentals rentals = new CarRentals();
        rentals.mainMenu();
        LocalDate currentDate = LocalDate.now();
    }
        
        public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            System.out.println("        ==== Main Menu ====");
            System.out.println("1. Customer Operations");
            System.out.println("2. Car Operations");
            System.out.println("3. Rental Operations");
            System.out.println("4. View Report");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
             while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number:");
                sc.next(); 
            }
            
            int action = sc.nextInt();

            switch (action) {
                case 1:
                    customerMenu();
                    break;
                case 2:
                    carMenu();
                    break;
                case 3:
                    rentalMenu();
                    break;
                case 4:
                    reportmenu ();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again:");
            }
        }
        System.out.println("Thank you, See you later!");
    }

    public void customerMenu() {
        Scanner sc = new Scanner(System.in);
        boolean back = false;

        while (!back) {
            System.out.println("        ==== Customer Menu ====");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. View Customer");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            
             while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number:");
                sc.next();
            }
            
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addpeople();
                    break;
                case 2:
                    viewpeople();
                    updatepeople();
                    viewpeople();
                    break;
                case 3:
                    viewpeople();
                    deletepeople();
                    viewpeople();
                    break;
                case 4:
                    viewpeople();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again:");
            }
        }
    }  
    
    public void carMenu() {
      Scanner sc = new Scanner(System.in);
        boolean back = false;

        while (!back) {
            System.out.println("        ==== Car Menu ====");
            System.out.println("1. Add Car");
            System.out.println("2. Update Car");
            System.out.println("3. Delete Car");
            System.out.println("4. View Car");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            
             while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number:");
                sc.next();
            }
            
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addcar();
                    break;
                case 2:
                    viewcar();
                    updatecar();
                    viewcar();
                    break;
                case 3:
                    viewcar();
                    deletecar();
                    viewcar();
                    break;
                case 4:
                    viewcar();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again:");
            }
        }
    }

    public void reportmenu() {
        Scanner sc = new Scanner(System.in);
        boolean back = false;

        while (!back) {
            System.out.println("        ==== View Report ====");
            System.out.println("1. View General Report");
            System.out.println("2. View Specific Report");         
            System.out.println("3. Back to Main Menu");
            System.out.print("Select an option: ");
            
             while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number:");
                sc.next();
            }
            
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewgreport();
                    break;
                case 2 :
                    viewsreport();
                    break;
                case 3 :
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again:");
            }
        }
    }
    
    private void rentalMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean back = false;
        
        while (!back) {
            System.out.println("        ==== Rental Menu ====");
            System.out.println("1. Add Rental");
            System.out.println("2. Update Rental");
            System.out.println("3. Delete Rental");
            System.out.println("4. View Rental");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select Action: ");
            
             while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number:");
                sc.next();
            }
            
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addRental();
                    break;
                case 2:
                    viewRental();
                    updateRental();
                    viewRental();
                    break;
                case 3:
                    viewRental();
                    deleteRental();
                    viewRental();
                    break;
                case 4:
                    viewRental();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
            }
        } 
    }
    
    public void addpeople(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("First Name: ");
        String fname = sc.next();
        System.out.print("Last Name: ");
        String lname = sc.next();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Status (): ");
        String status = sc.next();

        String sql = "INSERT INTO customer (cst_fname, cst_lname, cst_email, cst_status) VALUES (?, ?, ?, ?)";


        conf.addRecord(sql, fname, lname, email, status);

        }
    
    private void viewpeople() {
        String qry = "SELECT * FROM customer";
        String[] hdrs = {"ID", "First Name", "Last Name", "Email", "Status"};
        String[] clmns = {"cst_id", "cst_fname", "cst_lname", "cst_email", "cst_status"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clmns);
        }

    private void updatepeople(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
             
        System.out.print("New First Name: ");
        String nfname = sc.next();
        System.out.print("New Last Name: ");
        String nlname = sc.next();
        System.out.print("New Email: ");
        String nemail = sc.next();
        System.out.print("New Status: ");
        String nstatus = sc.next();
                 
        String qry = "UPDATE customer SET cst_fname = ?, cst_lname = ?, cst_email = ?, cst_status = ? WHERE cst_id = ?";
                 
        config conf = new config();
        conf.updateRecord(qry, nfname, nlname, nemail, nstatus, id);
        }
             
    private void deletepeople(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to delete: ");
        int id = sc.nextInt();
             
        String qry = "DELETE FROM customer WHERE cst_id = ?";
             
        config conf = new config();
        conf.deleteRecord(qry, id);
        }
             
    public void addcar(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Brand: ");
        String brand = sc.next();
        System.out.print("Model: ");
        String model = sc.next();
        System.out.print("Quantity: ");
        int qtty = sc.nextInt();
        System.out.print("Price: ");
        int price = sc.nextInt();
                
        String sql = "INSERT INTO cars (car_brand, car_model, car_qtty, car_price) VALUES (?, ?, ?, ?)";
        conf.addRecord(sql, brand, model, qtty, price);

        }
    
    private void viewcar() {
        String qry = "SELECT car_id, car_brand, car_model, " +
                 "CASE WHEN car_qtty = 0 THEN 'Unavailable' ELSE 'Available' END AS Availability, " +
                 "car_price FROM cars";
    
        String[] hdrs = {"ID", "Brand", "Model", "Availability", "Price"};
        String[] clmns = {"car_id", "car_brand", "car_model", "Availability", "car_price"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clmns);
        }

    private void updatecar(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
             
        System.out.print("New Quantity: ");
        int nqtty = sc.nextInt();
        System.out.print("New Price: ");
        int nprice = sc.nextInt();
                 
        String qry = "UPDATE cars SET car_qtty = ?, car_price = ? WHERE car_id = ?";
                 
        config conf = new config();
        conf.updateRecord(qry, nqtty,  nprice, id);
        }
             
    private void deletecar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to delete: ");
        int id = sc.nextInt();
             
        String qry = "DELETE FROM cars WHERE car_id = ?";
             
        config conf = new config();
        conf.deleteRecord(qry, id);
        }
             
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
        int customerId = sc.nextInt();
        System.out.print("Add Car ID: ");
        int carId = sc.nextInt();

        LocalDate rentalDate = null;
        LocalDate returnDate = null;
    
        boolean validDate = false;
        while (!validDate) {
            System.out.print("Rental Date (YYYY-MM-DD): ");
            String rentalDateInput = sc.next();
                try {
                rentalDate = LocalDate.parse(rentalDateInput);
                validDate = true;
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                        }
                        try {
                            rentalDate = LocalDate.parse(rentalDateInput);
                            validDate = true;
                            } catch (DateTimeParseException e) { 
                                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                            }
                        }
        validDate = false;
            while (!validDate) {
                System.out.print("Return Date (YYYY-MM-DD): ");
                String returnDateInput = sc.next();
                    try {
                    returnDate = LocalDate.parse(returnDateInput); 
                    validDate = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                        }
                            try {
                                returnDate = LocalDate.parse(returnDateInput); 
                                 validDate = true;
                                    } catch (DateTimeParseException e) {
                                        System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                                    }
                                }

        System.out.print("Paid Amount: ");
        double paidAmount = sc.nextDouble();
        System.out.print("Status (Active/Inactive): ");
        String status = sc.next();

        String addRentalQuery = "INSERT INTO rentals (cst_id, car_id, rnt_rentdate, rnt_ddate, rnt_pcash, rnt_status) " +
                            "VALUES (?, ?, ?, ?, ?, ?)";

        conf.addRecord(addRentalQuery, customerId, carId, rentalDate.toString(), returnDate.toString(), paidAmount, status);
            }
                          
    private void viewRental() {
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

    private void updateRental(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
             
        System.out.print("New Return Date: ");
        String nrtrdate = sc.next();
        System.out.print("New Paid Amount: ");
        int npcash = sc.nextInt();
        System.out.print("New Status: ");
        String nstatus = sc.next();
                 
        String qry = "UPDATE rentals SET rnt_duedate = ?, rnt_pcash = ?, rnt_status = ? WHERE rnt_id = ?";
                 
        config conf = new config();
        conf.updateRecord(qry, nrtrdate, npcash, nstatus, id);
             }
             
    private void deleteRental(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to delete: ");
        int id = sc.nextInt();
             
        String qry = "DELETE FROM rentals WHERE rnt_id = ?";
             
        config conf = new config();
        conf.deleteRecord(qry, id);
             }
    
    private void viewgreport() {
        config conf = new config(); 
        System.out.println("       ==== General Reports ====");
        
        String totalCarsRentedQuery = "SELECT COUNT(*) AS total_rentals FROM rentals";
        String[] headers1 = {"Total Rentals"};
        String[] columns1 = {"total_rentals"};
        conf.viewRecords(totalCarsRentedQuery, headers1, columns1);

        String totalRevenueQuery = "SELECT SUM(rnt_pcash) AS total_revenue FROM rentals";
        String[] headers2 = {"Total Revenue"};
        String[] columns2 = {"total_revenue"};
        conf.viewRecords(totalRevenueQuery, headers2, columns2);

        String mostRentedCarQuery = 
                "SELECT car_model, COUNT(r.car_id) AS times_rented " +
                "FROM rentals r " +
                "JOIN cars c ON r.car_id = c.car_id " +
                "GROUP BY car_model " +
                "ORDER BY times_rented DESC " +
                "LIMIT 1";
        String[] headers3 = {"Most Rented Car", "Times Rented"};
        String[] columns3 = {"car_model", "times_rented"};
        conf.viewRecords(mostRentedCarQuery, headers3, columns3);
        }
    
    private void viewsreport() {
    config conf = new config();
    Scanner sc = new Scanner(System.in);
    boolean back = false;

    while (!back) {
        System.out.println("==== Specific Reports ====");
        System.out.println("1. View All Active Rentals");
        System.out.println("2. View Overdue Rentals");
        System.out.println("3. View Customer Rental History");
        System.out.println("4. Back To Reports");
        System.out.print("Select an option: ");
        int specificChoice = sc.nextInt();

        switch (specificChoice) {
            case 1:
                String activeRentalsQuery = "SELECT rnt_id, cst_id, car_id, rnt_rentdate, rnt_ddate, rnt_pcash, rnt_status " +
                                            "FROM rentals WHERE LOWER(rnt_status) = 'active'";
                String[] activeHeaders = {"ID", "Customer ID", "Car ID", "Rental Date", "Return Date", "Paid Amount", "Status"};
                String[] activeColumns = {"rnt_id", "cst_id", "car_id", "rnt_rentdate", "rnt_ddate", "rnt_pcash", "rnt_status"};
                conf.viewRecords(activeRentalsQuery, activeHeaders, activeColumns);
                break;

            case 2:
                String overdueQuery = "SELECT rnt_id, cst_id, car_id, rnt_rentdate, rnt_ddate, rnt_pcash, rnt_status " +
                                      "FROM rentals WHERE rnt_ddate < DATE('now') AND LOWER(rnt_status) = 'active'";
                String[] overdueHeaders = {"ID", "Customer ID", "Car ID", "Rental Date", "Due Date", "Paid Amount", "Status"};
                String[] overdueColumns = {"rnt_id", "cst_id", "car_id", "rnt_rentdate", "rnt_ddate", "rnt_pcash", "rnt_status"};
                conf.viewRecords(overdueQuery, overdueHeaders, overdueColumns);
                break;

            case 3:
                viewpeople();
                System.out.print("Enter Customer ID: ");
                int custId = sc.nextInt();

                String historyQuery = "SELECT rnt_id, car_id, rnt_rentdate, rnt_ddate, rnt_pcash, rnt_status " +
                                      "FROM rentals WHERE cst_id = " + custId;
                String[] historyHeaders = {"ID", "Car ID", "Rental Date", "Return Date", "Paid Amount", "Status"};
                String[] historyColumns = {"rnt_id", "car_id", "rnt_rentdate", "rnt_ddate", "rnt_pcash", "rnt_status"};
                conf.viewRecords(historyQuery, historyHeaders, historyColumns);
                break;

            case 4:
                back = true;
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}
    }
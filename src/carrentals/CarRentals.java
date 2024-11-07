package carrentals;

import java.util.Scanner;


public class CarRentals {

   
    public static void main(String[] args) {
        CarRentals rentals = new CarRentals();
        rentals.mainMenu();
    }
        
        public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            System.out.println("==== Main Menu ====");
            System.out.println("1. Customer Operations");
            System.out.println("2. Car Operations");
            System.out.println("3. Rental Operations");
            System.out.println("4. View");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
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
                    viewMenu ();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        System.out.println("Thank you, See you later!");
    }

    
    public void customerMenu() {
        Scanner sc = new Scanner(System.in);
        boolean back = false;

        while (!back) {
            System.out.println("==== Customer Menu ====");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");
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
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    
    public void carMenu() {
      Scanner sc = new Scanner(System.in);
        boolean back = false;

        while (!back) {
            System.out.println("==== Car Menu ====");
            System.out.println("1. Add Car");
            System.out.println("2. Update Car");
            System.out.println("3. Delete Car");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");
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
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        
    }


    public void viewMenu() {
        Scanner sc = new Scanner(System.in);
        boolean back = false;

        while (!back) {
            System.out.println("==== View Menu ====");
            System.out.println("1. View Customers");
            System.out.println("2. View Cars");
            System.out.println("3. View Rentals");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewpeople();
                    break;
                case 2:
                    viewcar();
                    break;
                case 3:    
                    viewRental();
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private void rentalMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("==== Rental Menu ====");
            System.out.println("1. Add Rental");
            System.out.println("2. Update Rental");
            System.out.println("3. Delete Rental");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select Action: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addRental();
                    break;
                case 2:
                    updateRental();
                    break;
                case 3:
                    deleteRental();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
            }
        } while (choice != 4);
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
                System.out.print("Status: ");
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
        String qry = "SELECT * FROM cars";
        String[] hdrs = {"ID", "Brand", "Model", "Quantity", "Price"};
        String[] clmns = {"car_id", "car_brand", "car_model", "car_qtty", "car_price"};

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
             
             public void addRental(){
                Scanner sc = new Scanner(System.in);
                config conf = new config();
                System.out.print("Add Customer ID: ");
                String cst_id = sc.next();
                System.out.print("Add Car ID: ");
                String car_id = sc.next();
                System.out.print("Rental Date: ");
                String rtldate = sc.next();
                System.out.print("Return Date: ");
                String rtrdate = sc.next();
                System.out.println("Paid Amount: ");
                int paidcash = sc.nextInt();
                System.out.println("Status: ");
                String status = sc.next();

                String sql = "INSERT INTO rentals (cst_id, car_id, rnt_rentdate, rnt_ddate, rnt_pcash, rnt_status) VALUES (?, ?, ?, ?, ?, ?)";


                conf.addRecord(sql, cst_id, car_id, rtldate, rtrdate, paidcash, status);

        }
             private void viewRental() {
        String qry = "SELECT * FROM rentals";
        String[] hdrs = {"ID", "Customer ID", "Car ID", "Rental Date", "Return Date", "Paid Amount", "Status"};
        String[] clmns = {"car_id", "cst_id", "car_id", "rnt_rentdate", "rnt_ddate", "rnt_pcash", "rnt_status"};

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
                 String npcash = sc.next();
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
             
    }
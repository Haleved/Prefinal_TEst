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

                String sql = "INSERT INTO StudentsG (s_fname, s_lname, s_email, s_status) VALUES (?, ?, ?, ?)";


                conf.addRecord(sql, fname, lname, email, status);

        }
             private void viewpeople() {
        String qry = "SELECT * FROM StudentsG";
        String[] hdrs = {"ID", "First Name", "Last Name", "Email", "Status"};
        String[] clmns = {"s_id", "s_fname", "s_lname", "s_email", "s_status"};

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
                 
                 String qry = "UPDATE StudentsG SET s_fname = ?, s_lname = ?, s_email = ?, s_status = ? WHERE s_id = ?";
                 
                 config conf = new config();
                 conf.updateRecord(qry, nfname, nlname, nemail, nstatus, id);
             }
             
             private void deletepeople(){
             Scanner sc = new Scanner(System.in);
             System.out.println("Enter ID to delete: ");
             int id = sc.nextInt();
             
             String qry = "DELETE FROM StudentsG WHERE s_id = ?";
             
             config conf = new config();
             conf.deleteRecord(qry, id);
             }
             
              public void addcar(){
                Scanner sc = new Scanner(System.in);
                config conf = new config();
                System.out.print("Brand: ");
                String fname = sc.next();
                System.out.print("Model: ");
                String lname = sc.next();
                System.out.print("Quantity: ");
                String email = sc.next();
                

                //String sql = "INSERT INTO StudentsG (s_fname, s_lname, s_email, s_status) VALUES (?, ?, ?, ?)";


                //conf.addRecord(sql, fname, lname, email, status);

        }
             private void viewcar() {
        //String qry = "SELECT * FROM StudentsG";
        //String[] hdrs = {"ID", "First Name", "Last Name", "Email", "Status"};
        //String[] clmns = {"s_id", "s_fname", "s_lname", "s_email", "s_status"};

        config conf = new config();
        //conf.viewRecords(qry, hdrs, clmns);
    }

             private void updatecar(){
             Scanner sc = new Scanner(System.in);
             System.out.print("Enter ID to update: ");
             int id = sc.nextInt();
             
                 System.out.print("New Quantity: ");
                 String nfname = sc.next();
                 System.out.print("New Status: ");
                 String nstatus = sc.next();
                 
                 //String qry = "UPDATE StudentsG SET s_fname = ?, s_lname = ?, s_email = ?, s_status = ? WHERE s_id = ?";
                 
                 config conf = new config();
                 //conf.updateRecord(qry, nfname,  nstatus, id);
             }
             
             private void deletecar(){
             Scanner sc = new Scanner(System.in);
             System.out.println("Enter ID to delete: ");
             int id = sc.nextInt();
             
             //String qry = "DELETE FROM StudentsG WHERE s_id = ?";
             
             config conf = new config();
            // conf.deleteRecord(qry, id);
             }
             
             public void addRental(){
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

                String sql = "INSERT INTO StudentsG (s_fname, s_lname, s_email, s_status) VALUES (?, ?, ?, ?)";


                conf.addRecord(sql, fname, lname, email, status);

        }
             private void viewRental() {
        String qry = "SELECT * FROM StudentsG";
        String[] hdrs = {"ID", "First Name", "Last Name", "Email", "Status"};
        String[] clmns = {"s_id", "s_fname", "s_lname", "s_email", "s_status"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clmns);
    }

             private void updateRental(){
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
                 
                 String qry = "UPDATE StudentsG SET s_fname = ?, s_lname = ?, s_email = ?, s_status = ? WHERE s_id = ?";
                 
                 config conf = new config();
                 conf.updateRecord(qry, nfname, nlname, nemail, nstatus, id);
             }
             
             private void deleteRental(){
             Scanner sc = new Scanner(System.in);
             System.out.println("Enter ID to delete: ");
             int id = sc.nextInt();
             
             String qry = "DELETE FROM StudentsG WHERE s_id = ?";
             
             config conf = new config();
             conf.deleteRecord(qry, id);
             }
             
    }

package carrentals;

import java.util.Scanner;


public class CarRentals {
    
    people peopleManager = new people();
    car carSeer = new car();
    rental rentalDoer = new rental();
    report reportGivee = new report();
   
    public static void main(String[] args) {       
        CarRentals app = new CarRentals();
        app.mainMenu();
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
                    peopleManager.addpeople();
                    break;
                case 2:
                    peopleManager.viewpeople();
                    peopleManager.updatepeople();
                    peopleManager.viewpeople();
                    break;
                case 3:
                    peopleManager.viewpeople();
                    peopleManager.deletepeople();
                    peopleManager.viewpeople();
                    break;
                case 4:
                    peopleManager.viewpeople();
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
                    carSeer.addcar();
                    break;
                case 2:
                    carSeer.viewcar();
                    carSeer.updatecar();
                    carSeer.viewcar();
                    break;
                case 3:
                    carSeer.viewcar();
                    carSeer.deletecar();
                    carSeer.viewcar();
                    break;
                case 4:
                    carSeer.viewcar();
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
                    reportGivee.viewgreport();
                    break;
                case 2 :
                    reportGivee.viewsreport();
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
                    rentalDoer.addRental();
                    break;
                case 2:
                    rentalDoer.viewRental();
                    rentalDoer.updateRental();
                    rentalDoer.viewRental();
                    break;
                case 3:
                    rentalDoer.viewRental();
                    rentalDoer.deleteRental();
                    rentalDoer.viewRental();
                    break;
                case 4:
                    rentalDoer.viewRental();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
            }
        } 
    }
    
}
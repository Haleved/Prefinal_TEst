package carrentals;

import java.util.Scanner;


public class people {
    public void addpeople() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("First Name: ");
        String fname = sc.nextLine();
        while (fname.isEmpty()) {
            System.out.print("First Name cannot be empty. Please enter a valid First Name: ");
            fname = sc.nextLine();
        }

        System.out.print("Last Name: ");
        String lname = sc.nextLine();
        while (lname.isEmpty()) {
            System.out.print("Last Name cannot be empty. Please enter a valid Last Name: ");
            lname = sc.nextLine();
        }

        System.out.print("Email: ");
        String email = sc.nextLine();
        while (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.print("Invalid email format. Please enter a valid Email: ");
            email = sc.nextLine();
        }

        System.out.print("Status (Active/Inactive): ");
        String status = sc.nextLine();
        while (!(status.equalsIgnoreCase("Active") || status.equalsIgnoreCase("Inactive"))) {
            System.out.print("Invalid status. Please enter 'Active' or 'Inactive': ");
            status = sc.nextLine();
        }

        String sql = "INSERT INTO customer (cst_fname, cst_lname, cst_email, cst_status) VALUES (?, ?, ?, ?)";
        conf.addRecord(sql, fname, lname, email, status);
    }

    public void viewpeople() {
        String qry = "SELECT * FROM customer";
        String[] hdrs = {"ID", "First Name", "Last Name", "Email", "Status"};
        String[] clmns = {"cst_id", "cst_fname", "cst_lname", "cst_email", "cst_status"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clmns);
    }

    public void updatepeople() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID to update: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid numeric ID: ");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("New First Name: ");
        String nfname = sc.nextLine();
        while (nfname.isEmpty()) {
            System.out.print("First Name cannot be empty. Please enter a valid First Name: ");
            nfname = sc.nextLine();
        }

        System.out.print("New Last Name: ");
        String nlname = sc.nextLine();
        while (nlname.isEmpty()) {
            System.out.print("Last Name cannot be empty. Please enter a valid Last Name: ");
            nlname = sc.nextLine();
        }

        System.out.print("New Email: ");
        String nemail = sc.nextLine();
        while (!nemail.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.print("Invalid email format. Please enter a valid Email: ");
            nemail = sc.nextLine();
        }

        System.out.print("New Status (Active/Inactive): ");
        String nstatus = sc.nextLine();
        while (!(nstatus.equalsIgnoreCase("Active") || nstatus.equalsIgnoreCase("Inactive"))) {
            System.out.print("Invalid status. Please enter 'Active' or 'Inactive': ");
            nstatus = sc.nextLine();
        }

        String qry = "UPDATE customer SET cst_fname = ?, cst_lname = ?, cst_email = ?, cst_status = ? WHERE cst_id = ?";
        config conf = new config();
        conf.updateRecord(qry, nfname, nlname, nemail, nstatus, id);
    }

    public void deletepeople() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID to delete: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid numeric ID: ");
            sc.next();
        }
        int id = sc.nextInt();

        String qry = "DELETE FROM customer WHERE cst_id = ?";
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}
package carrentals;

import java.util.Scanner;


public class report {
   public void viewgreport() {
        config conf = new config();
        System.out.println("       ==== General Reports ====");

        try {
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
        } catch (Exception e) {
            System.out.println("An error occurred while fetching general reports. Please try again.");
        }
    }

    public void viewsreport() {
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

            int specificChoice = -1;
            if (sc.hasNextInt()) {
                specificChoice = sc.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next(); // Clear the invalid input
                continue;
            }

            switch (specificChoice) {
                case 1:
                    try {
                        String activeRentalsQuery = 
                                "SELECT rnt_id, cst_id, car_id, rnt_rentdate, rnt_ddate, rnt_pcash, rnt_status " +
                                "FROM rentals WHERE LOWER(rnt_status) = 'active'";
                        String[] activeHeaders = {"ID", "Customer ID", "Car ID", "Rental Date", "Return Date", "Paid Amount", "Status"};
                        String[] activeColumns = {"rnt_id", "cst_id", "car_id", "rnt_rentdate", "rnt_ddate", "rnt_pcash", "rnt_status"};
                        conf.viewRecords(activeRentalsQuery, activeHeaders, activeColumns);
                    } catch (Exception e) {
                        System.out.println("Error fetching active rentals. Please try again.");
                    }
                    break;

                case 2:
                    try {
                        String overdueQuery = 
                                "SELECT rnt_id, cst_id, car_id, rnt_rentdate, rnt_ddate, rnt_pcash, rnt_status " +
                                "FROM rentals WHERE rnt_ddate < DATE('now') AND LOWER(rnt_status) = 'active'";
                        String[] overdueHeaders = {"ID", "Customer ID", "Car ID", "Rental Date", "Due Date", "Paid Amount", "Status"};
                        String[] overdueColumns = {"rnt_id", "cst_id", "car_id", "rnt_rentdate", "rnt_ddate", "rnt_pcash", "rnt_status"};
                        conf.viewRecords(overdueQuery, overdueHeaders, overdueColumns);
                    } catch (Exception e) {
                        System.out.println("Error fetching overdue rentals. Please try again.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    if (sc.hasNextInt()) {
                        int custId = sc.nextInt();
                        try {
                            String historyQuery = 
                                    "SELECT rnt_id, car_id, rnt_rentdate, rnt_ddate, rnt_pcash, rnt_status " +
                                    "FROM rentals WHERE cst_id = " + custId;
                            String[] historyHeaders = {"ID", "Car ID", "Rental Date", "Return Date", "Paid Amount", "Status"};
                            String[] historyColumns = {"rnt_id", "car_id", "rnt_rentdate", "rnt_ddate", "rnt_pcash", "rnt_status"};
                            conf.viewRecords(historyQuery, historyHeaders, historyColumns);
                        } catch (Exception e) {
                            System.out.println("Error fetching rental history for customer ID: " + custId);
                        }
                    } else {
                        System.out.println("Invalid Customer ID. Please enter a valid number.");
                        sc.next(); // Clear the invalid input
                    }
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
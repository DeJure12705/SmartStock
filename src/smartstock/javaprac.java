/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstock;

import java.util.Scanner;

public class javaprac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input total bill and paid amount
        System.out.print("Enter total bill: ");
        double totalBill = scanner.nextDouble();
        System.out.print("Enter paid amount: ");
        double paidAmount = scanner.nextDouble();

        // Calculate status
        String status = calculateStatus(totalBill, paidAmount);

        // Output status
        System.out.println("Status: " + status);
    }

    // Method to calculate status
    public static String calculateStatus(double totalBill, double paidAmount) {
        String status;
        if (paidAmount == 0.0) {
            status = "Unpaid";
        } else if (totalBill > paidAmount) {
            status = "Partial";
        } else {
            status = "Paid";
        }
        return status;
    }
}

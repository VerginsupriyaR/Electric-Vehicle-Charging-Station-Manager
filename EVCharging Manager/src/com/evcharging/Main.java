package com.evcharging;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ChargingService service = new ChargingService();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== EV CHARGING STATION MANAGER ===");
            System.out.println("1. Start Charging Session");
            System.out.println("2. View Session by ID");
            System.out.println("3. View All Sessions");
            System.out.println("4. Update Session");
            System.out.println("5. Delete Session");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Vehicle Number: ");
                    String vno = sc.nextLine();

                    System.out.print("Station Name: ");
                    String station = sc.nextLine();

                    System.out.print("Units Consumed: ");
                    double units = sc.nextDouble();

                    service.startCharging(vno, station, units);
                    System.out.println("Charging session started successfully.");
                    break;

                case 2:
                    System.out.print("Enter Session ID: ");
                    int id = sc.nextInt();

                    ChargingSessionDTO s = service.getSession(id);
                    if (s != null) {
                        System.out.println(
                            s.getSessionId() + " | " +
                            s.getVehicleNumber() + " | " +
                            s.getStationName() + " | " +
                            s.getUnitsConsumed() + " units | ₹" +
                            s.getTotalCost()
                        );
                    } else {
                        System.out.println("Session not found.");
                    }
                    break;

                case 3:
                    List<ChargingSessionDTO> list = service.getAllSessions();
                    System.out.println("\nID | Vehicle | Station | Units | Cost");
                    for (ChargingSessionDTO cs : list) {
                        System.out.println(
                            cs.getSessionId() + " | " +
                            cs.getVehicleNumber() + " | " +
                            cs.getStationName() + " | " +
                            cs.getUnitsConsumed() + " | ₹" +
                            cs.getTotalCost()
                        );
                    }
                    break;

                case 4:
                    System.out.print("Session ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Vehicle Number: ");
                    String nv = sc.nextLine();

                    System.out.print("New Station Name: ");
                    String ns = sc.nextLine();

                    System.out.print("New Units Consumed: ");
                    double nu = sc.nextDouble();

                    service.updateSession(uid, nv, ns, nu);
                    System.out.println("Session updated successfully.");
                    break;

                case 5:
                    System.out.print("Enter Session ID to delete: ");
                    int did = sc.nextInt();

                    service.deleteSession(did);
                    System.out.println("Session deleted successfully.");
                    break;

                case 6:
                    System.out.println("Thank you. Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

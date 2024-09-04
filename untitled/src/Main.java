import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static UserManager userManager = new UserManager();
    private static CarbonTracker carbonTracker = new CarbonTracker();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Carbon Tracker application!");
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create User");
            System.out.println("2. Update User");
            System.out.println("3. Delete User");
            System.out.println("4. Add Carbon Consumption");
            System.out.println("5. Display Carbon Consumption");
            System.out.println("6. Calculate Daily Average");
            System.out.println("7. Calculate Weekly Average");
            System.out.println("8. Calculate Monthly Average");
            System.out.println("9. Exit");

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    userManager.createUser();
                    break;
                case 2:
                    System.out.print("Enter User ID to update: ");
                    String idUpdate = scanner.nextLine();
                    userManager.updateUser(idUpdate);
                    break;
                case 3:
                    System.out.print("Enter User ID to delete: ");
                    String idDelete = scanner.nextLine();
                    userManager.deleteUser(idDelete);
                    break;
                case 4:
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter amount of CO2: ");
                    int amount = scanner.nextInt();
                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    LocalDate startDate = LocalDate.parse(scanner.next());
                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    LocalDate endDate = LocalDate.parse(scanner.next());
                    carbonTracker.addConsumptionRecord(userId, amount, startDate, endDate);
                    break;
                case 5:
                    System.out.print("Enter User ID to display consumption: ");
                    userId = scanner.nextLine();
                    carbonTracker.getConsumptions(userId).
                            values().forEach(consumption -> System.out.println( "this is amount"+consumption.getAmount()+"\n start date:"+consumption.getStartdate()+"\n end date:"+consumption.getEnddate()));
                    break;
                case 6:
                    System.out.print("Enter User ID: ");
                    userId = scanner.nextLine();
                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    startDate = LocalDate.parse(scanner.next());
                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    endDate = LocalDate.parse(scanner.next());
                    System.out.println("Daily Average: " + carbonTracker.calculateDailyAverage(userId, startDate, endDate));
                    break;
                case 7:
                    System.out.print("Enter User ID: ");
                    userId = scanner.nextLine();
                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    startDate = LocalDate.parse(scanner.next());
                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    endDate = LocalDate.parse(scanner.next());
                    System.out.println("Weekly Average: " + carbonTracker.calculateWeeklyAverage(userId, startDate, endDate));
                    break;
                case 8:
                    System.out.print("Enter User ID: ");
                    userId = scanner.nextLine();
                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    startDate = LocalDate.parse(scanner.next());
                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    endDate = LocalDate.parse(scanner.next());
                    System.out.println("Monthly Average: " + carbonTracker.calculateMonthlyAverage(userId, startDate, endDate));
                    break;
                case 9:
                    running = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}

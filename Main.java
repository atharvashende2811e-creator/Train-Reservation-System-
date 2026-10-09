
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TrainService service = new TrainService();

    public static void main(String[] args) {
        int choice;

        System.out.println("====================================");
        System.out.println("     TRAIN RESERVATION SYSTEM");
        System.out.println("====================================");

        do {
            showMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    service.displayAllTrains();
                    break;

                case 2:
                    searchTrains();
                    break;

                case 3:
                    bookTicket();
                    break;

                case 4:
                    checkPNR();
                    break;

                case 5:
                    cancelTicket();
                    break;

                case 6:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please enter 1 to 6."
                    );
            }
        } while (choice != 6);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. View All Trains");
        System.out.println("2. Search Trains");
        System.out.println("3. Book Ticket");
        System.out.println("4. Check PNR Status");
        System.out.println("5. Cancel Ticket");
        System.out.println("6. Exit");
        System.out.println("===============================");
    }

    private static void searchTrains() {
        System.out.print("Enter source station: ");
        String source = scanner.nextLine().trim();

        System.out.print("Enter destination station: ");
        String destination = scanner.nextLine().trim();

        List<Train> results =
            service.searchTrains(source, destination);

        if (results.isEmpty()) {
            System.out.println("No matching trains found.");
        } else {
            System.out.println("\nMatching trains:");
            for (Train train : results) {
                train.displayTrain();
            }
        }
    }

    private static void bookTicket() {
        service.displayAllTrains();

        int trainNumber = readInt(
            "\nEnter train number to book: "
        );

        int count = readInt("Enter number of passengers: ");

        if (count < 1 || count > 100) {
            System.out.println(
                "Passenger count must be between 1 and 100."
            );
            return;
        }

        List<Passenger> passengers = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            System.out.println("\nPassenger " + i);

            System.out.print("Enter name: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                return;
            }

            int age = readInt("Enter age: ");

            if (age < 0 || age > 120) {
                System.out.println("Please enter a valid age.");
                return;
            }

            System.out.print("Enter gender: ");
            String gender = scanner.nextLine().trim();

            if (gender.isEmpty()) {
                System.out.println("Gender cannot be empty.");
                return;
            }

            passengers.add(
                new Passenger(name, age, gender)
            );
        }

        service.bookTicket(trainNumber, passengers);
    }

    private static void checkPNR() {
        System.out.print("Enter PNR number: ");
        String pnr = scanner.nextLine().trim();

        service.checkPNR(pnr);
    }

    private static void cancelTicket() {
        System.out.print("Enter PNR number to cancel: ");
        String pnr = scanner.nextLine().trim();

        service.cancelTicket(pnr);
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(
                    "Please enter a valid whole number."
                );
            }
        }
    }
}

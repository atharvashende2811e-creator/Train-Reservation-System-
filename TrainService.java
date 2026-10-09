
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainService {
    private List<Train> trains;
    private Map<String, Booking> bookings;
    private int pnrCounter = 1001;

    public TrainService() {
        trains = new ArrayList<>();
        bookings = new HashMap<>();
        loadSampleTrains();
    }

    private void loadSampleTrains() {
        // Demonstration data, not live railway schedules.
        trains.add(new Train(101, "Bhopal Express",
                "Bhopal", "Delhi", 100, 750.00));

        trains.add(new Train(102, "Mumbai Mail",
                "Bhopal", "Mumbai", 80, 600.00));

        trains.add(new Train(103, "Shatabdi Demo",
                "Delhi", "Bhopal", 90, 850.00));

        trains.add(new Train(104, "Nagpur Express",
                "Bhopal", "Nagpur", 70, 450.00));

        trains.add(new Train(105, "Chennai Express",
                "Mumbai", "Chennai", 100, 900.00));
    }

    public void displayAllTrains() {
        System.out.println("\n========== AVAILABLE TRAINS ==========");
        System.out.println(
            "Number | Train Name | Route | Seats | Fare"
        );

        for (Train train : trains) {
            train.displayTrain();
        }
    }

    public List<Train> searchTrains(String source,
                                    String destination) {
        List<Train> results = new ArrayList<>();

        for (Train train : trains) {
            if (train.getSource().equalsIgnoreCase(source.trim())
                    && train.getDestination()
                            .equalsIgnoreCase(destination.trim())) {
                results.add(train);
            }
        }

        return results;
    }

    public Booking bookTicket(int trainNumber,
                              List<Passenger> passengers) {
        if (passengers == null || passengers.isEmpty()) {
            System.out.println("At least one passenger is required.");
            return null;
        }

        Train selectedTrain = null;

        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                selectedTrain = train;
                break;
            }
        }

        if (selectedTrain == null) {
            System.out.println("Train not found.");
            return null;
        }

        if (!selectedTrain.reserveSeats(passengers.size())) {
            System.out.println("Not enough seats available.");
            return null;
        }

        String pnr = "PNR" + pnrCounter++;
        Booking booking = new Booking(
            pnr, selectedTrain, passengers
        );

        bookings.put(pnr, booking);

        System.out.println("\nTicket booked successfully!");
        booking.displayBooking();

        return booking;
    }

    public void checkPNR(String pnr) {
        Booking booking = bookings.get(pnr.trim().toUpperCase());

        if (booking == null) {
            System.out.println("Invalid PNR number.");
        } else {
            booking.displayBooking();
        }
    }

    public boolean cancelTicket(String pnr) {
        Booking booking = bookings.get(
            pnr.trim().toUpperCase()
        );

        if (booking == null) {
            System.out.println("Booking not found.");
            return false;
        }

        if (booking.isCancelled()) {
            System.out.println("This ticket is already cancelled.");
            return false;
        }

        booking.getTrain().releaseSeats(
            booking.getPassengerCount()
        );

        booking.cancel();

        System.out.println("Ticket cancelled successfully.");
        System.out.println("PNR: " + booking.getPnr());

        return true;
    }
}

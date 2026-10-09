
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private String pnr;
    private Train train;
    private List<Passenger> passengers;
    private double totalFare;
    private boolean cancelled;

    public Booking(String pnr, Train train,
                   List<Passenger> passengers) {
        this.pnr = pnr;
        this.train = train;
        this.passengers = new ArrayList<>(passengers);
        this.totalFare = train.getFare() * passengers.size();
        this.cancelled = false;
    }

    public String getPnr() {
        return pnr;
    }

    public Train getTrain() {
        return train;
    }

    public int getPassengerCount() {
        return passengers.size();
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void cancel() {
        cancelled = true;
    }

    public void displayBooking() {
        System.out.println("\n========== BOOKING DETAILS ==========");
        System.out.println("PNR: " + pnr);
        System.out.println("Train: " + train.getTrainName());
        System.out.println("Train Number: " + train.getTrainNumber());
        System.out.println("Route: " + train.getSource()
                           + " -> " + train.getDestination());
        System.out.println("Passengers:");

        for (Passenger passenger : passengers) {
            passenger.displayPassenger();
        }

        System.out.printf("Total Fare: Rs. %.2f%n", totalFare);
        System.out.println("Status: " +
            (cancelled ? "CANCELLED" : "CONFIRMED"));
        System.out.println("=====================================");
    }
}

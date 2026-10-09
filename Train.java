
public class Train {
    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;
    private double fare;

    public Train(int trainNumber, String trainName,
                 String source, String destination,
                 int totalSeats, double fare) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.fare = fare;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getFare() {
        return fare;
    }

    public boolean reserveSeats(int count) {
        if (count <= 0 || count > availableSeats) {
            return false;
        }

        availableSeats -= count;
        return true;
    }

    public void releaseSeats(int count) {
        if (count > 0 && availableSeats + count <= totalSeats) {
            availableSeats += count;
        }
    }

    public void displayTrain() {
        System.out.println(
            trainNumber + " | " + trainName + " | " +
            source + " -> " + destination + " | " +
            availableSeats + "/" + totalSeats +
            " seats | Rs. " + String.format("%.2f", fare)
        );
    }
}

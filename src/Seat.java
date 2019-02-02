public class Seat implements Comparable<Seat> {

    private final String seatNumber;
    private boolean reserved = false;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int compareTo(Seat seat) {
        return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }

    public boolean reserve() {
        if(!this.reserved) {
            this.reserved = true;
            System.out.println("Seat "+this.seatNumber+" has been reserved");
            return true;
        } else {
            System.out.println("The seat has been already Reserved!");
            return false;
        }
    }

    public boolean ifReserved() {
        return reserved;
    }

    public boolean cancel() {
        if(this.reserved) {
            this.reserved = false;
            System.out.println("Reservation of seat "+this.getSeatNumber()+" cancelled!");
            return true;
        } else {
            return false;
        }
    }
}
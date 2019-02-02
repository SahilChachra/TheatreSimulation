
import java.util.*;
public class Theatre {

    private final String theatreName;
    private List<Seat> seats = new ArrayList<Seat>();
    private int numRows, seatsPerRow;

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        this.numRows = numRows;
        this.seatsPerRow = seatsPerRow;
        int lastRow = 'A' + (this.numRows -1);
        for (char row = 'A'; row <= lastRow; row++) {
            for(int seatNum = 1; seatNum <= this.seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return this.theatreName;
    }

    public void getSeats() {
        int lastRow = 'A' + (numRows-1);
        System.out.println("Arrangment of seat is displayed below\n");
//        System.out.println();

        System.out.println("************Screen This Side************");
        for(char row = 'A'; row <=lastRow; row++) {
            for(int seatNum = 1; seatNum < this.seatsPerRow; seatNum++) {
                System.out.print(row + String.format("%02d", seatNum)+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean reserveSeat(String seatNumber) {
        int low = 0;
        int high = seats.size()-1;

        while (low <= high) {
            //System.out.print(".");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("There is no seat " + seatNumber);
        return false;
    }

    public boolean cancelSeat(String seatNumber) {
        int low = 0;
        int high = seats.size()-1;

        while (low <= high) {
            //System.out.print(".");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return seats.get(mid).cancel();
            }
        }
        System.out.println("There is no seat " + seatNumber);
        return false;
    }

    public boolean seatStatus(String seatNumber) {
        int low = 0;
        int high = seats.size()-1;

        while (low <= high) {
            //System.out.print(".");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return seats.get(mid).ifReserved();
            }
        }
        System.out.println("Invalid seat number");
        return false;
    }



    
}

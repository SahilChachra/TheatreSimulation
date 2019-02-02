import java.util.*;
public class Main {

    private static double totalAmount = 50, seatCost = 250.0;
    public static void main(String[] args) {

        ArrayList<Seat> seats = new ArrayList<Seat>();
        Scanner read = new Scanner(System.in);
        Theatre theatre = new Theatre("Olympian", 8, 12);

        int ch;
        System.out.println("Theatre name : "+theatre.getTheatreName());
        printChoice();

        while(true) {
            System.out.println("Enter choice");
            ch = read.nextInt();
            read.nextLine();
            switch (ch) {

                case 0: printChoice();
                break;

                case 1 : theatre.getSeats();
                         break;

                case 2 :
                    System.out.println("Enter Seat number");
                    String seatNumber = read.nextLine();
                    boolean ifReserved = theatre.reserveSeat(seatNumber);
                    seats.add(new Seat(seatNumber));
                    calcBooked(ifReserved);
                    break;

                case 3:
                    System.out.println("Enter Seat number");
                    String cancelSeat = read.nextLine();
                    boolean ifCancelled = theatre.cancelSeat(cancelSeat);
                    seats.remove(cancelSeat);
                    calcCancel(ifCancelled);
                    break;

                case 4:
                    System.out.println("Total amount : "+totalAmount);
                    break;

                case 5: bookingDetails();
                break;

                case 6:
                    System.out.println("Enter seat number");
                    String seatNumStatus = read.nextLine();
                    boolean status = theatre.seatStatus(seatNumStatus);
                    statusSeat(status);
                    break;

                case 7:
                    System.out.println("Seats booked : ");
                    for(int i=0;i<seats.size();i++) {
                        System.out.println(seats.get(i).getSeatNumber()+"\t");
                    }
                    break;

                case 8: return;
            }
        }

    }

    public static void printChoice() {
        System.out.println("0. Print Options");
        System.out.println("1. Arrangement of seats");
        System.out.println("2. Reserve Seat");
        System.out.println("3. Cancel Reservation");
        System.out.println("4. Total amount");
        System.out.println("5. Booking details.");
        System.out.println("6. Seat Booking status");
        System.out.println("7. Seats Booked");
        System.out.println("8. Exit");
    }

    public static double calcBooked(boolean ifBooked) {
        if(ifBooked) {
            totalAmount+=seatCost;
        }
        return totalAmount;
    }

    public static double calcCancel(boolean ifCanclled) {
        if(ifCanclled) {
            totalAmount-=seatCost;
        }
        return totalAmount;
    }

    public static void statusSeat(boolean seatStatus) {

        if(seatStatus) {
            System.out.println("This seat is reserved");
        } else {
            System.out.println("This seat is not reserved");
        }

    }

    public static void bookingDetails() {
        System.out.println("Booking id : "+(int)Math.floor((Math.random()*10000)));
        System.out.println("Total amount : ₹"+totalAmount);
        System.out.println("Please show the booking ID and pay at the counter");
    }

}

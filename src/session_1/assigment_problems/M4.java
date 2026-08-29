package session_1.assigment_problems;

public class M4 {
    class HallTicket {

        String studentName;
        int seatNumber;

        HallTicket(String studentName, int seatNumber) {
            this.studentName = studentName;
            this.seatNumber = seatNumber;
        }
    }

    public class M4ReferenceCopiesandasharedExamHallTicket {

        public static void main(String[] args) {

            HallTicket priya = new HallTicket("Priya", 0);

            // Both variables point to the same object
            HallTicket copy = priya;

            // Change through the second reference
            copy.seatNumber = 45;

            System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
            System.out.println("copy == priya: " + (copy == priya));

            // Separate object with identical values
            HallTicket separate = new HallTicket("Priya", 45);

            System.out.println("separate == priya: " + (separate == priya));
        }
    }
}

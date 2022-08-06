import java.time.LocalDate;
import java.time.LocalTime;;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Calendar calendar;
    private static int year;

    public static void main(String[] args) {
        initCalendar();
        int choice;
        int meetingId;
        LocalDate meetingDay;
        LocalTime startTime;
        LocalTime endTime;
        String description;

        do {
            showOptions();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter meeting date (MM-dd):");
                    meetingDay = LocalDate.parse(year + "-" + scanner.next());
                    System.out.println("Enter meeting start time (H:mm):");
                    startTime = LocalTime.parse(scanner.next());
                    System.out.println("Enter meeting end time (H:mm):");
                    endTime = LocalTime.parse(scanner.next());
                    System.out.println("Enter description for meeting:");
                    scanner.skip("\\R?");
                    description = scanner.nextLine();
                    calendar.addMeeting(meetingDay, startTime, endTime, description);
                    break;

                case 2:
                    System.out.println("Enter the date of the meeting to be delated (MM-dd):");
                    meetingDay = LocalDate.parse(year + "-" + scanner.next());
                    System.out.println("Enter meeting ID:");
                    meetingId = scanner.nextInt();
                    calendar.deleteMeeting(meetingId, meetingDay);
                    break;

                case 3:
                    System.out.println("Enter meetings date: (MM-dd)");
                    meetingDay = LocalDate.parse(year + "-" + scanner.next());
                    calendar.showMeetingDay(meetingDay);
                    break;

                case 4:
                    System.out.println("Enter meeting month (MM):");
                    meetingDay = LocalDate.parse((year + "-" + scanner.nextInt() + "-" + "10"));
                    calendar.showMeetingMonth(meetingDay);
                    break;
                default:
                    System.out.println("Try again.");
                    break;
            }
        } while (choice != 0);
    }

    private static void initCalendar() {
        System.out.println("Enter the year for your Calendar:");
        year = scanner.nextInt();
        calendar = new Calendar(year);
    }

    private static void showOptions() {
        System.out.println("-------------- OPTIONS --------------");
        System.out.println("1. Add meeting.");
        System.out.println("2. Delete meeting.");
        System.out.println("3. Show all meetings of the day.");
        System.out.println("4. Show all days in month.");
        System.out.println("-------------------------------------");
    }
}
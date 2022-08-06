import java.time.LocalDate;
import java.time.LocalTime;

public class Calendar {

    public Calendar(int year) {
        boolean isLeapYear = year % 4 == 0;
        for (int i = 0; i < 12; i++) {
            months[i] = new Month(i + 1, isLeapYear);
        }
    }

    private int nextMeetingId = 1;
    private Month[] months = new Month[12];

    public void addMeeting(LocalDate meetingDay, LocalTime startTime, LocalTime endTime, String description) {
        if (months[meetingDay.getMonthValue() - 1].createMeeting(nextMeetingId, meetingDay, startTime, endTime, description)) {
            nextMeetingId++;
        }
    }

    public void deleteMeeting(int id, LocalDate meetingDay) {
        months[meetingDay.getMonthValue() - 1].deleteMeetingFromDay(id, meetingDay);
    }

    public void showMeetingDay(LocalDate meetingDay) {
        months[meetingDay.getMonthValue() - 1].showMeetingDay(meetingDay);
    }

    public void showMeetingMonth(LocalDate meetingDay) {
        months[meetingDay.getMonthValue() - 1].showMeetingMonth();
    }
}

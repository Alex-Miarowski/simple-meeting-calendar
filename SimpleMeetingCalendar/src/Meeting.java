import java.time.LocalDate;
import java.time.LocalTime;

public class Meeting {

    public Meeting(int id, LocalDate meetingDay, LocalTime startTime, LocalTime endTime, String description) {
        this.id = id;
        this.meetingDay = meetingDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    private int id;
    private LocalDate meetingDay;
    private LocalTime startTime;
    private LocalTime endTime;
    private String description;

    @Override
    public String toString() {
        return "ID: " + id +
                "\nDate: " + meetingDay +
                "\nStart time: " + startTime +
                "\nEnd time: " + endTime +
                "\nDescription: " + description +
                "\n--------------------------------------------";
    }

    public int getId() {
        return id;
    }

    public LocalDate getMeetingDay() {
        return meetingDay;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}

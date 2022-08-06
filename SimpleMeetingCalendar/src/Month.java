import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class Month {

    public Month(int month, boolean isLeapYear) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> amountOfDaysInMonth = 31;
            case 4, 6, 9, 11 -> amountOfDaysInMonth = 30;
            case 2 -> amountOfDaysInMonth = (isLeapYear) ? 29 : 28;
            default -> {
            }
        }
        days = new ArrayList[amountOfDaysInMonth];
        for (int i = 0; i < amountOfDaysInMonth; i++) {
            days[i] = new ArrayList<>();
        }
    }

    public ArrayList<Meeting>[] days;
    private int amountOfDaysInMonth = 0;

    public boolean createMeeting(int id, LocalDate meetingDay, LocalTime startTime, LocalTime endTime, String description) {
        if (startTime.isBefore(endTime)) {
            int dayIndex = meetingDay.getDayOfMonth() - 1;
            if (days[dayIndex].size() > 0) {
                for (int i = 0; i < days[dayIndex].size(); i++) {
                    Meeting existingMeeting = days[dayIndex].get(i);
                    if (endTime.isBefore(existingMeeting.getStartTime()) && startTime.isBefore(existingMeeting.getStartTime())) {
                        addMeetingToDay(id, meetingDay, startTime, endTime, description);
                        sortMeetingsDay(meetingDay);
                        return true;
                    } else if (i == days[dayIndex].size() - 1 && startTime.isAfter(existingMeeting.getEndTime())) {
                        addMeetingToDay(id, meetingDay, startTime, endTime, description);
                        return true;
                    } else {
                        System.out.println("WARNING! Your meeting ID = " + id + " collides with other meeting.");
                        return false;
                    }
                }
            } else {
                addMeetingToDay(id, meetingDay, startTime, endTime, description);
                return true;
            }
        } else {
            System.out.println("WARNING! Your meeting ID = " + id + " ends before starting.");
            return false;
        }
        return false;
    }

    private void addMeetingToDay(int id, LocalDate meetingDay, LocalTime startTime, LocalTime endTime, String description) {
        Meeting newMeeting = new Meeting(id, meetingDay, startTime, endTime, description);
        days[meetingDay.getDayOfMonth() - 1].add(newMeeting);
        System.out.println("Meeting added.");
    }

    public void deleteMeetingFromDay(int id, LocalDate meetingDay) {
        days[meetingDay.getDayOfMonth() - 1].removeIf(meeting -> meeting.getId() == id);
    }

    public void showMeetingDay(LocalDate meetingDay) {
        days[meetingDay.getDayOfMonth() - 1].forEach(meeting -> {
            System.out.println(meeting.toString());
        });
    }

    public void showMeetingMonth() {
        for (int i = 0; i < amountOfDaysInMonth; i++) {
            if (days[i].size() > 0) {
                for (int j = 0; j < days[i].size(); j++) {
                    System.out.println(days[i].get(j).toString());
                }
            } else {
                System.out.println("Day: " + (i + 1) + " no meetings planed." +
                        "\n--------------------------------------------");
            }
        }
    }

    private void sortMeetingsDay(LocalDate meetingDay) {
        days[meetingDay.getDayOfMonth() - 1].sort(Comparator.comparing(Meeting::getStartTime));
    }
}

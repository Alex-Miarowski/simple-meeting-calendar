import java.util.Comparator;

public class MeetingComparator implements Comparator<Meeting> {
    public int compare(Meeting meeting1, Meeting meeting2){
        return meeting1.getMeetingDay().getDayOfMonth() - meeting2.getMeetingDay().getDayOfMonth();
    }
}

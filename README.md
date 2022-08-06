# __Simple Meeting Calendar__

## _Description:_
Simple console application created using Java.\
Single Calendar object is for one year which user choice.\
Inside you can add meetings to your schedule with the following informations:
- Meeting date
- Meeting start time
- Meeting end time
- Description for the meeting

To your disposal are options:
- Create single meeting
- Delete single meeting
- Show all meetings in single day (chosen by user)
- Show all meetings in single month (chosen by user)


## _Classes:_
### Meeting.java:
- Represents single meeting
- Contains id for meeting, meeting date, start time, end time and desciption
- Has overriden method toString() for presentation


### Month.java:
- Represents single month
- Contains all meetings for one month in Array of ArrayLists
- Adjusts amount of days in constructor depending on the month number provided and about leap year information

> __Main methods:__

>> createMeeting() - returns true if meeting has been added or false if something goes wrong with information about it. Checks if start time of current meeting is before end time or is there no collides with existing meetings

>> deleteMeetingFromDay() - deletes meeting from Array in the indicated day based on id and meeting day

>> showMeetingDay() - print all meetings added on particular day

>> showMeetingMonth() - print all meetings added on particular month


### Calendar.java:
- Instance contain all months in Array
- In constructor as argument gets year for the calendar. Based on that provides information about leap year
- In methods provides informations and uses them on particular month based on typed meeting day


### Main.java:
- Main is used to communicate with user using prints and Scanner object
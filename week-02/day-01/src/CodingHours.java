public class CodingHours {
    public static void main(String[] args) {
        // An average Green Fox attendee codes 6 hours daily
        // The semester is 17 weeks long
        //
        // Print how many hours is spent with coding in a semester by an attendee,
        // if the attendee only codes on workdays.
        //
        // Print the percentage of the coding hours in the semester if the average
        // work hours weekly is 52

        int dailyWorkingHours = 6;
        int semester = 17;
        int workingDaysinAWeek = 5;
        int workdaysInSemester = semester * workingDaysinAWeek;
        int codingHoursInSemester = workdaysInSemester * dailyWorkingHours;
        int workHoursWeekly = 52;
        double percentageOfCodingHours = ((double) (workingDaysinAWeek * dailyWorkingHours) / workHoursWeekly) * 100;

        System.out.println(codingHoursInSemester);
        System.out.println(percentageOfCodingHours);
    }
}

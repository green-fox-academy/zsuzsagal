public class SecondsInADay {
    public static void main(String[] args) {
        // Write a program that prints the remaining seconds (as an integer) from a
        // day if the current time is represented by the variables
        //14 hours 34 mins 42 seconds

        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;

        int hoursInDay = 24;
        int minutesInDay = hoursInDay*60;
        int secondsInDay = minutesInDay * 60;

        int timeInSeconds = (currentHours*60)*60 + currentMinutes*60 + currentSeconds;
        int remainingSeconds = secondsInDay-timeInSeconds;
        System.out.println("The remaining seconds are: " +remainingSeconds);

    }
}

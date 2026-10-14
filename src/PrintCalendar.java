import java.util.Scanner;

public class PrintCalendar {

    // ANSI Color Codes for Console Styling
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String DIM_GRAY = "\u001B[90m"; // Color for previous/next month days

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter full year (e.g., 2026): ");
        int year = input.nextInt();

        System.out.print("Enter month as a number (1-12): ");
        int month = input.nextInt();

        System.out.println();
        printMonth(year, month);

        input.close();
    }

    private static void printMonth(int year, int month) {
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }

    public static void printMonthTitle(int year, int month) {
        String monthName = getMonthName(month);
        System.out.println(CYAN + "         " + monthName + " " + year + RESET);
        System.out.println(YELLOW + "-----------------------------" + RESET);
        System.out.println(YELLOW + " Sun Mon Tue Wed Thu Fri Sat " + RESET);
        System.out.println(YELLOW + "-----------------------------" + RESET);
    }

    public static void printMonthBody(int year, int month) {
        int startDay = StartDay(year, month);
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        // Determine previous month and its total days
        int prevMonth = (month == 1) ? 12 : month - 1;
        int prevYear = (month == 1) ? year - 1 : year;
        int daysInPrevMonth = getNumberOfDaysInMonth(prevYear, prevMonth);

        int cell = 0;

        // Display remaining dates from the previous month
        int startPrevDay = daysInPrevMonth - startDay + 1;
        for (int i = 0; i < startDay; i++) {
            System.out.printf(DIM_GRAY + "%4d" + RESET, startPrevDay + i);
            cell++;
        }

        // Display days of the current month
        for (int day = 1; day <= numberOfDaysInMonth; day++) {
            // Highlight Sundays in Red, weekdays in Green
            String dayColor = (cell % 7 == 0) ? RED : GREEN;

            System.out.printf(dayColor + "%4d" + RESET, day);

            cell++;
            if (cell % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
        System.out.println(YELLOW + "-----------------------------" + RESET);
    }

    public static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return months[month - 1];
    }

    public static int StartDay(int year, int month) {
        final int START_DAY_FOR_JAN_1_1800 = 3;
        int totalNumberOfDays = getTotalNumberOfDays(year, month);
        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }

    public static int getTotalNumberOfDays(int year, int month) {
        int total = 0;
        for (int i = 1800; i < year; i++) {
            if (isLeapYear(i))
                total += 366;
            else
                total += 365;
        }
        for (int i = 1; i < month; i++) {
            total += getNumberOfDaysInMonth(year, i);
        }
        return total;
    }

    public static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12)
            return 31;
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        if (month == 2)
            return isLeapYear(year) ? 29 : 28;
        return 0;
    }

    public static Boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static String removeWhitespaces(String source) {
        // note, that StringBuilder is a much wiser choice here,
        // as we don't have any form of concurrency here, so
        // thread-safe datastructures will only make it slower
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {
            if (!Character.isSpaceChar(source.charAt(i))) {
                builder.append(source.charAt(i));
            }
        }

        return builder.toString();
    }

    public static void task1() {
        String testInput = " I  lo__ Java .";
        String testOutput = removeWhitespaces(testInput);
        System.out.printf("(%s) -> (%s)%n", testInput, testOutput);
    }

    public static List<LocalDate> getFridayThe13ths(int yearLimit) {
        List<LocalDate> dates = new ArrayList<>();

        LocalDate date = LocalDate.now();
        // start search from the next friday (from now)
        date = date.plusDays((7 + DayOfWeek.FRIDAY.getValue() - date.getDayOfWeek().getValue()) % 7);

        // limit results until (years * 52) number of weeks have been checked (starting from the next friday)
        int weekLimit = yearLimit * 52;

        for (int week = 0; week < weekLimit; week++) {
            if (date.getDayOfMonth() == 13) {
                dates.add(date);
            }

            // check next week this time
            date = date.plusWeeks(1);
        }

        return dates;
    }

    public static void task3() {
        List<LocalDate> list = getFridayThe13ths(2);
        for (LocalDate date : list) {
            System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
    }
}

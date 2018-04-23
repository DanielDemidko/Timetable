package danieldemidko.Timetable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Week {
    private final static String[] DAY_NAMES = {
            "Воскресенье", "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота"
    };
    private final boolean isUpper;
    private final List<Day> days = new ArrayList<Day>();


    public boolean isUpper() {
        return isUpper;
    }

    public boolean isLower() {
        return !isUpper;
    }

    public List<Day> getDays() {
        return days;
    }

    @Override
    public String toString() {
        final var builder = new StringBuilder(isUpper ? "По числителю" : "По знаменателю");
        for (final var i : days) {
            builder.append('\n');
            builder.append(i);
        }
        return builder.toString();
    }

    public Week(final String groupName, final boolean isUpper) {
        this.isUpper = isUpper;
        final var reader =
                new LineReader(
                        new BufferedReader(
                                new InputStreamReader(
                                        getClass().getResourceAsStream(
                                                "Data/" + groupName + '_' + (isUpper ? 0 : 1) + ".txt"))));
        int counter = 1;
        while (reader.Ready() && counter <= 6) {
            days.add(new Day(DAY_NAMES[counter], reader.ReadLines()));
            ++counter;
        }
    }
}

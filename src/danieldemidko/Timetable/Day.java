package danieldemidko.Timetable;

import java.util.ArrayList;
import java.util.List;

public class Day {
    private final String name;
    private final List<Lesson> lessons = new ArrayList<Lesson>();

    public String getName() {
        return name;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    @Override
    public String toString() {
        final var builder = new StringBuilder(name);
        for (final var i : lessons) {
            builder.append('\n');
            builder.append(i);
        }
        return builder.toString();
    }

    public Day(final String name, final List<String> source) {
        this.name = name;
        for (var i : source) {
            lessons.add(new Lesson(i));
        }
        source.clear();
    }
}

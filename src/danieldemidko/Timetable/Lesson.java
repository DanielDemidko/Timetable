package danieldemidko.Timetable;

public class Lesson {
    private static final String[] TIMES = {
            "?", "8:30-10:00", "10:10-11:40", "11:50-13:20",
            "13:30-15:00", "15:10-16:40", "16:50-18:20", "18:30-20:00"
    };
    private int index = 0;
    private String name = "?", hall = "?", time = "?";

    public int getIndex() {
        return index;
    }

    public String getHall() {
        return hall;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "№" + index + " Время: " + time + " Предмет: \"" + name + "\" Аудитория: " + hall;
    }

    public Lesson(final String line) {
        if (line == null) {
            return;
        }
        try {
            index = Integer.parseInt(line.substring(0, line.indexOf(" ")));
        } catch (NumberFormatException e) {
            // System.err.println(e.getLocalizedMessage());
        } catch (StringIndexOutOfBoundsException e) {
           // System.err.println(e.getLocalizedMessage());
        }
        if (index > 7) {
            index = 0;
        }
        time = TIMES[index];
        try {
            name = line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\""));
        } catch (StringIndexOutOfBoundsException e) {
            name = "Неизвестно";
            return;
        }
        try {
            hall = line.substring(line.lastIndexOf(" ") + 1);
        } catch (StringIndexOutOfBoundsException e) {
            hall = "Неизвестна";
        }
    }
}

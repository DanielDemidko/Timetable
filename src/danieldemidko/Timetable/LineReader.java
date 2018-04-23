package danieldemidko.Timetable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LineReader {
    private final BufferedReader reader;

    public boolean Ready() {
        try {
            return reader.ready();
        } catch (IOException e) {
            return false;
        }
    }

    public List<String> ReadLines() {
        final var result = new ArrayList<String>();
        var startWithEmpty = true;
        while (Ready()) {
            try {
                final var currentLine = reader.readLine();
                if(currentLine.isEmpty()) {
                    if(startWithEmpty) {
                        continue;
                    }
                    return result;
                }
                startWithEmpty = false;
                result.add(currentLine);
            } catch (IOException e) {
                return result;
            }
        }
        return result;
    }

    public List<List<String>> ReadAllLines() {
        final var result = new ArrayList<List<String>>();
        while (Ready()) {
            result.add(ReadLines());
        }
        return result;
    }

    public LineReader(final BufferedReader r) {
        reader = r;
    }
}

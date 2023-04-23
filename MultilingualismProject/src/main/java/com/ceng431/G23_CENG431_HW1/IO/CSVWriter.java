package main.java.com.ceng431.G23_CENG431_HW1.IO;


import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVWriter implements ICSVWriter {
    private String convertToCSV(String[] data) {
        return Stream.of(data).collect(Collectors.joining(","));
    }

    private String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public void createCSVFile(String filename, List<String[]> data) {
        File csvOutputFile = new File(filename);
        // If it exists, and it is not a directory do not create it again
            try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
                data.stream().map(this::convertToCSV).forEach(pw::println);
                csvOutputFile.createNewFile();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}

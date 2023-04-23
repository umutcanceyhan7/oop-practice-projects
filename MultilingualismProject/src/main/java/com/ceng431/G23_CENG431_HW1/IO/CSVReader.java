package main.java.com.ceng431.G23_CENG431_HW1.IO;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements ICSVReader {
    public CSVReader() {

    }

    public List<List<String>> readFile(String fileName, char separator) throws IOException {

        // Prepare.
        BufferedReader csvReader = null;
        List<List<String>> csvList = new ArrayList<>();
        String csvRecord = null;
        InputStream file = new FileInputStream(fileName);
        // Process records.
        try {
            csvReader = new BufferedReader(new InputStreamReader(file));
            while ((csvRecord = csvReader.readLine()) != null) {
                csvList.add(parseCsvRecord(csvRecord, separator));
            }
        } catch (IOException e) {
            throw new RuntimeException("Reading CSV failed.", e);
        } finally {
            if (csvReader != null)
                try {
                    csvReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return csvList;
    }
    /**
     * CSV record parser. Convert a CSV record to a List of Strings representing the fields of the
     * CSV record. The CSV record is expected to be separated by the specified CSV field separator.
     * @param record The CSV record.
     * @param csvSeparator The CSV field separator to be used.
     * @return A List of Strings representing the fields of each CSV record.
     */
    private List<String> parseCsvRecord(String record, char csvSeparator) {

        // Prepare.
        boolean quoted = false;
        StringBuilder fieldBuilder = new StringBuilder();
        List<String> fields = new ArrayList<String>();

        // Process fields.
        for (int i = 0; i < record.length(); i++) {
            char c = record.charAt(i);
            fieldBuilder.append(c);

            if (c == '"') {
                quoted = !quoted; // Detect nested quotes.
            }

            if ((!quoted && c == csvSeparator) // The separator ..
                    || i + 1 == record.length()) // .. or, the end of record.
            {
                String field = fieldBuilder.toString() // Obtain the field, ..
                        .replaceAll(csvSeparator + "$", "") // .. trim ending separator, ..
                        .replaceAll("^\"|\"$", "") // .. trim surrounding quotes, ..
                        .replace("\"\"", "\""); // .. and un-escape quotes.
                fields.add(field.trim()); // Add field to List.
                fieldBuilder = new StringBuilder(); // ReList.
            }
        }

        return fields;
    }

}

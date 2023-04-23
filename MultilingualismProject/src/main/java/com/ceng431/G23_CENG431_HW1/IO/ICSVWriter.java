package main.java.com.ceng431.G23_CENG431_HW1.IO;

import java.util.List;

public interface ICSVWriter {
    void createCSVFile(String filename, List<String[]> data);
}

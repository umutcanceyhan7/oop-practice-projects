package main.java.com.ceng431.G23_CENG431_HW1.IO;

import java.io.IOException;
import java.util.List;

public interface ICSVReader {
    List<List<String>> readFile(String filePath, char separator) throws IOException;
}

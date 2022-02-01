package reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Txt saver class
 */
public class ReportSaverToTxt {

    private static final String BASE_PATH = "omo-smarthome/reports/";

    public static void saveToFile(String filename, String report) {
        File file = new File(BASE_PATH + filename);
        file.getParentFile().mkdirs();
        try(FileWriter writer = new FileWriter(file)) {
            writer.write(report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

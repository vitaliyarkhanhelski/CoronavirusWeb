package CoronovirusWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
public class CoronovirusWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoronovirusWebApplication.class, args);

        File log = new File("OutputLog.txt");
        try {
            if (log.createNewFile()) {
                Print.print("File created: " + log.getName());
                FileWriter myWriter = new FileWriter(log);
                myWriter.write("File was created " + Data.getNow() + ":\n");
                writeNewLogWithDate(myWriter);
                myWriter.close();
            } else {
                FileWriter myWriter = new FileWriter(log, true);
                myWriter.write("\n");
                writeNewLogWithDate(myWriter);
                myWriter.close();
            }
        } catch (IOException e) {
            Print.print("An error occured");
            e.printStackTrace();
        }

        DataBaseService.checkDataBase();

    }

    private static void writeNewLogWithDate(FileWriter myWriter) throws IOException {
        myWriter.write("New Log " + Data.getNow() + ":\n");
    }
}

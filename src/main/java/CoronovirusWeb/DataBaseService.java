package CoronovirusWeb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBaseService {

    private static String fileName="Database.txt";

    static List<Integer> getDataFromDataBase() {
        List<Integer> list = new ArrayList<>();
        try {
            File database = new File(fileName);
            Scanner scanner = new Scanner(database);
            scanner.nextLine();
            Print.print("Read from DataBase.");
            String[] s = scanner.nextLine().split(" ");
            list.add(Integer.parseInt(s[0]));
            list.add(Integer.parseInt(s[1]));
            list.add(Integer.parseInt(s[2]));
            return list;
        } catch (FileNotFoundException e) {
            Print.print("File not found.");
            e.printStackTrace();
        }
        return list;
    }


    static void checkDataBase(){
        try{
            File database = new File(fileName);

            if (database.createNewFile())
                Print.print("File created: "+database.getName());

            if (database.length() == 0){
                writeToFile();
                return;
            }
            Scanner scanner = new Scanner(database);
            String s = scanner.next();
            if(!s.equals(LocalDate.now().toString())){
                writeToFile();
                return;
            }
            Print.print("DataBase is ok and ready.");
        } catch (IOException e) {
            Print.print("An error occurred.");
            e.printStackTrace();
        }
    }


     static void writeToFile() {
        try{
            Print.print("Write to Database.");
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(LocalDate.now()+"\n");
            myWriter.write(
                    Integer.toString(CoronovirusGetDataFromWeb.getActiveCases())+" "+
                    Integer.toString(CoronovirusGetDataFromWeb.getMildCases())+" "+
                    Integer.toString(CoronovirusGetDataFromWeb.getCriticalCases())
            );
            myWriter.close();
            Print.print("Successfully wrote to DataBase.");
        } catch (IOException e) {
            Print.print("An error occurred.");
            e.printStackTrace();
        }
     }
}

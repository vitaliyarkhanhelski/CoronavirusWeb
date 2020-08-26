package CoronovirusWeb;

import java.io.FileWriter;
import java.io.IOException;

public class Print {

    static void print(String s){
        System.out.println(s);
        try{
            FileWriter myWriter = new FileWriter("OutputLog.txt",true);
            myWriter.write(Data.getNow()+": "+s+"\n");
            myWriter.close();
        } catch (IOException e) {
            Print.print("An error occurred.");
            e.printStackTrace();
        }
    }
}

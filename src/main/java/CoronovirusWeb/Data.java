package CoronovirusWeb;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Data {

    static String getNow(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy, EEEE, hh:mm:ss");
        return "("+dateTimeFormatter.format(LocalDateTime.now())+")";
    }

}

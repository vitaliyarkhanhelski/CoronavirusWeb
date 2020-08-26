package CoronovirusWeb;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class CoronovirusGetDataFromWeb {

    static int getActiveCases(){
        int i=0;
        try{
            Document document = getDocument();
            String text = document.getElementsByClass("number-table-main").first().text();
            i = getValue(text);
        } catch (IOException e) {
            printError();
            e.printStackTrace();
        }
        return i;
    }


    static int getMildCases(){
        int i=0;
        try{
            Document document = getDocument();
            String text = document.getElementsByClass("number-table").first().text();
            i = getValue(text);
        } catch (IOException e) {
            printError();
            e.printStackTrace();
        }
        return i;
    }


    static int getCriticalCases(){
        int i=0;
        try{
            Document document = getDocument();
            String text = document.getElementsByClass("number-table").get(1).text();
            i = getValue(text);
        } catch (IOException e) {
            printError();
            e.printStackTrace();
        }
        return i;
    }


    private static Document getDocument() throws IOException {
        return Jsoup.connect("https://www.worldometers.info/coronavirus/country/poland/").get();
    }


    private static void printError() {
        Print.print("An error occurred.");
    }


    private static int getValue(String text) {
        int i;
        i = Integer.parseInt(text.replace(",", ""));
        return i;
    }
}

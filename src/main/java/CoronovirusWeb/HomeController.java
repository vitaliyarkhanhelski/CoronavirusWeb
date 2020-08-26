package CoronovirusWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    String getHomePage(ModelMap map) {
        List<Integer> list = DataBaseService.getDataFromDataBase();
        map.put("activeCases", list.get(0));
        map.put("date", Data.getNow());
        map.put("mildCases", list.get(1));
        map.put("criticalCases", list.get(2));
        map.put("probability", format((double) (list.get(0)) * 50 / (36 * 1000 * 1000)));
        return "corona";
    }


    static String format(double d) {
        BigDecimal bigDecimal = new BigDecimal(d);
        return bigDecimal.setScale(3, RoundingMode.HALF_EVEN).toString();
    }
}

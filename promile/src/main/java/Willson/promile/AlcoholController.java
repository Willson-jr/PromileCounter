package Willson.promile;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@NoArgsConstructor
@Controller
public class AlcoholController {
//    @GetMapping("/hello)
//    localhost:8080/hello
//    sever localhost:8080/

    @GetMapping("/")
    public String home() {
        return "alcohol";   //zwroc plik alcohol.html z folderu resources/templates
    }
    private AlcoholCounter alcoholCounter = new AlcoholCounter();
    //@RequestParam automatycznie zmienia nam amienne z adresu url
    @GetMapping("/result")
    public String getResult(
        @RequestParam Double quantity,
        @RequestParam Double weight,
        @RequestParam String alcohol,
        @RequestParam Double hours,
        @RequestParam boolean sex, ModelMap modelMap
        ){
        char prom = 8240;
        Alcohol alcoholEnum = Alcohol.valueOf(alcohol);


        float result = alcoholCounter.calculatePerMil(quantity*1000,weight,sex, alcoholEnum);
        String resultString = String.format("%.2f",result);


        float resultTime = alcoholCounter.calculatePermilWithHours(quantity*1000,weight,sex,hours,alcoholEnum);
        String resultTimeString = String.format("%.2f",resultTime);

        float hoursTo = alcoholCounter.calculateToZero(quantity*1000,weight,sex,hours,alcoholEnum);
        String hoursToString = String.format("%.2f",hoursTo);


        modelMap.put("result",resultString+prom);
        modelMap.put("resultPerHours",resultTimeString+prom+" after " + hours + " hours");
        modelMap.put("resultHours",hoursToString+" hours to reach 0 "+prom);



        return "result";   //templates/result.html
    }


}





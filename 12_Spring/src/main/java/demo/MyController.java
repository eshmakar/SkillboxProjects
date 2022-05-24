package demo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/")
@Validated
public class MyController {

    @GetMapping("/name-for-day")
    public String getNumberOfDayWeek(@RequestParam @Min(1) @Max(value = 7, message = "day number has to be less than or equal to 7") Integer dayOfWeek){
        System.out.println(dayOfWeek);
        if (dayOfWeek>7)
            return "Не может быть больше 7";
        return dayOfWeek.toString();

    }
}

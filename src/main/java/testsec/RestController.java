package testsec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {
 
    @GetMapping(value = "/test")
    public @ResponseBody String getTestData() {
        return "OK";
    }
}
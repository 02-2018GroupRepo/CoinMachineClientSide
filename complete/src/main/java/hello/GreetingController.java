package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class GreetingController {

   // private static final String template = "Hello, %s!";
  //  private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/requestAmount")
    public double request(@RequestParam(value="ID")String machineID){
        return Machine.getTotal();
    }
    @RequestMapping("/hey")
    public String sayhey() {
        return "Hello from serverside";
    }
}

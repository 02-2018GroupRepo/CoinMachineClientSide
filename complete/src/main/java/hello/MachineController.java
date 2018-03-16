package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class MachineController {

   // private static final String template = "Hello, %s!";
  //  private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/requestAmount")
    public String request(@RequestParam(value="ID")String machineID){
        return Machine.getTotal(machineID);
    }
}

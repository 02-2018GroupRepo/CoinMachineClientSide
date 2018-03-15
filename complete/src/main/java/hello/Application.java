package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.crypto.Mac;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Machine machine = new Machine("1234");



        String input = "";
        try{
            input= bufferedReader.readLine();
            while (!input.equals("done")) {
                //makeCall(machine.getID());
                input = bufferedReader.readLine();

                if (input.equals("pop")) {
                    machine.removeFromList();
                }
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}

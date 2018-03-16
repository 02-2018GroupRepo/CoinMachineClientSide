package hello;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Scanner;
@SpringBootApplication

public class OperatorAplication {

        public static void main(String[] args) {

            SpringApplication.run(MachineApplication.class, args);
            Scanner input = new Scanner (System.in);

            boolean done = false;

            while(!done) {


                System.out.println("Enter the Machine ID");
                String machineID = input.next();

                String tURL = "http://192.168.88.167:8080/requestAmount";
                UriComponentsBuilder builder = UriComponentsBuilder.
                        fromUriString(tURL).queryParam("ID", machineID);

                RestTemplate restTemplate = new RestTemplate();


                String response = restTemplate.getForObject(builder.toUriString(), String.class);
                if (response != null) {
                    System.out.println("The vending machine total is: $" + response);
                    System.out.println("Enter y to contine and n to stop");
                    String in = input.next();
                    if (in.equals("y") || in.equals("Y")) {
                        done = false;
                    } else {
                        done = true;
                    }
                } else {
                    System.out.println("Invalid Machine ID");
                }
            }
        }

}

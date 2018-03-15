package hello;


import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;

public class Machine {

    static private double totalMoney = 35;
    ArrayList<String> products = new ArrayList<String>();
    private String machineID;


    public Machine(String machineID) {
        this.machineID = machineID;
        //double totalMoney = 35;

        products.add("cake");
        products.add("cookie");
        products.add("chips");
        products.add("chocolate");
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    // Add one item at a time
    public void addToList(String item) {
        products.add(item);
    }

    // (OverLoad Method) Add multiple Items at a time
    public void addToList(int amountToAdd, String item) {
        for (int i = 0; i < amountToAdd; i++) {
            products.add(item);
        }
    }

    // Remove the first item
    public void removeFromList() {
        products.remove(0);
        requestRestock();
    }

    public void requestRestock() {
        if (products.size() < 3) ; // Send a request to the HomeBase by using magic
        {
            makeCall(machineID);
            // Send ID to homeBase
        }
    }

    public int getSize() {
        return products.size();
    }

    public void receivedMessage() {
        // include conditional to check message status
        System.out.println("Thanks! Received Confirmation from HomeDepot");
    }

    public String getID() {
        return machineID;
    }

    private void makeCall(String machineID) {

        String transactionUrl = "http://192.168.88.89:8080/hello/requestRestock";
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(transactionUrl).queryParam("id", machineID);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(builder.toUriString(), String.class);
        System.out.println(response);
    }
        public static double getTotal(){
        return totalMoney;
        }
}

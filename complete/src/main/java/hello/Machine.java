package hello;


import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;

public class Machine {

    static private double totalMoney = 35.25;
    ArrayList<String> products = new ArrayList<String>();
    private static String machineID;


    public Machine(String machineID) {
        this.machineID = machineID;

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
        String p = products.remove(0);
        System.out.println(p + " was removed. There are " + products.size() + " left" );
        requestRestock();
    }

    public void requestRestock() {
        if (products.size() < 3) // Send a request to the HomeBase by using magic
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

        String transactionUrl = "http://192.168.88.123:8080/hello/requestRestock";
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(transactionUrl).queryParam("id", machineID);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(builder.toUriString(), String.class);
        System.out.println(response);
    }

    public static String getTotal(String id) {
        if (machineID.equals(id)) {
            return Double.toString(totalMoney);
        } else return "That is an invalid ID. Machine not found.";
    }
}

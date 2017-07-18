package com.betterbet.betterbet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ExpandableMyAccountListDataPump {
    public static HashMap<String, List<String>> getData() {
        LinkedHashMap<String, List<String>> expandableListDetail = new LinkedHashMap<String, List<String>>();

        List<String> persInformation = new ArrayList<String>();
        persInformation.add("Username: abc@gmail.com");
        persInformation.add("First Name: Jimmy");
        persInformation.add("Last Name: Cricket");
        persInformation.add("Email: abc@gmail.com");
        persInformation.add("Phone Number: 613-888-0939");

        List<String> billingAddress = new ArrayList<String>();
        billingAddress.add("First Name: Jimmy");
        billingAddress.add("Last Name: Cricket");
        billingAddress.add("Apt./Suite #: 2");
        billingAddress.add("Address: 123 main street");
        billingAddress.add("Postal Code: K5V 2G4");

        List<String> creditCard = new ArrayList<String>();
        creditCard.add("Master Card XXXX XXXX XXXX 2323");

        expandableListDetail.put("Personal Information", persInformation);
        expandableListDetail.put("Credit Card Information", creditCard);
        expandableListDetail.put("Billing Address", billingAddress);
        return expandableListDetail;
    }
}

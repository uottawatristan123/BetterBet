package com.betterbet.betterbet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableMyAccountListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> persInformation = new ArrayList<String>();
        persInformation.add("Username: abc@gmail.com");
        persInformation.add("First Name: Conor");
        persInformation.add("Last Name: McGregor");
        persInformation.add("Email: abc@gmail.com");
        persInformation.add("Phone Number: 613-888-0939");

        List<String> billingAddress = new ArrayList<String>();
        billingAddress.add("United States");
        billingAddress.add("Spain");
        billingAddress.add("Argentina");
        billingAddress.add("France");
        billingAddress.add("Russia");

        List<String> creditCard = new ArrayList<String>();
        creditCard.add("Master Card XXXX XXXX XXXX 2323");

        expandableListDetail.put("Personal Information", persInformation);
        expandableListDetail.put("Billing Address", billingAddress);
        expandableListDetail.put("Credit Card Information", creditCard);
        expandableListDetail.put("Change Password", null);
        expandableListDetail.put("Deactivate Account", null);
        return expandableListDetail;
    }
}

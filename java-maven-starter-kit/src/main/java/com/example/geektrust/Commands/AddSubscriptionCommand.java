package com.example.geektrust.Commands;

import java.util.List;

import com.example.geektrust.MainClass.Enums;
import com.example.geektrust.Service.SubsService;

public class AddSubscriptionCommand implements ICommand{
    private final SubsService subsService;
    
    public AddSubscriptionCommand(SubsService subsService){
        this.subsService = subsService;
    }

    final String failed = "ADD_SUBSCRIPTION_FAILED";
    @Override
    public void invoke(List<String> tokens) {
        if(!Enums.getDflag()){
            System.out.println(failed + " INVALID_DATE");
            return;
        }
        String category = tokens.get(1);
        String plan = tokens.get(2);
        if(subsService.isPresent(category)){
            System.out.println(failed + " DUPLICATE_CATEGORY");
            return;
        }
        
        Enums.setSflag(true);
        subsService.addSubscription(category, plan);
    }
}

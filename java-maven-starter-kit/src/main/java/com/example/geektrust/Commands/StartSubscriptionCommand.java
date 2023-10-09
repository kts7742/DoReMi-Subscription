package com.example.geektrust.Commands;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.example.geektrust.MainClass.Enums;
import com.example.geektrust.Service.SubsService;

public class StartSubscriptionCommand implements ICommand{
    private final SubsService subsService;
    
    public StartSubscriptionCommand(SubsService subsService){
        this.subsService = subsService;
    }

    private final int TWO = 2, ONE = 1, ZERO = 0;

    @Override
    public void invoke(List<String> tokens) {
        String date = tokens.get(1);
                String[] d = date.split("-");
                String isValidDate = d[TWO]+"-"+d[ONE]+"-"+d[ZERO];
                try{
                    LocalDate.parse(isValidDate);
                }
                catch(DateTimeParseException de){
                    System.out.println("INVALID_DATE");
                    Enums.setDflag(false);
                    return;
                }
                
                Enums.setDflag(true);
                subsService.startSubsription(date);
    }
}

package com.example.geektrust.Commands;

public enum CommandKeyboard {
    START_SUBSCRIPTION_COMMAND("START_SUBSCRIPTION"),
    ADD_SUBSCRIPTION_COMMAND("ADD_SUBSCRIPTION"),
    ADD_TOPUP_COMMAND("ADD_TOPUP"),
    PRINT_RENEWAL_DETAILS_COMMAND("PRINT_RENEWAL_DETAILS");
    
    private final String name;
    private CommandKeyboard(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

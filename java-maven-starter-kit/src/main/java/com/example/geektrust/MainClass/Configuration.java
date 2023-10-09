package com.example.geektrust.MainClass;

import com.example.geektrust.Commands.AddSubscriptionCommand;
import com.example.geektrust.Commands.AddTopupCommand;
import com.example.geektrust.Commands.CommandKeyboard;
import com.example.geektrust.Commands.CommandRegistry;
import com.example.geektrust.Commands.PrintRenewalDetailsCommand;
import com.example.geektrust.Commands.StartSubscriptionCommand;
import com.example.geektrust.Repository.ISubsRepository;
import com.example.geektrust.Repository.SubsRepository;
import com.example.geektrust.Service.SubsService;

public class Configuration {
    private ISubsRepository subsRepository = new SubsRepository();
    private SubsService subService = new SubsService(subsRepository);

    private final StartSubscriptionCommand startSubscriptionCommand = new StartSubscriptionCommand(subService);
    private final AddSubscriptionCommand addSubscriptionCommand = new AddSubscriptionCommand(subService);
    private final AddTopupCommand addTopupCommand = new AddTopupCommand(subService);
    private final PrintRenewalDetailsCommand printRenewalDetailsCommand = new PrintRenewalDetailsCommand(subService);

    private final CommandRegistry commandRegistry = new CommandRegistry();

    private void registerCommand(){
        commandRegistry.registerCommand(CommandKeyboard.START_SUBSCRIPTION_COMMAND.getName(), startSubscriptionCommand);
        commandRegistry.registerCommand(CommandKeyboard.ADD_SUBSCRIPTION_COMMAND.getName(), addSubscriptionCommand);
        commandRegistry.registerCommand(CommandKeyboard.ADD_TOPUP_COMMAND.getName(), addTopupCommand);
        commandRegistry.registerCommand(CommandKeyboard.PRINT_RENEWAL_DETAILS_COMMAND.getName(), printRenewalDetailsCommand);
    }

    public CommandRegistry getCommandRegistry(){
        registerCommand();
        return commandRegistry;
    }

    public SubsService getService(){
        return subService;
    }
}

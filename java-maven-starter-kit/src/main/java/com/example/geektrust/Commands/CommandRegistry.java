package com.example.geektrust.Commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandRegistry {
    private final Map<String, ICommand> commands = new HashMap<>();

    public void registerCommand(String commandKeyboard, ICommand command){
        commands.putIfAbsent(commandKeyboard, command);
    }

    public void unregisterCommand(String commandKeyboard){
        commands.remove(commandKeyboard);
    }

    private ICommand get(String commandName){
        return commands.get(commandName);
    }

    private List<String> parse(String input){
        return Arrays.stream(input.split(" ")).collect(Collectors.toList());
    }

    public void invokeCommands(String input){
        List<String> tokens = parse(input);
        ICommand command = get(tokens.get(0));
        command.invoke(tokens);
        return;
    }
}

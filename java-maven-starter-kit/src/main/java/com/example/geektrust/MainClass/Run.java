package com.example.geektrust.MainClass;

import java.io.IOException;
import java.util.List;

import com.example.geektrust.Commands.CommandRegistry;

public class Run {
    
    public Run(List<String> commands) throws IOException{
        Configuration conf = new Configuration();

        CommandRegistry commandRegistry = conf.getCommandRegistry();

        new Enums();

        int i = 0;
        while(i < commands.size()){
            commandRegistry.invokeCommands(commands.get(i++));
        }
    }
}

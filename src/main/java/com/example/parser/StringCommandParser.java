package com.example.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.command.ICommand;

public class StringCommandParser {

    public static final String BY_EACH_CHARACTER = "";
    public static final int START_INDEX = 0;
    
    private static ICommand rotateLeft = r-> r.turnLeft();
    private static ICommand rotateRight = r-> r.turnRight();
    private static ICommand move = r-> r.move();
    
    private static Map<String,ICommand> stringToCommandMap = new HashMap<String, ICommand>() {{
        put("L", rotateLeft);
        put("R", rotateRight);
        put("M", move);
    }};

    private String commandString;

    public StringCommandParser(final String commandString) {
        this.commandString = commandString;
    }

    public List<ICommand> toCommands() {
        if(isNullOrEmpty(commandString)) return new ArrayList<ICommand>();
        return buildCommandsList(commandString);
    }

    private List<ICommand> buildCommandsList(final String commandString) {
        List<ICommand> commands = new ArrayList<ICommand>();

        for(String commandCharacter : commandCharactersFrom(commandString)) {
            if (commandCharacter == null) break;
            ICommand mappedCommand = lookupEquivalentCommand(commandCharacter.toUpperCase());
            commands.add(mappedCommand);
        }

        return commands;
    }

    private boolean isNullOrEmpty(final String commandString) {
        return (null == commandString || commandString.trim().length() == 0);
    }

    private String[] commandCharactersFrom(final String commandString) {
        return Arrays.copyOfRange(commandString.split(BY_EACH_CHARACTER), START_INDEX, commandString.length() + 1);
    }

    private ICommand lookupEquivalentCommand(final String commandString) {
        return stringToCommandMap.get(commandString);
    }

}

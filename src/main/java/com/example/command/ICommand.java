package com.example.command;

import com.example.rover.MarsRover;

public interface ICommand {

    public void execute(final MarsRover rover);

}

package com.example.rover;

import org.junit.Assert;
import org.junit.Test;

import com.example.command.ICommand;
import com.example.universe.Coordinates;
import com.example.universe.Direction;
import com.example.universe.Plateau;

public class CommandTest {

	@Test
	public void shouldMoveRover() {
		// Given
		ICommand move = r -> r.move();
		Plateau plateau = new Plateau(5, 5);
		Coordinates startingPosition = new Coordinates(1, 2);
		MarsRover rover = new MarsRover(plateau, Direction.N, startingPosition);

		// When
		move.execute(rover);

		// Then
		Assert.assertEquals("1 3 N", rover.currentLocation());
	}

	@Test
	public void shouldRotateLeft() {
		// Given
		ICommand rotateLeft = r -> r.turnLeft();
		Plateau plateau = new Plateau(5, 5);
		Coordinates startingPosition = new Coordinates(1, 2);
		MarsRover rover = new MarsRover(plateau, Direction.N, startingPosition);

		// When
		rotateLeft.execute(rover);

		// Then
		Assert.assertEquals("1 2 W", rover.currentLocation());
	}

	@Test
	public void shouldRotateRight() {
		// Given
		ICommand rotateRight = r -> r.turnRight();
		Plateau plateau = new Plateau(5, 5);
		Coordinates startingPosition = new Coordinates(1, 2);
		MarsRover rover = new MarsRover(plateau, Direction.N, startingPosition);

		// When
		rotateRight.execute(rover);

		// Then
		Assert.assertEquals("1 2 E", rover.currentLocation());
	}

}

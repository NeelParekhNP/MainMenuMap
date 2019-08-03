package com.example.practice;

import static java.lang.Math.abs;

public class Player {
    private int xPosition;
    private int yPosition;
    private int differenceX;
    private int differenceY;

    // Create a player and specify starting position
    public Player(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void setXPosition(int newXPosition) {
        xPosition = newXPosition;
    }

    public void setYPosition(int newYPosition) {
        yPosition = newYPosition;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void move(int destinationX, int destinationY) {
        differenceX = destinationX - xPosition;
        differenceY = destinationY - yPosition;
        while(!(differenceX == 0 & differenceY == 0)) {
            if(abs(differenceX) >= abs(differenceY)) {
                moveCloserX(destinationX);
                differenceX = destinationX - xPosition;
                printPlayerPosition();
            }else{
                moveCloserY(destinationY);
                differenceY = destinationY - yPosition;
                printPlayerPosition();
            }
        }
    }

    public void printPlayerPosition() {
        System.out.println("Player at X: " + xPosition + " Y: " + yPosition + ".");
    }

    public void moveCloserX(int destination) {
        if(destination > xPosition){
            xPosition++;
        }if (destination < xPosition){
            xPosition--;
        }else {

        }
    }

    public void moveCloserY(int destination) {
        if(destination > yPosition){
            yPosition++;
        }if (destination < yPosition){
            yPosition--;
        }else {

        }
    }
}


/**
 * Main method for running in eclipse in case it's useful
 *
 * public class Main {
 * public Player player;
 *
 * 	public static void main(String[] args) {
 * 	    // create player with starting location on grid
 * 		Player player = new Player(5,16);
 *
 * 		player.printPlayerPosition();
 *
 *      // example use of move method for testing.
 * 		player.move(1, 1);
 *        }
 *
 * 	/**
 * 	public void setDestination(int xValue, yValue) {
 * 		player.move(xValue, yValue);
 *    }
 *    */* }
 */


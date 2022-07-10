package org.example;

import org.example.controller.PathFinderController;

import java.io.File;

public class App
{

    private static PathFinderController controller;

    /*
     * Main method. Start of the application. You can choose, from where you can input the maze.
     */
    public static void main(String[] args) throws Exception {
        File maze = new File("src/main/resources/maze1.txt");

        //From file
        controller = new PathFinderController(maze);
        //From user input
//        controller = new PathFinderController();
    }
}

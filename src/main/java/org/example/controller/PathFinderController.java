package org.example.controller;

import org.example.model.Coordinate;
import org.example.model.Maze;
import org.example.readers.FindPathInputReaderFile;
import org.example.readers.FindPathInputReaderStdIn;
import org.example.service.MazeService;
import org.example.service.MazeSolver;

import java.io.File;
import java.util.List;

public class PathFinderController {
    private MazeService mazeService = new MazeService();
    private FindPathInputReaderFile pathInputReaderFile = new FindPathInputReaderFile();
    private FindPathInputReaderStdIn pathInputReaderStdIn = new FindPathInputReaderStdIn();

    public PathFinderController(File file) throws Exception {

        Maze maze = pathInputReaderFile.initializeMaze(pathInputReaderFile.findMazeFromFile(file));
        execute(maze);
    }

    public PathFinderController() {
        Maze maze = pathInputReaderStdIn.initializeMaze(pathInputReaderStdIn.findMazeFromInput());
        execute(maze);
    }

    private void execute(Maze maze) {

        MazeSolver mazeSolver = new MazeSolver();
        List<Coordinate> path = mazeSolver.solve(maze);
        System.out.println(mazeService.printDirections(path));
    }
}

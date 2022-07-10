package org.example.controller;

import org.example.model.Coordinate;
import org.example.model.Maze;
import org.example.readers.FindPathInputReaderFile;
import org.example.service.MazeSolver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;


public class PathFinderControllerTest {

    private FindPathInputReaderFile pathInputReaderFile = new FindPathInputReaderFile();

    List<Coordinate> expectedPath = new LinkedList<>();
    @Before
    public void before() {
        expectedPath.add(new Coordinate(2,2, new Coordinate(2,1, new Coordinate(2,0, new Coordinate(1,0,new Coordinate(0,0))))));
        expectedPath.add(new Coordinate(2,1, new Coordinate(2,0, new Coordinate(1,0,new Coordinate(0,0)))));
        expectedPath.add(new Coordinate(2,0, new Coordinate(1,0,new Coordinate(0,0))));
        expectedPath.add(new Coordinate(1,0,new Coordinate(0,0)));
        expectedPath.add(new Coordinate(0,0));
    }

    @Test
    public void pathFinderController() throws Exception {
        File mazeFile = new File("src/main/resources/maze2.txt");

        Maze maze = pathInputReaderFile.initializeMaze(pathInputReaderFile.findMazeFromFile(mazeFile));

        MazeSolver mazeSolver = new MazeSolver();
        List<Coordinate> path = mazeSolver.solve(maze);


        Assert.assertEquals(expectedPath.get(0).getX(), path.get(0).getX());
        Assert.assertEquals(expectedPath.get(1).getX(), path.get(1).getX());
        Assert.assertEquals(expectedPath.get(2).getX(), path.get(2).getX());
        Assert.assertEquals(expectedPath.get(3).getX(), path.get(3).getX());
        Assert.assertEquals(expectedPath.get(4).getX(), path.get(4).getX());

        Assert.assertEquals(expectedPath.get(0).getY(), path.get(0).getY());
        Assert.assertEquals(expectedPath.get(1).getY(), path.get(1).getY());
        Assert.assertEquals(expectedPath.get(2).getY(), path.get(2).getY());
        Assert.assertEquals(expectedPath.get(3).getY(), path.get(3).getY());
        Assert.assertEquals(expectedPath.get(4).getY(), path.get(4).getY());
    }
}
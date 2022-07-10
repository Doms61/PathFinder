package org.example.readers;

import org.example.model.Maze;
import org.example.service.MazeService;

public class FindPathInputReaderFile extends AbstractFindPathInputReader {
    private MazeService mazeService = new MazeService();

    public Maze initializeMaze(StringBuilder maze) {
        return mazeService.initializeMaze(maze);
    }
}

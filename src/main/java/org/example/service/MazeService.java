package org.example.service;

import org.example.model.*;
import org.example.model.enums.DirectionElements;
import org.example.model.enums.MazeCharElements;
import org.example.model.enums.MazeElements;

import java.util.*;

/**
 * Service class, for initializing, printing and other minor things
 */
public class MazeService {

    private Maze maze = new Maze();
    ArrayList<Coordinate> directionsToEnd= new ArrayList<>();

    public Maze initializeMaze(StringBuilder text){

        if ((text = new StringBuilder(text.toString().trim())).length() != 0) {
            String[] lines = text.toString().split("[\r]?\n");
            maze.setMaze(new int[lines.length][lines[0].length()]);
            maze.setVisited(new boolean[lines.length][lines[0].length()]);

            for (int row = 0; row < maze.getHeight(); row++) {
                if (lines[row].length() != maze.getWidth()) {
                    throw new IllegalArgumentException("line " + (row + 1) + " wrong length (was " + lines[row].length() + " but should be " + maze.getWidth() + ")");
                }
                assignMazeElements(lines, row);
            }
            return maze;
        } else {
            throw new IllegalArgumentException("empty lines data");
        }
    }

    private void assignMazeElements(String[] lines, int row){
        for (int col = 0; col < maze.getWidth(); col++) {
            if (lines[row].charAt(col) == MazeCharElements.WALL.getValue())
                maze.getMaze()[row][col] = MazeElements.WALL.getValue();
            else if (lines[row].charAt(col) == MazeCharElements.START.getValue()) {
                maze.getMaze()[row][col] = MazeElements.START.getValue();
                maze.setStart(new Coordinate(row, col));
            } else if (lines[row].charAt(col) == MazeCharElements.END.getValue()) {
                maze.getMaze()[row][col] = MazeElements.END.getValue();
                maze.setEnd(new Coordinate(row, col));
            } else
                maze.getMaze()[row][col] = MazeElements.ROAD.getValue();
        }
    }

    public List<String> printDirections(List<Coordinate> path) {
        Coordinate coordinate = path.get(0);
        ArrayList<String> dirs = new ArrayList<>();
        ArrayList<Coordinate> directions = getDirections(coordinate);
        for (Coordinate current : directions) {
            Coordinate prev = current.getParent();

            if (current.getX() == prev.getX() && current.getY() - 1 == prev.getY()) {
                dirs.add(DirectionElements.RIGHT.getValue());
            }
            if (current.getX() - 1 == prev.getX() && current.getY() == prev.getY()) {
                dirs.add(DirectionElements.DOWN.getValue());
            }
            if (current.getX() == prev.getX() && current.getY() + 1 == prev.getY()) {
                dirs.add(DirectionElements.LEFT.getValue());
            }
            if (current.getX() + 1 == prev.getX() && current.getY() == prev.getY()) {
                dirs.add(DirectionElements.UP.getValue());
            }
        }
        Collections.reverse(dirs);
        return dirs;

    }
    private ArrayList<Coordinate> getDirections(Coordinate coordinate) {

        if (coordinate.getParent() != null) {
            directionsToEnd.add(coordinate);
            getDirections(coordinate.getParent());
        }
        return directionsToEnd;
    }

    private String toString(int[][] maze) {
        StringBuilder result = new StringBuilder(this.maze.getWidth() * (this.maze.getHeight() + 1));
        for (int row = 0; row < this.maze.getHeight(); row++) {
            for (int col = 0; col < this.maze.getWidth(); col++) {
                if (maze[row][col] == MazeElements.ROAD.getValue()) {
                    result.append(MazeCharElements.ROAD.getValue());
                } else if (maze[row][col] == MazeElements.WALL.getValue()) {
                    result.append(MazeCharElements.WALL.getValue());
                } else if (maze[row][col] == MazeElements.START.getValue()) {
                    result.append(MazeCharElements.START.getValue());
                } else if (maze[row][col] == MazeElements.END.getValue()) {
                    result.append(MazeCharElements.END.getValue());
                } else {
                    result.append('.');
                }
            }
            result.append('\n');
        }
        return result.toString();
    }
}

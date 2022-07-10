package org.example.model.enums;

/**
 * Enum class for all enums with String values
 */
public enum MazeCharElements {


    START('S'),
    END('X'),
    ROAD(' '),
    WALL('#');
    private final char value;
    MazeCharElements(final char value) {
        this.value = value;
    }
    public char getValue() {
        return value;
    }

}

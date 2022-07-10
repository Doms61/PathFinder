package org.example.model.enums;

/**
 * Enum class for all enums with int elements
 */
public enum MazeElements {

    ROAD(0),
    WALL(1),
    START(2),
    END(3),
    PATH(4);


    private final int value;
    MazeElements(final int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

}

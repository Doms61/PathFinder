package org.example.model.enums;

/**
 * Enum class for all enums with String values
 */
public enum DirectionElements {

    RIGHT("R"),
    LEFT("L"),
    DOWN("D"),
    UP("U");

    private final String value;
    DirectionElements(final String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}

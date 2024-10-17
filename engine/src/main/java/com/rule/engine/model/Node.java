package com.rule.engine.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Node {
    private String type;   // "operator" or "operand"
    private Node left;     // Left child for operator nodes
    private Node right;    // Right child for operator nodes
    private String value;  // Value for operand nodes (conditions)
    public Node() {
    }

    // Constructor for operand nodes (leaf)
    public Node(String type, String value) {
        this.type = type;
        this.value = value;
    }

    // Constructor for operator nodes (internal)
    public Node(String type, Node left, Node right) {
        this.type = type;
        this.left = left;
        this.right = right;
    }
    @JsonCreator
    public Node(@JsonProperty("type") String type,
                @JsonProperty("left") Node left,
                @JsonProperty("right") Node right,
                @JsonProperty("value") String value) {
        this.type = type;
        this.left = left;
        this.right = right;
        this.value = value;
    }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

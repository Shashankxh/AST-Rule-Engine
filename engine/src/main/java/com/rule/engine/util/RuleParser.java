package com.rule.engine.util;

import com.rule.engine.model.Node;

public class RuleParser {

    // Parse a simple rule and return the corresponding AST
    public Node parseRule(String rule) {
        // This is a simplified parser. You can extend this to handle more complex rules.
        String[] parts = rule.split(" ");

        if (parts.length == 3) {
            // Operand node: e.g., "age > 30"
            return new Node("operand", rule);
        } else if (parts.length > 3) {
            // Operator node: e.g., "age > 30 AND salary > 50000"
            Node leftOperand = new Node("operand", parts[0] + " " + parts[1] + " " + parts[2]);
            String operator = parts[3];  // AND or OR
            Node rightOperand = new Node("operand", parts[4] + " " + parts[5] + " " + parts[6]);
            return new Node(operator, leftOperand, rightOperand);
        }

        return null;
    }

    // Combine multiple rules into a single AST using AND/OR
    public Node combineRules(Node rule1, String operator, Node rule2) {
        return new Node(operator, rule1, rule2);
    }
}

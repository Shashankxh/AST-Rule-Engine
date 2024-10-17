package com.rule.engine.Service;
import com.rule.engine.model.Node;
import com.rule.engine.util.RuleParser;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RuleService {

    private final RuleParser ruleParser = new RuleParser();

    // Create a rule and return the AST
    public Node createRule(String rule) {
        return ruleParser.parseRule(rule);
    }

    // Combine two ASTs with an operator (AND/OR)
    public Node combineRules(Node rule1, String operator, Node rule2) {
        return ruleParser.combineRules(rule1, operator, rule2);
    }

    // Evaluate the rule AST against the provided user data
    public boolean evaluateRule(Node node, Map<String, Object> data) {
        if (node == null) return false;

        if ("operand".equals(node.getType())) {
            // Simple condition evaluation: Example "age > 30"
            return evaluateCondition(node.getValue(), data);
        }

        // Recursively evaluate left and right nodes for operators (AND/OR)
        boolean leftResult = evaluateRule(node.getLeft(), data);
        boolean rightResult = evaluateRule(node.getRight(), data);

        if ("AND".equals(node.getType())) {
            return leftResult && rightResult;
        } else if ("OR".equals(node.getType())) {
            return leftResult || rightResult;
        }

        return false;
    }

    // Helper method to evaluate conditions like "age > 30"
    private boolean evaluateCondition(String condition, Map<String, Object> data) {
        String[] parts = condition.split(" ");
        String attribute = parts[0];     // e.g., age
        String operator = parts[1];      // e.g., >
        int value = Integer.parseInt(parts[2]);  // e.g., 30

        int userValue = (int) data.get(attribute);  // Fetch the value from user data

        switch (operator) {
            case ">":
                return userValue > value;
            case "<":
                return userValue < value;
            case "=":
                return userValue == value;
            default:
                return false;
        }
    }
}
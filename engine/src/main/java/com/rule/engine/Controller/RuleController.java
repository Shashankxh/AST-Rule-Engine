package com.rule.engine.Controller;
import com.rule.engine.model.Node;

import com.rule.engine.Service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/rules")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    // Endpoint to create a rule and return its AST
    @PostMapping("/create")
    public Node createRule(@RequestBody String rule) {
        return ruleService.createRule(rule);
    }

    // Endpoint to combine two rules
    @PostMapping("/combine")
    public Node combineRules(@RequestParam String operator, @RequestBody Map<String, Node> rules) {
        return ruleService.combineRules(rules.get("rule1"), operator, rules.get("rule2"));
    }

    // Endpoint to evaluate a rule against user data
    @PostMapping("/evaluate")
    public boolean evaluateRule(@RequestBody Map<String, Object> request) {
        Node rule = (Node) request.get("rule");
        Map<String, Object> data = (Map<String, Object>) request.get("data");
        return ruleService.evaluateRule(rule, data);
    }
}
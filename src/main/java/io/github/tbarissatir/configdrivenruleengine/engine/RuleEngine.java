package io.github.tbarissatir.configdrivenruleengine.engine;

import io.github.tbarissatir.configdrivenruleengine.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RuleEngine {

    private final List<Rule> rules = new ArrayList<>();

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public EvaluationResult evaluate(String input) {
        for (Rule r : rules) {
            if (input.contains(r.getCondition())) {
                return new EvaluationResult(true, r.getAction());
            }
        }
        return new EvaluationResult(false, null);
    }


}

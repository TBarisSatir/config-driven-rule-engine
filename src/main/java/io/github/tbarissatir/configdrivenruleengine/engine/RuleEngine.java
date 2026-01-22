package io.github.tbarissatir.configdrivenruleengine.engine;

import io.github.tbarissatir.configdrivenruleengine.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class RuleEngine {

    private final List<Rule> rules = new ArrayList<>();

    private static final Logger log = LoggerFactory.getLogger(RuleEngine.class);

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public EvaluationResult evaluate(String input) {

        log.debug("Starting rule evaluation. ruleCount={}, input='{}'",
                rules.size(), input);

        for (Rule rule : rules) {

            switch (rule.getName()) {

                case "PROFANITY_FILTER":
                    if (input.matches(".*(fuck).*")) { //genişletilmeli. hepsini buraya yazamam todo : Fix
                        return new EvaluationResult(true, false, rule.getName(), "Content flagged as inappropriate");
                    }
                    break;

                case "TOO_SHORT":
                    if (input.trim().length() < 10) {
                        return new EvaluationResult(false, true, rule.getName(), "Content is too short");
                    }
                    break;

                case "SPAM_DETECTION":
                    String[] words = input.split("\\s+");
                    Map<String, Integer> freq = new HashMap<>();

                    for (String w : words) {
                        freq.put(w, freq.getOrDefault(w,0)+1);
                        if (freq.get(w) >= 3) {
                            return new EvaluationResult(true, false, rule.getName(), "Content marked as spam.");
                        }
                    }
                    break;

                case "SECURITY_RISK":
                    if (input.matches(".*(password|token|credential|card number).*")) {
                        return new EvaluationResult(true, false, rule.getName(), "Content may contain sensitive information.");
                    }
                    break;

                case "URGENT_FLAG":
                    if (input.contains("urgent")) {
                        return new EvaluationResult(false, true, rule.getName(), "Task marked as urgent.");
                    }
                    break;
            }
        }
        log.debug("No rules matched");
        return new EvaluationResult(false, false, null, "None.");
    }
}


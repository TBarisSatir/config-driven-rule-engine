package io.github.tbarissatir.configdrivenruleengine.engine;

import io.github.tbarissatir.configdrivenruleengine.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Component
public class RuleEngine {

    private final List<Rule> rules = new ArrayList<>();

    private static final Logger log = LoggerFactory.getLogger(RuleEngine.class);

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public EvaluationResult evaluate(String input) {

        for (Rule rule : rules) {

            switch (rule.getName()) {

                case "PROFANITY_FILTER":
                    if (input.matches(".*(fuck).*")) { //input genişletilebilir.
                        return new EvaluationResult(true, false, rule.getName(), "Content flagged as inappropriate");
                    }
                    break;

                case "TOO_SHORT":
                    if (input.length() < 5) {
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
                        return new EvaluationResult(false, false, rule.getName() , "Content flagged as urgent.");
                    }
                    break;
            }
        }
        log.debug("Evaluating input against {} rules", rules.size());
        return new EvaluationResult(false, false, null, "None.");
    }
}


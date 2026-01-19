package io.github.tbarissatir.configdrivenruleengine.config;

import io.github.tbarissatir.configdrivenruleengine.engine.RuleEngine;
import io.github.tbarissatir.configdrivenruleengine.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RuleConfig {

    private final RuleEngine ruleEngine;

    public RuleConfig(RuleEngine ruleEngine) {
        this.ruleEngine = ruleEngine;
    }

    @PostConstruct
    public void initRules() {

        ruleEngine.addRule(new Rule("PROFANITY_FILTER", RuleType.BLOCK, null, "Content flagged as inappropriate"));
        ruleEngine.addRule(new Rule("TOO_SHORT", RuleType.WARNING, null, "Content is too short"));
        ruleEngine.addRule(new Rule("SPAM_DETECTION", RuleType.BLOCK, null , "Content marked as spam."));
        ruleEngine.addRule(new Rule("SECURITY_RISK", RuleType.BLOCK, null , "Content may contain sensitive information."));
        ruleEngine.addRule(new Rule("URGENT_FLAG", RuleType.INFO, "urgent" , "Content flagged as urgent."));
    }
}
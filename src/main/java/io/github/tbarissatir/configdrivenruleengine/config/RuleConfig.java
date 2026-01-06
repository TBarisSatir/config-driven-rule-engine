package io.github.tbarissatir.configdrivenruleengine.config;

import io.github.tbarissatir.configdrivenruleengine.engine.RuleEngine;
import io.github.tbarissatir.configdrivenruleengine.model.Rule;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class RuleConfig {

    private final RuleEngine ruleEngine;

    public RuleConfig(RuleEngine ruleEngine) {
        this.ruleEngine = ruleEngine;
    }

    @PostConstruct
    public void initRules() {

        ruleEngine.addRule(new Rule("error", "BLOCK"));
        ruleEngine.addRule(new Rule("urgent", "PRIORITY"));
        ruleEngine.addRule(new Rule("todo", "NORMAL"));
    }
}

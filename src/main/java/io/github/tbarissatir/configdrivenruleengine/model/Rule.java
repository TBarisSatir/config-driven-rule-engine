package io.github.tbarissatir.configdrivenruleengine.model;

public class Rule {

    private String name;
    private RuleType type;
    private String trigger;
    private String ruleMsg;

    public Rule(String name, RuleType type, String trigger, String ruleMsg) {
        this.name = name;
        this.type = type;
        this.trigger = trigger;
        this.ruleMsg = ruleMsg;
    }

    public String getName() { return name; }
    public RuleType getType() { return type; }
    public String getTrigger() { return trigger; }
    public String getRuleMsg() {return ruleMsg; }
}


package io.github.tbarissatir.configdrivenruleengine.model;

public class Rule {

    private String name;
    private RuleType type;
    private String trigger;

    public Rule(String name, RuleType type, String trigger) {
        this.name = name;
        this.type = type;
        this.trigger = trigger;
    }

    public String getName() { return name; }
    public RuleType getType() { return type; }
    public String getTrigger() { return trigger; }
}


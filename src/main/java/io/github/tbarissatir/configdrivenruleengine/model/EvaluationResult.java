package io.github.tbarissatir.configdrivenruleengine.model;

public class EvaluationResult {

    private boolean blocked;
    private boolean warning;
    private String ruleName;
    private String ruleMsg;

    public EvaluationResult(boolean blocked, boolean warning, String ruleName, String ruleMsg) {
        this.blocked = blocked;
        this.warning = warning;
        this.ruleName = ruleName;
        this.ruleMsg = ruleMsg;
    }

    public boolean isBlocked() { return blocked; }
    public boolean isWarning() { return warning; }
    public String getRuleName() { return ruleName; }
    public boolean isMatched() { return blocked || warning; }
    public String getRuleMsg() { return ruleMsg; }
}

package io.github.tbarissatir.configdrivenruleengine.model;

public class EvaluationResult {

    private boolean blocked;
    private boolean warning;
    private String ruleName;

    public EvaluationResult(boolean blocked, boolean warning, String ruleName) {
        this.blocked = blocked;
        this.warning = warning;
        this.ruleName = ruleName;
    }

    public boolean isBlocked() { return blocked; }
    public boolean isWarning() { return warning; }
    public String getRuleName() { return ruleName; }
    public boolean isMatched() { return blocked || warning; }

}

package io.github.tbarissatir.configdrivenruleengine.dto;

public class RuleEvaluationResponse {

    private boolean matched;
    private String ruleName;
    private boolean warning;

    public RuleEvaluationResponse(boolean matched, String ruleName, boolean warning) {
        this.matched = matched;
        this.ruleName = ruleName;
        this.warning = warning;
    }

    public boolean isMatched() { return matched; }
    public String getRuleName() { return ruleName; }
    public boolean isWarning() { return warning; }
}

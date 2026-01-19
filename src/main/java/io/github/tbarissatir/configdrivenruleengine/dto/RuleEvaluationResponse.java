package io.github.tbarissatir.configdrivenruleengine.dto;

public class RuleEvaluationResponse {

    private boolean matched;
    private String ruleName;
    private boolean warning;
    private String ruleMsg;

    public RuleEvaluationResponse(boolean matched, String ruleName, boolean warning, String ruleMsg) {
        this.matched = matched;
        this.ruleName = ruleName;
        this.warning = warning;
        this.ruleMsg = ruleMsg;
    }

    public boolean isMatched() { return matched; }
    public String getRuleName() { return ruleName; }
    public boolean isWarning() { return warning; }
    public String getRuleMsg() { return ruleMsg; }
}

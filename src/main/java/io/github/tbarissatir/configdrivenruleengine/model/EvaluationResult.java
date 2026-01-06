package io.github.tbarissatir.configdrivenruleengine.model;

public class EvaluationResult {

    private final boolean matched;
    private final String ruleName;

    public EvaluationResult(boolean matched, String ruleName) {
        this.matched = matched;
        this.ruleName = ruleName;
    }

    public boolean isMatched() {
        return matched;
    }

    public String getRuleName() {
        return ruleName;
    }
}

package io.github.tbarissatir.ruleengine.model;

public class Rule {

    private String condition;
    private String action;

    public  Rule(String condition, String action){
        this.condition = condition;
        this.action = action;
    }

    public String getCondition(){
        return condition;
    }

    public String getAction(){
        return action;
    }
}

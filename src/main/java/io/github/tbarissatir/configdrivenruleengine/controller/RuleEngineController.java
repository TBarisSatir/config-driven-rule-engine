package io.github.tbarissatir.configdrivenruleengine.controller;

import io.github.tbarissatir.configdrivenruleengine.dto.RuleEvaluationRequest;
import io.github.tbarissatir.configdrivenruleengine.dto.RuleEvaluationResponse;
import io.github.tbarissatir.configdrivenruleengine.engine.RuleEngine;
import org.springframework.web.bind.annotation.*;
import io.github.tbarissatir.configdrivenruleengine.model.*;

@RestController
@RequestMapping("/api/rules")
public class RuleEngineController {

    private final RuleEngine engine;

    public RuleEngineController(RuleEngine engine) {
        this.engine = engine;
    }

    @PostMapping("/evaluate")
    public RuleEvaluationResponse evaluate(@RequestBody RuleEvaluationRequest req) {
        var result = engine.evaluate(req.input());

        return new RuleEvaluationResponse(
                result.isMatched(),
                result.getRuleName(),
                result.isWarning()
        );
    }

}

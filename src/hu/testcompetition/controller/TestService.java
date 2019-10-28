package hu.testcompetition.controller;

import hu.testcompetition.model.domain.TestResult;
import hu.testcompetition.model.domain.Validator;

import java.util.List;

public class TestService {

    private final Validator validator;
    private final List<TestResult> testResults;

    public TestService(Validator validator, List<TestResult> testResults) {
        this.validator = validator;
        this.testResults = testResults;
    }

    public int getCompetitorNumber() {
        return testResults.size();
    }
}

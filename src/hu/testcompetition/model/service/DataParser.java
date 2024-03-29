package hu.testcompetition.model.service;

import hu.testcompetition.model.domain.TestResult;
import hu.testcompetition.model.domain.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class DataParser {

    Validator createValidator(String line) {
        return new Validator(line);
    }

    List<TestResult> createTestResults(List<String> lines) {
        return lines.stream()
                .map(this::createTestResult)
                .collect(Collectors.toList());
    }

    private TestResult createTestResult(String line) {
        String[] items = line.split(" ");
        return new TestResult(items[0], items[1]);
    }

}

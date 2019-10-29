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

    public String getAnswerById(String id) {
        return getTestResuktById(id).getAnswer();
    }

    public String getCheckedResult(String id) {
        return String.format("%s\t(A helyes megoldás)%n%s\t(A versenyző helyes válaszai)",
                validator.getAnswer(), validator.checkResult(getTestResuktById(id).getAnswer()));
    }

    public String getCorrectAnswerStatistic(int taskNumber) {
        long countCorrectAnswers = countCorrectAnswers(taskNumber - 1);
        double percent = countCorrectAnswers * 100.0 / getCompetitorNumber();
        return String.format("A feladatra %d fő, a versenyzők %5.2f%%-a adott helyes választ", countCorrectAnswers, percent);
    }


    private TestResult getTestResuktById(String id) {
        return testResults.stream()
                .filter(i -> i.getId().equals(id))
                .findAny()
                .get();
    }

    private long countCorrectAnswers(int taskNumber) {
        return testResults.stream()
                .map(i -> i.getAnswer())
                .filter(answer -> validator.isCorrect(answer, taskNumber))
                .count();
    }
}

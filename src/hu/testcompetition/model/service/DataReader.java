package hu.testcompetition.model.service;

import hu.testcompetition.model.domain.TestResult;
import hu.testcompetition.model.domain.Validator;

import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private final DataParser dataParser;
    private final List<String> lines;

    public DataReader(DataParser dataParser, FileDataReader fileDataReader) {
        this.dataParser = dataParser;
        this.lines = fileDataReader.read();
    }

    public Validator getValidator() {
        return dataParser.createValidator(lines.get(0));

    }

    public List<TestResult> getTestResult() {
        List<String> strings = new ArrayList<>(lines);
        strings.remove(0);
        return dataParser.createTestResults(strings);
    }

}

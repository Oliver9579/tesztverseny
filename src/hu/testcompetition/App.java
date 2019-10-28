package hu.testcompetition;

import hu.testcompetition.controller.TestService;
import hu.testcompetition.model.domain.TestResult;
import hu.testcompetition.model.domain.Validator;
import hu.testcompetition.model.service.DataParser;
import hu.testcompetition.model.service.DataReader;
import hu.testcompetition.model.service.FileDataReader;

import java.util.List;

public class App {
    private final TestService testService;

    App(){
        DataParser dataParser = new DataParser();
        FileDataReader fileDataReader = new FileDataReader("valaszok.txt");
        DataReader dataReader = new DataReader(dataParser, fileDataReader);
        Validator validator = dataReader.getValidator();
        List<TestResult> testResults = dataReader.getTestResult();
        testService = new TestService( validator, testResults);
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("1. feladat: Az adatok beolvasása");
        System.out.println("2. feladat: A vetélkedőn "+ testService.getCompetitorNumber() +" versenyző indult el");
    }
}

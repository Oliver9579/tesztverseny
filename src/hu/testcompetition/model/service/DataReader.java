package hu.testcompetition.model.service;

import hu.testcompetition.model.domain.CompetitionResult;

import java.util.List;

public interface DataReader {

    List<CompetitionResult> getData(String input);
}

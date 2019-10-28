package hu.testcompetition.model.service;

import hu.testcompetition.model.domain.CompetitionResult;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileDataReader implements DataReader {


    @Override
    public List<CompetitionResult> getData(String input) {
        return parse(read(input));
    }

    private List<String> read(String input){
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            lines = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
    private List<CompetitionResult> parse (List<String> lines){
        lines.remove(0);
        return lines.stream()
                .map(this::createCompetitionResult)
                .collect(Collectors.toList());
    }
    private CompetitionResult createCompetitionResult(String line){
        return new CompetitionResult(line)
}

}

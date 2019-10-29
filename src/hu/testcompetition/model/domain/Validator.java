package hu.testcompetition.model.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Validator {
    private final String answer;

    public Validator(String answer) {
        this.answer = answer;
    }

    public String checkResult(String competitorAnswer) {
        return IntStream.range(0, answer.length())
                .mapToObj(i -> checkTask(competitorAnswer, i))
                .collect(Collectors.joining());
    }


    public boolean isCorrect(String competitorAnswer, int i) {
        return answer.charAt(i) == competitorAnswer.charAt(i);
    }

    public String getAnswer() {
        return answer;
    }

    private String checkTask(String competitorAnswer, int i) {
        return isCorrect(competitorAnswer, i) ? "+" : " ";
    }
}

package com.nhnacademy.edu.springframework.project.repository;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CsvScores implements Scores {

    private CsvScores(){}
    private static CsvScores csvScores = new CsvScores();

    private Collection <Score> scores;

    /** TODO 2 :
     * Java Singleton 패턴으로 getInstance() 를 구현하세요.
     **/
    public static Scores getInstance() {
        return csvScores;
    }

    // TODO 5 : score.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요.
    @Override
    public void load() {
        scores = new ArrayList<>();
        try (
                InputStream inputStream = new ClassPathResource("data/score.csv").getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitStrings = line.split(",");
                int studentSeq = Integer.parseInt(splitStrings[0]);
                int score = Integer.parseInt(splitStrings[1]);
                scores.add(new Score(studentSeq, score));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Score> findAll() {
        load();
        return new ArrayList<>(scores);
    }
}

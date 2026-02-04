package com.json.ipl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class JsonIplProcessor {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        List<IplMatch> matches = mapper.readValue(
                new File("files/ipl_input.json"),
                new TypeReference<List<IplMatch>>() {}
        );

        for (IplMatch m : matches) {
            m.team1 = CensorUtil.maskTeamName(m.team1);
            m.team2 = CensorUtil.maskTeamName(m.team2);
            m.winner = CensorUtil.maskTeamName(m.winner);
            m.player_of_match = CensorUtil.redactPlayer();
        }

        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(new File("files/ipl_censored.json"), matches);

        System.out.println("Censored JSON generated!");
    }
}

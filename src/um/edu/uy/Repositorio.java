package um.edu.uy;

import um.edu.uy.Tads.Hash.HashNode;
import um.edu.uy.Tads.Hash.OpenHash;
import um.edu.uy.Tads.HeapJope.Heap;
import um.edu.uy.Tads.KeyNotFoundException;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static um.edu.uy.MedalType.NA;

public class Repositorio {

    public static OpenHash<Long, Athlete> atletas1 = new OpenHash<>(140000, 140000);

    public static OpenHash<String, NationalOlympicCommitte> regions = new OpenHash<>(1500, 1500);

    public static OpenHash<String, NationalOlympicCommitte> regionsXnoc = new OpenHash<>(232, 232);

    public static OpenHash<String, AthleteOlympicParticipation> participationsXregion = new OpenHash<>(300, 300);

    public static OpenHash<Long, AthleteOlympicParticipation> participations = new OpenHash<>(140000, 140000);


    public static OpenHash<String, Team> teams = new OpenHash<>(300, 300);


    public static void init() {

        System.out.println("Cargando datos...");

        String line1;

        String line2;

        BufferedReader br1;

        BufferedReader br2;

        long previousId = -1;

        long id;

        String name;

        SexType sex;

        int age;

        float weight;

        float height;

        Team team;

        SeasonType season;

        City city;

        OlympicGame game;

        Sport sport;

        Event event;

        Athlete tempAtleta = null;

        try {

            br1 = new BufferedReader(new FileReader("resources/noc_regions.csv"));

            br1.readLine();

            while ((line1 = br1.readLine()) != null) {

                String[] nocs = line1.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if (nocs[0].equals("SIN")) nocs[0] = "SGP";

                if (nocs.length == 3) {

                    regions.put(nocs[1], new NationalOlympicCommitte(nocs[0], nocs[1], nocs[2]));

                    regionsXnoc.put(nocs[0], new NationalOlympicCommitte(nocs[0], nocs[1], nocs[2]));

                } else {

                    regions.put(nocs[1], new NationalOlympicCommitte(nocs[0], nocs[1], null));

                    regionsXnoc.put(nocs[0], new NationalOlympicCommitte(nocs[0], nocs[1], null));

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            br2 = new BufferedReader(new FileReader("resources/athlete_events.csv"));

            br2.readLine();

            while ((line2 = br2.readLine()) != null) {

                String[] atleta = line2.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                atleta[0] = atleta[0].substring(1, atleta[0].length() - 1);

                id = Long.valueOf(atleta[0]);

                atleta[1] = atleta[1].substring(1, atleta[1].length() - 1);

                name = atleta[1];

                atleta[2] = atleta[2].substring(1, atleta[2].length() - 1);

                if (atleta[2].equals("M")) {

                    sex = SexType.MALE;

                } else {

                    sex = SexType.FEMALE;

                }

                if (!atleta[3].equals("NA")) age = Integer.parseInt(atleta[3]);
                else age = 0;

                if (!atleta[4].equals("NA")) height = Float.parseFloat(atleta[4]);
                else height = 0;

                if (!atleta[5].equals("NA")) weight = Float.parseFloat(atleta[5]);
                else weight = 0;

                atleta[7] = atleta[7].substring(1, atleta[7].length() - 1);

                team = new Team(atleta[6]);

                if (teams != null) if (!teams.contains(team.getNombre())) teams.put(team.getNombre(), team);
                else teams.put(team.getNombre(), team);

                try {

                    tempAtleta = new Athlete(id, name, sex, age, height, weight, team, regionsXnoc.get(atleta[7]));

                } catch (KeyNotFoundException e) {
                    e.printStackTrace();
                }

                if (tempAtleta != null && tempAtleta.getId() != previousId) atletas1.put(id, tempAtleta);

                if (tempAtleta != null) previousId = tempAtleta.getId();

                atleta[10] = atleta[10].substring(1, atleta[10].length() - 1);

                if (atleta[10].equals("Winter")) season = SeasonType.WINTER;
                else season = SeasonType.SUMMER;

                atleta[11] = atleta[11].substring(1, atleta[11].length() - 1);

                city = new City(atleta[11]);

                atleta[8] = atleta[8].substring(1, atleta[8].length() - 1);

                game = new OlympicGame(atleta[8], Integer.parseInt(atleta[9]), season, city);

                atleta[12] = atleta[12].substring(1, atleta[12].length() - 1);

                sport = new Sport(atleta[12]);

                atleta[13] = atleta[13].substring(1, atleta[13].length() - 1);

                event = new Event(atleta[13], sport);

                atleta[14] = atleta[14].substring(1, atleta[14].length() - 1);

                MedalType medal;

                switch (atleta[14]) {
                    case "Gold":

                        medal = MedalType.GOLD;

                        break;
                    case "Silver":

                        medal = MedalType.SILVER;

                        break;
                    case "Bronze":

                        medal = MedalType.BRONZE;

                        break;
                    default:

                        medal = NA;

                        break;
                }

                AthleteOlympicParticipation participacionTemp = new AthleteOlympicParticipation(medal, tempAtleta, game);
                participacionTemp.setEvento(event);

                participationsXregion.put(tempAtleta.getNoc().getRegion(), participacionTemp);

                participations.put(id, participacionTemp);

            }
            System.out.println("Datos cargados");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
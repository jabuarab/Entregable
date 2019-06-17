package um.edu.uy;

import um.edu.uy.Tads.Hash.ClosedHash;
import um.edu.uy.Tads.Hash.ColissionManagement;
import um.edu.uy.Tads.Hash.OpenHash;
import um.edu.uy.Tads.HeapJope.Heap;
import um.edu.uy.Tads.KeyNotFoundException;
import um.edu.uy.Tads.TreeJope.BTree;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.Scanner;

public class Repositorio {


    public static OpenHash<String, Athlete> atletas = new OpenHash<>(232, 232);

    public static OpenHash<String, NationalOlympicCommitte> regions = new OpenHash<>(232, 232);

    public static OpenHash<Integer, AthleteOlympicParticipation> participations = new OpenHash<>(140000, 140000);

    public static OpenHash<String, Team> teams = new OpenHash<>(300, 300);

    public  static  boolean MaryilinA = false;

    public static void init() {


        Scanner sc = new Scanner(System.in);

        System.out.println("Cargando datos...");

        long previousid = -1;


        String line1;

        String line2;

        BufferedReader br1;

        BufferedReader br2;

        try {

            br1 = new BufferedReader(new FileReader("resources/noc_regions.csv"));

            br1.readLine();

            while ((line1 = br1.readLine()) != null) {

                String[] nocs = line1.split(",");

                if (nocs[0].equals("SIN")) {
                    nocs[0] = "SGP";
                }


                if (nocs[0].equals("SIN")) nocs[0] = "SGP";

                if (nocs.length == 3) {

                    nocs[2] = nocs[2].substring(1, nocs[2].length() - 1);

                    regions.put(nocs[1], new NationalOlympicCommitte(nocs[0], nocs[1], nocs[2]));

                } else {

                    regions.put(nocs[1], new NationalOlympicCommitte(nocs[0], nocs[1], null));

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

                long id = Long.valueOf(atleta[0]);

                atleta[1] = atleta[1].substring(1, atleta[1].length() - 1);

                String name = atleta[1];

                atleta[2] = atleta[2].substring(1, atleta[2].length() - 1);

                SexType sex;

                if (atleta[2].equals("M")) {

                    sex = SexType.MALE;

                } else {

                    sex = SexType.FEMALE;

                }

                int age;

                if (!atleta[3].equals("NA")) age = Integer.parseInt(atleta[3]);
                else age = 0;

                float height;

                if (!atleta[4].equals("NA")) height = Float.parseFloat(atleta[4]);
                else height = 0;

                float weight;

                if (!atleta[5].equals("NA")) weight = Float.parseFloat(atleta[5]);
                else weight = 0;

                atleta[7] = atleta[7].substring(1, atleta[7].length() - 1);

                Team team = new Team(atleta[6]);
                if (teams != null) {
                    if (!teams.contains(team.getNombre())) {
                        teams.put(team.getNombre(), team);
                    }
                }
                if (teams == null) {
                    teams.put(team.getNombre(), team);
                }

                int regiontemp = -1;
                int cualNoc = -1;
                for (int i = 0; i < regions.getHash().length; i++) {
<<<<<<< HEAD
                    if (regions.getHash()[i] != null) {
                        for (int j = 0; j < regions.getHash()[i].size(); j++) {
                            if (atleta[7].equals(regions.getHash()[i].get(j).getData().getName())) {
                                cualNoc = j;
                                regiontemp = i;
                            }
=======
                    for (int j = 0; j < regions.getHash()[i].size(); j++) {
                        if (atleta[7].equals(regions.getHash()[i].get(j).getData().getName())) {
                            cualNoc = j;
                            regiontemp = i;
                        }
>>>>>>> d468af8319de696562aec5a0fdd89b422e581fef

                        }
                    }
                }
                int tempInt = 0;
                Athlete tempAtleta;
                try {
                    Athlete tempAtleta1 = new Athlete(id, name, sex, age, height, weight,
                            team, regions.getHash()[regiontemp].get(cualNoc).getData());
                    tempAtleta = tempAtleta1;
                } catch (NegativeArraySizeException e1) {
                    System.out.println("Esta mal algo en agrgar los atletas");
                    for (int j = 0; j < regions.getTodos("NA").size(); j++) {
                        if (regions.getTodos("NA").get(j).getData().getName().equals(atleta[7])) {
                            tempInt = j;
                        }
                    }
                    Athlete tempAtleta1 = new Athlete(id, name, sex, age, height, weight, team, regions.getTodos("NA").get(tempInt).getData());
                    tempAtleta = tempAtleta1;

                }
                if (tempAtleta.getId() == 1169 && !MaryilinA ){MaryilinA = true;}

                if (tempAtleta.getId() != previousid  || MaryilinA) {

                    atletas.put(tempAtleta.getNoc().getName(), tempAtleta);

                }
                previousid = tempAtleta.getId();

                SeasonType season;

                atleta[10] = atleta[10].substring(1, atleta[10].length() - 1);

                if (atleta[10].equals("Winter")) {

                    season = SeasonType.WINTER;

                } else {

                    season = SeasonType.SUMMER;

                }

                atleta[11] = atleta[11].substring(1, atleta[11].length() - 1);

                City city = new City(atleta[11]);

                atleta[8] = atleta[8].substring(1, atleta[8].length() - 1);

                OlympicGame game = new OlympicGame(atleta[8], Integer.parseInt(atleta[9]), season, city);

                atleta[12] = atleta[12].substring(1, atleta[12].length() - 1);

                Sport sport = new Sport(atleta[12]);

                atleta[13] = atleta[13].substring(1, atleta[13].length() - 1);

                Event evento = new Event(atleta[13], sport);
<<<<<<< HEAD

                //atleta[14] = atleta[14].substring(1, atleta[14].length() - 1);
=======
>>>>>>> d468af8319de696562aec5a0fdd89b422e581fef

                atleta[14] = atleta[14].substring(1, atleta[14].length() - 1);

                int arrayMedalVar = 0;

                MedalType medal;

                switch (atleta[14]) {
                    case "Gold":

                        medal = MedalType.GOLD;
                        arrayMedalVar = 1;

                        break;
                    case "Silver":

                        medal = MedalType.SILVER;

                        arrayMedalVar = 2;

                        break;
                    case "Bronze":

                        medal = MedalType.BRONZE;

                        arrayMedalVar = 3;


                        break;
                    default:

                        medal = MedalType.NA;

                        arrayMedalVar = 0;
                        break;
                }

                if (arrayMedalVar != 0) {

                    switch (arrayMedalVar) {

                        case 1:

                            int[] a = {0, 0, 0, 0};
                            int posicion = -1;
                            for (int i = 0; i < atletas.getTodos(atleta[7]).size(); i++)
                                if (atletas.getTodos(atleta[7]).get(i).getData().getId() == Integer.parseInt(atleta[0])) {
                                    a = atletas.getTodos(atleta[7]).get(i).getData().getMedallas();
                                    posicion = i;
                                }

                            a = atletas.getTodos(atleta[7]).get(posicion).getData().getMedallas();
                            a[1] = a[1] + 1;

                            a[0] = a[0] + 1;
<<<<<<< HEAD
                            atletas.getTodos(atleta[7]).get(posicion).getData().setMedallas(a);
                            int[] a1 = {0, 0, 0, 0};
                            int posicion1 = -1;
                            int posicion2 = -1;

                            for (int i = 0; i < regions.getHash().length; i++) {
                                if (regions.getHash()[i] != null) {
                                    for (int j = 0; j < regions.getHash()[i].size(); j++) {
                                        if (regions.getHash()[i].get(j).getData().getName().equals(atleta[7])) {
                                            a1 = regions.getHash()[i].get(j).getData().getMedallas();
                                            posicion1 = i;
                                            posicion2 = j;
                                        }
                                    }
                                }
                            }
=======


                            actulizarMedallas(atleta[7], Integer.parseInt(atleta[0]), atletas, a);

                            int[] a1 = regions.get(tempAtleta.getNoc().getName()).getMedallas();
>>>>>>> d468af8319de696562aec5a0fdd89b422e581fef

                            a1[1] = a1[1] + 1;

                            a1[0] = a1[0] + 1;
<<<<<<< HEAD
                            regions.getHash()[posicion1].get(posicion2).getData().setMedallas(a1);
=======

                            actulizarMedallasNC(atleta[7], Integer.parseInt(atleta[0]), regions, a1);


                            regions.get(tempAtleta.getNoc().getName()).setMedallas(a1);

>>>>>>> d468af8319de696562aec5a0fdd89b422e581fef
                            break;
                        case 2:

                            int[] b = {0, 0, 0, 0};
                            int pos= -1;
                            for (int i = 0; i < atletas.getTodos(atleta[7]).size(); i++)
                                if (atletas.getTodos(atleta[7]).get(i).getData().getId() == id) {
                                    b = atletas.getTodos(atleta[7]).get(i).getData().getMedallas();
                                    pos= i;
                                }

                            b[2] = b[2] + 1;
                            b[0] = b[0] + 1;
                            atletas.getTodos(atleta[7]).get(pos).getData().setMedallas(b);




                            int[] b1 = {0, 0, 0, 0};
                            int pos1 = -1;
                            int pos2 = -1;

                            for (int i = 0; i < regions.getHash().length; i++) {
                                if (regions.getHash()[i] != null) {
                                    for (int j = 0; j < regions.getHash()[i].size(); j++) {
                                        if (regions.getHash()[i].get(j).getData().getName().equals(atleta[7])) {
                                            b1 = regions.getHash()[i].get(j).getData().getMedallas();
                                            pos1 = i;
                                            pos2 = j;
                                        }
                                    }
                                }
                            }

                            b1[1] = b1[1] + 1;
                            b1[0] = b1[0] + 1;
                            regions.getHash()[pos1].get(pos2).getData().setMedallas(b1);

//                            regions.getHash()[posicion1].get(posicion2).getData().setMedallas(b1);
                            break;
                        case 3:

                            int[] c = {0, 0, 0, 0};
                            int poss= -1;
                            for (int i = 0; i < atletas.getTodos(atleta[7]).size(); i++)
                                if (atletas.getTodos(atleta[7]).get(i).getData().getId() == id) {
                                    c = atletas.getTodos(atleta[7]).get(i).getData().getMedallas();
                                    poss= i;
                                }

                            c[2] = c[2] + 1;
                            c[0] = c[0] + 1;
                            atletas.getTodos(atleta[7]).get(poss).getData().setMedallas(c);

                            int[] c1 = {0, 0, 0, 0};
                            int poss1 = -1;
                            int poss2 = -1;

                            for (int i = 0; i < regions.getHash().length; i++) {
                                if (regions.getHash()[i] != null) {
                                    for (int j = 0; j < regions.getHash()[i].size(); j++) {
                                        if (regions.getHash()[i].get(j).getData().getName().equals(atleta[7])) {
                                            c1 = regions.getHash()[i].get(j).getData().getMedallas();
                                            poss1 = i;
                                            poss2 = j;
                                        }
                                    }
                                }
                            }

                            c1[1] = c1[1] + 1;
                            c1[0] = c1[0] + 1;
                            regions.getHash()[poss1].get(poss2).getData().setMedallas(c1);


                            break;
                    }
                }

                AthleteOlympicParticipation participacionTemp = new AthleteOlympicParticipation(medal, tempAtleta, game);
                participacionTemp.setEvento(evento);
                participations.put(participacionTemp.getJuegoOlimpico().getYear(), participacionTemp);

            }
            System.out.println("Datos cargados");
        } catch (IOException  e) {
            e.printStackTrace();
        }


    }

<<<<<<< HEAD
    public static um.edu.uy.Tads.Heap.Heap<Athlete, Integer> medalTotalAtleth = new um.edu.uy.Tads.Heap.Heap<Athlete, Integer>(10);

    public static um.edu.uy.Tads.Heap.Heap<String, Integer> medalTotalNC = new um.edu.uy.Tads.Heap.Heap<String, Integer>(10);

    public static um.edu.uy.Tads.Heap.Heap<Athlete, Integer> medalGoldAtleth = new um.edu.uy.Tads.Heap.Heap<Athlete, Integer>(10);

    public static um.edu.uy.Tads.Heap.Heap<String, Integer> medalGoldNC = new um.edu.uy.Tads.Heap.Heap<String, Integer>(10);

    public static um.edu.uy.Tads.Heap.Heap<Athlete, Integer> medalSilverAtleth = new um.edu.uy.Tads.Heap.Heap<Athlete, Integer>(10);

    public static um.edu.uy.Tads.Heap.Heap<String, Integer> medalSilverNOC = new um.edu.uy.Tads.Heap.Heap<String, Integer>(10);

    public static um.edu.uy.Tads.Heap.Heap<Athlete, Integer> medalBronceAtlethe = new um.edu.uy.Tads.Heap.Heap<Athlete, Integer>(10);

    public static um.edu.uy.Tads.Heap.Heap<String, Integer> medalBronceNOC = new um.edu.uy.Tads.Heap.Heap<String, Integer>(10);

    public static um.edu.uy.Tads.Heap.Heap<OlympicGame, Integer> olympicGamesOrdenado = new um.edu.uy.Tads.Heap.Heap<OlympicGame, Integer>(10);
=======
    public static Heap<Integer, Athlete> medalTotalAthlete = new Heap<>(135571, false);

    public static Heap<Integer,String> medalTotalNOC = new Heap<>(135571, false);

    public static Heap<Integer, Athlete> medalGoldAthlete = new Heap<>(135571, false);

    public static Heap<Integer, String> medalGoldNOC = new Heap<>(135571, false);

    public static Heap<Integer, Athlete> medalSilverAthlete = new Heap<>(135571, false);

    public static Heap<Integer, String> medalSilverNOC = new Heap<>(135571, false);

    public static Heap<Integer, Athlete> medalBronzeAthlete = new Heap<>(135571, false);

    public static Heap<Integer,String> medalBronceNOC = new Heap<>(135571, false);
>>>>>>> d468af8319de696562aec5a0fdd89b422e581fef

    public static Heap<Integer, OlympicGame> olympicGamesOrdenado = new Heap<>(135571, false);

}
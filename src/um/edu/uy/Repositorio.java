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

    public static OpenHash<String,Team> teams = new OpenHash<>(300, 300);

    public static void init() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Cargando datos...");

        ClosedHash<String, NationalOlympicCommitte> regions = new ClosedHash<>(232, 232, ColissionManagement.LINEAR);

        ClosedHash<String, Athlete> atletas = new ClosedHash<>(232, 232, ColissionManagement.LINEAR);

        OpenHash<Integer, AthleteOlympicParticipation> participations = new OpenHash<>(140000, 140000);

        long previousid =-1;


        String line1;

        String line2;

        BufferedReader br1;

        BufferedReader br2;

        try {

            br1 = new BufferedReader(new FileReader("resources/noc_regions.csv"));

            br1.readLine();

            while ((line1 = br1.readLine()) != null) {

                String[] nocs = line1.split(",");

                if (nocs[0].equals("SIN")){
                    nocs[0]= "SGP";
                }


                if (nocs[0].equals("SIN")) nocs[0] = "SGP";

                if (nocs.length == 3) {

                    nocs[2] = nocs[2].substring(1, nocs[2].length() - 1);

                    regions.put(nocs[0], new NationalOlympicCommitte(nocs[0], nocs[1], nocs[2]));

                } else {

                    regions.put(nocs[0], new NationalOlympicCommitte(nocs[0], nocs[1], null));

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

                Team team = new Team(atleta[6]);  // no estamos agregando gente

                if(!teams.contains(team.getNombre())){
                    teams.put(team.getNombre(),team);
                }
                Athlete tempAtleta = new Athlete(id, name, sex, age, height, weight,
                        team, regions.get(atleta[7]));




                if (tempAtleta.getId() != previousid) {

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

                Event evento= new Event(atleta[13], sport);

                //atleta[14] = atleta[14].substring(1, atleta[14].length() - 1);
                int arraymMdalVAr = 0;

                atleta[14] = atleta[14].substring(1, atleta[14].length() - 1);

                int arrayMedalVar = 0;

                MedalType medal;

                switch (atleta[14]) {
                    case "Gold":

                        medal = MedalType.GOLD;
                        arraymMdalVAr = 1;

                        break;
                    case "Silver":

                        medal = MedalType.SILVER;

                        arraymMdalVAr = 2;

                        break;
                    case "Bronze":

                        medal = MedalType.BRONZE;

                        arraymMdalVAr = 3;


                        break;
                    default:

                        medal = MedalType.NA;

                        arraymMdalVAr = 0;
                        break;
                }

                if (arrayMedalVar != 0) {

                    switch (arrayMedalVar) {

                        case 1:

                            int[] a = atletas.get(atleta[0]).getMedallas();

                            a[1] = a[1] + 1;

                            a[0] = a[0] + 1;

                            atletas.get(atleta[0]).setMedallas(a);  // estoy en duda si esto funciona bien

                            int[] a1 = regions.get(tempAtleta.getNoc().getName()).getMedallas();

                            a1[1] = a1[1] + 1;

                            a1[0] = a1[0] + 1;


                            regions.get(tempAtleta.getNoc().getName()).setMedallas(a1);

                            break;
                        case 2:

                            int[] b = atletas.get(atleta[0]).getMedallas();
                            b[2] = b[2] + 1;
                            b[0] = b[0] + 1;
                            atletas.get(atleta[0]).setMedallas(b);  // estoy en duda si esto funciona bien

                            int[] b1 = regions.get(tempAtleta.getNoc().getName()).getMedallas();
                            b1[1] = b1[1] + 1;
                            b1[0] = b1[0] + 1;

                            regions.get(tempAtleta.getNoc().getName()).setMedallas(b1);

                            break;
                        case 3:

                            int[] c = atletas.get(atleta[0]).getMedallas();
                            c[2] = c[2] + 1;
                            c[0] = c[0] + 1;
                            atletas.get(atleta[0]).setMedallas(c);  // estoy en duda si esto funciona bien
                            int[] c1 = regions.get(tempAtleta.getNoc().getName()).getMedallas();
                            c1[1] = c1[1] + 1;
                            c1[0] = c1[0] + 1;
                            regions.get(tempAtleta.getNoc().getName()).setMedallas(c1);

                            break;
                    }
                }
                AthleteOlympicParticipation participacionTemp = new AthleteOlympicParticipation(medal, tempAtleta, game);
                participacionTemp.setEvento(evento);
                participations.put(participacionTemp.getJuegoOlimpico().getYear(), participacionTemp);

            }
        } catch (IOException | KeyNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Heap<Integer, Athlete> medalTotalAtleth = new Heap<Integer, Athlete>(10, false);

    public static Heap<Integer, NationalOlympicCommitte> medalTotalNC = new Heap<Integer, NationalOlympicCommitte>(10, false);

    public static Heap<Integer, Athlete> medalGoldAtleth = new Heap<Integer, Athlete>(10, false);

    public static Heap<Integer, NationalOlympicCommitte> medalGoldNC = new Heap<Integer, NationalOlympicCommitte>(10, false);

    public static Heap<Integer, Athlete> medalSilverAtleth = new Heap<Integer, Athlete>(10, false);

    public static Heap<Integer, NationalOlympicCommitte> medalSilverNC = new Heap<Integer, NationalOlympicCommitte>(10, false);

    public static Heap<Integer, Athlete> medalBronceAtleth = new Heap<Integer, Athlete>(10, false);

    public static Heap<Integer, NationalOlympicCommitte> medalBronceNC = new Heap<Integer, NationalOlympicCommitte>(10, false);

    public static Heap<Integer, OlympicGame> olimpicGamesOrdenado = new Heap<Integer, OlympicGame>(10, false);
}
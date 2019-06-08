package um.edu.uy;

import um.edu.uy.Tads.Hash.ClosedHash;
import um.edu.uy.Tads.Hash.ColissionManagement;
import um.edu.uy.Tads.KeyNotFoundException;
import um.edu.uy.Tads.Hash.OpenHash;
import um.edu.uy.Tads.TreeJope.BTree;
import um.edu.uy.Tads.TreeJope.EmptyTreeException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

    private static void menu() {

        Scanner sc = new Scanner(System.in);

        boolean salir = false;

        System.out.println("Cargando datos...");

        ClosedHash<String, NationalOlympicCommitte> regions = new ClosedHash<>(232, 232, ColissionManagement.LINEAR);

        OpenHash<Integer, AthleteOlympicParticipation> participations = new OpenHash<>(140000, 140000);

        int i = 0;

        String line1;

        String line2;

        BufferedReader br1;

        BufferedReader br2;

        try {

            br1 = new BufferedReader(new FileReader("/Users/jpalg/Desktop/Entregable/src/um/edu/uy/noc_regions.csv"));

            br1.readLine();

            while ((line1 = br1.readLine()) != null) {

                String[] nocs = line1.split(",");

                if (nocs.length == 3) {

                    nocs[2] = nocs[2].substring(1, nocs[2].length() - 1);

                    regions.put(nocs[0], new NationalOlympicCommitte(nocs[0], nocs[1], nocs[2]));

                } else regions.put(nocs[0], new NationalOlympicCommitte(nocs[0], nocs[1], null));

                i++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        i = 0;

        try {

            br2 = new BufferedReader(new FileReader("/Users/jpalg/Desktop/Entregable/src/um/edu/uy/athlete_events.csv"));

            br2.readLine();

            while ((line2 = br2.readLine()) != null) {

                String[] atleta = line2.split(";");

                //atleta[0] = atleta[0].substring(1, atleta[0].length() - 1);

                long id = Long.parseLong(atleta[0]);

                //atleta[1] = atleta[1].substring(1, atleta[1].length() - 1);


                String name = atleta[1];

                SexType sex;

                //atleta[2] = atleta[2].substring(1, atleta[2].length() - 1);

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

                //atleta[7] = atleta[7].substring(1, atleta[7].length() - 1);

                Team team = new Team(regions.get(atleta[7]).getRegion());

                Athlete atletas = new Athlete(id, name, sex, age, height, weight,
                        team, regions.get(atleta[7]));

                SeasonType season;

                //atleta[10] = atleta[10].substring(1, atleta[10].length() - 1);

                if (atleta[10].equals("Winter")) {

                    season = SeasonType.WINTER;

                } else {

                    season = SeasonType.SUMMER;

                }

                //atleta[11] = atleta[11].substring(1, atleta[11].length() - 1);

                City city = new City(atleta[11]);

                //atleta[8] = atleta[8].substring(1, atleta[8].length() - 1);

                OlympicGame game = new OlympicGame(atleta[8], Integer.parseInt(atleta[9]), season, city);

                //atleta[12] = atleta[12].substring(1, atleta[12].length() - 1);

                Sport sport = new Sport(atleta[12]);

                //atleta[13] = atleta[13].substring(1, atleta[13].length() - 1);

                Event event = new Event(atleta[13], sport);

                //atleta[14] = atleta[14].substring(1, atleta[14].length() - 1);

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
                        medal = MedalType.NA;
                        break;
                }

                participations.put(Integer.parseInt(atleta[0]), new AthleteOlympicParticipation(medal, atletas, game));

                i++;

            }
        } catch (IOException | KeyNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Bienvenido! Seleccione una opcion: ");

        System.out.println("1- Atletas con mas medallas     2- Regiones con mas medallas    3- JJOO con mas atletas femeninas");

        System.out.println("4- Competiciones con mas atletas de determinado sexo    5- Equipos mas efectivos    6- Salir");

        while (!salir) {

            switch (sc.nextInt()) {

                case 1:


                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    salir = true;

                    System.out.println("Hasta luego! Gracias!");

                    break;
                default:


                    break;
            }
        }
    }

    public static void main(String[] args) {

        menu();

    }
}

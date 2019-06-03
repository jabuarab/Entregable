package um.edu.uy;

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

        Athlete[] atletas = new Athlete[140000];

        OpenHash<String, NationalOlympicCommitte> regions = new OpenHash<>(231, 232);

        OpenHash<Integer, AthleteOlympicParticipation> participations = new OpenHash<>(140000, 140000);

        BTree<String, Team> teams = new BTree<>();

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

                regions.put(nocs[0], new NationalOlympicCommitte(nocs[1], nocs[2]));

                teams.insert(nocs[0], new Team(nocs[1]));

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

                String[] atleta = line2.split(",");

                long id = Long.parseLong(atleta[0]);

                String name = atleta[1];

                SexType sex;

                if (atleta[2].equals("M")) {

                    sex = SexType.MALE;

                } else {

                    sex = SexType.FEMALE;

                }

                int age = Integer.parseInt(atleta[3]);

                float height = Float.parseFloat(atleta[4]);

                float weight = Float.parseFloat(atleta[5]);

                atletas[i] = new Athlete(id, name, sex, age, height, weight,
                        teams.find(atleta[6]), regions.get(atleta[7]));

                SeasonType season;

                if (atleta[11].equals("Winter")) {

                    season = SeasonType.WINTER;

                } else {

                    season = SeasonType.SUMMER;

                }

                City city = new City(atleta[12]);

                OlympicGame game = new OlympicGame(atleta[9], Integer.parseInt(atleta[10]), season, city);

                Sport sport = new Sport(atleta[13]);

                Event event = new Event(atleta[14], sport);

                MedalType medal;

                switch (atleta[15]) {
                    case "Gold":
                        medal = MedalType.GOLD;
                        break;
                    case "Silver":
                        medal = MedalType.SILVER;
                        break;
                    case "Brozne":
                        medal = MedalType.BRONZE;
                        break;
                    default:
                        medal = MedalType.NA;
                        break;
                }

                participations.put(Integer.parseInt(atleta[0]), new AthleteOlympicParticipation(medal, atletas[i], game));

                i++;

            }
        } catch (IOException | KeyNotFoundException | EmptyTreeException e) {
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

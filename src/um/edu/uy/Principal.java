package um.edu.uy;

import java.util.Scanner;

public class Principal {
    private static void init() {

        Scanner scani = new Scanner("athlete_events.csv");

        while (scani.hasNext()) {

            String[] nextline = scani.nextLine().split(",");

            int id = Integer.parseInt(nextline[0]);

            String name = nextline[1];

            SexType sex = SexType.valueOf(nextline[2]);

            int age = Integer.valueOf(nextline[3]);

            float heigth = Float.valueOf(nextline[4]);

            float weigth = Float.valueOf(nextline[5]);

            String team = nextline[6];

            String Noc = nextline[7];

            String games = nextline[8];

            int year = Integer.valueOf(nextline[9]);

            SeasonType season = SeasonType.valueOf(nextline[10]);

            String city = nextline[11];

            String sport = nextline[12];

            String event = nextline[13];

            MedalType medal = MedalType.valueOf(nextline[14]);

            // crear objetos

        }
    }


    public static void main(String[] args) {

        init();

    }


}

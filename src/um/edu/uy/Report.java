package um.edu.uy;

import um.edu.uy.Tads.Hash.HashNode;
import um.edu.uy.Tads.Hash.OpenHash;
import um.edu.uy.Tads.HeapJope.Heap;
import um.edu.uy.Tads.KeyNotFoundException;

import java.time.Year;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Report {

    public static void One() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione una opcion:\n"
                + " 1- Medallas totales\n"
                + " 2- Medallas de oro\n"
                + " 3- Medallas de plata\n"
                + " 4- Medallas de bronce\n");

        Athlete atleta;

        int minYear, maxYear, tempYear, opcion;

        boolean state = true;

        do {
            try {

                switch (sc.nextInt()) {

                    case 1:

                        state = true;

                        Heap<Integer, Athlete> totalMedals = new Heap<>(140000, false);

                        int totalMedallas = 0;

                        for (long i = 0; i < Repositorio.participations.getSize(); i++) {

                            minYear = 2500;
                            maxYear = 0;
                            if (Repositorio.participations.getTodos(i) != null) {
                                for (HashNode<Long, AthleteOlympicParticipation> part : Repositorio.participations.getTodos(i)) {

                                    if (!part.getData().getMedalType().equals(MedalType.NA)) totalMedallas++;

                                    tempYear = part.getData().getJuegoOlimpico().getYear();

                                    if (tempYear > maxYear) maxYear = tempYear;
                                    if (tempYear < minYear) minYear = tempYear;

                                }
                                try {
                                    Repositorio.atletas1.get(i).setDebutGames(minYear);
                                    Repositorio.atletas1.get(i).setRetirementGames(maxYear);
                                    totalMedals.add(totalMedallas, Repositorio.atletas1.get(i));
                                } catch (KeyNotFoundException e) {
                                    e.printStackTrace();
                                }
                                totalMedallas = 0;

                            }
                        }

                        for (int i = 0; i < 10; i++) {

                            int cantMedals = totalMedals.getRoot();

                            atleta = totalMedals.removeRoot();

                            System.out.println(i + 1 + "  -  " + atleta.getName() + "  -  " + atleta.getSex() +
                                    "  -  " + cantMedals + " medallas entre " + atleta.getDebutGames() + " - " + atleta.getRetirementGames());

                        }

                        break;

                    case 2:

                        state = true;

                        Heap<Integer, Athlete> goldMedals = new Heap<>(140000, false);

                        int allGoldMedals = 0;

                        for (long i = 1; i < Repositorio.participations.getSize(); i++) {

                            minYear = 2500;
                            maxYear = 0;

                            if (Repositorio.participations.getTodos(i) != null) {

                                for (HashNode<Long, AthleteOlympicParticipation> part : Repositorio.participations.getTodos(i)) {

                                    if (part.getData().getMedalType().equals(MedalType.GOLD)) allGoldMedals++;

                                    tempYear = part.getData().getJuegoOlimpico().getYear();

                                    if (tempYear > maxYear) maxYear = tempYear;
                                    if (tempYear < minYear) minYear = tempYear;

                                }

                                try {
                                    Repositorio.atletas1.get(i).setDebutGames(minYear);
                                    Repositorio.atletas1.get(i).setRetirementGames(maxYear);
                                    goldMedals.add(allGoldMedals, Repositorio.atletas1.get(i));
                                } catch (KeyNotFoundException e) {
                                    e.printStackTrace();
                                }
                                allGoldMedals = 0;
                            }
                        }
                        for (int i = 0; i < 10; i++) {

                            int cantMedals = goldMedals.getRoot();

                            atleta = goldMedals.removeRoot();

                            System.out.println(i + 1 + "  -  " + atleta.getName() + "  -  " + atleta.getSex() + "   -   " +
                                    cantMedals + " medallas de oro entre " + atleta.getDebutGames() + " - " + atleta.getRetirementGames());

                        }

                        break;

                    case 3:

                        state = true;

                        Heap<Integer, Athlete> silverMedals = new Heap<>(140000, false);

                        int allSilverMedals = 0;

                        for (long i = 1; i < Repositorio.participations.getSize(); i++) {

                            maxYear = 0;
                            minYear = 2500;

                            if (Repositorio.participations.getTodos(i) != null) {

                                for (HashNode<Long, AthleteOlympicParticipation> part : Repositorio.participations.getTodos(i)) {

                                    if (part.getData().getMedalType().equals(MedalType.SILVER)) allSilverMedals++;

                                    tempYear = part.getData().getJuegoOlimpico().getYear();

                                    if (tempYear > maxYear) maxYear = tempYear;
                                    if (tempYear < minYear) minYear = tempYear;

                                }
                                try {
                                    Repositorio.atletas1.get(i).setDebutGames(minYear);
                                    Repositorio.atletas1.get(i).setRetirementGames(maxYear);
                                    silverMedals.add(allSilverMedals, Repositorio.atletas1.get(i));
                                } catch (KeyNotFoundException e) {
                                    e.printStackTrace();
                                }
                                allSilverMedals = 0;
                            }

                        }
                        for (int i = 0; i < 10; i++) {

                            int cantMedals = silverMedals.getRoot();

                            atleta = silverMedals.removeRoot();

                            System.out.println(i + 1 + "  -  " + atleta.getName() + "  -  " + atleta.getSex() + "   -   " +
                                    cantMedals + " medallas de plata entre " + atleta.getDebutGames() + " - " + atleta.getRetirementGames());

                        }

                        break;

                    case 4:

                        state = true;

                        Heap<Integer, Athlete> bronzeMedals = new Heap<>(140000, false);

                        int allBronzeMedals = 0;

                        for (long i = 1; i < Repositorio.participations.getSize(); i++) {

                            minYear = 2500;
                            maxYear = 0;

                            if (Repositorio.participations.getTodos(i) != null) {

                                for (HashNode<Long, AthleteOlympicParticipation> part : Repositorio.participations.getTodos(i)) {

                                    if (part.getData().getMedalType().equals(MedalType.BRONZE)) allBronzeMedals++;

                                    tempYear = part.getData().getJuegoOlimpico().getYear();

                                    if (tempYear > maxYear) maxYear = tempYear;
                                    if (tempYear < minYear) minYear = tempYear;

                                }

                                try {
                                    Repositorio.atletas1.get(i).setDebutGames(minYear);
                                    Repositorio.atletas1.get(i).setRetirementGames(maxYear);
                                    bronzeMedals.add(allBronzeMedals, Repositorio.atletas1.get(i));
                                } catch (KeyNotFoundException e) {
                                    e.printStackTrace();
                                }
                                allBronzeMedals = 0;
                            }
                        }
                        for (int i = 0; i < 10; i++) {

                            int cantMedals = bronzeMedals.getRoot();

                            atleta = bronzeMedals.removeRoot();

                            System.out.println(i + 1 + "  -  " + atleta.getName() + " - " + atleta.getSex() + "   -   " +
                                    cantMedals + " medallas de bronce entre " + atleta.getDebutGames() + " - " + atleta.getRetirementGames());

                        }

                        break;
                    default:

                        System.out.println("Opcion no valida.");

                        break;
                }
            } catch (NumberFormatException | InputMismatchException e) {
                state = false;
                System.out.println("Opcion invalida, seleccione una opcion correcta.");
                sc.nextLine();
            }
        } while (!state);
    }

    public static void Two() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione una opcion:\n"
                + "     1- Medallas totales\n"
                + "     2- Medallas de oro\n"
                + "     3- Medallas de plata\n"
                + "     4- Medallas de bronce\n");

        boolean state = true;

        NationalOlympicCommitte noc;

        String yearSportMedal;

        ArrayList<String> yearAndSportAndMedal = new ArrayList<>();

        do {
            try {

                switch (sc.nextInt()) {

                    case 1:

                        state = true;

                        Heap<Integer, NationalOlympicCommitte> totalMedals = new Heap<>(500, false);

                        int totalMedallas = 0;

                        for (int i = 0; i < Repositorio.participationsXregion.getSize(); i++) {

                            if (Repositorio.participationsXregion.getTodos(i) != null) {
                                for (HashNode<Integer, AthleteOlympicParticipation> part : Repositorio.participationsXregion.getTodos(i)) {

                                    yearSportMedal = part.getData().getJuegoOlimpico().getYear() +
                                            part.getData().getEvento().getName() +
                                            part.getData().getMedalType();

                                    if (yearAndSportAndMedal.isEmpty() || !yearAndSportAndMedal.contains(yearSportMedal)) {

                                        yearAndSportAndMedal.add(yearSportMedal);

                                        if (!part.getData().getMedalType().equals(MedalType.NA)) totalMedallas++;

                                    }
                                }

                                try {
                                    totalMedals.add(totalMedallas, Repositorio.regions.get(i));
                                } catch (KeyNotFoundException e) {
                                    e.printStackTrace();
                                }

                                totalMedallas = 0;
                                yearAndSportAndMedal.clear();

                            }
                        }

                        for (int i = 0; i < 10; i++) {

                            int cantMedals = totalMedals.getRoot();

                            noc = totalMedals.removeRoot();

                            System.out.println(i + 1 + "  -  " + noc.getRegion() + "  -  " + cantMedals + " medallas.");

                        }

                        break;

                    case 2:

                        state = true;

                        Heap<Integer, NationalOlympicCommitte> goldMedals = new Heap<>(500, false);

                        int medallasOro = 0;

                        for (int i = 0; i < Repositorio.participationsXregion.getSize(); i++) {

                            if (Repositorio.participationsXregion.getTodos(i) != null) {
                                for (HashNode<Integer, AthleteOlympicParticipation> part : Repositorio.participationsXregion.getTodos(i)) {

                                    yearSportMedal = part.getData().getJuegoOlimpico().getYear() +
                                            part.getData().getEvento().getName() +
                                            part.getData().getMedalType();

                                    if (yearAndSportAndMedal.isEmpty() || !yearAndSportAndMedal.contains(yearSportMedal)) {

                                        yearAndSportAndMedal.add(yearSportMedal);

                                        if (part.getData().getMedalType().equals(MedalType.GOLD)) medallasOro++;

                                    }
                                }

                                try {
                                    goldMedals.add(medallasOro, Repositorio.regions.get(i));
                                } catch (KeyNotFoundException e) {
                                    e.printStackTrace();
                                }

                                medallasOro = 0;
                                yearAndSportAndMedal.clear();

                            }
                        }

                        for (int i = 0; i < 10; i++) {

                            int cantMedals = goldMedals.getRoot();

                            noc = goldMedals.removeRoot();

                            System.out.println(i + 1 + "  -  " + noc.getRegion() + "  -  " + cantMedals + " medallas de oro.");

                        }

                        break;

                    case 3:

                        state = true;

                        Heap<Integer, NationalOlympicCommitte> silverMedals = new Heap<>(500, false);

                        int medallasPlata = 0;

                        for (int i = 0; i < Repositorio.participationsXregion.getSize(); i++) {

                            if (Repositorio.participationsXregion.getTodos(i) != null) {
                                for (HashNode<Integer, AthleteOlympicParticipation> part : Repositorio.participationsXregion.getTodos(i)) {

                                    yearSportMedal = part.getData().getJuegoOlimpico().getYear() +
                                            part.getData().getEvento().getName() +
                                            part.getData().getMedalType();

                                    if (yearAndSportAndMedal.isEmpty() || !yearAndSportAndMedal.contains(yearSportMedal)) {

                                        yearAndSportAndMedal.add(yearSportMedal);

                                        if (part.getData().getMedalType().equals(MedalType.SILVER)) medallasPlata++;

                                    }
                                }

                                try {
                                    silverMedals.add(medallasPlata, Repositorio.regions.get(i));
                                } catch (KeyNotFoundException e) {
                                    e.printStackTrace();
                                }

                                medallasPlata = 0;
                                yearAndSportAndMedal.clear();

                            }
                        }

                        for (int i = 0; i < 10; i++) {

                            int cantMedals = silverMedals.getRoot();

                            noc = silverMedals.removeRoot();

                            System.out.println(i + 1 + "  -  " + noc.getRegion() + "  -  " + cantMedals + " medallas de plata.");

                        }

                        break;

                    case 4:

                        state = true;

                        Heap<Integer, NationalOlympicCommitte> bronzeMedals = new Heap<>(500, false);

                        int medallasBronce = 0;

                        for (int i = 0; i < Repositorio.participationsXregion.getSize(); i++) {

                            if (Repositorio.participationsXregion.getTodos(i) != null) {
                                for (HashNode<Integer, AthleteOlympicParticipation> part : Repositorio.participationsXregion.getTodos(i)) {

                                    yearSportMedal = part.getData().getJuegoOlimpico().getYear() +
                                            part.getData().getEvento().getName() +
                                            part.getData().getMedalType();

                                    if (yearAndSportAndMedal.isEmpty() || !yearAndSportAndMedal.contains(yearSportMedal)) {

                                        yearAndSportAndMedal.add(yearSportMedal);

                                        if (part.getData().getMedalType().equals(MedalType.BRONZE)) medallasBronce++;

                                    }
                                }

                                try {
                                    bronzeMedals.add(medallasBronce, Repositorio.regions.get(i));
                                } catch (KeyNotFoundException e) {
                                    e.printStackTrace();
                                }

                                medallasBronce = 0;
                                yearAndSportAndMedal.clear();

                            }
                        }

                        for (int i = 0; i < 10; i++) {

                            int cantMedals = bronzeMedals.getRoot();

                            noc = bronzeMedals.removeRoot();

                            System.out.println(i + 1 + "  -  " + noc.getRegion() + "  -  " + cantMedals + " medallas de bronce.");

                        }

                        break;
                    default:

                        System.out.println("Opcion no valida.");

                        break;
                }
            } catch (NumberFormatException | InputMismatchException e) {
                state = false;
                System.out.println("Opcion invalida, seleccione una opcion correcta.");
                sc.nextLine();
            }
        } while (!state);
    }

    public static void Three() {

        OpenHash<String, OlympicGame> jjoo = new OpenHash<>(100000000, 100000000);
        Heap<Integer, OlympicGame> jjooh = new Heap<>(1000000, false);
        ArrayList<String> yaParticipo = new ArrayList<>(10000);

        for (int i = 0; i < Repositorio.participations.getHash().length; i++)

            if (Repositorio.participations.getHash()[i] != null) {


                for (int j = 0; j < Repositorio.participations.getHash()[i].size(); j++) {

                    if (Repositorio.participations.getHash()[i].get(j).getData().getAtleta().getSex().equals(SexType.FEMALE) && !yaParticipo.contains(Repositorio.participations.getHash()[i].get(j).getData().getJuegoOlimpico().getName())) {

                        jjoo.put(Repositorio.participations.getHash()[i].get(j).getData().getJuegoOlimpico().getName(), Repositorio.participations.getHash()[i].get(j).getData().getJuegoOlimpico());

                        yaParticipo.add(Repositorio.participations.getHash()[i].get(j).getData().getJuegoOlimpico().getName());

                    }
                }
            }

        for (int k = 0; k < jjoo.getHash().length; k++) {

            int participantes = 0;

            if (jjoo.getHash()[k] != null) {

                participantes = 0;

                for (int j = 0; j < jjoo.getHash()[k].size(); j++) {

                    if (jjoo.getHash()[k].get(j) != null) {

                        participantes++;

                    }

                }

                jjooh.add(participantes, jjoo.getHash()[k].get(0).getData());

            }

            yaParticipo.clear();

        }

        for (int i = 0; i < 10; i++) {

            int cantParticipantesF = jjooh.getRoot();

            OlympicGame jjootemp = jjooh.removeRoot();

            System.out.println(i + 1 + "  -  " + jjootemp.getName() + "   -   " + jjootemp.getYear() + "   -   " + cantParticipantesF + " participantes Femeninos.");

        }
    }

    public static void Four() {

        System.out.println("Seleccione el sexo:" +
                "\n 1 - Femenino" +
                "\n 2 -  Masculino");

        Scanner sc = new Scanner(System.in);

        SexType A = null;

        boolean tempBool = false;

        boolean state = true;

        do {

            try {

                switch (sc.nextInt()) {
                    case 1:
                        A = SexType.FEMALE;
                        tempBool = true;
                        state = true;
                        break;
                    case 2:
                        A = SexType.MALE;
                        tempBool = true;
                        state = true;
                        break;
                    default:
                        state = false;
                        System.out.println("Opcion invalida.\n");
                        break;
                }
            } catch (InputMismatchException | NumberFormatException e) {
                state = false;
                System.out.println("Opcion invalida");
                sc.nextLine();
            }
        } while (!state);

        if (tempBool) {

            Heap<Integer, Event> competicionHeap = new Heap<>(100000, false);
            OpenHash<String, Event> competicion = new OpenHash<>(100000, 100000);

            for (int i = 0; i < Repositorio.participations.getHash().length; i++) {

                ArrayList<String> listaRepetidos = new ArrayList<String>(100000);

                if (Repositorio.participations.getHash()[i] != null) {

                    for (HashNode<Long, AthleteOlympicParticipation> part : Repositorio.participations.getHash()[i]) {

                        if (part.getData().getAtleta().getSex().equals(A) &&
                                !listaRepetidos.contains(part.getData().getEvento().getName())) {

                            competicion.put(part.getData().getEvento().getName(), part.getData().getEvento());

                            listaRepetidos.add(part.getData().getEvento().getName());

                        }
                    }
                }
            }

            for (int k = 0; k < competicion.getHash().length; k++) {

                int jugadores = 0;

                if (competicion.getHash()[k] != null) {

                    jugadores = 0;

                    for (int j = 0; j < competicion.getHash()[k].size(); j++) {

                        if (competicion.getHash()[k].get(j) != null) {

                            jugadores++;

                        }
                    }

                    competicionHeap.add(jugadores, competicion.getHash()[k].get(0).getData());

                }
            }

            int cantParticipantesF;

            Event competicion1;

            for (int i = 0; i < 5; i++) {

                cantParticipantesF = competicionHeap.getRoot();

                competicion1 = competicionHeap.removeRoot();

                System.out.println(i + 1 + "  -  " + competicion1.getName() + "   -   " + competicion1.getDeporte().getName() + "   -   " + A + "   -   " + cantParticipantesF + " participantes .");

            }
        }
    }

    public static void Five() {

        Scanner sc = new Scanner(System.in);

        boolean state1, state2, state3;

        int anoMin = 0, anoMax = 0;

        do {
            do {
                try {

                    System.out.print("Indique el año inicial: \n");

                    anoMin = sc.nextInt();

                    state1 = true;

                } catch (InputMismatchException | NumberFormatException e) {
                    state1 = false;
                    sc.nextLine();
                    System.out.println("Ingrese un ano.\n");
                }
            } while (!state1);

            do {
                try {

                    System.out.print("Indique el año final: \n");

                    anoMax = sc.nextInt();

                    state2 = true;

                } catch (InputMismatchException | NumberFormatException e) {
                    state2 = false;
                    sc.nextLine();
                    System.out.println("Ingrese un ano.");
                }
            } while (!state2);


            if (anoMin < 1896) {

                System.out.println("El primer juego olimpico fue un 1896. Ingrese un ano valido.\n");

                state3 = false;

            }else if (anoMax > 2019) {

                System.out.println("No se puede predecir el futuro.\n");

                state3 = false;
            } else if (anoMin >= anoMax) {

                System.out.println("El ano inicial debe ser menor que ano final.\n");

                state3 = false;
            } else state3 = true;

        } while (!state3);

        OpenHash<String, Integer> datos = new OpenHash<>(140000, 140000);

        String nombre = null;

        Heap<Float, String[]> equiposOrdenados = new Heap<Float, String[]>(10000, false);

        int count = 0;

        int medallas = 0;

        for (int i = 0; i < Repositorio.participations.getHash().length; i++) {

            if (Repositorio.participations.getHash()[i] != null) {

                for (HashNode<Long, AthleteOlympicParticipation> part : Repositorio.participations.getHash()[i]) {

                    if (part.getData().getJuegoOlimpico().getYear() <= anoMax && part.getData().getJuegoOlimpico().getYear() >= anoMin) {

                        if (!part.getData().getMedalType().equals(MedalType.NA)) {

                            datos.put(part.getData().getAtleta().getTeam().getNombre(), 1);

                        } else {

                            datos.put(part.getData().getAtleta().getTeam().getNombre(), 0);

                        }
                    }
                }
            }
        }

        for (int j = 0; j < datos.getHash().length; j++) {

            if (datos.getHash()[j] != null) {

                for (HashNode<String, Integer> nodoTemp : datos.getHash()[j]) {

                    count++;

                    medallas = medallas + nodoTemp.getData();

                    nombre = nodoTemp.getKey();

                }
            }

            if (nombre != null && count != 0) {

                String[] a = {"" + nombre, medallas + "", count + ""};

                equiposOrdenados.add((float) (medallas / count), a);

            }

            medallas = 0;

            count = 0;

        }

        for (int c = 0; c < 5; c++) {

            String[] tempArrayString = equiposOrdenados.removeRoot();

            System.out.println(c + 1 + " - " + tempArrayString[0] + " con " + tempArrayString[1] +
                    " medalla/s respartidas entre " + tempArrayString[1] + " atleta/s");
        }
    }
}
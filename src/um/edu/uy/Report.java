package um.edu.uy;

import um.edu.uy.Tads.Hash.HashNode;
import um.edu.uy.Tads.Hash.OpenHash;
import um.edu.uy.Tads.HeapJope.Heap;
import um.edu.uy.Tads.KeyNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
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

        int minYear, maxYear, tempYear;

        switch (sc.nextInt()) {

            case 1:

                Heap<Integer, Athlete> totalMedals = new Heap<>(140000, false);

                int totalMedallas = 0;

                for (long i = 1; i < Repositorio.participations.getSize(); i++) {

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

                Heap<Integer, Athlete> goldMedals = new Heap<>(140000, false);

                int allGoldMedals = 0;

                for (long i = 1; i < Repositorio.participations.getSize(); i++) {

                    minYear = 2500;
                    maxYear = 0;

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

                for (int i = 0; i < 10; i++) {

                    int cantMedals = goldMedals.getRoot();

                    atleta = goldMedals.removeRoot();

                    System.out.println(i + 1 + "  -  " + atleta.getName() + "  -  " + atleta.getSex() + "   -   " +
                            cantMedals + " medallas de oro entre " + atleta.getDebutGames() + " - " + atleta.getRetirementGames());

                }

                break;

            case 3:

                Heap<Integer, Athlete> silverMedals = new Heap<>(140000, false);

                int allSilverMedals = 0;

                for (long i = 1; i < Repositorio.participations.getSize(); i++) {

                    maxYear = 0;
                    minYear = 2500;

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

                for (int i = 0; i < 10; i++) {

                    int cantMedals = silverMedals.getRoot();

                    atleta = silverMedals.removeRoot();

                    System.out.println(i + 1 + "  -  " + atleta.getName() + "  -  " + atleta.getSex() + "   -   " +
                            cantMedals + " medallas de plata entre " + atleta.getDebutGames() + " - " + atleta.getRetirementGames());

                }

                break;

            case 4:

                Heap<Integer, Athlete> bronzeMedals = new Heap<>(140000, false);

                int allBronzeMedals = 0;

                for (long i = 1; i < Repositorio.participations.getSize(); i++) {

                    minYear = 2500;
                    maxYear = 0;

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

                for (int i = 0; i < 10; i++) {

                    int cantMedals = bronzeMedals.getRoot();

                    atleta = bronzeMedals.removeRoot();

                    System.out.println(i + 1 + "  -  " + atleta.getName() + " - " + atleta.getSex() + "   -   " +
                            cantMedals + " medallas de bronce entre " + atleta.getDebutGames() + " - " + atleta.getRetirementGames());

                }

                break;
        }
    }

    public static void Two() {

        Scanner sc = new Scanner(System.in);

        String noc;

        System.out.println("Seleccione una opcion:\n"
                + "     1- Medallas totales\n"
                + "     2- Medallas de oro\n"
                + "     3- Medallas de plata\n"
                + "     4- Medallas de bronce\n");

        switch (sc.nextInt()) {

            case 1:

                Heap<Integer, String> regionsMedals = new Heap<>(300, false);

                int totalMedallas = 0;


                for (int i = 0; i < 10; i++) {

                    int cantMedals = regionsMedals.getRoot();

                    noc = regionsMedals.removeRoot();

                    System.out.println(i + 1 + "  -  " + noc + "  -  " + cantMedals + " medallas. ");
                }

                break;

            case 2:
                /*if (!medallasOroNC) {
                    int cantMedallas = 0;
                    for (int i = 0; i < hashNC.length; i++) {
                        for (int j = 0; i < hashNC[i].size(); i++)// menor o menor igual?
                            if (hashNC[i].get(j).getData().getMedallas()[1] != 0) {
                                cantMedallas = cantMedallas + hashNC[i].get(j).getData().getMedallas()[1];

                            }
                        Repositorio.medalBronceNOC.add(cantMedallas, hashNC[i].get(0).getKey());
                    }

                    medallasOroNC = true;
                }
                Nodo<String, Integer>[] listaNOCOro = Repositorio.medalGoldNOC.getHeap();// completar
                printTop10Noc(listaNOCOro, 1);
*/
                break;
            case 3:
  /*              if (!medallasPlataNC) {
                    int cantMedallas = 0;
                    for (int i = 0; i < hashNC.length; i++) {
                        for (int j = 0; i < hashNC[i].size(); i++)// menor o menor igual?
                            if (hashNC[i].get(j).getData().getMedallas()[2] != 0) {
                                cantMedallas = cantMedallas + hashNC[i].get(j).getData().getMedallas()[2];

                            }
                        Repositorio.medalBronceNOC.add(cantMedallas, hashNC[i].get(0).getKey());
                    }

                    medallasPlataNC = true;
                }
                Nodo<String, Integer>[] listaNOCPlata = Repositorio.medalSilverNOC.getHeap();// completar
                printTop10Noc(listaNOCPlata, 2);
*/
                break;
            case 4:
 /*               if (!medallasBronceNC) {
                    int cantMedallas = 0;
                    for (int i = 0; i < hashNC.length; i++) {
                        for (int j = 0; i < hashNC[i].size(); i++)// menor o menor igual?
                            if (hashNC[i].get(j).getData().getMedallas()[3] != 0) {
                                cantMedallas = cantMedallas + hashNC[i].get(j).getData().getMedallas()[3];

                            }
                        Repositorio.medalBronceNOC.add(cantMedallas, hashNC[i].get(0).getKey());
                    }

                    medallasBronceNC = true;
                }

                Nodo<String, Integer>[] listaNOCBronce = Repositorio.medalBronceNOC.getHeap();// completar
               printTop10Noc(listaNOCBronce, 3);
   */
                break;
            default:

                System.out.println("Opcion no valida.");
                break;
        }

    }

    public static void Three() {
        OpenHash<String, OlympicGame> jjoo = new OpenHash<String, OlympicGame>(100000, 100000);
        Heap<Integer, OlympicGame> jjooh = new Heap<Integer, OlympicGame>(1000, false);

        for (int i = 0; i < Repositorio.participations.getHash().length; i++)
            if (Repositorio.participations.getHash()[i] != null) {
                ArrayList<String> yaParticipo = new ArrayList<String>(10000);
                for (int j = 0; j < Repositorio.participations.getHash()[i].size(); j++) {
                    if (Repositorio.participations.getHash()[i].get(j).getData().getAtleta().getSex().equals(SexType.FEMALE) && !yaParticipo.contains(Repositorio.participations.getHash()[i].get(j).getData().getJuegoOlimpico().getName())) {
                        jjoo.put(Repositorio.participations.getHash()[i].get(j).getData().getJuegoOlimpico().getName(), Repositorio.participations.getHash()[i].get(j).getData().getJuegoOlimpico());
                        yaParticipo.add(Repositorio.participations.getHash()[i].get(j).getData().getJuegoOlimpico().getName());
                    }
                }
            }
        for (int k = 0; k < jjoo.getHash().length; k++) {
            if (jjoo.getHash()[k] != null) {
                int participantes = 0;
                for (int j = 0; j < jjoo.getHash()[k].size(); j++) {
                    if (jjoo.getHash()[k].get(j) != null) {
                        participantes++;
                    }
                }
                jjooh.add(participantes, jjoo.getHash()[k].get(0).getData());

            }
        }

        for (int i = 0; i < 10; i++) {

            int cantParticipantesF = jjooh.getRoot();

            OlympicGame jjootemp = jjooh.removeRoot();

            System.out.println(i + 1 + "  -  " + jjootemp.getName() + "   -   " + jjootemp.getYear() + "   -   " + cantParticipantesF + " participantes Femeninos.");

        }

    }

    public static void Four() {

        System.out.println("Seleccione el sexo:" +
                "\n 1: femenino" +
                "\n 2: masculino");

        Scanner sc = new Scanner(System.in);
        SexType A = null;
        boolean tempBool = false;
        switch (sc.nextInt()) {
            case 1:
                A = SexType.FEMALE;
                tempBool = true;
                break;
            case 2:
                A = SexType.MALE;
                tempBool = true;
                break;
            default:
                tempBool = false;
                break;
        }

        if (tempBool) {


            Heap<Integer, Event> competicionHeap = new Heap<Integer, Event>(10000, false);
            OpenHash<String, Event> competicion = new OpenHash<String, Event>(10000, 10000);
            for (int i = 0; i < Repositorio.participations.getHash().length; i++) {
                if (Repositorio.participations.getHash()[i] != null) {
                    ArrayList<String> listaRepetidos = new ArrayList<String>(10000);
                    for (HashNode<Long, AthleteOlympicParticipation> part : Repositorio.participations.getHash()[i]) {
                        if (part.getData().getAtleta().getSex().equals(A) && !listaRepetidos.contains(part.getData().getEvento().getName())) {
                            competicion.put(part.getData().getEvento().getName(), part.getData().getEvento());
                            listaRepetidos.add(part.getData().getEvento().getName());

                        }
                    }

                }
            }
            for (int k = 0; k < competicion.getHash().length; k++) {
                if (competicion.getHash()[k] != null) {
                    int jugadores = 0;
                    for (int j = 0; j < competicion.getHash()[k].size(); j++) {
                        if (competicion.getHash()[k].get(j) != null) {
                            jugadores++;
                        }
                    }
                    competicionHeap.add(jugadores, competicion.getHash()[k].get(0).getData());

                }
            }

            for (int i = 0; i < 5; i++) {

                int cantParticipantesF = competicionHeap.getRoot();

                Event compteicion = competicionHeap.removeRoot();

                System.out.println(i + 1 + "  -  " + compteicion.getName() + "   -   " + compteicion.getDeporte().getName() + "   -   " + A + "   -   " + cantParticipantesF + " participantes .");

            }
        }
    }

    public static void Five() {

    }
}



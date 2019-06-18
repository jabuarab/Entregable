package um.edu.uy;

import um.edu.uy.Tads.Hash.HashNode;
import um.edu.uy.Tads.Hash.OpenHash;
import um.edu.uy.Tads.Heap.Nodo;
import um.edu.uy.Tads.HeapJope.Heap;
import um.edu.uy.Tads.HeapJope.HeapNodo;
import um.edu.uy.Tads.KeyNotFoundException;
import um.edu.uy.Tads.QueueJope.ListaQueue;

import java.time.Year;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Report {

    public static void One() {

        Formatter fmt = new Formatter();

        Scanner sc = new Scanner(System.in);

        ArrayList<HashNode<String, Athlete>>[] hashA = Repositorio.atletas.getHash();

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

                for (int i = 0; i < 10; i++) {

                    int cantMedals = totalMedals.getRoot();

                    atleta = totalMedals.removeRoot();

                    System.out.println(i + 1 + "  -  " + atleta.getName() + "  -  " +  atleta.getSex() +
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

   /* public static void Two() {
        ArrayList<HashNode<String, NationalOlympicCommitte>>[] hashNC = Repositorio.regions.getHash();
        System.out.println("Seleccione una opcion: \n"
                + " 1- Medallas totales\n"
                + " 2- Medallas de oro \n"
                + " 3- Medallas de plata \n"
                + " 4- Medallas de bronce\n");
        switch (sc.nextInt()) {
            case 1:
                if (!medallasTotalesNC) {
                    int cantMedallas = 0;
                    for (int i = 0; i < hashNC.length; i++) {
                        for (int j = 0; i < hashNC[i].size(); i++)// menor o menor igual?
                            if (hashNC[i].get(j).getData().getMedallas()[0] != 0) {
                                cantMedallas = cantMedallas + hashNC[i].get(j).getData().getMedallas()[0];

                            }
                        Repositorio.medalBronceNOC.add(cantMedallas, hashNC[i].get(0).getKey());
                    }
                    medallasTotalesNC = true;
                }
                Nodo<String, Integer>[] listaNOCTotal = Repositorio.medalTotalNOC.getHeap();// completar
                printTop10Noc(listaNOCTotal, 0);

                break;
            case 2:
                if (!medallasOroNC) {
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

                break;
            case 3:
                if (!medallasPlataNC) {
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

                break;
            case 4:
                if (!medallasBronceNC) {
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
                break;
            default:

                System.out.println("Opcion no valida.");
                break;
        }


    }

    public static void Three() {
        if (!atletasFemeninas) {
            SexType sexTemp = SexType.FEMALE;
            int juegoolimpico = -1;

            ArrayList<HashNode<Integer, AthleteOlympicParticipation>>[] participaciones = Repositorio.participations.getHash();
            for (int i = 0; i < participaciones.length; i++) {
                int count = 0;

                for (int j = 0; j < participaciones[i].size(); j++) {
                    if (participaciones[i].get(j).getData().getAtleta().getSex().equals(sexTemp)) {
                        count = count + 1;
                    }
                    Repositorio.olimpicGamesOrdenado.add(count, participaciones[i].get(j).getData().getJuegoOlimpico());
                }


            }
            atletasFemeninas = true;
        }
        for (int j = 0; j < Repositorio.olimpicGamesOrdenado.getHeap().length; j++) {
            System.out.println("-Nombre:" + Repositorio.olimpicGamesOrdenado.getHeap()[j].getValue().getName());
            System.out.print("-Anio:" + Repositorio.olimpicGamesOrdenado.getHeap()[j].getValue().getYear());
            System.out.print("Cantdida de atletas femeninos:" + Repositorio.olimpicGamesOrdenado.getHeap()[j].getKey());
        }
        Nodo<OlympicGame, Integer>[] a = Repositorio.olimpicGamesOrdenado.getHeap();

    }

    public static void Four() {

    }

    public static void Five() throws KeyNotFoundException {
        System.out.println("Indique el año inicial");
        int añoMin = sc.nextInt();
        if (añoMin < 1896) {
            añoMin = 1896;
        }
        System.out.println("Indique el año final");
        int añoMax = sc.nextInt();
        int year = Year.now().getValue();
        if (añoMax < year) {
            añoMax = year;
        }
        OpenHash<String, Team> equiposTempHash = Repositorio.teams;
        for (int i = añoMin; i <= añoMax; i++) {
            NationalOlympicCommitte noc = Repositorio.participations.get(i).getAtleta().getNoc();
            Team equipo = Repositorio.participations.get(i).getAtleta().getTeam();

            long id = Repositorio.participations.get(i).getAtleta().getId();

            for (int j = 0; j < Repositorio.atletas.getTodos(noc.getName()).size(); j++) {
                if (Repositorio.atletas.getTodos(noc.getName()).get(j).getData().getId() == id) {
                    int[] a = equiposTempHash.get(equipo.getNombre()).medallas;
                    int[] b = Repositorio.atletas.getTodos(noc.getName()).get(j).getData().getMedallas();
                    equiposTempHash.get(equipo.getNombre()).medallas[0] = a[0] + b[0];
                    equiposTempHash.get(equipo.getNombre()).medallas[1] = a[1] + b[1];
                    equiposTempHash.get(equipo.getNombre()).medallas[2] = a[2] + b[2];
                    equiposTempHash.get(equipo.getNombre()).medallas[3] = a[3] + b[3];
                    equiposTempHash.get(equipo.getNombre()).atletas.add(Repositorio.atletas.getTodos(noc.getName()).get(j).getData());
                }
            }

        }

        Heap<Integer, Team> equiposOrdenados = new Heap<Integer, Team>(10, false);
        for (int i = 0; i < equiposTempHash.getHash().length; i++) {
            int cantidadMedallas = equiposTempHash.getHash()[i].get(0).getData().medallas[0];
            int cantidadAtletas = equiposTempHash.getHash()[i].get(0).getData().atletas.size();
            if (cantidadMedallas != 0) {
                equiposOrdenados.add(cantidadAtletas / cantidadMedallas, equiposTempHash.getHash()[i].get(0).getData());
            }
        }
        for (int i = 0; i < 16; i++) { //top 15
            Team equipotemp = equiposOrdenados.getHeap()[i].getData();


            System.out.println("-Equipo:" + equipotemp.getNombre());

            System.out.print("-Cantidad de medallas:" + equipotemp.medallas[0]);

            System.out.print("-Cantidad de medallas:" + equipotemp.atletas.size());

        }


    }

}

    private static void printTop10Atletas(um.edu.uy.Tads.Heap.Heap<Athlete, Integer> atletas, int tipoMedalla) {
        int aniomax = 0;


        int aniomin = 0;

        ListaQueue<Athlete> atletasQuee = new ListaQueue<>();


        for (int i = 0; i < 10; i++) { //top 15
            try {

                Nodo<Athlete, Integer> tempAtleta1 = atletas.eliminar();
                atletasQuee.enqueue(tempAtleta1.getValue());
                ArrayList<HashNode<Integer, AthleteOlympicParticipation>> participacionAtleta = Repositorio.participations.getHash()[(int) tempAtleta1.getValue().getId()];
                for (int j = 0; j < participacionAtleta.size(); j++) {
                    int anio = participacionAtleta.get(j).getData().getJuegoOlimpico().getYear();
                    if (anio < aniomin || aniomin == 0) {
                        aniomin = anio;
                    }
                    if (aniomax < anio) {
                        aniomax = anio;
                    }
                    Athlete tempAtleta = atletasQuee.dequeue();
                    atletas.add(tempAtleta.getMedallas()[tipoMedalla], tempAtleta);

                    System.out.println("Nombre:" + tempAtleta.getName());
                    System.out.print("-Sexo:" + tempAtleta.getSex());
                    System.out.print("-Cantidad de medallas:" + tempAtleta.getMedallas()[tipoMedalla]);
                    System.out.print("-Anio minimo:" + aniomin);
                    System.out.print("-Anio maximo:" + aniomax);
                }
            } catch (uy.edu.um.prog2.exceptions.EmptyQueueException e) {
                e.printStackTrace();
            }
        }


    }


    private static void printTop10Noc(Nodo<String, Integer>[] NOCs, int tipoMedalla) {

        for (int i = 0; i < 16; i++) { //top 15
            String tempNOC = NOCs[i].getValue();
            System.out.println("Nombre:" + tempNOC);
            System.out.print("-Cantidad de medallas:" + NOCs[i].getValue());

        }


    }

//variables auxiliares

    private static boolean medallasTotalesA = false;

    private static boolean medallasTotalesNC = false;

    private static boolean medallasOroNC = false;

    private static boolean medallasOroA = false;

    private static boolean medallasPlataA = false;

    private static boolean medallasPlataNC = false;

    private static boolean medallasBronceNC = false;

    private static boolean medallasBronceA = false;

    private static boolean atletasFemeninas = false;

    public static Heap<Integer, Athlete> medalTotalAthlete = new Heap<>(135571, false);

    public static Heap<Integer, String> medalTotalNOC = new Heap<>(135571, false);

    public static Heap<Integer, Athlete> medalGoldAthlete = new Heap<>(135571, false);

    public static Heap<Integer, String> medalGoldNOC = new Heap<>(135571, false);

    public static Heap<Integer, Athlete> medalSilverAthlete = new Heap<>(135571, false);

    public static Heap<Integer, String> medalSilverNOC = new Heap<>(135571, false);

    public static Heap<Integer, Athlete> medalBronzeAthlete = new Heap<>(135571, false);

    public static Heap<Integer, String> medalBronceNOC = new Heap<>(135571, false);

    public static Heap<Integer, OlympicGame> olympicGamesOrdenado = new Heap<>(135571, false);*/
}





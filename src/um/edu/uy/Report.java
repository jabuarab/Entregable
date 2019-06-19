package um.edu.uy;

import um.edu.uy.Tads.Hash.HashNode;
import um.edu.uy.Tads.Hash.OpenHash;
import um.edu.uy.Tads.Heap.Nodo;
import um.edu.uy.Tads.HeapJope.Heap;
import um.edu.uy.Tads.HeapJope.HeapNodo;
import um.edu.uy.Tads.KeyNotFoundException;
import um.edu.uy.Tads.QueueJope.ListaQueue;

import java.lang.invoke.SwitchPoint;
import java.time.Year;
import java.util.ArrayList;
import java.util.Formatter;
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

        NationalOlympicCommitte noc;

        System.out.println("Seleccione una opcion:\n"
                + "     1- Medallas totales\n"
                + "     2- Medallas de oro\n"
                + "     3- Medallas de plata\n"
                + "     4- Medallas de bronce\n");

        Heap<Integer, String> regionsMedals = new Heap<>(150000, false);
        OpenHash<String, Integer> regionesHash = new OpenHash<>(150000, 150000);
        ArrayList<String> repetidos = new ArrayList<String>(150000);
        int totalMedallasJigador = 0;


        switch (sc.nextInt()) {


            case 1:


                for (int i = 0; i < Repositorio.participations.getHash().length; i++) {
                    if (Repositorio.participations.getHash()[i] != null) {
                        totalMedallasJigador = 0;
                        for (HashNode<Long, AthleteOlympicParticipation> part : Repositorio.participations.getHash()[i]) {
                            if (!part.getData().getMedalType().equals(MedalType.NA)) {
                                if (!repetidos.contains(part.getData().getEvento().getName() + part.getData().getJuegoOlimpico().getYear() + "" + part.getData().getAtleta().getTeam().getNombre())) {
                                    repetidos.add(part.getData().getEvento().getName() + part.getData().getJuegoOlimpico().getYear() + "" + part.getData().getAtleta().getTeam().getNombre());

                                    totalMedallasJigador++;
                                }
                            }
                        }
                        regionesHash.put(Repositorio.participations.getHash()[i].get(0).getData().getAtleta().getNoc().getRegion(), totalMedallasJigador);
                    }
                }
                for (int j = 0; j < regionesHash.getHash().length; j++) {
                    int medallasRegion = 0;
                    if (regionesHash.getHash()[j] != null) {
                        for (HashNode<String, Integer> nodoTemp : regionesHash.getHash()[j]) {
                            medallasRegion = medallasRegion + nodoTemp.getData();

                        }
                        regionsMedals.add(medallasRegion, regionesHash.getHash()[j].get(0).getKey());
                    }
                }


                for (int i = 0; i < 10; i++) {

                    int cantMedals = regionsMedals.getRoot();

                    String region = regionsMedals.removeRoot();

                    System.out.println(i + 1 + "  -  " + region + "  -  " + cantMedals + " medallas. ");
                }

                break;

            case 2:

                for (int i = 0; i < Repositorio.participations.getHash().length; i++) {
                    if (Repositorio.participations.getHash()[i] != null) {
                        totalMedallasJigador = 0;
                        for (HashNode<Long, AthleteOlympicParticipation> part : Repositorio.participations.getHash()[i]) {
                            if (part.getData().getMedalType().equals(MedalType.GOLD)) {
                                if (!repetidos.contains(part.getData().getEvento().getName() + part.getData().getJuegoOlimpico().getYear() + "" + part.getData().getAtleta().getTeam().getNombre())) {
                                    repetidos.add(part.getData().getEvento().getName() + part.getData().getJuegoOlimpico().getYear() + "" + part.getData().getAtleta().getTeam().getNombre());

                                    totalMedallasJigador++;
                                }
                            }
                        }
                        regionesHash.put(Repositorio.participations.getHash()[i].get(0).getData().getAtleta().getNoc().getRegion(), totalMedallasJigador);
                    }
                }
                for (int j = 0; j < regionesHash.getHash().length; j++) {
                    int medallasRegion = 0;
                    if (regionesHash.getHash()[j] != null) {
                        for (HashNode<String, Integer> nodoTemp : regionesHash.getHash()[j]) {
                            medallasRegion = medallasRegion + nodoTemp.getData();

                        }
                        regionsMedals.add(medallasRegion, regionesHash.getHash()[j].get(0).getKey());
                    }
                }


                for (int i = 0; i < 10; i++) {

                    int cantMedals = regionsMedals.getRoot();

                    String region = regionsMedals.removeRoot();

                    System.out.println(i + 1 + "  -  " + region + "  -  " + cantMedals + " medallas de oro");
                }
                break;
            case 3:
                for (int i = 0; i < Repositorio.participations.getHash().length; i++) {
                    if (Repositorio.participations.getHash()[i] != null) {
                        totalMedallasJigador = 0;
                        for (HashNode<Long, AthleteOlympicParticipation> part : Repositorio.participations.getHash()[i]) {
                            if (part.getData().getMedalType().equals(MedalType.SILVER)) {
                                if (!repetidos.contains(part.getData().getEvento().getName() + part.getData().getJuegoOlimpico().getYear() + "" + part.getData().getAtleta().getTeam().getNombre())) {
                                    repetidos.add(part.getData().getEvento().getName() + part.getData().getJuegoOlimpico().getYear() + "" + part.getData().getAtleta().getTeam().getNombre());

                                    totalMedallasJigador++;
                                }
                            }
                        }
                        regionesHash.put(Repositorio.participations.getHash()[i].get(0).getData().getAtleta().getNoc().getRegion(), totalMedallasJigador);
                    }
                }
                for (int j = 0; j < regionesHash.getHash().length; j++) {
                    int medallasRegion = 0;
                    if (regionesHash.getHash()[j] != null) {
                        for (HashNode<String, Integer> nodoTemp : regionesHash.getHash()[j]) {
                            medallasRegion = medallasRegion + nodoTemp.getData();

                        }
                        regionsMedals.add(medallasRegion, regionesHash.getHash()[j].get(0).getKey());
                    }
                }


                for (int i = 0; i < 10; i++) {

                    int cantMedals = regionsMedals.getRoot();

                    String region = regionsMedals.removeRoot();

                    System.out.println(i + 1 + "  -  " + region + "  -  " + cantMedals + " medallas de plata. ");
                }
                break;
            case 4:
                for (int i = 0; i < Repositorio.participations.getHash().length; i++) {
                    if (Repositorio.participations.getHash()[i] != null) {
                        totalMedallasJigador = 0;
                        for (HashNode<Long, AthleteOlympicParticipation> part : Repositorio.participations.getHash()[i]) {
                            if (part.getData().getMedalType().equals(MedalType.BRONZE)) {
                                if (!repetidos.contains(part.getData().getEvento().getName() + part.getData().getJuegoOlimpico().getYear() + "" + part.getData().getAtleta().getTeam().getNombre())) {
                                    repetidos.add(part.getData().getEvento().getName() + part.getData().getJuegoOlimpico().getYear() + "" + part.getData().getAtleta().getTeam().getNombre());

                                    totalMedallasJigador++;
                                }
                            }
                        }
                        regionesHash.put(Repositorio.participations.getHash()[i].get(0).getData().getAtleta().getNoc().getRegion(), totalMedallasJigador);
                    }
                }
                for (int j = 0; j < regionesHash.getHash().length; j++) {
                    int medallasRegion = 0;
                    if (regionesHash.getHash()[j] != null) {
                        for (HashNode<String, Integer> nodoTemp : regionesHash.getHash()[j]) {
                            medallasRegion = medallasRegion + nodoTemp.getData();

                        }
                        regionsMedals.add(medallasRegion, regionesHash.getHash()[j].get(0).getKey());
                    }
                }


                for (int i = 0; i < 10; i++) {

                    int cantMedals = regionsMedals.getRoot();

                    String region = regionsMedals.removeRoot();

                    System.out.println(i + 1 + "  -  " + region + "  -  " + cantMedals + " medallas de bronce. ");
                }
                break;
            default:

                System.out.println("Opcion no valida.");
                break;
        }

    }

    public static void Three() {
        OpenHash<String, OlympicGame> jjoo = new OpenHash<String, OlympicGame>(100000000, 100000000);
        Heap<Integer, OlympicGame> jjooh = new Heap<Integer, OlympicGame>(1000000, false);

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


            Heap<Integer, Event> competicionHeap = new Heap<Integer, Event>(100000, false);
            OpenHash<String, Event> competicion = new OpenHash<String, Event>(100000, 100000);
            for (int i = 0; i < Repositorio.participations.getHash().length; i++) {
                ArrayList<String> listaRepetidos = new ArrayList<String>(100000);
                if (Repositorio.participations.getHash()[i] != null) {
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
        OpenHash<String, Integer> equiposYMedallas = new OpenHash<String, Integer>(10000, 10000); // Con un array de integer podria saber que tipo de medalla osn
        Heap<Float, String[]> equiposOrdenados = new Heap<Float, String[]>(10000, false);
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique el año inicial");
        int añoMin = sc.nextInt();
        if (añoMin < 1896) {
            añoMin = 1895;
        }
        System.out.println("Indique el año final");
        int añoMax = sc.nextInt();
        int year = Year.now().getValue();
        if (añoMax > year) {
            añoMax = year;
        }
        ArrayList<String> equiposXAnio = new ArrayList<>();
        int largo = Repositorio.participations.getHash().length;
        for (int i = 0; i < largo; i++) {
            if (Repositorio.participations.getHash()[i] != null) {
                boolean booltemp = true;
                String data = null;
                String nombreEquipo = null;
                int cantidadDeMedallas = 0;
                for (HashNode<Long, AthleteOlympicParticipation> part : Repositorio.participations.getHash()[i]) {
                    if (part.getData().getJuegoOlimpico().getYear() <= añoMax && part.getData().getJuegoOlimpico().getYear() >= añoMin) {
                        data = "" + part.getData().getEvento().getName() + part.getData().getAtleta().getTeam().getNombre() + part.getData().getJuegoOlimpico().getYear();
                        if (!equiposXAnio.contains(data)) {
                            equiposXAnio.add(data);
                            if (!part.getData().getMedalType().equals(MedalType.NA)) {
                                cantidadDeMedallas++;
                            }

                        }

                    }
                    nombreEquipo = part.getData().getAtleta().getTeam().getNombre();
                }
                equiposYMedallas.put(nombreEquipo, cantidadDeMedallas);
            }
        }
        for (int i = 0; i < equiposYMedallas.getHash().length; i++) {
            int medallas = 0;
            int count = 0;
            String equipo = null;
            if (equiposYMedallas.getHash()[i] != null) {
                for (HashNode<String, Integer> nodoTemp : equiposYMedallas.getHash()[i]) {
                    count++;
                    medallas = medallas + nodoTemp.getData();
                    equipo = nodoTemp.getKey();
                }
                float relacion = medallas / count;
                String[] equipo1 = {equipo, medallas + "", count + ""};
                equiposOrdenados.add(relacion, equipo1);
            }
        }
        for (int c = 0; c < 10; c++) {
            String[] tempArrayString = equiposOrdenados.removeRoot();
            System.out.println(" Equipo : " + tempArrayString[0] + " - cantidadde competidores: " + tempArrayString[2] +
                    "Cantidad de medallas:" + tempArrayString[1]
                    + "-entre los años (" + añoMax + "-" + añoMin + ")");

        }


    }
}

    /*
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






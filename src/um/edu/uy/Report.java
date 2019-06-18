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

        switch (sc.nextInt()) {

            case 1:

                Heap<Integer, Athlete> totalMedals = new Heap<>(140000, false);

                int totalMedallas = 0;

                for (long i = 1; i < Repositorio.participations.getSize(); i++) {

                    for (HashNode<Long, AthleteOlympicParticipation> part : Repositorio.participations.getTodos(i)) {

                        if (!part.getData().getMedalType().equals(MedalType.NA)) totalMedallas++;
                    }

                    try {
                        totalMedals.add(totalMedallas, Repositorio.atletas1.get(i));
                    } catch (KeyNotFoundException e) {
                        e.printStackTrace();
                    }
                    totalMedallas = 0;
                }

                for (int i = 0; i < 10; i++) {

                    int cantMedals = totalMedals.getRoot();

                    atleta = totalMedals.removeRoot();

                    System.out.println(i + 1 + "  -  " + atleta.getName() + "   -   " + cantMedals + "medallas.");

                }

                break;

            case 2:

                Heap<Integer, Athlete> goldMedals = new Heap<>(140000, false);

                int allGoldMedals = 0;

                for (long i = 1; i < Repositorio.participations.getSize(); i++) {

                    for (HashNode<Long, AthleteOlympicParticipation> part : Repositorio.participations.getTodos(i)) {

                        if (part.getData().getMedalType().equals(MedalType.GOLD)) allGoldMedals++;

                    }

                    try {
                        goldMedals.add(allGoldMedals, Repositorio.atletas1.get(i));
                    } catch (KeyNotFoundException e) {
                        e.printStackTrace();
                    }
                    allGoldMedals = 0;
                }

                for (int i = 0; i < 10; i++) {

                    int cantMedals = goldMedals.getRoot();

                    atleta = goldMedals.removeRoot();

                    System.out.println(i + 1 + "  -  " + atleta.getName() + "   -   " + cantMedals + " medallas de oro.");

                }

                break;

            case 3:

                Heap<Integer, Athlete> silverMedals = new Heap<>(140000, false);

                int allSilverMedals = 0;

                for (long i = 1; i < Repositorio.participations.getSize(); i++) {

                    for (HashNode<Long, AthleteOlympicParticipation> part : Repositorio.participations.getTodos(i)) {

                        if (part.getData().getMedalType().equals(MedalType.SILVER)) allSilverMedals++;

                    }

                    try {
                        silverMedals.add(allSilverMedals, Repositorio.atletas1.get(i));
                    } catch (KeyNotFoundException e) {
                        e.printStackTrace();
                    }
                    allSilverMedals = 0;
                }

                for (int i = 0; i < 10; i++) {

                    int cantMedals = silverMedals.getRoot();

                    atleta = silverMedals.removeRoot();

                    System.out.println(i + 1 + "  -  " + atleta.getName() + "   -   " + cantMedals + " medallas de plata.");

                }

                break;

            case 4:

                Heap<Integer, Athlete> bronzeMedals = new Heap<>(140000, false);

                int allBronzeMedals = 0;

                for (long i = 1; i < Repositorio.participations.getSize(); i++) {

                    for (HashNode<Long, AthleteOlympicParticipation> part : Repositorio.participations.getTodos(i)) {

                        if (part.getData().getMedalType().equals(MedalType.BRONZE)) allBronzeMedals++;

                    }

                    try {
                        bronzeMedals.add(allBronzeMedals, Repositorio.atletas1.get(i));
                    } catch (KeyNotFoundException e) {
                        e.printStackTrace();
                    }
                    allBronzeMedals = 0;
                }

                for (int i = 0; i < 10; i++) {

                    int cantMedals = bronzeMedals.getRoot();

                    atleta = bronzeMedals.removeRoot();

                    System.out.println(i + 1 + "  -  " + atleta.getName() + "   -   " + cantMedals + " medallas de bronce.");

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

        switch (sc.nextInt()) {


            case 1:

                Heap<Integer, NationalOlympicCommitte> regionsMedals = new Heap<>(300, false);

                int totalMedallas = 0;

                for (int i = 0; i < Repositorio.participationsXregion.getSize(); i++) {

                    if (Repositorio.participationsXregion.getHash()[i] != null) {

                        for (int j = 0; j < Repositorio.participationsXregion.getHash()[i].size(); j++) {

                            if (!Repositorio.participationsXregion.getHash()[i].get(j).getData().getMedalType().equals(MedalType.NA))
                                totalMedallas++;
                        }

                        regionsMedals.add(totalMedallas, Repositorio.regions.getHash()[i].get(0).getData());
                    }
                    totalMedallas = 0;
                }

                for (int i = 0; i < 10; i++) {

                    int cantMedals = regionsMedals.getRoot();

                    noc = regionsMedals.removeRoot();

                    System.out.println(i + 1 + "  -  " + noc.getName() + "  -  " + cantMedals + " medallas. ");
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
        OpenHash<String, OlympicGame> jjoo = new OpenHash<String,OlympicGame>(100000, 100000);
        Heap<Integer,OlympicGame>  jjooh = new Heap<Integer,OlympicGame>(1000,false);

        for (int i = 0; i < Repositorio.participations.getHash().length; i++)
            if (Repositorio.participations.getHash()[i] !=null ){
                ArrayList<String> yaParticipo = new ArrayList<String>(10000);
                for (int j = 0;j<Repositorio.participations.getHash()[i].size();j++){
                    if (Repositorio.participations.getHash()[i].get(j).getData().getAtleta().getSex().equals(SexType.FEMALE) && !yaParticipo.contains(Repositorio.participations.getHash()[i].get(j).getData().getJuegoOlimpico().getName())){
                        jjoo.put(Repositorio.participations.getHash()[i].get(j).getData().getJuegoOlimpico().getName(),Repositorio.participations.getHash()[i].get(j).getData().getJuegoOlimpico());
                        yaParticipo.add(Repositorio.participations.getHash()[i].get(j).getData().getJuegoOlimpico().getName());
                    }
                }
            }
        for (int k=0;k<jjoo.getHash().length;k++){
            if (jjoo.getHash()[k] !=null){
                int participantes=0;
                for (int j =0;j<jjoo.getHash()[k].size();j++){
                    if(jjoo.getHash()[k].get(j) != null){
                        participantes++;
                    }
                }jjooh.add(participantes,jjoo.getHash()[k].get(0).getData());

            }
        }

        for (int i = 0; i < 10; i++) {

            int cantParticipantesF= jjooh.getRoot();

            OlympicGame jjootemp= jjooh.removeRoot();

            System.out.println(i + 1 + "  -  " +jjootemp.getName()  + "   -   "+ jjootemp.getYear()+"   -   "+ cantParticipantesF+ " participantes Femeninos.");

        }

    }


    }


   /* public static void Three() {
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






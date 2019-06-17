package um.edu.uy;


import um.edu.uy.Tads.Hash.HashNode;
import um.edu.uy.Tads.Hash.OpenHash;
import um.edu.uy.Tads.Heap.Nodo;
import um.edu.uy.Tads.HeapJope.Heap;
import um.edu.uy.Tads.KeyNotFoundException;
import um.edu.uy.Tads.QueueJope.ListaQueue;
import uy.edu.um.prog2.exceptions.EmptyQueueException;

import java.time.Year;
import java.util.ArrayList;

import java.util.Scanner;

public class Menu {

    private static Scanner sc = new Scanner(System.in);


    private static void One() {
        ArrayList<HashNode<String, Athlete>>[] hashA = Repositorio.atletas.getHash();
        System.out.println("Seleccione una opcion: \n"
                + " 1- Medallas totales\n"
                + " 2- Medallas de oro \n"
                + " 3- Medallas de plata \n"
                + " 4- Medallas de bronce\n");
        switch (sc.nextInt()) {
            case 1:
                if (!medallasTotalesA) {
                    for (int i = 0; i < hashA.length; i++) {
                        if (hashA[i] != null)
                            for (int j = 0; i < hashA[i].size(); i++)// menor o menor igual?
                                if (hashA[i].get(j).getData().getMedallas()[0] != 0) {
                                    Repositorio.medalTotalAthlete.add(hashA[i].get(j).getData().getMedallas()[0], hashA[i].get(j).getData());
                                }

                    }

                    medallasTotalesA = true;
                }
                for (int k = 0; k < 10; k++) {

                    um.edu.uy.Tads.Heap.Heap<Athlete, Integer> listaAtletasTotal = Repositorio.medalTotalAthlete;
                    printTop10Atletas(listaAtletasTotal, 0);
                }


                break;
            case 2:
                if (!medallasOroA) {
                    for (int i = 0; i < hashA.length; i++) {
                        for (int j = 0; i < hashA[i].size(); i++)// menor o menor igual?
                            if (hashA[i].get(j).getData().getMedallas()[1] != 0) {
                                Repositorio.medalGoldAthlete.add(hashA[i].get(j).getData().getMedallas()[1], hashA[i].get(j).getData());
                            }
                        ;
                    }
                    medallasOroA = true;
                }
                um.edu.uy.Tads.Heap.Heap<Athlete, Integer> listaAtletasOro = Repositorio.medalTotalAthlete;

                printTop10Atletas(listaAtletasOro, 1);


                break;
            case 3:
                if (!medallasPlataA) {
                    for (int i = 0; i < hashA.length; i++) {
                        for (int j = 0; i < hashA[i].size(); i++)// menor o menor igual?
                            if (hashA[i].get(j).getData().getMedallas()[2] != 0) {
                                Repositorio.medalSilverAthlete.add(hashA[i].get(j).getData().getMedallas()[2], hashA[i].get(j).getData());
                            }
                        ;
                    }
                    medallasPlataA = true;
                }
                um.edu.uy.Tads.Heap.Heap<Athlete, Integer> listaAtletasPlata = Repositorio.medalTotalAthlete;
                printTop10Atletas(listaAtletasPlata, 2);

                break;
            case 4:
                if (!medallasBronceA) {
                    for (int i = 0; i < hashA.length; i++) {
                        for (int j = 0; i < hashA[i].size(); i++)// menor o menor igual?
                            if (hashA[i].get(j).getData().getMedallas()[3] != 0) {
                                Repositorio.medalBronzeAthlete.add(hashA[i].get(j).getData().getMedallas()[3], hashA[i].get(j).getData());
                            }
                        ;
                    }
                    medallasBronceA = true;
                }
                um.edu.uy.Tads.Heap.Heap<Athlete, Integer> listaAtletasbronce = Repositorio.medalTotalAthlete;
                printTop10Atletas(listaAtletasbronce, 3);
                break;
            default:

                System.out.println("Opcion no valida.");
                break;
        }


    }

    private static void Two() {
        ArrayList<HashNode<String, NationalOlympicCommitte>>[] hashNC = Repositorio.regions.getHash();
        System.out.println("Seleccione una opcion: \n"
                + " 1- Medallas totales\n"
                + " 2- Medallas de oro \n"
                + " 3- Medallas de plata \n"
                + " 4- Medallas de bronce\n");
        switch (sc.nextInt()) {
            case 1:
                if (!medallasTotalesNC) {
                    int cantMedallas =0;
                    for (int i = 0; i < hashNC.length; i++) {
                        for (int j = 0; i < hashNC[i].size(); i++)// menor o menor igual?
                            if (hashNC[i].get(j).getData().getMedallas()[0] != 0) {
                                cantMedallas = cantMedallas +hashNC[i].get(j).getData().getMedallas()[0];

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
                    int cantMedallas=0;
                    for (int i = 0; i < hashNC.length; i++) {
                        for (int j = 0; i < hashNC[i].size(); i++)// menor o menor igual?
                            if (hashNC[i].get(j).getData().getMedallas()[1] != 0) {
                                cantMedallas = cantMedallas +hashNC[i].get(j).getData().getMedallas()[1];

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
                    int cantMedallas=0;
                    for (int i = 0; i < hashNC.length; i++) {
                        for (int j = 0; i < hashNC[i].size(); i++)// menor o menor igual?
                            if (hashNC[i].get(j).getData().getMedallas()[2] != 0) {
                                cantMedallas = cantMedallas +hashNC[i].get(j).getData().getMedallas()[2];

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
                    int cantMedallas=0;
                    for (int i = 0; i < hashNC.length; i++) {
                        for (int j = 0; i < hashNC[i].size(); i++)// menor o menor igual?
                            if (hashNC[i].get(j).getData().getMedallas()[3] != 0) {
                                 cantMedallas = cantMedallas +hashNC[i].get(j).getData().getMedallas()[3];

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

    private static void Three() {
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

    private static void Four() {

    }

    private static void Five() throws KeyNotFoundException {
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


    public static void menu() {
        boolean datoscCargados = false;
        boolean salir = false;
        String mensajeDatos = "No hay datos cargados :(";

        System.out.println("Bienvenido! Seleccione una opcion: \n" +
                " 0- Cargar datos\n" +
                " 1- Atletas con mas medallas \n" +
                " 2- Regiones con mas medallas \n " +
                "3- JJOO con mas atletas femeninas \n " +
                "  4- Competiciones con mas atletas de determinado sexo  \n " +
                " 5- Equipos mas efectivos  \n" +
                "   6- Salir");

        while (!salir) {

            switch (sc.nextInt()) {                //aca tendriamos que manejar la exepcion de si nos madna alguna letra o null o algo que no sea un numero
                case 0:
                    if (!datoscCargados) {
                        Repositorio.init();
                        datoscCargados = true;
                    } else {
                        System.out.println("Datos ya cargados :)");

                    }
                    break;

                case 1:
                    if (datoscCargados) {
                        One();
                    } else {
                        System.out.println(mensajeDatos);
                    }

                    break;
                case 2:

                    if (datoscCargados) {

                        Two();
                    } else {
                        System.out.println(mensajeDatos);
                    }

                    break;
                case 3:

                    if (datoscCargados) {
                        Three();
                    } else {
                        System.out.println(mensajeDatos);
                    }


                    break;
                case 4:


                    if (datoscCargados) {
                        Four();
                    } else {
                        System.out.println(mensajeDatos);
                    }

                    break;
                case 5:

                    if (datoscCargados) {
                        try {
                            Five();        ///////////// try y catch
                        } catch (KeyNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else {

                        System.out.println(mensajeDatos);
                    }


                    break;
                case 6:

                    salir = true;

                    System.out.println("Hasta luego! Gracias!");

                    break;
                default:

                    System.out.println("Opcion no valida.");

                    break;
            }
        }
    }


    //funciones auxiliares


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
            } catch (EmptyQueueException e) {
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


}

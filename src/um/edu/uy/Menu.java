package um.edu.uy;



import um.edu.uy.Tads.Hash.HashNode;
import um.edu.uy.Tads.Hash.OpenHash;
import um.edu.uy.Tads.HeapJope.Heap;
import um.edu.uy.Tads.HeapJope.HeapNodo;
import um.edu.uy.Tads.KeyNotFoundException;

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
                        for (int j = 0; i < hashA[i].size(); i++)// menor o menor igual?
                            if (hashA[i].get(j).getData().getMedallas()[0] != 0) {
                                Repositorio.medalTotalAtleth.add(hashA[i].get(j).getData().getMedallas()[0], hashA[i].get(j).getData());
                            }
                        ;
                    }
                    medallasTotalesA = true;
                }
                for (int k = 0; k < 10; k++) {
                    HeapNodo<Integer, Athlete>[] listaAtletasTotal = Repositorio.medalTotalAtleth.getHeap();
                    printTop10Atletas(listaAtletasTotal, 0);
                }


                break;
            case 2:
                if (!medallasOroA) {
                    for (int i = 0; i < hashA.length; i++) {
                        for (int j = 0; i < hashA[i].size(); i++)// menor o menor igual?
                            if (hashA[i].get(j).getData().getMedallas()[1] != 0) {
                                Repositorio.medalGoldAtleth.add(hashA[i].get(j).getData().getMedallas()[1], hashA[i].get(j).getData());
                            }
                        ;
                    }
                    medallasOroA = true;
                }
                HeapNodo<Integer, Athlete>[] listaAtletasOro = Repositorio.medalGoldAtleth.getHeap();
                printTop10Atletas(listaAtletasOro, 1);


                break;
            case 3:
                if (!medallasPlataA) {
                    for (int i = 0; i < hashA.length; i++) {
                        for (int j = 0; i < hashA[i].size(); i++)// menor o menor igual?
                            if (hashA[i].get(j).getData().getMedallas()[2] != 0) {
                                Repositorio.medalSilverAtleth.add(hashA[i].get(j).getData().getMedallas()[2], hashA[i].get(j).getData());
                            }
                        ;
                    }
                    medallasPlataA = true;
                }

                HeapNodo<Integer, Athlete>[] listaAtletasPlata = Repositorio.medalGoldAtleth.getHeap();
                printTop10Atletas(listaAtletasPlata, 2);

                break;
            case 4:
                if (!medallasBronceA) {
                    for (int i = 0; i < hashA.length; i++) {
                        for (int j = 0; i < hashA[i].size(); i++)// menor o menor igual?
                            if (hashA[i].get(j).getData().getMedallas()[3] != 0) {
                                Repositorio.medalBronceAtleth.add(hashA[i].get(j).getData().getMedallas()[3], hashA[i].get(j).getData());
                            }
                        ;
                    }
                    medallasBronceA = true;
                }

                HeapNodo<Integer, Athlete>[] listaAtletasbronce = Repositorio.medalGoldAtleth.getHeap();
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
                    for (int i = 0; i < hashNC.length; i++) {
                        for (int j = 0; i < hashNC[i].size(); i++)// menor o menor igual?
                            if (hashNC[i].get(j).getData().getMedallas()[0] != 0) {
                                Repositorio.medalTotalNC.add(hashNC[i].get(j).getData().getMedallas()[0], hashNC[i].get(j).getData());
                            }
                        ;
                    }
                    medallasTotalesNC = true;
                }
                HeapNodo<Integer, NationalOlympicCommitte>[] listaNOCTotal = Repositorio.medalTotalNC.getHeap();// completar
                printTop10Noc(listaNOCTotal, 0);

                break;
            case 2:
                if (!medallasOroNC) {
                    for (int i = 0; i < hashNC.length; i++) {
                        for (int j = 0; i < hashNC[i].size(); i++)// menor o menor igual?
                            if (hashNC[i].get(j).getData().getMedallas()[1] != 0) {
                                Repositorio.medalGoldNC.add(hashNC[i].get(j).getData().getMedallas()[1], hashNC[i].get(j).getData());
                            }
                        ;
                    }
                    medallasOroNC = true;
                }
                HeapNodo<Integer, NationalOlympicCommitte>[] listaNOCOro = Repositorio.medalGoldNC.getHeap();// completar
                printTop10Noc(listaNOCOro, 1);

                break;
            case 3:
                if (!medallasPlataNC) {
                    for (int i = 0; i < hashNC.length; i++) {
                        for (int j = 0; i < hashNC[i].size(); i++)// menor o menor igual?
                            if (hashNC[i].get(j).getData().getMedallas()[2] != 0) {
                                Repositorio.medalSilverNC.add(hashNC[i].get(j).getData().getMedallas()[2], hashNC[i].get(j).getData());
                            }
                        ;
                    }
                    medallasPlataNC = true;
                }
                HeapNodo<Integer, NationalOlympicCommitte>[] listaNOCPlata = Repositorio.medalSilverNC.getHeap();// completar
                printTop10Noc(listaNOCPlata, 2);

                break;
            case 4:
                if (!medallasBronceNC) {
                    for (int i = 0; i < hashNC.length; i++) {
                        for (int j = 0; i < hashNC[i].size(); i++)// menor o menor igual?
                            if (hashNC[i].get(j).getData().getMedallas()[3] != 0) {
                                Repositorio.medalBronceNC.add(hashNC[i].get(j).getData().getMedallas()[3], hashNC[i].get(j).getData());
                            }
                        ;
                    }
                    medallasBronceNC = true;
                }

                HeapNodo<Integer, NationalOlympicCommitte>[] listaNOCBronce = Repositorio.medalBronceNC.getHeap();// completar
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
            System.out.println("-Nombre:" + Repositorio.olimpicGamesOrdenado.getHeap()[j].getData().getName());
            System.out.print("-Anio:" + Repositorio.olimpicGamesOrdenado.getHeap()[j].getData().getYear());
            System.out.print("Cantdida de atletas femeninos:" + Repositorio.olimpicGamesOrdenado.getHeap()[j].getKey());
        }

    }

    private static void Four() {

    }

    private static void Five() throws KeyNotFoundException {
            System.out.println("Indique el año inicial");
            int añoMin=sc.nextInt();
            if (añoMin < 1896){
                añoMin=1896;
            }
            System.out.println("Indique el año final");
            int añoMax=sc.nextInt();
            int year = Year.now().getValue();
            if(añoMax<year){
                añoMax = year;
            }
            OpenHash<String,Team> equiposTempHash = Repositorio.teams;
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

            Heap<Integer,Team> equiposOrdenados = new Heap<Integer,Team>(10,false);
            for(int i =0;i<equiposTempHash.getHash().length;i++){
               int cantidadMedallas=  equiposTempHash.getHash()[i].get(0).getData().medallas[0];
               int cantidadAtletas =equiposTempHash.getHash()[i].get(0).getData().atletas.size();
               if (cantidadMedallas!=0){
                   equiposOrdenados.add(cantidadAtletas/cantidadMedallas,equiposTempHash.getHash()[i].get(0).getData());
               }
            }
        for (int i = 0; i < 16; i++) { //top 15
            Team equipotemp = equiposOrdenados.getHeap()[i].getData();


            System.out.println("-Equipo:" +equipotemp.getNombre());

            System.out.print("-Cantidad de medallas:" +equipotemp.medallas[0] );

            System.out.print("-Cantidad de medallas:" +equipotemp.atletas.size());

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
                    if(!datoscCargados){
                        Repositorio.init();
                        datoscCargados = true;
                    } else {
                        System.out.println("Datos ya cargados :)");

                    }
                    break;

                case 1:
                    if(datoscCargados){
                    One();}
                    else{
                        System.out.println(mensajeDatos);
                    }

                    break;
                case 2:

                    if(datoscCargados){

                        Two();
                    } else {
                        System.out.println(mensajeDatos);
                    }

                    break;
                case 3:

                    if(datoscCargados){
                        Three();
                    } else {
                        System.out.println(mensajeDatos);
                    }


                    break;
                case 4:


                    if(datoscCargados){
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


    private static void printTop10Atletas(HeapNodo<Integer, Athlete>[] atletas, int tipoMedalla) {
        int aniomax = 0;
        int aniomin = 0;
        for (int i = 0; i < 16; i++) { //top 15
            Athlete tempAtleta = atletas[i].getData();
            ArrayList<HashNode<Integer, AthleteOlympicParticipation>> participacionAtleta = Repositorio.participations.getHash()[(int) tempAtleta.getId()];
            for (int j = 0; j < participacionAtleta.size(); j++) {
                int anio = participacionAtleta.get(j).getData().getJuegoOlimpico().getYear();
                if (anio < aniomin || aniomin == 0) {
                    aniomin = anio;
                }
                if (aniomax < anio) {
                    aniomax = anio;
                }
            }
            System.out.println("Nombre:" + tempAtleta.getName());
            System.out.print("-Sexo:" + tempAtleta.getSex());
            System.out.print("-Cantidad de medallas:" + tempAtleta.getMedallas()[tipoMedalla]);
            System.out.print("-Anio minimo:" + aniomin);
            System.out.print("-Anio maximo:" + aniomax);
        }


    }


    private static void printTop10Noc(HeapNodo<Integer, NationalOlympicCommitte>[] NOCs, int tipoMedalla) {

        for (int i = 0; i < 16; i++) { //top 15
            NationalOlympicCommitte tempNOC = NOCs[i].getData();


            System.out.println("Nombre:" + tempNOC.getRegion());

            System.out.print("-Cantidad de medallas:" + tempNOC.getMedallas()[tipoMedalla]);

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

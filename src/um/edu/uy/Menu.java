package um.edu.uy;

import java.util.Scanner;

public class Menu {

    private static Scanner sc = new Scanner(System.in);

    private static void One(){

    }

    private static void Two(){

    }

    private static void Three(){

    }

    private static void Four(){

    }
    private  static void Five(){

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

            switch (sc.nextInt()) {
                case 0:
                    if(!datoscCargados){
                        Repositorio.init();
                    }else{
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
                    }
                    else{
                        System.out.println(mensajeDatos);
                    }

                    break;
                case 3:

                    if(datoscCargados){
                        Three();
                    }
                    else{
                        System.out.println(mensajeDatos);
                    }


                    break;
                case 4:

                    if(datoscCargados){
                        Four();
                    }
                    else{
                        System.out.println(mensajeDatos);
                    }

                    break;
                case 5:

                    if(datoscCargados){
                        Five();}
                    else{
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

}

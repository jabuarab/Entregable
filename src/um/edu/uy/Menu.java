package um.edu.uy;


import java.security.PrivateKey;
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

        boolean salir = false;

        System.out.println("Bienvenido! Seleccione una opcion: ");

        System.out.println("1- Atletas con mas medallas     2- Regiones con mas medallas    3- JJOO con mas atletas femeninas");

        System.out.println("4- Competiciones con mas atletas de determinado sexo    5- Equipos mas efectivos    6- Salir");

        while (!salir) {

            switch (sc.nextInt()) {

                case 1:

                    One();

                    break;
                case 2:

                    Two();

                    break;
                case 3:

                    Three();

                    break;
                case 4:

                    Four();

                    break;
                case 5:

                    Five();

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

package um.edu.uy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void menu() {

        boolean datosCargados = false;

        boolean salir = false;

        boolean state = true;

        Scanner sc = new Scanner(System.in);

        System.out.println("\nBienvenido!");

        do {
            while (!salir) {

                System.out.println(
                        "\nSeleccione una opcion:\n" +
                                "   0- Cargar datos\n" +
                                "   1- Atletas con mas medallas\n" +
                                "   2- Regiones con mas medallas\n" +
                                "   3- JJOO con mas atletas femeninas\n" +
                                "   4- Competiciones con mas atletas de determinado sexo\n" +
                                "   5- Equipos mas efectivos\n" +
                                "   6- Salir");

                try {
                    int opcion = sc.nextInt();
                    switch (opcion) {

                        case 0:

                            if (!datosCargados) {

                                Repositorio.init();

                                datosCargados = true;

                            } else System.out.println("Datos ya cargados :)");

                            break;

                        case 1:

                            if (datosCargados) Report.One();
                            else System.out.println("Primero deben ser cargados los datos.");

                            break;

                        case 2:

                            if (datosCargados) Report.Two();
                            else System.out.println("Primero deben ser cargados los datos.");

                            break;

                        case 3:

                            if (datosCargados) Report.Three();
                            else System.out.println("Primero deben ser cargados los datos.");

                            break;

                        case 4:

                            if (datosCargados) Report.Four();
                            else System.out.println("Primero deben ser cargados los datos.");

                            break;

                        case 5:

                            if (datosCargados) Report.Five();
                            else System.out.println("Primero deben ser cargados los datos.");

                            break;

                        case 6:

                            salir = true;

                            System.out.println("Hasta luego! Gracias!");

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
            }
        } while (!state);
    }
}


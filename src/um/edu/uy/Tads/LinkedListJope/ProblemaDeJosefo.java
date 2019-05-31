package uy.edu.um.prog2.tad.linkedlist;

import uy.edu.um.prog2.exceptions.PosicionInvalidaException;

class ProblemaDeJosefo {

    private ListaEnlazada2<Integer> colEliminados = new ListaEnlazada2<>();
    private int pos = 0;
    private int pos1 = 0;

    ListaEnlazada2<Integer> juego(int m, ListaEnlazadaCircular<Integer> colIntegrantes) throws PosicionInvalidaException {

        while (colIntegrantes.getSize() > 1) {
            while (pos1 < m) {
                pos1++;
                if (pos == colIntegrantes.getSize() - 1) pos = 0;
                else pos++;
            }
            //System.out.println("pos = " + pos + "   size = " + colIntegrantes.getSize());
            pos1 = 0;
            colEliminados.add(colIntegrantes.get(pos));
            colIntegrantes.remove(pos);
            if (pos == colIntegrantes.getSize()) pos = 0;
            else if (pos == colIntegrantes.getSize() - 1) pos = -1;
        }
        return colEliminados;
    }
}

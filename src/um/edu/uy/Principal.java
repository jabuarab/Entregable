package um.edu.uy;

import um.edu.uy.Tads.Hash.ClosedHash;
import um.edu.uy.Tads.Hash.ColissionManagement;
import um.edu.uy.Tads.KeyNotFoundException;
import um.edu.uy.Tads.Hash.OpenHash;
import um.edu.uy.Tads.TreeJope.BTree;
import um.edu.uy.Tads.TreeJope.EmptyTreeException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Principal {



    public static void main(String[] args) {
        Repositorio.init();
        Menu.menu();

    }
}

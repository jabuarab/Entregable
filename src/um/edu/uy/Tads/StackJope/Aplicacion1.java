package uy.edu.um.prog2.tad.stack;

import java.util.Scanner;

public class Aplicacion1 {

    public void comprobarSimbolos() {
        ListaStack<Character> simbolos = new ListaStack<>();
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.print("Escriba la expresion a evaluar: ");
        s = sc.nextLine();
        char[] expresion = s.toCharArray();

        for (char c : expresion) {
            if (simbolos.isEmpty() && (c == '}' || c == ']' || c == ')')) {
                simbolos.push(c);
                break;
            }
            if (c == '{' || c == '[' || c == '(') {
                simbolos.push(c);
            }
            switch (c) {
                case '}':
                    if (simbolos.top() == '{') {
                        simbolos.pop();
                    }
                    break;
                case ']':
                    if (simbolos.top() == '[') {
                        simbolos.pop();
                    }
                    break;
                case ')':
                    if (simbolos.top() == '(') {
                        simbolos.pop();
                    }
                    break;
            }
        }
        if (!simbolos.isEmpty()) {
            System.out.println("Simbolos desbalanceados.");
        } else {
            System.out.println("Simbolos OK!");
        }
    }
}


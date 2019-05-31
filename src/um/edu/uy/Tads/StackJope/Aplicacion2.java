package uy.edu.um.prog2.tad.stack;

import uy.edu.um.prog2.exceptions.SimboloInvalidoException;

public class Aplicacion2 {

    private ListaStack<String> cuenta = new ListaStack<>();

    public void evaluarPosfija(String s) throws SimboloInvalidoException {
        String[] expresion = s.split(" ");
        String ele1;
        String ele2;
        for (String ele : expresion) {
            if(esUnNumero(ele)) {
                cuenta.push(ele);
            } else {
                switch (ele) {
                    case "+":
                        ele1 = cuenta.top();
                        cuenta.pop();
                        ele2 = cuenta.top();
                        cuenta.pop();
                        cuenta.push(sumar(ele1,ele2));
                        break;
                    case "-":
                        ele1 = cuenta.top();
                        cuenta.pop();
                        ele2 = cuenta.top();
                        cuenta.pop();
                        cuenta.push(restar(ele1,ele2));
                        break;
                    case "*":
                        ele1 = cuenta.top();
                        cuenta.pop();
                        ele2 = cuenta.top();
                        cuenta.pop();
                        cuenta.push(multiplicar(ele1,ele2));
                        break;
                    case "/":
                        ele1 = cuenta.top();
                        cuenta.pop();
                        ele2 = cuenta.top();
                        cuenta.pop();
                        cuenta.push(dividir(ele1,ele2));
                        break;
                    default:
                        throw new SimboloInvalidoException();
                }
            }
        }
        System.out.println("El resultado es: " + cuenta.top());
    }

    private String sumar(String a, String b) {
        int resu = Integer.parseInt(a) + Integer.parseInt(b);
        return  Integer.toString(resu) ;
    }

    private String restar(String a, String b) {
        int resu = Math.abs(Integer.parseInt(a) - Integer.parseInt(b));
        return  Integer.toString(resu) ;
    }

    private String multiplicar(String a, String b) {
        int resu = Integer.parseInt(a) * Integer.parseInt(b);
        return  Integer.toString(resu) ;
    }

    private String dividir(String a, String b) {
        int resu = Integer.parseInt(a) / Integer.parseInt(b);
        return  Integer.toString(resu) ;
    }
    private boolean esUnNumero(String numero){
        try{
            Integer.parseInt(numero);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}



package sample.Estructuras;

import javafx.event.ActionEvent;

public class Busqueda {
    public int secuencial(String[][] array, String dato1, String dato2) {
        int indice = -1;

        for (int x = 0; x < array.length; x++) {
            if (array[x][1].equals(dato1) && array[x][2].equals(dato2)) {
                indice = x;
                return indice;
            }
        }

        return indice;
    }

    public static int[] burbuja(int[] arreglo) {
        int auxiliar;
        int[] arregloOrdenado;
        for (int i = 2; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - i; j++) {

                if (arreglo[j] > arreglo[j+1] + 1) {
                    auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = auxiliar;
                }//if
            }//forJ
        }//Fori
        arregloOrdenado=arreglo;
        return  arregloOrdenado;

    }

    public  String[][] burbujaArray(String[][] arreglo) {
        String auxiliar;//Respaldar el juego
        String auxiliar2;//Respaldar el precio
        String[][] arregloOrdenado;
        for (int i = 0; i < arreglo.length-1; i++) {
            for (int j = 0; j < arreglo.length - i-1; j++) {

                if (Integer.parseInt(arreglo[j][1])>Integer.parseInt(arreglo[j+1][1])) {
                    auxiliar = arreglo[j][0];
                    auxiliar2 = arreglo[j][1];
                    arreglo[j][0] = arreglo[j + 1][0];
                    arreglo[j][1] = arreglo[j + 1][1];
                    arreglo[j + 1][0] = auxiliar;
                    arreglo[j + 1][1] = auxiliar2;
                }//if
            }//forJ
        }//Fori
        arregloOrdenado=arreglo;
        return  arregloOrdenado;

    }

    public void mostrarArreglo(int[]arreglo){
        int k;
        for (k=0;k<arreglo.length;k++){
            System.out.println(" [ " + arreglo[k] + " ] ");
        }
        System.out.println();
    }

    public String[][] burbujaAlfa(String[][] arreglo) {
        String auxiliar;
        String auxiliar2;
        String[][] arregloOrdenado;
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - i - 1; j++) {
                if (arreglo[j][0].compareTo(arreglo[j + 1][0]) > 0) {
                    auxiliar = arreglo[j][0];
                    auxiliar2 = arreglo[j][1];
                    arreglo[j][0] = arreglo[j + 1][0];
                    arreglo[j][1] = arreglo[j + 1][1];
                    arreglo[j + 1][0] = auxiliar;
                    arreglo[j + 1][1] = auxiliar2;
                }
            }
        }
        arregloOrdenado = arreglo;
        return arregloOrdenado;
    }

}

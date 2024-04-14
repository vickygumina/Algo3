import java.util.*;

public class Ejercicio5 {

    static int n, k; // Declarados como static para que puedan ser accesibles en el método main
    static Boolean[][] matriz; // Declarada como static para poder ser accesible en el método main

    // Constructor de la clase
    public Ejercicio5(int n, int k) {
        this.n = n;
        this.k = k;
        matriz = new Boolean[n + 1][k + 1]; // Inicializar la matriz con las dimensiones adecuadas
    }

    public static Boolean subset_sum(Boolean[][] matriz, int[] c, int i, int j) {
        if (j < 0) {
            return false;
        } else {
            if (i == 0) { 
                return (j == 0);
            }
        }

        if (matriz[i][j] == null) {
            matriz[i][j] = subset_sum(matriz, c, i - 1, j) || subset_sum(matriz, c, i - 1, j - c[i - 1]);
        }
        return matriz[i][j];
    }

    public static void main(String[] args) {
        int k = 12;
        int[] c = {6, 12, 6};

        Ejercicio5 ejercicio = new Ejercicio5(c.length, k); // Crear una instancia de la clase Ejercicio5

        for (int i = 0; i < c.length + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                matriz[i][j] = null;
            }
        }

        // Llamar a la función subset_sum y mostrar el resultado
        boolean resultado = subset_sum(matriz, c, c.length, k);
        System.out.println("¿Se puede obtener la suma de " + k + " con los elementos dados?: " + resultado);
    }
}

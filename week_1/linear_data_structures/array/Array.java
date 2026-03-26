package week_1.linear_data_structures.array;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        //Inicialização de arrays no Java
        int[] array = new int[8]; 
        int[] array2 = {0, 1, 2, 3, 4, 5, 6, 7};

        //Acessando as posições do array
        System.out.println(array[0]); // Estou me referindo a posição 1 que é indexada por 0.
        //Lembrando que ao tentar acessar uma posição que não existe, o Java lança uma exception ArrayIndexOutOfBoundsException

        //Para percorrer as posições do array você pode usar também as estruturas de repetição.

        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        // Ou até mesmo fazer

        for(int v : array) {
            System.out.println(v);
        }

        //Dessa forma você faz uma iteração por todas as posições de maneira mais syntax suggar.


        //Por fim o java Utils fornecem algumas biblioteca para realizar operações com os arrays. Uma delas é o sort, que ordena lexicograficamente os valores.
        int[] numbers = {5, 2, 8, 1, 4};
        Arrays.sort(numbers);
        // Resultado: [1, 2, 4, 5, 8]
    }
}

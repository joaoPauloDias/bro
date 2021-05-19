import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    /*
    A função merge combinará duas sequências ordenadas. Como parâmetro teremos as duas sequências, S1 e S2, e como resultado teremos uma única sequência de elementos ordenados.
        Crie uma sequência vazia. Chame ela de S.
        Crie dois ponteiros p1 e p2, cada um apontará para o primeiro elemento da sequência S1 e S2 respectivamente.
        Enquanto existir elementos na sequência para p1 e p2 apontar, faça:
        1. Se o elemento que p1 aponta for menor que o elemento que p2 aponta, adicione o elemento que p1 aponta na última posição de S. e faça p1 apontar para o próximo elemento de S1.
        2. Caso contrário, adiciona o elemento que p2aponta na última posição de S e faça p2 apontar para o próximo elemento de S2.
        Se ainda existirem elementos para p1 apontar, adicione eles em ordem na última posição da sequência S.
        Se ainda existirem elementos para p2 apontar, adicione eles em ordem na última posição da sequência S.
        Retorne a sequência S como resultado da combinação.
     */
    static void merge(int l, int r, ArrayList<Integer> x){
        int meio = (l+r)/2;
        ArrayList<Integer> S = new ArrayList<Integer>(); //sequencia auxiliar, comeca vazia

        int p1 = l; //p1 aponta pra o 1° elemento da 1° parte
        int p2 = meio+1; //p2 aponta pra o 1° elemento da 2° parte

        while(p1 <=meio && p2 <= r){
            //adicionando menor elemento na última posicao
            //ate alguma das sequencias ficar vazia
            if(x.get(p1) <= x.get(p2))
                S.add(x.get(p1++));
            else
                S.add(x.get(p2++));
        }
        //adicionando elementos que possivelmente sobraram
        while(p1<=meio)S.add(x.get(p1++));

        while(p2<=meio)S.add(x.get(p2++));

        //Atualizando vetor original com valores do auxiliar
        for(int i = 0; i < S.size(); i++)
            x.set(l+i, S.get(i));
        // Agora o intervalo [l,r] em x esta ordenado

    }
    //[l, r] = intervalo que precisa ser ordenado
    //x = conjunto de dados a ser ordenado

    /*
    A função mergeSort()
    Esta é uma função recursiva. Recebe como parâmetro uma sequência de números e retorna esta sequência ordenada. A função executa os seguintes passos:
        Se o tamanho da sequência for menor ou igual a 1, retorne esta mesma sequência, pois ela já estará ordenada por definição.
        Divida a sequência na metade.
        Chame a função mergeSort() para a primeira parte e armazene o resultado da função.
        Chame a função mergeSort() para a segunda parte e armazene o resultado da função.
        Chame a função merge() para combinar o resultado do passo 3 e do passo 4. Em seguida retorne o resultado da função merge().
    */

    static void mergeSort(int l, int r, ArrayList<Integer> x){
        int meio;
        //se l == r o intervalo ja estara ordenado
        if(l<r){
            meio = (l+r)/2;
            mergeSort(l, meio, x);//ordena 1° metade
            mergeSort(meio+1, r, x);//ordena 2° metade
            merge(l, r, x);//combina as duas partes
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner t = new Scanner(System.in);

        ArrayList<Integer> x = new ArrayList<>(Arrays.asList(38, 27, 43, 3, 9, 82, 10));

        mergeSort(0, x.size()-1, x);

        System.out.println("Sequencia ordenada:");

        for(int i : x)
            System.out.print(i+" ");
    }

}

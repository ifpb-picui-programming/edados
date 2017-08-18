/*/* Arquivo: OrdenaVetCLI.java
*
* IFPB - CAMPUS PICUÍ.
* PROGRAMAÇÃO. Turma: POO. 2017.1
*  Prof.: Me. Sergio ESPINOLA. http://mestre.sergiodbe.net/IFPB
*  Objetivo: Este programa é MENU (CLI) com várias opções de java estruturado!
*
*  Data: 13/7/2017.
*/

package net.sergiodbe.mestre.edados;

import static java.lang.System.out;

/**
 *
 * @author Me. Sérgio ESPINOLA <http://mestre.sergiodbe.net/IFPB>
 */
public class OrdenaVetCLI {
    
    /*  V1 = 2 4 6 8 10     (caso melhor)
    -> Tam.=5; Comparações= 24; Trocas=8
    V2 = 5 1 12 -5 -16  (caso médio)
    -> Tam.=5; Comparações= 24; Trocas=8
    V3 = 12 5 1 -5 -16  (PIOR CASO!)
    -> Tam.=5; Comparações=24; Trocas=10
    v4 = 12 5 1 -5 -16 20 30 19 16 2
    -> Tam.=10; Comparações= 99; Trocas=21
    v5 = 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1
    -> Tam.=10; Comparações= 399; Trocas=190
    */
    
    
    static int compar=0;
    static int trocas=0;
    static int tamVetorOrd=0;
    static int tamVetorMERGEOrd=0;
    
    
    public static void main(String[] argums) {
        int opcao;
        out.println("---------------------------------------");
        out.println("| >> IFPB-PC MENU                     |");
        out.println("|    DISC.: EDADOS             2017.1 |");
        out.println("|    Turma: 3o Informática            |");
        out.println("|    Prof.: Sérgio Espinola           |");
        out.println("| Opções para programas:              |");
        out.println("|  OrdenaVetCLI                       |");
        out.println("|    <TIPO> [VETOR_N elementos]       |");
        out.println("|       101 = BUBBLE_SORT             |");
        out.println("|       102 =  BUBBLE_SORT-flag       |");
        out.println("|       103 =  COMB_SORT              |");
        out.println("|       104 = MERGE_SORT              |");
        out.println("|   ex                                |");
        out.println("|   java OrdenaVetCLI                 |");
        out.println("|        101 5 1 12 -5 -16            |");
        out.println("|        102 5 1 12 -5 -16            |");
        out.println("---------------------------------------");
        
        int numArgums = argums.length;
        if (numArgums >= 1){
            tamVetorOrd = numArgums-1;
            tamVetorMERGEOrd = numArgums-1;
            
            
            int vetLido[] = new int[tamVetorOrd];
            int vetOrdenacao[] = new int[tamVetorOrd];
            
            opcao = Integer.parseInt(argums[0]);
            
            // Ler Vetor
            for (int c=0; c<numArgums-1; c++) {
                // conversao de STRING para int
                vetLido[c] = Integer.parseInt(argums[c+1]);
            } //fim For
            
            switch (opcao) {
                case 101:
                    // SAÍDA # Parte #1
                    out.println("************************************************");
                    out.println(" Selecionada OP#1: BUBLE SORT");
                    out.println(" Lido(s): " + numArgums + " argumento(s)!");
                    out.println(" Vetor lido: ");
                    imprimirNumeros(vetLido);
                    out.println();
                    out.println("************************************************");
                    
                    
                    //TODO Compreender a finalidade da linha seguinte! Funcionou? :D
                    vetOrdenacao=vetLido;
                    
                    long tempoTM1 = System.currentTimeMillis();
                    long tempoNT1 = System.nanoTime();
                    
                    /* Comparação <trivial> de Tempo de Execução
                    VIDE Considerações para TEMPO PRECISO (benchmark)
                    Fonte1: https://shipilev.net/blog/2014/nanotrusting-nanotime/
                    e http://openjdk.java.net/projects/code-tools/jmh/
                    */
                    
                    //Chamada do Algoritmo de Ordenação!
                    bubble_sort(vetOrdenacao);
                    
                    long tempoTM2 = System.currentTimeMillis();
                    long tempoNT2 = System.nanoTime();
                    
                    long tempoGastoTM = Math.abs(tempoTM2 - tempoTM1);
                    long tempoGastoNT = Math.abs(tempoNT2 - tempoNT1);
                    
                    
                    // SAÍDA # Parte #2
                    out.println("------------------------------------------------");
                    out.println(" EXECUÇÃO buble_sort finalizada!");
                    //TODO VIDE OBS #2 DE AULA: PASSAGEM DE PARÂMETROS
                    out.println(" Vetor lido?! ");
                    imprimirNumeros(vetLido);
                    out.println();
                    out.println("------------------------------------------------");
                    
                    
                    // SAÍDA # Parte #3
                    out.println(">>>> Vetor ORDENADO: ");
                    imprimirNumeros(vetOrdenacao);
                    out.println();
                    out.println(" Tamanho:\t\t\t\t"+tamVetorOrd);
                    out.println(" Tempo [currentTimeMillis(), ms]:\t" + tempoGastoTM);
                    out.println(" Tempo [nanoTime()/1000 -> us]:\t\t" + tempoGastoNT/1000);
                    out.println(" | op1 = Comparações(comp):\t\t" + compar);
                    out.println(" | op2 = Trocas:\t\t\t" + trocas);
                    if (trocas!=0) {
                        out.println("\t\tT/comp [us/op1]:\t" + tempoGastoNT/compar);
                        out.println("\t\tT/trocas [us/op2]:\t" + tempoGastoNT/trocas);
                    } else {
                        out.println("\t\tT/comp [us/op1]:\t" + tempoGastoNT/compar);
                        out.println("\t\tT/trocas [us/op2]:\t - (não houve trocas)");
                    }
                    
                    
                    break;
                    
                case 102:    
                    
                    // SAÍDA # Parte #1
                    out.println("************************************************");
                    out.println(" Selecionada OP#1: BUBLE SORT b");
                    out.println(" Lido(s): " + numArgums + " argumento(s)!");
                    out.println(" Vetor lido: ");
                    imprimirNumeros(vetLido);
                    out.println();
                    out.println("************************************************");
                    
                    
                    //TODO Compreender a finalidade da linha seguinte! Funcionou? :D
                    vetOrdenacao=vetLido;
                    
                     tempoTM1 = System.currentTimeMillis();
                     tempoNT1 = System.nanoTime();
                    
                    /* Comparação <trivial> de Tempo de Execução
                    VIDE Considerações para TEMPO PRECISO (benchmark)
                    Fonte1: https://shipilev.net/blog/2014/nanotrusting-nanotime/
                    e http://openjdk.java.net/projects/code-tools/jmh/
                    */
                    
                    //Chamada do Algoritmo de Ordenação!
                    bubble_sort_otim(vetOrdenacao);
                    
                     tempoTM2 = System.currentTimeMillis();
                     tempoNT2 = System.nanoTime();
                    
                     tempoGastoTM = Math.abs(tempoTM2 - tempoTM1);
                     tempoGastoNT = Math.abs(tempoNT2 - tempoNT1);
                    
                    
                    // SAÍDA # Parte #2
                    out.println("------------------------------------------------");
                    out.println(" EXECUÇÃO buble_sort_melhor finalizada!");
                    //TODO VIDE OBS #2 DE AULA: PASSAGEM DE PARÂMETROS
                    out.println(" Vetor lido?! ");
                    imprimirNumeros(vetLido);
                    out.println();
                    out.println("------------------------------------------------");
                    
                    
                    // SAÍDA # Parte #3
                    out.println(">>>> Vetor ORDENADO: ");
                    imprimirNumeros(vetOrdenacao);
                    out.println();
                    out.println(" Tamanho:\t\t\t\t"+tamVetorOrd);
                    out.println(" Tempo [currentTimeMillis(), ms]:\t" + tempoGastoTM);
                    out.println(" Tempo [nanoTime()/1000 -> us]:\t\t" + tempoGastoNT/1000);
                    out.println(" | op1 = Comparações(comp):\t\t" + compar);
                    out.println(" | op2 = Trocas:\t\t\t" + trocas);
                    if (trocas!=0) {
                        out.println("\t\tT/comp [us/op1]:\t" + tempoGastoNT/compar);
                        out.println("\t\tT/trocas [us/op2]:\t" + tempoGastoNT/trocas);
                    } else {
                        out.println("\t\tT/comp [us/op1]:\t" + tempoGastoNT/compar);
                        out.println("\t\tT/trocas [us/op2]:\t - (não houve trocas)");
                    }
                    
                    
                    break;

                    
                    
                    
                case 103:
                    
                    
                    
                    break;
                    
                    
                case 104:
                    
                    int[] vetorMERGEOrdenacao;
                    int[] vetorMERGEOrdenacaoTemp;
                    
                    
                    // SAÍDA # Parte #1
                    out.println("************************************************");
                    out.println(" Selecionada OP#2: MERGE-SORT");
                    out.println(" Lido(s): " + numArgums + " argumento(s)!");
                    out.println(" Vetor lido: ");
                    imprimirNumeros(vetLido);
                    out.println();
                    out.println("************************************************");
                    
                    
                    //TODO Compreender a finalidade da linha seguinte! Funcionou? :D
                    vetorMERGEOrdenacao=vetLido;
                    
                    tempoTM1 = System.currentTimeMillis();
                    tempoNT1 = System.nanoTime();
                    
                    /* Comparação <trivial> de Tempo de Execução
                    VIDE Considerações para TEMPO PRECISO (benchmark)
                    Fonte1: https://shipilev.net/blog/2014/nanotrusting-nanotime/
                    e http://openjdk.java.net/projects/code-tools/jmh/
                    */
                    
                    //Chamada do Algoritmo de Ordenação!
                    break;
                    
                default:
                    out.println("Seleção Inválida");
                    break; // Esta parte é opcional
            }
            
        } else out.println("Nada a ser feito. :D Requer 2 ou mais argumentos!");
    } //fim main
    
    
    
    // ALGORITMOS (parte LÓGICA, CONSTRUÍDA paralela ao main()    )
    // Buble_sort
    // Fonte: http://www.java2novice.com/java-sorting-algorithms/bubble-sort/
    //
    public static void bubble_sort(int[] vetorHomog) {
        int n = vetorHomog.length;
        //TODO VIDE OBS #3 DE AULA: PASSAGEM DE PARÂMETROS
        int[] novoVetorHomog = vetorHomog;
        
        int k;
        for (int h = n; h >= 0; h--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                compar+=1;
                if (novoVetorHomog[i] > novoVetorHomog[k]) {
                    trocas+=1;
                    trocaNumeros(i, k, novoVetorHomog);
                }
            }
            imprimirNumeros(vetorHomog);
        }
    }


    // ALGORITMOS (parte LÓGICA, CONSTRUÍDA paralela ao main()    )
    // Buble_sort
    // Fonte: http://www.java2novice.com/java-sorting-algorithms/bubble-sort/
    //
    public static void bubble_sort_otim(int[] vetorHomog) {
        int n = vetorHomog.length;
        //TODO VIDE OBS #3 DE AULA: PASSAGEM DE PARÂMETROS
        int[] novoVetorHomog = vetorHomog;
        
        int k;
        for (int h = n; h >= 0; h--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                compar+=1;
                if (novoVetorHomog[i] > novoVetorHomog[k]) {
                    trocas+=1;
                    trocaNumeros(i, k, novoVetorHomog);
                }
                
            }
            imprimirNumeros(vetorHomog);
        }
    }
    

    
    private static void trocaNumeros(int i, int j, int[] vetorHomog) {
        //TODO Compreender a finalidade da linha seguinte! Funcionou?
        int temp = vetorHomog[i];
        vetorHomog[i] = vetorHomog[j];
        vetorHomog[j] = temp;
        out.print(" trocados elementos! Posições[i:" + i + ",j:"+j+"]. Valores: ");
        out.println( String.valueOf(vetorHomog[i])
                + " <-> " + String.valueOf(vetorHomog[j]));
        
    }
    
    private static void imprimirNumeros(int[] vetorH) {
        //TODO Compreender a finalidade da linha seguinte! Funcionou?
        int[] novoVetorH = vetorH;
        for (int i = 0; i < novoVetorH.length; i++) {
            out.print("|" + novoVetorH[i] + "|");
        }
        out.println("\n");
    }
    
} // fim classe*/

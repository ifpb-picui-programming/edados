/*/* Arquivo: OrdenaVetCLI.java
*
* IFPB - CAMPUS PICUÍ.
* PROGRAMAÇÃO. Turma: POO. 2017.1
*  Prof.: Me. Sergio ESPINOLA. http://mestre.sergiodbe.net/IFPB
*  Objetivo: Este programa é MENU (CLI) com várias opções de java estruturado!
*
*  Data: 21/06/2018.
*/
package net.sergiodbe.mestre.ifpb.edados181;



import static java.lang.System.out;

/**
 *
 * @author Me. Sérgio ESPINOLA <http://mestre.sergiodbe.net/IFPB>
 */
public class OrdenaVetCLI {
    
   /*  V1 = 2 4 6 8 10     (caso melhor)
     -> Tam.=5; ComparaC'C5es= 24; Trocas=8
     V2 = 5 1 12 -5 -16  (caso mC)dio)
     -> Tam.=5; ComparaC'C5es= 24; Trocas=8
     V3 = 12 5 1 -5 -16  (PIOR CASO!)
     -> Tam.=5; ComparaC'C5es=24; Trocas=10
     v4 = 12 5 1 -5 -16 20 30 19 16 2
     -> Tam.=10; ComparaC'C5es= 99; Trocas=21
     v5 = 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1
     -> Tam.=10; ComparaC'C5es= 399; Trocas=190
   */


  static int compar = 0;
  static int trocas = 0;
  
  static int tamVetorOrd = 0;
  static int tamVetorMERGEOrd = 0;

  static long tempoTM1 = 0;
  static long tempoNT1 = 0;

  static long tempoTM2 = 0;
  static long tempoNT2 = 0;

  static long tempoGastoTM = 0;
  static long tempoGastoNT = 0;


  public static void main (String[] argums) {
    int opcao;
      out.println ("---------------------------------------");
      out.println ("| >> IFPB-PC MENU                     |");
      out.println ("|    DISC.: EDADOS             2018.1 |");
      out.println ("|    Turma: 3o Informatica            |");
      out.println ("|    Prof.: Me. Sergio Espinola       |");
      out.println ("| Opcoes para programas:              |");
      out.println ("|  OrdenaVetCLI                       |");
      out.println ("|    <TIPO> [VETOR_N elementos]       |");
      out.println ("|       101 = BUBBLE_SORT (BB)        |");
      out.println ("|       102 =   [BUBBLE_SORT-flag]    |");
      out.println ("|       103 =   [COMB_SORT]           |");
      out.println ("|       104 =   [MERGE_SORT]          |");
      out.println ("|       110 = SELECT_SORT (SS)        |");
      out.println ("|   ex                                |");
      out.println ("|   java OrdenaVetCLI                 |");
      out.println ("|        101 5 1 12 9 7    <- Para BS |");
      out.println ("|        110 5 1 12 9 7    <- Para SS |");
      out.println ("---------------------------------------");

    int numArgums = argums.length;
    if (numArgums >= 1)
      {
	tamVetorOrd = numArgums - 1;
	tamVetorMERGEOrd = numArgums - 1;


	int vetLido[] = new int[tamVetorOrd];
	int vetOrdenacao[] = new int[tamVetorOrd];

	opcao = Integer.parseInt (argums[0]);

	// Ler Vetor
	for (int c = 0; c < numArgums - 1; c++)
	  {
	    // conversao de STRING para int
	    vetLido[c] = Integer.parseInt (argums[c + 1]);
	  }			//fim For

	switch (opcao)
	  {
	  case 101:
	    out.println ("************************************************");
	    out.println (" Selecionada OP#1: BUBLE SORT");
	    out.println (" Lido(s): " + numArgums + " argumento(s)!");
	    out.println (" Vetor lido: ");
	    imprimirNumeros (vetLido);
	    out.println ();
	    out.println ("************************************************");


	    //TODO Compreender a finalidade da linha seguinte! Funcionou? :D
	    vetOrdenacao = vetLido;

	    tempoTM1 = System.currentTimeMillis ();
	    tempoNT1 = System.nanoTime ();

	    /* Comparacao <trivial> de Tempo de Execucao
	       VIDE Consideracoes para TEMPO PRECISO (benchmark)
	       Fonte1: https://shipilev.net/blog/2014/nanotrusting-nanotime/
	       e http://openjdk.java.net/projects/code-tools/jmh/
	     */

	    //Chamada do Algoritmo de Ordenacao!
	    bubble_sort (vetOrdenacao);

	    tempoTM2 = System.currentTimeMillis ();
	    tempoNT2 = System.nanoTime ();

	    tempoGastoTM = Math.abs (tempoTM2 - tempoTM1);
	    tempoGastoNT = Math.abs (tempoNT2 - tempoNT1);


	    out.println ("------------------------------------------------");
	    out.println (" EXECUCAO buble_sort finalizada!");
	    //TODO VIDE OBS #2 DE AULA: PASSAGEM DE PARAMETROS
	    out.println (" Vetor lido?! ");
	    imprimirNumeros (vetLido);
	    out.println ();
	    out.println ("------------------------------------------------");

	    out.println (">>>> Vetor ORDENADO: ");
	    imprimirNumeros (vetOrdenacao);
	    out.println ();
	    exibirEstatisticas(tamVetorOrd, tempoGastoTM, tempoGastoNT, compar, trocas);

	    break; // FIM da OPCAO 101

	  case 102:

	    out.println ("************************************************");
	    out.println (" Selecionada OP#1: BUBLE SORT b");
	    out.println (" Lido(s): " + numArgums + " argumento(s)!");
	    out.println (" Vetor lido: ");
	    imprimirNumeros (vetLido);
	    out.println ();
	    out.println ("************************************************");


	    //TODO Compreender a finalidade da linha seguinte! Funcionou? :D
	    vetOrdenacao = vetLido;

	    tempoTM1 = System.currentTimeMillis ();
	    tempoNT1 = System.nanoTime ();

	    /* Comparacao <trivial> de Tempo de Execucao
	       VIDE, para TEMPO PRECISO (benchmark),
	       Fonte1: https://shipilev.net/blog/2014/nanotrusting-nanotime/
	       e http://openjdk.java.net/projects/code-tools/jmh/
	     */

	    //Chamada do Algoritmo de Ordenacao!
	    bubble_sort_otim (vetOrdenacao);

	    tempoTM2 = System.currentTimeMillis ();
	    tempoNT2 = System.nanoTime ();

	    tempoGastoTM = Math.abs (tempoTM2 - tempoTM1);
	    tempoGastoNT = Math.abs (tempoNT2 - tempoNT1);


	    out.println ("------------------------------------------------");
	    out.println (" EXECUCAO buble_sort_melhor finalizada!");
	    //TODO VIDE OBS #2 DE AULA: PASSAGEM DE PARAMETROS
	    out.println (" Vetor lido?! ");
	    imprimirNumeros (vetLido);
	    out.println ();
	    out.println ("------------------------------------------------");


	    out.println (">>>> Vetor ORDENADO: ");
	    imprimirNumeros (vetOrdenacao);
	    out.println ();
	    exibirEstatisticas(tamVetorOrd, tempoGastoTM, tempoGastoNT, compar, trocas);
	 break; // FIM da OPCAO 102




	  case 103:



	    break;


	  case 104:

	    int[] vetorMERGEOrdenacao;
	    int[] vetorMERGEOrdenacaoTemp;


	    // SAC
	    out.println ("************************************************");
	    out.println (" Selecionada OP#2: MERGE-SORT");
	    out.println (" Lido(s): " + numArgums + " argumento(s)!");
	    out.println (" Vetor lido: ");
	    imprimirNumeros (vetLido);
	    out.println ();
	    out.println ("************************************************");


	    //TODO Compreender a finalidade da linha seguinte! Funcionou? :D
	    vetorMERGEOrdenacao = vetLido;

	    tempoTM1 = System.currentTimeMillis ();
	    tempoNT1 = System.nanoTime ();


	    //Chamada do Algoritmo de Ordenacao!
	    break; // FIM da OPCAO 104


	  case 110:
	    out.println ("************************************************");
	    out.println (" Selecionada OP#10: SELECT_SORT");
	    out.println (" Lido(s): " + numArgums + " argumento(s)!");
	    out.println (" Vetor lido: ");
	    imprimirNumeros (vetLido);
	    out.println ();
	    out.println ("************************************************");


	    //TODO Compreender a finalidade da linha seguinte! Funcionou? :D
	    vetOrdenacao = vetLido;

	    tempoTM1 = System.currentTimeMillis ();
	    tempoNT1 = System.nanoTime ();

	    /* Comparacao <trivial> de Tempo de Execucao
	       VIDE Consideracoes para TEMPO PRECISO (benchmark)
	       Fonte1: https://shipilev.net/blog/2014/nanotrusting-nanotime/
	       e http://openjdk.java.net/projects/code-tools/jmh/
	     */

	    //Chamada do Algoritmo de Ordenacao SS!
	    selection_sort (vetOrdenacao);


	    tempoTM2 = System.currentTimeMillis ();
	    tempoNT2 = System.nanoTime ();

	    tempoGastoTM = Math.abs (tempoTM2 - tempoTM1);
	    tempoGastoNT = Math.abs (tempoNT2 - tempoNT1);


	    out.println ("------------------------------------------------");
	    out.println (" EXECUCAO selection_sort finalizada!");
	    out.println ("------------------------------------------------");

	    out.println (">>>> Vetor ORDENADO (SS): ");
	    imprimirNumeros (vetOrdenacao);
	    out.println ();
	    exibirEstatisticas(tamVetorOrd, tempoGastoTM, tempoGastoNT, compar, trocas);
	  break; // FIM DO 110


	  default:
	    out.println ("Selecao Invalida");
	    break;		// Esta parte eh opcional!
	  }

      }
    else
      out.println ("Nada a ser feito. :D Requer 2 ou mais argumentos!");
  }	//fim MAIN 






  // ALGORITMOS AUX (parte LOGICA, metodos estaticos - procedimentos)
  
  // Buble_sort
  // Fonte: http://www.java2novice.com/java-sorting-algorithms/bubble-sort/
  public static void bubble_sort(int[] _vetorHomog){
    int n = _vetorHomog.length;
    int[] novoVetorHomog = _vetorHomog;

    int k;
    for (int h = n; h >= 0; h--) {
	   for (int i = 0; i < n - 1; i++) {
	     k = i + 1;
	     compar += 1;
	     if (novoVetorHomog[i] > novoVetorHomog[k]) {
		   trocas += 1;
		   trocaNumeros (i, k, novoVetorHomog);
	      }
	   }
	   imprimirNumeros (novoVetorHomog);
    }
  }	//BS



  // ALGORITMOS (parte LOGICA)
  // Selection_sort
  // Fonte:  https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/sorting.html
  //
  public static void selection_sort(int[] _vetorHomog){	    
      int i, j, iMin, aux;
      int n = _vetorHomog.length;
      
      int[] novoVetorHomog = _vetorHomog;
      
	  for (i=0; i<n-1; i=i+1) {
	        iMin = i;        

	        for (j=i+1; j<n; j=j+1) {
	            if (novoVetorHomog[iMin] > novoVetorHomog[j]) {
	                iMin = j;
	            } 
    	        compar += 1;
	            
	        }
	        if (iMin!=i) {
	            
	           aux     = novoVetorHomog[iMin];
	           novoVetorHomog[iMin] = novoVetorHomog[i];
	           novoVetorHomog[i]    = aux;
	           
	           out.print (" trocados elementos! Posicoes[iMin:" + iMin + ", i:" + i +
	                        "]. Valores: ");
               out.println (String.valueOf(novoVetorHomog[iMin]) + " <-> " +
		                    String.valueOf(novoVetorHomog[i]));
         
	           
	           trocas += 1;

	           //trocaNumeros(iMin, i, novoVetorHomog[i]);
	           
	        }
        }
  }



  // ALGORITMOS (parte LOGICA)
  // Buble_sort
  // Fonte: http://www.java2novice.com/java-sorting-algorithms/bubble-sort/
  //
  public static void bubble_sort_otim (int[]vetorHomog)
  {
    int n = vetorHomog.length;
    //TODO VIDE OBS #3 DE AULA: PASSAGEM DE PARAMETROS
    int[] novoVetorHomog = vetorHomog;

    int k;
    for (int h = n; h >= 0; h--)
      {
	for (int i = 0; i < n - 1; i++)
	  {
	    k = i + 1;
	    compar += 1;
	    if (novoVetorHomog[i] > novoVetorHomog[k])
	      {
		trocas += 1;
		trocaNumeros (i, k, novoVetorHomog);
	      }

	  }
	imprimirNumeros (vetorHomog);
      }
  }



  private static void trocaNumeros(int _i, int _j, int[] _vetorHomog)
  {
    //TODO Compreender a finalidade da linha seguinte! Funcionou?
    int temp = _vetorHomog[_i];
    _vetorHomog[_i] = _vetorHomog[_j];
    _vetorHomog[_j] = temp;
    out.print (" trocados elementos! Posicoes[i:" + _i + ",j:" + _j +
	       "]. Valores: ");
    out.println (String.valueOf(_vetorHomog[_i]) + " <-> " +
		 String.valueOf(_vetorHomog[_j]));
  }

  private static void imprimirNumeros (int[]vetorH)
  {
    //TODO Compreender a finalidade da linha seguinte! Funcionou?
    int[] novoVetorH = vetorH;
    for (int i = 0; i < novoVetorH.length; i++)
      {
	out.print ("|" + novoVetorH[i] + "|");
      }
    out.println ("\n");
  }




  private static void exibirEstatisticas(int _tamVetorOrd, long _tempoGastoTM, 
        long _tempoGastoNT, int _compar, int _trocas){
	out.println (" Tamanho:\t\t\t\t" + _tamVetorOrd);
	out.println (" Tempo [currentTimeMillis(), ms]:\t" +
			 _tempoGastoTM);
	out.println (" Tempo [nanoTime()/1000 -> us]:\t\t" +
			 _tempoGastoNT / 1000);
	out.println (" | op1 = Comparacoes(comp):\t\t" + _compar);
	out.println (" | op2 = Trocas:\t\t\t" + _trocas);
	if ( (_trocas != 0) && (_compar != 0) ) {
	   out.println ("\t\tT/comp [us/op1]:\t" +
			     _tempoGastoNT / _compar);
	   out.println ("\t\tT/trocas [us/op2]:\t" +
			     _tempoGastoNT / _trocas);
	}
	else
	    {
            if (_compar == 0)
                out.println ("\t\tT/compar [us/op2]:\t - (nao houve Comparacoes)");
            if (_trocas == 0)
                out.println ("\t\tT/trocas [us/op2]:\t - (nao houve Trocas)");
	    }
      
    }

}				// fim classe*/

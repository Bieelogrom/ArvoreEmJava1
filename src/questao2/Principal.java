package questao2;

import libIntArvore.Arvore;

public class Principal {
	public static void main(String[] args) {
		int[] vetor = {33, 15, 41, 38, 47, 34, 49, 43};
		//Teste int[] vetor = {108, 130, 127, 10, 0, 13, 131, 184, 26, 2, 14, 158, 144, 69, 79, 111};
		Arvore arvore = new Arvore();
		
		for(int i : vetor) {
			arvore.insert(i);
		}
		
		try {
			arvore.prefixSearch();
			System.out.println(" ");
			arvore.infixSearch();
			System.out.println(" ");
			arvore.postfixSearch();
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}

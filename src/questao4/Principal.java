package questao4;

import libIntArvore.Arvore;

public class Principal {
	public static void main(String[] args) {
		int[] vetor = {7, 8, 3, 4, 2, 1, 6, 5};
		Arvore arvore = new Arvore();
		
		for(int i : vetor) {
			arvore.insert(i);
		}
		
		try {
			arvore.remove(7);
			arvore.remove(6);
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

package questao3;

import libCharArvore.Arvore;

public class Principal {
	public static void main(String[] args) {
		
		char[] asciiValores = {77, 70, 83, 68, 74, 80, 85, 65, 69, 72, 81, 84, 87, 75};
		Arvore arvore = new Arvore();
		
		
		for(char i : asciiValores) {
			arvore.insert(i);
		}
		
		try {
			arvore.remove((int)'F');
			arvore.remove((int)'U');
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

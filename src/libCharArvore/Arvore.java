package libCharArvore;

import java.util.NoSuchElementException;

public class Arvore implements IArvore{
	No raiz;
	
	public Arvore() {
		raiz = null;
	}
	

	@Override
	public void insert(char valor) {
		No elemento = new No();
		elemento.dado = valor;
		insertLeaf(elemento, raiz);
	}

	private void insertLeaf(No elemento, No raizDeSubArvore) {
		if(raiz == null) {
			raiz = elemento;
		}else {
			if(elemento.dado < raizDeSubArvore.dado) {
				if(raizDeSubArvore.esquerda == null) {
					raizDeSubArvore.esquerda = elemento;
				} else {
					insertLeaf(elemento, raizDeSubArvore.esquerda);
				}
			}
			if(elemento.dado > raizDeSubArvore.dado) {
				if(raizDeSubArvore.direita == null) {
					raizDeSubArvore.direita = elemento;
				} else {
					insertLeaf(elemento, raizDeSubArvore.direita);
				}
			}
		}
	}


	@Override
	public void search(char valor) {
		try {
			No elemento = nodeSearch(raiz, valor);
			int level = nodeLevel(raiz, valor);
			System.out.println("Dado: "+ elemento.dado + " no nível: "+ level);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private int nodeLevel(No raizDeSubArvore, char valor) {
		if(raiz == null) {
			throw new NoSuchElementException("Árvore vazia!");
		}else if(valor < raizDeSubArvore.dado) {
			return 1 + nodeLevel(raizDeSubArvore.esquerda, valor);
		}else if(valor > raizDeSubArvore.dado) {
			return 1 + nodeLevel(raizDeSubArvore.direita, valor);
		}else {
			return 0;
		}
	}


	private No nodeSearch(No raizDeSubArvore, char valor) {
		if(raiz == null) {
			throw new NoSuchElementException("Árvore vazia!");
		}else if(valor < raizDeSubArvore.dado) {
			return nodeSearch(raizDeSubArvore.esquerda, valor);
		}else if(valor > raizDeSubArvore.dado) {
			return nodeSearch(raizDeSubArvore.direita, valor);
		}else {
			return raizDeSubArvore;
		}
	}


	@Override
	public void remove(int i) {
		try {
			removeChild(raiz, i);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private void removeChild(No raizSubArvore, int i) throws Exception {
		if(exists((char) i)) {
			No elemento = nodeSearch(raizSubArvore, (char) i);
			No parent = nodeParent(null, raiz, (char) i);
			if(elemento.esquerda != null && elemento.direita != null) {
				No noTroca = elemento.esquerda;
				while(noTroca.direita != null) {
					noTroca = noTroca.direita;
				}
				parent = nodeParent(null, raiz, noTroca.dado);
				elemento.dado = noTroca.dado;
				noTroca.dado = (char) i;
				removeOneOrZeroLeaf(parent, noTroca);
			}else {
				removeOneOrZeroLeaf(parent, elemento);
			}
		}else {
			throw new NoSuchElementException("Valor inexistente!");
		}
	}


	private void removeOneOrZeroLeaf(No parent, No elemento) {
		if(elemento.esquerda == null && elemento.direita == null) {
			if(parent == null) {
				raiz = null;
			}else {
				change(parent, elemento, null);
			}
		}else if(elemento.direita != null) {
			if(parent == null) {
				raiz = elemento.direita;
			}else {
				change(parent, elemento, elemento.direita);
			}
		}else {
			if(parent == null) {
				raiz = elemento.esquerda;
			}else {
				change(parent, elemento, elemento.esquerda);
			}
		}
	}


	private void change(No parent, No elemento, No novoNo) {
		if(parent.esquerda != null && parent.esquerda.dado == elemento.dado) {
			parent.esquerda = novoNo;
		}else if(parent.direita.dado == elemento.dado) {
			parent.direita = novoNo;
		}
	}


	private No nodeParent(No parent, No raizDeSubArvore, char valor) throws Exception {
		if(raiz == null) {
			throw new Exception("Arvore vazia!");
		}else if(valor < raizDeSubArvore.dado) {
			return nodeParent(raizDeSubArvore, raizDeSubArvore.esquerda, valor);
		}else if(valor > raizDeSubArvore.dado) {
			return nodeParent(raizDeSubArvore, raizDeSubArvore.direita, valor);
		}else {
			return parent;
		}
	}


	@Override
	public void prefixSearch() throws Exception {
		prefix(raiz);
	}

	private void prefix(No raizSubArvore) throws Exception {
		if(raiz == null) {
			throw new Exception("Arvore vazia!");
		}else {
			System.out.print(raizSubArvore.dado+" ");
			if(raizSubArvore.esquerda != null) {
				prefix(raizSubArvore.esquerda);
			}
			if(raizSubArvore.direita != null) {
				prefix(raizSubArvore.direita);
			}
		}
	}


	@Override
	public void infixSearch() throws Exception {
		infix(raiz);
	}

	private void infix(No raizSubArvore) throws Exception {
		if(raiz == null) {
			throw new Exception("Arvore vazia!");
		}else {
			if(raizSubArvore.esquerda != null) {
				infix(raizSubArvore.esquerda);
			}
			System.out.print(raizSubArvore.dado+" ");
			if(raizSubArvore.direita != null) {
				infix(raizSubArvore.direita);
			}
		}
	}


	@Override
	public void postfixSearch() throws Exception {
		postfix(raiz);
	}

	private void postfix(No raizSubArvore) throws Exception {
		if(raiz == null) {
			throw new Exception("Arvore vazia!");
		}else {
			if(raizSubArvore.esquerda != null) {
				postfix(raizSubArvore.esquerda);
			}
			if(raizSubArvore.direita != null) {
				postfix(raizSubArvore.direita);
			}
			System.out.print(raizSubArvore.dado+" ");
		}
	}


	@Override
	public boolean exists(char valor) {
		try {
			nodeSearch(raiz, valor);
			return true;
		} catch (NoSuchElementException | NullPointerException e) {
			return false;
		}
	}

}

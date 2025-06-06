package libIntArvore;

public interface IArvore {
	
	public void insert(int valor);
	public void search(int valor);
	public void remove(int valor);
	public void prefixSearch() throws Exception;
	public void infixSearch() throws Exception;
	public void postfixSearch() throws Exception;
	public boolean exists(int valor);
	
}

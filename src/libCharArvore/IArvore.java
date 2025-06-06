package libCharArvore;

public interface IArvore {
	public void insert(char valor);
	public void search(char valor);
	public void remove(int valor);
	public void prefixSearch() throws Exception;
	public void infixSearch() throws Exception;
	public void postfixSearch() throws Exception;
	public boolean exists(char valor);
}

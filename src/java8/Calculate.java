package java8;

/*
 * Interface with extension methods
 */

public interface Calculate {
	
	public int add(int a, int b);
	
	public int sub(int a, int b);
	
	public default double sqrt(int a) {
		return Math.sqrt(a);
	}

}

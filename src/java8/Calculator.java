package java8;

public class Calculator implements Calculate{

	@Override
	public int add(int a, int b) {
		return  a + b;
	}

	@Override
	public int sub(int a, int b) {
		return a - b;
	}

}

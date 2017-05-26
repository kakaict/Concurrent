package java8;

public class AllTest {
	
	public static void main(String [] args){
		
		
		Calculator calculator = new Calculator();
		
		System.out.println(calculator.sqrt(15));
		
		PersonFactory<Person> personFactory = Person::new;
		Person f = personFactory.createPerson("f", "l");
		
	}

}

package java8;

public interface PersonFactory <P extends Person> {
	
	public  P createPerson(String fName, String lName); 
	

}

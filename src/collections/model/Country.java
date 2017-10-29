package collections.model;

public class Country {
	
	private String name;
	
	private Integer id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Country(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		if (getId() %2 == 0){
			return 30;
		}
		return 35;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Country other = (Country) obj;
		return other.getName().equalsIgnoreCase(getName());
				
	}
	
	

}

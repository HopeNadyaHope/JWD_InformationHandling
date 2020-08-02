package by.epam.lab02.bean;

public class Headline implements TextElement {
	
	private String number;
	private String name;
	
	public Headline(String number, String name) {
		this.number = number;
		this.name = name;
	}
	
	@Override
	public String getInfo() {
		return number + " " +name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Headline other = (Headline) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  this.getClass().getSimpleName() + " number=" + number + ", name=" + name + "]";
	}
}
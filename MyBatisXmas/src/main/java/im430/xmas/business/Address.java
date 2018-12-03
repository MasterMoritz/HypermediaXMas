package im430.xmas.business;

import java.util.Objects;

public class Address {
	private int id;
	private String text;

	@Override
	public int hashCode() {
		return Objects.hash(text);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(text, other.text);
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Address(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public Address() {
	}

}

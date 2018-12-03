package im430.xmas.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Child {
	private int id;
	private String name;
	private Address address;
	private List<Gift> gifts;

	@Override
	public int hashCode() {
		return Objects.hash(address, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Child other = (Child) obj;
		return Objects.equals(address, other.address) && Objects.equals(name, other.name);
	}

	public Child() {
		gifts = new ArrayList<>();
	}

	public Child(int id, String name, Address address, List<Gift> gift) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.gifts = gift;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public List<Gift> getGifts() {
		return gifts;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setGifts(List<Gift> gift) {
		this.gifts = gift;
	}
	
	public void addGift(Gift gift) {
		if (gifts == null) {
			gifts = new ArrayList<>();
		}
		gifts.add(gift);
	}
	public void removeGift(Gift gift) {
		if (gifts == null) {
			gifts = new ArrayList<>();
		}
		gifts.remove(gift);
	}
}

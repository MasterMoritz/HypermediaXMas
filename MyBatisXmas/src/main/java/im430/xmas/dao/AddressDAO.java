package im430.xmas.dao;

import java.util.List;

import im430.xmas.business.Address;

public interface AddressDAO {
	void addAddress(Address address);

	void updateAddress(Address address);

	void removeAddress(Address address);

	Address getAddressById(int id);

	List<Address> getAllAddresses();

}

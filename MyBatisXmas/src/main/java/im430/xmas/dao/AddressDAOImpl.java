package im430.xmas.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import im430.xmas.business.Address;

@Resource
@Transactional
public class AddressDAOImpl implements AddressDAO {
	static Logger log = LogManager.getFormatterLogger(AddressDAOImpl.class);

	private final String BASE_PATH = "im430.xmas.dao.AddressDAOImpl";

	@Autowired
	private SqlSession sqlSession;

	public AddressDAOImpl() {
	}

	@Override
	public void addAddress(Address address) {
		sqlSession.insert(BASE_PATH + ".addAddress", address);
	}

	@Override
	public void updateAddress(Address address) {
		sqlSession.update(BASE_PATH + ".updateAddress", address);
	}

	@Override
	public void removeAddress(Address address) {
		sqlSession.delete(BASE_PATH + ".removeAddress", address);
		address.setId(-1);
	}

	@Override
	@Transactional(readOnly = true)
	public Address getAddressById(int id) {
		return sqlSession.selectOne(BASE_PATH + ".getAddressById", id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Address> getAllAddresses() {
		return sqlSession.selectList(BASE_PATH + ".getAllAddresses");
	}

}

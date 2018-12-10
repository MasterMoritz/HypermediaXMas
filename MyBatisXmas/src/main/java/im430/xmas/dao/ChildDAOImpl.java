package im430.xmas.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import im430.xmas.business.Address;
import im430.xmas.business.Child;
import im430.xmas.business.Gift;

@Resource
@Transactional
public class ChildDAOImpl implements ChildDAO {

	static Logger log = LogManager.getFormatterLogger(ChildDAOImpl.class);

	private final String BASE_PATH = "im430.xmas.dao.ChildDAOImpl";

	@Autowired
	private SqlSession sqlSession;
	
	public ChildDAOImpl() {
	}
	
	@Override
	@Transactional(readOnly = true)
	public Child getChildById(int id) {
		return sqlSession.selectOne(BASE_PATH + ".getChildById", id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Child> getAllChildren() {
		return sqlSession.selectList(BASE_PATH + ".getAllChildren");
	}

	@Override
	public void addChild(Child child) {
		sqlSession.insert(BASE_PATH + ".addChild", child);
	}

	@Override
	public void removeChild(Child child) {
		sqlSession.delete(BASE_PATH + ".removeChild", child);

	}

	@Override
	public void updateChild(Child child) {
		sqlSession.update(BASE_PATH + "updateChild", child);
	}

	@Override
	public void addGift(Child child, Gift gift) {
		Map<String, Object> params = new HashMap<>();
		params.put("gift", gift);
		params.put("child", child);
		sqlSession.insert(BASE_PATH + ".addGift", params);
		child.addGift(gift);
	}

	@Override
	public void removeGift(Child child, Gift gift) {
		sqlSession.delete(BASE_PATH + ".removeGift", gift);
		child.removeGift(gift);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Child getChildByIdNp1(int id) {
		return sqlSession.selectOne(BASE_PATH + ".getChildByIdNp1", id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Child> getAllChildrenNp1() {
		return sqlSession.selectList(BASE_PATH + ".getAllChildrenNp1");
	}
	
}

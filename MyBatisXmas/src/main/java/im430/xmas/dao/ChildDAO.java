package im430.xmas.dao;

import java.util.List;

import im430.xmas.business.Child;
import im430.xmas.business.Gift;

public interface ChildDAO {
	Child getChildById(int id);

	List<Child> getAllChildren();

	void addChild(Child child);

	void removeChild(Child child);

	void updateChild(Child child);

	void addGift(Child child, Gift gift);

	void removeGift(Child child, Gift gift);

	Child getChildByIdNp1(int id);

	List<Child> getAllChildrenNp1();
	
}

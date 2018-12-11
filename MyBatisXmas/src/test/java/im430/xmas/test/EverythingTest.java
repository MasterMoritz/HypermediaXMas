package im430.xmas.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import im430.xmas.business.Address;
import im430.xmas.business.Child;
import im430.xmas.business.Gift;
import im430.xmas.dao.AddressDAO;
import im430.xmas.dao.ChildDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContextTest.xml")
@Transactional
public class EverythingTest {
	@Autowired
	ChildDAO childDAO;

	@Autowired
	AddressDAO addressDAO;

	@Test
	public void test() {
		Child child = new Child();
		Gift gift = new Gift(-1, "TestGift");
		Gift gift2 = new Gift(-1, "ttstest");

		List<Gift> gifts = new ArrayList<>();
		gifts.add(gift);
		gifts.add(gift2);

		Address address = new Address(-1, "Holberweg 333");
		child.setName("carina2");
		child.setAddress(address);

		addressDAO.addAddress(address);
		assertEquals(address.getText(), addressDAO.getAddressById(address.getId()).getText());

		List<Child> children = childDAO.getAllChildren();
		int size = children.size();
		childDAO.addChild(child);

		assertEquals(size + 1, childDAO.getAllChildren().size());

		childDAO.addGift(child, gift);
		childDAO.addGift(child, gift2);

		child.setGifts(new ArrayList<>());

		child = childDAO.getChildById(child.getId());
		assertEquals(2, child.getGifts().size());

		assertTrue(child.getGifts().contains(gift));
		assertTrue(child.getGifts().contains(gift2));
	}
	
	@Test
	public void testNp1MyBatis() {
		Child child = new Child();
		Gift gift = new Gift(-1, "TestGift");
		Gift gift2 = new Gift(-1, "ttstest");

		List<Gift> gifts = new ArrayList<>();
		gifts.add(gift);
		gifts.add(gift2);

		Address address = new Address(-1, "Holberweg 333");
		child.setName("carina2");
		child.setAddress(address);

		addressDAO.addAddress(address);
		assertEquals(address.getText(), addressDAO.getAddressById(address.getId()).getText());

		List<Child> children = childDAO.getAllChildrenNp1();
		int size = children.size();
		childDAO.addChild(child);

		assertEquals(size + 1, childDAO.getAllChildrenNp1().size());

		childDAO.addGift(child, gift);
		childDAO.addGift(child, gift2);

		child.setGifts(new ArrayList<>());

		child = childDAO.getChildByIdNp1(child.getId());
		assertEquals(2, child.getGifts().size());

		assertTrue(child.getGifts().contains(gift));
		assertTrue(child.getGifts().contains(gift2));
	}
}
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

import com.mysql.fabric.xmlrpc.base.Array;

import im430.xmas.business.Address;
import im430.xmas.business.Child;
import im430.xmas.business.Gift;
import im430.xmas.dao.AddressDAO;
import im430.xmas.dao.ChildDAO;
import static org.junit.Assert.*;

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
		Child childnp1 = new Child();
		Gift gift = new Gift(-1, "TestGift");
		Gift gift2 = new Gift(-1, "ttstest");
		Gift gift3 = new Gift(-1, "mehrTestGift");
		Gift gift4 = new Gift(-1, "nochmehrtstest");
		
		List<Gift> gifts = new ArrayList<>();
		gifts.add(gift);
		gifts.add(gift2);
		
		Address address = new Address(-1,  "Holberweg 333");
		child.setName("carina2");
		child.setAddress(address);
		
		addressDAO.addAddress(address);
		assertEquals(address.getText(), addressDAO.getAddressById(address.getId()).getText());
		
		List<Child> children = childDAO.getAllChildren();
		int size = children.size();
		childDAO.addChild(child);
		
		assertEquals(size + 1, childDAO.getAllChildren().size());
		
		
		List<Gift> giftsnp1 = new ArrayList<>();
		giftsnp1.add(gift3);
		gifts.add(gift4);
		
		Address address2 = new Address(-1,  "Neustadt Zoo");
		childnp1.setName("Carinaoldernow");
		childnp1.setAddress(address);
		
		addressDAO.addAddress(address2);
		assertEquals(address2.getText(), addressDAO.getAddressById(address2.getId()).getText());
		
		
		
		List<Child> childrenNp1 = childDAO.getAllChildrenNp1();
		int size2 = childrenNp1.size();
		childDAO.addChild(childnp1);
		
		assertEquals(size2 + 1, childDAO.getAllChildrenNp1().size());
		
		
		
		childDAO.addGift(child, gift);
		childDAO.addGift(child, gift2);
		
		child.setGifts(new ArrayList<>());
		
		child = childDAO.getChildById(child.getId());
		assertEquals(2, child.getGifts().size());
		
		assertTrue(child.getGifts().contains(gift));
		assertTrue(child.getGifts().contains(gift2));
		
		
		childDAO.addGift(childnp1, gift3);
		childDAO.addGift(childnp1, gift4);
		
		childnp1.setGifts(new ArrayList<>());
		
		childnp1 = childDAO.getChildByIdNp1(childnp1.getId());
		assertEquals(2, childnp1.getGifts().size());
		
		assertTrue(childnp1.getGifts().contains(gift3));
		assertTrue(childnp1.getGifts().contains(gift4));
		
	}

}

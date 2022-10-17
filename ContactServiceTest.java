package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private String longName;
	private String shortPhone;
	private String longAddress;
	
	@BeforeEach
	void setUp() {
		id = "1234567890";
		firstName = "name";
		lastName = "name";
		phone = "1234567890";
		address = "42 Wallaby Way";
		longName = "This is too long to be in a name field";
		shortPhone = "123";
		longAddress = "P Sherman 42 Wallaby Way Sydney needs to be too long for an address";
	}

	@Test
	void testAddContact() {
		ContactService cs = new ContactService();
		cs.addContact(firstName, lastName, phone, address);
		Assertions.assertNotNull(cs.getContactList().get(0).getFirstName());
		Assertions.assertNotNull(cs.getContactList().get(0).getLastName());
		Assertions.assertNotNull(cs.getContactList().get(0).getPhone());
		Assertions.assertNotNull(cs.getContactList().get(0).getAddress());
		Assertions.assertEquals(firstName, cs.getContactList().get(0).getFirstName());
		Assertions.assertEquals(lastName,cs.getContactList().get(0).getLastName());
		Assertions.assertEquals(phone,cs.getContactList().get(0).getPhone());
		Assertions.assertEquals(address,cs.getContactList().get(0).getAddress());
	    
	}
	@Test
	void addLongNameTest() {
		ContactService cs = new ContactService();
		assertThrows(IllegalArgumentException.class,() ->cs.addContact(longName, lastName, phone, address));
	}
	@Test
	void addLongLastNameTest() {
		ContactService cs = new ContactService();
		assertThrows(IllegalArgumentException.class,() ->cs.addContact(firstName, longName, phone, address));
	}
    @Test
    void addNullNameTest() {
    	ContactService cs = new ContactService();
		assertThrows(IllegalArgumentException.class,() ->cs.addContact(null, lastName, phone, address));
    }
    @Test
    void addNullLastNameTest() {
    	ContactService cs = new ContactService();
		assertThrows(IllegalArgumentException.class,() ->cs.addContact(firstName, null, phone, address));
    }
    @Test
    void addShortPhoneTest() {
    	ContactService cs = new ContactService();
		assertThrows(IllegalArgumentException.class,() ->cs.addContact(firstName, lastName, shortPhone, address));
    }
    @Test
    void addNullPhoneTest() {
    	ContactService cs = new ContactService();
		assertThrows(IllegalArgumentException.class,() ->cs.addContact(firstName, lastName, null, address));
    }
    @Test
    void addLongAddressTest() {
    	ContactService cs = new ContactService();
		assertThrows(IllegalArgumentException.class,() ->cs.addContact(firstName, lastName, phone, longAddress));
    }
    @Test
    void addNullAddressTest() {
    	ContactService cs = new ContactService();
		assertThrows(IllegalArgumentException.class,() ->cs.addContact(firstName, lastName, phone, null));
    }
	@Test
	void testDeleteContact() throws Exception {
		ContactService cs = new ContactService();
		cs.addContact(firstName, lastName, phone, address);
		assertEquals(1, cs.getContactList().size());
		cs.deleteContact(cs.getContactList().get(0).getId());
		assertEquals(0, cs.getContactList().size());
	}
	@Test
	void testUpdateName() throws Exception {
		ContactService cs = new ContactService();
		cs.addContact(firstName, lastName, phone, address);
		cs.updateFirstName(cs.getContactList().get(0).getId(), firstName);
		assertEquals(firstName, cs.getContactList().get(0).getFirstName());
		
	}
	@Test 
	void testUdateLastName() throws Exception {
		ContactService cs = new ContactService();
		cs.addContact(firstName, lastName, phone, address);
		cs.updateLastName(cs.getContactList().get(0).getId(), lastName);
		assertEquals(lastName, cs.getContactList().get(0).getLastName());
	}
	@Test
	void testUpdatePhone() throws Exception {
		ContactService cs = new ContactService();
		cs.addContact(firstName, lastName, phone, address);
		cs.updatePhone(cs.getContactList().get(0).getId(), phone);
		assertEquals(phone, cs.getContactList().get(0).getPhone());
	}
	@Test
	void testUpdateAddress() throws Exception {
		ContactService cs = new ContactService();
		cs.addContact(firstName, lastName, phone, address);
		cs.updateAddress(cs.getContactList().get(0).getId(), address);
		assertEquals(address, cs.getContactList().get(0).getAddress());
	}
	
}

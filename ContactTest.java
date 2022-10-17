package contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class ContactTest  {
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
	   id = "0000001234";
	   firstName = "name";
	   lastName = "name";
	   phone = "1234567890";
	   address = "42 Wallaby Way";
	   longName =" This is too long to be a name";
	   shortPhone = "1234";
	   longAddress = "P Sherman 42 Wallaby Way Sydney is too long to be an address";
}

@Test
void testGetContactId() {
	Contact contact = new Contact(id, firstName, lastName, phone, address);
	   assertNotNull(contact.getId());
	   assertEquals(contact.getId().length(),10);
	   assertEquals(id, contact.getId());
}
@Test
void testGetContactFirstName() {
	Contact contact = new Contact(id, firstName, lastName, phone, address);
	assertNotNull(contact.getFirstName());
	assertTrue(contact.getFirstName().length() <=10);
	assertEquals(firstName, contact.getFirstName());
	
}
@Test
void testGetLastName() {
	Contact contact = new Contact(id, firstName, lastName, phone, address);
	assertNotNull(contact.getLastName());
	assertTrue(contact.getLastName().length()<=10);
	assertEquals(lastName, contact.getLastName());
}
@Test 
void testGetPhone() {
	Contact contact = new Contact(id, firstName, lastName, phone, address);
	assertNotNull(contact.getPhone());
	assertTrue(contact.getPhone().length()==10);
	assertEquals(phone, contact.getPhone());
}
@Test 
void testGetAddress() {
	Contact contact = new Contact(id, firstName, lastName, phone, address);
	assertNotNull(contact.getAddress());
	assertTrue(contact.getAddress().length() <=30);
	assertEquals(address, contact.getAddress());
}
@Test
void testSetFirstName() {
	Contact contact = new Contact(id, firstName, lastName, phone, address);
	assertThrows(IllegalArgumentException.class, ()-> contact.setFirstName(null));
	assertThrows(IllegalArgumentException.class, ()-> contact.setFirstName(longName));
	contact.setFirstName(firstName);
	assertEquals(firstName, contact.getFirstName());
}
@Test
void testSetLastName() {
	Contact contact = new Contact(id, firstName, lastName, phone, address);
	assertThrows(IllegalArgumentException.class, ()-> contact.setLastName(null));
	assertThrows(IllegalArgumentException.class, ()-> contact.setLastName(longName));
	contact.setLastName(lastName);
	assertEquals(lastName, contact.getLastName());
}

@Test
void testSetPhone() {
	Contact contact = new Contact(id, firstName, lastName, phone, address);
	assertThrows(IllegalArgumentException.class, ()-> contact.setPhone(null));
	assertThrows(IllegalArgumentException.class, ()-> contact.setPhone(shortPhone));
	contact.setPhone(phone);
	assertEquals(phone, contact.getPhone());
}
@Test
void testSetAddress() {
	Contact contact = new Contact(id, firstName, lastName, phone, address);
	assertThrows(IllegalArgumentException.class, ()-> contact.setAddress(null));
	assertThrows(IllegalArgumentException.class, ()-> contact.setAddress(longAddress));
	contact.setAddress(address);
	assertEquals(address, contact.getAddress());
}

}

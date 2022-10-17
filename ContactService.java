package contact;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ContactService{
//creates list of contacts
   private final List<Contact> contactList = new ArrayList<>();
   
   private String newId() {
	   return UUID.randomUUID().toString().substring(0,Math.min(toString().length(), 10));
   }
   
   public void addContact() {
	   Contact contact = new Contact(newId());
	   contactList.add(contact);
   }
   public void addContact(String firstName, String lastName, String phone, String address) {
	   Contact contact = new Contact(newId(), firstName, lastName, phone, address);
	   contactList.add(contact);
   }
   public void deleteContact(String id) throws Exception {
	   contactList.remove(findId(id));
   }
   public List<Contact> getContactList() {
	   return contactList;
   }
   public Contact findId(String id) throws Exception {
	   int i = 0;
	   while (i < contactList.size()) {
		   if(id.equals(contactList.get(i).getId())) {
			  return contactList.get(i);
		   }
		   i++;
	   }
	   throw new Exception("Contact not found");
   }
   public void updateFirstName(String id, String firstName) throws Exception {
	   findId(id).setFirstName(firstName);
   }
   public void updateLastName(String id, String lastName) throws Exception {
	   findId(id).setLastName(lastName);
   }
   public void updatePhone(String id, String phone) throws Exception {
	   findId(id).setPhone(phone);
   }
   public void updateAddress(String id, String address) throws Exception {
	   findId(id).setAddress(address);
   }
}

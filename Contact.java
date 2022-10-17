package contact;

public class Contact {

	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private String id;
	
    public Contact() {
    	id = "initial";
    	firstName = "name";
    	lastName = "name";
    	phone = "0000000000";
    	address = "initial address";
    }
    public Contact(String id) {
    	if(id == null || id.length() >10) {
    		throw new IllegalArgumentException("Invalid ID");
    	}
    	else {
    		this.id = id;
    	}
    	firstName = "name";
    	lastName = "name";
    	phone = "0000000000";
    	address = "initial address";
    }
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		if(id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		else {
			this.id = id;
		}
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}
	

	
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid name");
		}
		else {
		this.firstName = firstName;
		}
	}
	public void setLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid name");
		}
		else {
		this.lastName = lastName;
		}
	}
	public void setPhone(String phone) {
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		else {
		this.phone = phone;
		}
	}
	public void setAddress(String address) {
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		else {
		this.address = address;
		}
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public String getId() {
		return id;
	}
}

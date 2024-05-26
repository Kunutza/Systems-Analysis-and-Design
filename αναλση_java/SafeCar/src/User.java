import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class User {
	private String name;
	private String password;
	private Permissions permissions = new Permissions();
	private ArrayList<Application> UserApplicationsList = new ArrayList<>();
	
	private static ArrayList<Application> AllApplicationsList = new ArrayList<>();
	private static ArrayList<Customer> AllCustomersList = new ArrayList<>();
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	protected void createNewApplication(Application a) {
		if (this.permissions.getPermission(Permissions.CREATEAPPLICATION) == 0) {
			System.out.println("You do not have permission to create an application");
			return;
		} 
		
		this.UserApplicationsList.add(a);
		User.AllApplicationsList.add(a);	
		
	}
	
	protected void cancelApplication(Application a) {
		if (this.permissions.getPermission(Permissions.CANCELAPPLICATION) == 0) {
			System.out.println("You do not have permission to delete this application");
			return;
		}

		for (int i=0; i<this.UserApplicationsList.size(); i++) {
			if (this.UserApplicationsList.get(i).getApplicationNumber() == a.getApplicationNumber()) {
				this.UserApplicationsList.remove(i);
			}
		}
		for (int i=0; i<User.AllApplicationsList.size(); i++) {
			if (User.AllApplicationsList.get(i).getApplicationNumber() == a.getApplicationNumber()) {
				User.AllApplicationsList.remove(i);
			}
		}
	}
	
	protected void renewApplication(Application a) {
		if (this.permissions.getPermission(Permissions.RENEWAPPLICATION) == 0) {
			System.out.println("You do not have permission to renew this application");
			return;
		}
		
		for (int i=0; i<this.UserApplicationsList.size(); i++) {
			if (this.UserApplicationsList.get(i).getApplicationNumber() == a.getApplicationNumber()) {
				this.UserApplicationsList.get(i).setStatus(Application.status.PENDING);
				this.UserApplicationsList.get(i).setSubmitionDate(LocalDate.now());
				this.UserApplicationsList.get(i).setSubmitionTime(LocalTime.now());
			}
		}
		for (int i=0; i<User.AllApplicationsList.size(); i++) {
			if (User.AllApplicationsList.get(i).getApplicationNumber() == a.getApplicationNumber()) {
				User.AllApplicationsList.get(i).setStatus(Application.status.PENDING);
				User.AllApplicationsList.get(i).setSubmitionDate(LocalDate.now());
				User.AllApplicationsList.get(i).setSubmitionTime(LocalTime.now());
			}
		}
	}
	
	protected void createCustomer(Customer c) {
		if (this.permissions.getPermission(Permissions.CREATECUSTOMER) == 0) {
			System.out.println("You do not have permission to create a new customer");
			return;
		}
		
		User.AllCustomersList.add(c);
	}
	
	// make setter for CustomersList in order to check for permissions of Users
	// I make no getter for CustomerList here because everyone can see the CustomersList
	protected void editCustomerFullName(Customer c, String nfn) {
		if (this.permissions.getPermission(Permissions.EDITCUSTOMERDETAILS) == 0) {
			System.out.println("You do not have permission to edit customer details");
			return;
		}
		
		for (int i=0; i<User.AllCustomersList.size(); i++) {
			if (User.AllCustomersList.get(i).getCustomerFullName() == c.getCustomerFullName()) {
				User.AllCustomersList.get(i).setCustomerFullName(nfn);
			}
		}
			
	}
	
	protected void editCustomerBirthDate(Customer c, LocalDate nbd) {
		if (this.permissions.getPermission(Permissions.EDITCUSTOMERDETAILS) == 0) {
			System.out.println("You do not have permission to edit customer details");
			return;
		}
		
		for (int i=0; i<User.AllCustomersList.size(); i++) {
			if (User.AllCustomersList.get(i).getCustomerBirthDate() == c.getCustomerBirthDate()) {
				User.AllCustomersList.get(i).setCustomerBirthDate(nbd);
			}
		}
			
	}
	
	protected void editCustomerStreetAddress(Customer c, String nsa) {
		if (this.permissions.getPermission(Permissions.EDITCUSTOMERDETAILS) == 0) {
			System.out.println("You do not have permission to edit customer details");
			return;
		}
		
		for (int i=0; i<User.AllCustomersList.size(); i++) {
			if (User.AllCustomersList.get(i).getCustomerStreetAddress() == c.getCustomerStreetAddress()) {
				User.AllCustomersList.get(i).setCustomerStreetAddress(nsa);
			}
		}
			
	}
	
	protected void editCustomerDrivingLicenseNumber(Customer c, String ndln) {
		if (this.permissions.getPermission(Permissions.EDITCUSTOMERDETAILS) == 0) {
			System.out.println("You do not have permission to edit customer details");
			return;
		}
		
		for (int i=0; i<User.AllCustomersList.size(); i++) {
			if (User.AllCustomersList.get(i).getDrivingLicenseNumber() == c.getDrivingLicenseNumber()) {
				User.AllCustomersList.get(i).setDrivingLicenseNumber(ndln);
			}
		}
			
	}
	
	protected ArrayList<Application> getAllApplicationsList() {
		return User.AllApplicationsList;
	}
	
	protected ArrayList<Application> getUserApplicationsList() {
		return this.UserApplicationsList;
	}
	
	protected String getName() {
		return this.name;
	}
	
	protected Permissions getPermissions() {
		return this.permissions;
	}
	
	protected String getPassword() {
		return this.password;
	}
	
	protected void createReport() {
		return;
	}
}

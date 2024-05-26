import java.time.LocalDate;

public class Customer {
	private Integer CustomerNumber;
	private String CustomerFullName;
	private LocalDate CustomerBirthDate;
	private String CustomerStreetAddress;
	private String DrivingLicenseNumber;

	public Customer(
			Integer CustomerNumber, 
			String CustomerFullName, 
			LocalDate CustomerBirthDate,
			String CustomerStreetAddress,
			String DrivingLicenseNumber) {
		
		this.CustomerNumber = CustomerNumber;
		this.CustomerFullName = CustomerFullName;
		this.CustomerBirthDate = CustomerBirthDate;
		this.CustomerStreetAddress = CustomerStreetAddress;
		this.DrivingLicenseNumber = DrivingLicenseNumber;
	}
	
	protected Integer getCustomerNumber() {
		return this.CustomerNumber;
	}
	
	protected String getCustomerFullName() {
		return this.CustomerFullName;
	}
	
	protected LocalDate getCustomerBirthDate() {
		return this.CustomerBirthDate;
	}
	
	protected String getCustomerStreetAddress() {
		return this.CustomerStreetAddress;
	}
	
	protected String getDrivingLicenseNumber() {
		return this.DrivingLicenseNumber;
	}
	
	protected void setCustomerNumber(Integer CustomerNumber) {
		this.CustomerNumber = CustomerNumber;
	}
	
	protected void setCustomerFullName(String CustomerFullName) {
		this.CustomerFullName = CustomerFullName;
	}
	
	protected void setCustomerBirthDate(LocalDate CustomerBirthDate) {
		this.CustomerBirthDate = CustomerBirthDate;
	}

	protected void setCustomerStreetAddress(String CustomerStreetAddress) {
		this.CustomerStreetAddress = CustomerStreetAddress;
	}
	
	protected void setDrivingLicenseNumber(String DrivingLicenseNumder) {
		this.DrivingLicenseNumber = DrivingLicenseNumder;
	}
}

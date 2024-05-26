import java.time.LocalDate;
import java.time.LocalTime;

public class Application {
	public static enum status {COMPLETE, PENDING, REJECTED}
	
	private Integer ApplicationNumber;
	private LocalDate submitionDate = LocalDate.now();
	private LocalTime submitionTime = LocalTime.now();
	private status Status = status.PENDING;
	private String CustomerFullName;
	private String ApplicationDetails;
	
	public Application(Integer ApplicationNumber, String CustomerFullName, String ApplicationDetails) {
		this.ApplicationNumber = ApplicationNumber;
		this.CustomerFullName = CustomerFullName;
		this.ApplicationDetails = ApplicationDetails;
	}

	protected Integer getApplicationNumber() {
		return this.ApplicationNumber;
	}
	
	protected LocalDate getsubmitionDate() {
		return this.submitionDate;
	}

	protected LocalTime getsubmitionTime() {
		return this.submitionTime;
	}
	
	protected status getStatus() {
		return this.Status;
	}
	
	protected void setSubmitionDate(LocalDate date) {
		this.submitionDate = date;
	}
	
	protected void setSubmitionTime(LocalTime time) {
		this.submitionTime = time;
	}
	
	// The user does not change the status, it is supposed to change on its own 
	// after the insurance agency accepts or declines
	protected void setStatus(status s) {
		this.Status = s;
	}
	
	public String getCustomerFullName() {
		return this.CustomerFullName;
	}
	
	public String getApplicationDetails() {
		return this.ApplicationDetails;
	}
}

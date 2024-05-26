import java.util.HashMap;
import java.util.Map;

public class Permissions {
	
	public static final String ISADMIN = "isAdmin";
	public static final String CREATEUSER = "createUser";
	public static final String EDITUSER = "editUser";
	public static final String DELETEUSER = "deleteUser";
	public static final String CREATEREPORT = "createReport";
	public static final String CREATEAPPLICATION = "createApplication";
	public static final String CANCELAPPLICATION = "cancelApplication";
	public static final String RENEWAPPLICATION = "renewApplication";
	public static final String GETAPPLICATIONSTATUS = "getApplicationStatus";
	public static final String GETAPPLICATIONDETAILS = "getApplicationDetails";
	public static final String CREATECUSTOMER = "createCustomer";
	public static final String GETCUSTOMERDETAILS = "getCustomerDetails";
	public static final String EDITCUSTOMERDETAILS = "editCustomerDetails";
	
	private Map<String, Integer> permissionsMap = new HashMap<String, Integer>(){

	{
		put(ISADMIN, 0);
		put(CREATEUSER, 0);
		put(EDITUSER, 0);
		put(DELETEUSER, 0);
		put(CREATEREPORT, 0);
		put(CREATEAPPLICATION, 0);
		put(CANCELAPPLICATION, 0);
		put(RENEWAPPLICATION, 0);
		put(GETAPPLICATIONSTATUS, 0);
		put(GETAPPLICATIONDETAILS, 0);
		put(CREATECUSTOMER, 0);
		put(GETCUSTOMERDETAILS, 0);
		put(EDITCUSTOMERDETAILS, 0);
	}};
	
	protected Integer getPermission(String perm_name) {
		return this.permissionsMap.get(perm_name);
	}
	
	protected void changePermission(String perm_name, Integer value) {
		this.permissionsMap.replace(perm_name, value);
	}
		
}

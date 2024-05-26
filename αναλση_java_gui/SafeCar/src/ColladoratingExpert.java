
public class ColladoratingExpert extends User{

	public ColladoratingExpert(String name, String password) {
		super(name, password);
		this.setCollaboratingExpertDefaultPermissions();
		
	}

	private void setCollaboratingExpertDefaultPermissions() {
		getPermissions().changePermission(Permissions.ISADMIN, 0);
		getPermissions().changePermission(Permissions.CREATEUSER, 0);
		getPermissions().changePermission(Permissions.EDITUSER, 0);
		getPermissions().changePermission(Permissions.DELETEUSER, 0);
		getPermissions().changePermission(Permissions.CREATEREPORT, 0);
		getPermissions().changePermission(Permissions.CREATEAPPLICATION, 0);
		getPermissions().changePermission(Permissions.CANCELAPPLICATION, 0);
		getPermissions().changePermission(Permissions.RENEWAPPLICATION, 0);
		getPermissions().changePermission(Permissions.GETAPPLICATIONSTATUS, 1);
		getPermissions().changePermission(Permissions.GETAPPLICATIONDETAILS, 1);
		getPermissions().changePermission(Permissions.CREATECUSTOMER, 0);
		getPermissions().changePermission(Permissions.GETCUSTOMERDETAILS, 1);
		getPermissions().changePermission(Permissions.EDITCUSTOMERDETAILS, 0);
	}
}

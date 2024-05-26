public class Owner extends User {

	public Owner(String name, String password) {
		super(name, password);
		this.setOwnerDefaultPermissions();
	}
	
	private void setOwnerDefaultPermissions() {
		getPermissions().changePermission(Permissions.ISADMIN, 1);
		getPermissions().changePermission(Permissions.CREATEUSER, 1);
		getPermissions().changePermission(Permissions.EDITUSER, 1);
		getPermissions().changePermission(Permissions.DELETEUSER, 1);
		getPermissions().changePermission(Permissions.CREATEREPORT, 1);
		getPermissions().changePermission(Permissions.CREATEAPPLICATION, 1);
		getPermissions().changePermission(Permissions.CANCELAPPLICATION, 1);
		getPermissions().changePermission(Permissions.RENEWAPPLICATION, 1);
		getPermissions().changePermission(Permissions.GETAPPLICATIONSTATUS, 1);
		getPermissions().changePermission(Permissions.GETAPPLICATIONDETAILS, 1);
		getPermissions().changePermission(Permissions.CREATECUSTOMER, 1);
		getPermissions().changePermission(Permissions.GETCUSTOMERDETAILS, 1);
		getPermissions().changePermission(Permissions.EDITCUSTOMERDETAILS, 1);
	}

}

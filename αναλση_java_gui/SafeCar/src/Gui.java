import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;

import java.util.Properties;
import org.jdatepicker.impl.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

// TODO 
//WHEN I DO AN ACTION RESET THE SCREEN FOR FEEDBACK (SAVE, DELETE, EDIT ETC)
// RENEW APPLICATION
// REPORT THIS WILL NOT BE DONE

@SuppressWarnings("serial")
public class Gui extends JFrame {
	// login screen components
   JLabel username_label, password_label;
   PlaceholderTextField username_textfield, password_textfield;
   JButton login_btn;
   
   // components app screen after login
   // view applications
   GridBagConstraints gbcmc;
   JMenuBar menuBar;
   JMenu ApplicationsMenu;
   JLabel applicationNumlabel;
   JLabel customer_name_label;
   JLabel date_label;
   JLabel time_label;
   JLabel status_label;
   JLabel details_label;
   JPanel buttonPanel;
   // create application
   GridBagConstraints gbcna; 
   JButton newApplicationbtn;
   JLabel customerFullNamelbl;
   JLabel ApplicationDetailslbl;
   PlaceholderTextField ApplicationDetailstxtfld;
   PlaceholderTextField fullNametxtfld;
   // cancel application
   GridBagConstraints gbcca;
   JButton cancelApplicationbtn;
   JLabel deleteApplicationlabel;
   PlaceholderTextField ApplicationNumtxtfld;
   // view costumers
   JMenu CustomersMenu;
   GridBagConstraints gbcvc;
   JLabel CustomerNumlabel;
   JLabel birth_date_label;
   JLabel strt_addr_label;
   JLabel dln_label;
   // view my applications
   GridBagConstraints gbcmm;
   // create customer
   GridBagConstraints gbcc;
   JButton newCustomerbtn;	
   PlaceholderTextField customerStreetAddresstxtfld;
   PlaceholderTextField dlntxtfld;
   JDatePickerImpl datePicker;
   // edit customer details
   GridBagConstraints gbcce;
   PlaceholderTextField customerNumtxtfld;
   JButton editCustomerbtn;
   // view Users
   JMenu UsersMenu;
   GridBagConstraints gbcvu;
   JLabel user_username_label;
   JLabel user_password_label;
   // create Users
   GridBagConstraints gbccu; 
   PlaceholderTextField user_username_txtfld;
   PlaceholderTextField user_password_txtfld;
   JButton createUserbtn;
   // edit user
   GridBagConstraints gbceu;
   JButton EditUserbtn;
   // delete User
   GridBagConstraints gbcdu; 
   JButton deleteUserbtn;
   
   ArrayList<User> UserList = new ArrayList<>();
   User currentUser;
   
   

   // Constructor
   public Gui() {
	   UserList.add(new Owner("Γιώργος Γεωργίου", "Owner"));
	   UserList.add(new AdministrativeStaff("Βασίλης Βασιλειάδης", "AdministrativeStaff1"));
	   UserList.add(new AdministrativeStaff("Ζαχαρούλα Ζαχαρειάδου", "AdministrativeStaff2"));
	   UserList.add(new ColladoratingExpert("Αναστάσιος Αναστασιάδης", "CollaboratingExpert1"));
	   UserList.add(new ColladoratingExpert("Δήμητρα Δημητριάδου", "CollaboratingExpert2"));
	   UserList.add(new ColladoratingExpert("Ιωάννα Ιωαννίδου", "CollaboratingExpert3"));
	   UserList.add(new InsuranceAgent("Ελευτέριος Ελευτεριάδης", "InsuranceAgent1"));
	   UserList.add(new InsuranceAgent("Αλέξανδρος Αλεξανδρόπουλος", "InsuranceAgent2"));
	   UserList.add(new InsuranceAgent("Κωνσταντίνος Κωνσταντόπουλος", "InsuranceAgent3"));
	   UserList.add(new InsuranceAgent("Άγγελος Αγγελόπουλος", "InsuranceAgent4"));
	   UserList.add(new InsuranceAgent("Αλεξάνδρα Αλεξανδρίδου", "InsuranceAgent5"));
	   UserList.add(new InsuranceAgent("Κωνσταντίνα Κωνσταντινίδου", "InsuranceAgent6"));
	   UserList.add(new InsuranceAgent("Θεόδωρος Θεοδωριάδης", "InsuranceAgent7"));
	   UserList.add(new InsuranceAgent("Πέτρος Πετρόπουλος", "InsuranceAgent8"));
	   UserList.add(new InsuranceAgent("Αγάπη Αγαποπούλου", "InsuranceAgent9"));
	   UserList.add(new InsuranceAgent("Μαρίνα Μαρινοπούλου", "InsuranceAgent10"));
	
	   UserList.get(1).createNewApplication(new Application(1, "Alex", "kristala"));
	   UserList.get(2).createNewApplication(new Application(2, "Alex", "kristala"));
	   UserList.get(0).createNewApplication(new Application(3, "Ep", "amaxia"));
	   UserList.get(0).createNewApplication(new Application(4, "Pet", "skilia"));
	   
	   UserList.get(0).createCustomer(new Customer(1, "Nikitas ads", LocalDate.now(), "street", "123asda1123"));
	   UserList.get(0).createCustomer(new Customer(2, "Giorgis", LocalDate.now(), "Spiti", "8918d18123"));
	   
	   System.out.println(UserList.get(1).getUserApplicationsList().get(0).getApplicationNumber());
	   System.out.println(UserList.get(0).getAllApplicationsList().get(1).getApplicationNumber());
		

	   this.initLoginScreen();
   }
   // ActionListener for the login button
   private ActionListener loginButtonListener = new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           String username = username_textfield.getText();
           String password = password_textfield.getText();
           if(!username.equals(username_textfield.getPlaceholder()) && !password.equals(password_textfield.getPlaceholder())) {
        	   
        	   for (User user: UserList) {
        		   if (user.getName().equals(username) && user.getPassword().equals(password)) {
        			   getContentPane().removeAll();
        			   revalidate();
        			   repaint();
        			   currentUser = user;
        			   
        			   initMainScreen();
        			   return;
        		   }
        	   }
        	   
        	   // Login failed
        	   JOptionPane.showMessageDialog(null, "Invalid username or password!");
        	   
           }
       }
   };
   
   private ActionListener editCustomerButtonListener = new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   String fullname = fullNametxtfld.getText();
		   java.util.Date selectedDate = (java.util.Date) datePicker.getModel().getValue();
		   String street_address = customerStreetAddresstxtfld.getText();
		   String dln = dlntxtfld.getText();
		   String num = customerNumtxtfld.getText();
		   try {
			    Integer.parseInt(num);
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Insert a number");
				return;
			}
		   
		   // find the if the num exists in the list
		   for (Customer customer: currentUser.getAllCustomersList()) {
			   if (customer.getCustomerNumber() == Integer.parseInt(num)) {
				   customer.setCustomerFullName(fullname);
				   customer.setCustomerBirthDate(Instant.ofEpochMilli(selectedDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
				   customer.setCustomerStreetAddress(street_address);
				   customer.setDrivingLicenseNumber(dln);
				   editCustomers();
				   return;
			   }
		   }
		   JOptionPane.showMessageDialog(null, "No customer with this index was found");
	   }
   };
   
   private ActionListener createCustomerButtonListener = new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   Integer number = 0;
		   if (currentUser.getAllCustomersList().size() > 0) {
			   number = currentUser.getAllCustomersList().get(currentUser.getAllCustomersList().size() - 1).getCustomerNumber() + 1;
		   }
			   
		   String fullname = fullNametxtfld.getText();
		   java.util.Date selectedDate = (java.util.Date) datePicker.getModel().getValue();
		   String street_address = customerStreetAddresstxtfld.getText();
		   String dln = dlntxtfld.getText();
		   
		   if (fullname.equals(fullNametxtfld.getPlaceholder())) {
			   JOptionPane.showMessageDialog(null, "No name selected");
			   return;
		   }
		   if (selectedDate == null) {
			   JOptionPane.showMessageDialog(null, "No Date Selected");
			   return;
		   }
		   if (street_address.equals(customerStreetAddresstxtfld.getPlaceholder())) {
			   JOptionPane.showMessageDialog(null, "No street address selected");
			   return;
		   }
		   if (dln.equals(dlntxtfld.getPlaceholder())) {
			   JOptionPane.showMessageDialog(null, "No driving license number selected");
			   return;
		   }
		   
		   currentUser.createCustomer(new Customer(number, fullname, 
				   Instant.ofEpochMilli(selectedDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate(), 
				   street_address, dln));

		   createCustomers();
	   }
   };
   
   private ActionListener createApplicationButtonListener = new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   Integer number = 0;
		   if (currentUser.getAllApplicationsList().size() > 0) {
			   number = currentUser.getAllApplicationsList().get(currentUser.getAllApplicationsList().size() - 1).getApplicationNumber() + 1;
		   }
		   String fullname = fullNametxtfld.getText();
		   String details = ApplicationDetailstxtfld.getText();
		   
		   if (details.equals(ApplicationDetailstxtfld.getPlaceholder()) || fullname.equals(fullNametxtfld.getPlaceholder())) {
			   JOptionPane.showMessageDialog(null, "Not all application fields are complete");
			   return;
		   }
		   
		   currentUser.createNewApplication(new Application(
				   currentUser.getAllApplicationsList().get(currentUser.getAllApplicationsList().size() - 1).getApplicationNumber() + 1, 
				   fullname, details));

		   newApplication();
	   }
   };
   
   private ActionListener viewmyApplicationButtonListener = new ActionListener() {
	   @Override
       public void actionPerformed(ActionEvent e) {
getContentPane().removeAll();
		   
		   displayMainScreenMenu();
		   
		   setLayout(new GridBagLayout());
		   gbcmm = new GridBagConstraints();
		   
		   buttonPanel = new JPanel();
		    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		    
		    for (Application application: currentUser.getUserApplicationsList()) {
		    	JButton button = new JButton("App " + application.getApplicationNumber().toString());
		    	button.setPreferredSize(new Dimension(132, 24));
		    	button.setMaximumSize(new Dimension(132, 24));
		    	button.addActionListener(ApplicationButtonListener);
		    	buttonPanel.add(button);
		    }
		    

		    // Set a preferred size for the button panel to ensure proper scrolling
		    buttonPanel.setPreferredSize(new Dimension(132, 24*currentUser.getAllApplicationsList().size())); // Adjust dimensions as needed
		   
		    JScrollPane scrollPane = new JScrollPane(buttonPanel);
		    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		    scrollPane.setPreferredSize(new Dimension(150, 300)); // Adjust dimensions as needed
		    
		    // Add the scroll pane to the frame with appropriate layout constraints
		    gbcmm.gridx = 0;
		    gbcmm.gridy = 0;
		    gbcmm.gridheight = 7;
		    gbcmm.anchor = GridBagConstraints.CENTER;
		    add(scrollPane, gbcmm);
		    
		    applicationNumlabel = new JLabel("Application: -");
		    gbcmm.gridx = 1;  
		    gbcmm.gridy = 0;
		    gbcmm.gridheight = 1;
		    gbcmm.weightx = 1.0;
		    gbcmm.insets = new Insets(0, 100, 10, 0);
		    gbcmm.anchor = GridBagConstraints.WEST;
		    add(applicationNumlabel, gbcmm);
		    
		    customer_name_label = new JLabel("Fullname: -");
		    gbcmm.gridx = 1;  
		    gbcmm.gridy = 1;
		    gbcmm.gridheight = 1;
		    gbcmm.weightx = 1.0;
		    add(customer_name_label, gbcmm);
		    
		    date_label = new JLabel("Date: -");
		    gbcmm.gridx = 1;  
		    gbcmm.gridy = 2;
		    gbcmm.gridheight = 1;
		    gbcmm.weightx = 1.0;
		    add(date_label, gbcmm);
		    
		    time_label = new JLabel("Time: -");
		    gbcmm.gridx = 1; 
		    gbcmm.gridy = 3;
		    gbcmm.weightx = 1.0;
		    add(time_label, gbcmm);
		    
		    status_label = new JLabel("Status: -");
		    gbcmm.gridx = 1;  
		    gbcmm.gridy = 4;
		    gbcmm.weightx = 1.0;
		    add(status_label, gbcmm);
		    
		    details_label = new JLabel("Details: -");
		    gbcmm.gridx = 1;  
		    gbcmm.gridy = 5;
		    gbcmm.weightx = 1.0;
		    add(details_label, gbcmm);
		    
		    
		    
		    revalidate();
			repaint();
	   }
   };
   
   private ActionListener viewApplicationButtonListener = new ActionListener() {
	   @Override
       public void actionPerformed(ActionEvent e) {
		   getContentPane().removeAll();
		   
		   displayMainScreenMenu();
		   
		   setLayout(new GridBagLayout());
		   gbcmc = new GridBagConstraints();
		   
		   buttonPanel = new JPanel();
		    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		    
		    for (Application application: currentUser.getAllApplicationsList()) {
		    	JButton button = new JButton("App " + application.getApplicationNumber().toString());
		    	button.setPreferredSize(new Dimension(132, 24));
		    	button.setMaximumSize(new Dimension(132, 24));
		    	button.addActionListener(ApplicationButtonListener);
		    	buttonPanel.add(button);
		    }
		    

		    // Set a preferred size for the button panel to ensure proper scrolling
		    buttonPanel.setPreferredSize(new Dimension(132, 24*currentUser.getAllApplicationsList().size())); // Adjust dimensions as needed
		   
		    JScrollPane scrollPane = new JScrollPane(buttonPanel);
		    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		    scrollPane.setPreferredSize(new Dimension(150, 300)); // Adjust dimensions as needed
		    
		    
		    gbcmc.gridx = 0; 
		    gbcmc.gridy = 0;
		    gbcmc.gridheight = 7;
		    gbcmc.anchor = GridBagConstraints.CENTER;
		    add(scrollPane, gbcmc);
		    
		    applicationNumlabel = new JLabel("Application: -");
		    gbcmc.gridx = 1;  
		    gbcmc.gridy = 0;
		    gbcmc.gridheight = 1;
		    gbcmc.weightx = 1.0;
		    gbcmc.insets = new Insets(0, 100, 10, 0);
		    gbcmc.anchor = GridBagConstraints.WEST;
		    add(applicationNumlabel, gbcmc);
		    
		    customer_name_label = new JLabel("Fullname: -");
		    gbcmc.gridx = 1;  
		    gbcmc.gridy = 1;
		    gbcmc.gridheight = 1;
		    gbcmc.weightx = 1.0;
		    add(customer_name_label, gbcmc);
		    
		    date_label = new JLabel("Date: -");
		    gbcmc.gridx = 1; 
		    gbcmc.gridy = 2;
		    gbcmc.gridheight = 1;
		    gbcmc.weightx = 1.0;
		    add(date_label, gbcmc);
		    
		    time_label = new JLabel("Time: -");
		    gbcmc.gridx = 1; 
		    gbcmc.gridy = 3;
		    gbcmc.weightx = 1.0;
		    add(time_label, gbcmc);
		    
		    status_label = new JLabel("Status: -");
		    gbcmc.gridx = 1;  
		    gbcmc.gridy = 4;
		    gbcmc.weightx = 1.0;
		    add(status_label, gbcmc);
		    
		    details_label = new JLabel("Details: -");
		    gbcmc.gridx = 1;  
		    gbcmc.gridy = 5;
		    gbcmc.weightx = 1.0;
		    add(details_label, gbcmc);
		    
		    
		    
		    revalidate();
			repaint();
       }
   };
   
   private ActionListener deleteApplicationButtonListener = new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   String num = ApplicationNumtxtfld.getText();
		   
		   if (num.equals(ApplicationNumtxtfld.getPlaceholder())) {
			   JOptionPane.showMessageDialog(null, "Insert an application number");
			   return;
		   }
		   try {
			    Integer.parseInt(num);
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Insert a number");
				return;
			}
		   if (Integer.parseInt(num) < 0) {
			   JOptionPane.showMessageDialog(null, "Number is too small");
			   return;
		   }
		   if (Integer.parseInt(num) >= currentUser.getAllApplicationsList().get(currentUser.getAllApplicationsList().size() - 1).getApplicationNumber()) {
			   JOptionPane.showMessageDialog(null, "Number is too big");
			   return;
		   }
		   
		   
		   if (!currentUser.cancelApplication(new Application(Integer.parseInt(num), "", ""))) {
			   JOptionPane.showMessageDialog(null, "Could not find application with application number. Please try to delete an application that you yourself have created" + Integer.parseInt(num) + ".");
			   return;
		   };
	   }
   };
   
   private class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
	    private String datePattern = "yyyy-MM-dd";
	    private java.text.SimpleDateFormat dateFormatter = new java.text.SimpleDateFormat(datePattern);

	    @Override
	    public Object stringToValue(String text) throws java.text.ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value) throws java.text.ParseException {
	        if (value != null) {
	            java.util.Calendar cal = (java.util.Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }
	        return "";
	    }
   }
   
   private ActionListener createCustomersButtonListener = new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   createCustomers();
	   }
   };
   
   private void createCustomers() {
	   getContentPane().removeAll();
	   
	   displayMainScreenMenu();
	   
	   setLayout(new GridBagLayout());
	   gbcc = new GridBagConstraints();
	   
	   if (currentUser.getPermissions().getPermission(Permissions.CREATECUSTOMER) == 1) {
		   
		   newCustomerbtn = new JButton("Create Customer");
		   newCustomerbtn.addActionListener(createCustomerButtonListener);
		   newCustomerbtn.setPreferredSize(new Dimension(165, 24));
		   newCustomerbtn.setMaximumSize(new Dimension(165, 24));
		   gbcc.gridx = 0; 
		   gbcc.gridy = 0	;
		   gbcc.weightx = 1.0;
		   add(newCustomerbtn);
		   
		   customerFullNamelbl = new JLabel("Fullname: ");
		   gbcc.anchor = GridBagConstraints.EAST;
		   gbcc.gridx = 1;  
		   gbcc.gridy = 0;
		   gbcc.weightx = 1.0;
		   add(customerFullNamelbl, gbcc);
		   
		   fullNametxtfld = new PlaceholderTextField("Fullname", 20);
		   gbcc.anchor = GridBagConstraints.WEST;
		   gbcc.gridx = 2;  
		   gbcc.gridy = 0	;
		   gbcc.weightx = 1.0;
		   add(fullNametxtfld, gbcc);
		   
		   birth_date_label = new JLabel("Birth Date: ");
		   gbcc.anchor = GridBagConstraints.EAST;
		   gbcc.gridx = 1;  
		   gbcc.gridy = 1;
		   gbcc.weightx = 1.0;
		   add(birth_date_label, gbcc);
		   
		   UtilDateModel model = new UtilDateModel();
	        Properties p = new Properties();
	        p.put("text.today", "Today");
	        p.put("text.month", "Month");
	        p.put("text.year", "Year");
	        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
	        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	        gbcc.anchor = GridBagConstraints.WEST;
			gbcc.gridx = 2;  
			gbcc.gridy = 1;
			gbcc.weightx = 1.0;
	        add(datePicker, gbcc);
		   
		   strt_addr_label = new JLabel("Street Address: ");
		   gbcc.anchor = GridBagConstraints.EAST;
		   gbcc.gridx = 1;  
		   gbcc.gridy = 2	;
		   gbcc.weightx = 1.0;
		   add(strt_addr_label, gbcc);
		   
		   customerStreetAddresstxtfld = new PlaceholderTextField("Street Address", 20);
		   gbcc.anchor = GridBagConstraints.WEST;
		   gbcc.gridx = 2;  
		   gbcc.gridy = 2	;
		   gbcc.weightx = 1.0;
		   add(customerStreetAddresstxtfld, gbcc);
		   
		   dln_label = new JLabel("Driving License Number: ");
		   gbcc.anchor = GridBagConstraints.EAST;
		   gbcc.gridx = 1; 
		   gbcc.gridy = 3	;
		   gbcc.weightx = 1.0;
		   add(dln_label, gbcc);
		   
		   dlntxtfld = new PlaceholderTextField("Driving License Number", 20);
		   gbcc.anchor = GridBagConstraints.WEST;
		   gbcc.gridx = 2;  
		   gbcc.gridy = 3	;
		   gbcc.weightx = 1.0;
		   add(dlntxtfld, gbcc);
		   
	   }
	   
	   
	   revalidate();
		repaint();
   }
   
   private ActionListener createUserButtonListener = new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   // user_username_txtfld
		   // user_password_txtfld
		   if (user_username_txtfld.getText().equals(user_username_txtfld.getPlaceholder())) {
			   JOptionPane.showMessageDialog(null, "Please enter a username.");
			   return;
		   }
		   if (user_password_txtfld.getText().equals(user_password_txtfld.getPlaceholder())) {
			   JOptionPane.showMessageDialog(null, "Please enter a password.");
			   return;
		   }
		   
		   UserList.add(new User(user_username_txtfld.getText(), user_password_txtfld.getText()));
	   }
   };

   private void deleteUsers() {
getContentPane().removeAll();
	   
	   displayMainScreenMenu();
	   
	   setLayout(new GridBagLayout());
	   gbcdu = new GridBagConstraints();
	   
	   
	   if (currentUser.getPermissions().getPermission(Permissions.CREATEUSER) == 1) {
		   deleteUserbtn = new JButton("Delete Users");
		   deleteUserbtn.addActionListener(deleteUserButtonListener);
		   deleteUserbtn.setPreferredSize(new Dimension(165, 24));
		   deleteUserbtn.setMaximumSize(new Dimension(165, 24));
		   gbcdu.gridx = 0;  
		   gbcdu.gridy = 0	;
		   gbcdu.weightx = 1.0;
		   add(deleteUserbtn);
		   
		   user_username_label = new JLabel("Username: ");
		   gbcdu.anchor = GridBagConstraints.EAST;
		   gbcdu.gridx = 1;  
		   gbcdu.gridy = 0	;
		   gbcdu.weightx = 1.0;
		   add(user_username_label, gbcdu);
		   
		   user_username_txtfld = new PlaceholderTextField("User to Delete", 20);
		   gbcdu.anchor = GridBagConstraints.WEST;
		   gbcdu.gridx = 2; 
		   gbcdu.gridy = 0	;
		   gbcdu.weightx = 1.0;
		   add(user_username_txtfld, gbcdu);
	   }
	   
	   revalidate();
	   repaint();
   }
   
   private ActionListener deleteUsersButtonListener = new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   deleteUsers();
	   }
   };
   
   private ActionListener deleteUserButtonListener = new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   // user_username_txtfld
		   // user_password_txtfld
		   if (user_username_txtfld.getText().equals(user_username_txtfld.getPlaceholder())) {
			   JOptionPane.showMessageDialog(null, "Please enter a username.");
			   return;
		   }
		   
		   for (User user: UserList) {
			   if (user.getName().equals(user_username_txtfld.getText())) {
				   UserList.remove(user);
				   return;
			   }
		   }
		   
		   JOptionPane.showMessageDialog(null, "There is no User with that name.");
	   }
   };
   
   private ActionListener editUserButtonListener = new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   // user_username_txtfld
		   // user_password_txtfld
		   if (user_username_txtfld.getText().equals(user_username_txtfld.getPlaceholder())) {
			   JOptionPane.showMessageDialog(null, "Please enter a username.");
			   return;
		   }
		   if (user_password_txtfld.getText().equals(user_password_txtfld.getPlaceholder())) {
			   JOptionPane.showMessageDialog(null, "Please enter a password.");
			   return;
		   }
		   for (User user: UserList) {
			   if (user.getName().equals(user_username_txtfld.getText())) {
				   user.setPassword(user_password_txtfld.getText());
				   return;
			   }
		   }
		   
		   JOptionPane.showMessageDialog(null, "There is no User with that name.");
	   }
   };
   
   private ActionListener editUsersButtonListener = new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   editUsers();
	   }
   };
   
   private void editUsers() {
	   getContentPane().removeAll();
	   
	   displayMainScreenMenu();
	   
	   setLayout(new GridBagLayout());
	   gbceu = new GridBagConstraints();
	   
	   
	   if (currentUser.getPermissions().getPermission(Permissions.CREATEUSER) == 1) {
		   EditUserbtn = new JButton("Edit Users");
		   EditUserbtn.addActionListener(editUserButtonListener);
		   EditUserbtn.setPreferredSize(new Dimension(165, 24));
		   EditUserbtn.setMaximumSize(new Dimension(165, 24));
		   gbceu.gridx = 0; 
		   gbceu.gridy = 0	;
		   gbceu.weightx = 1.0;
		   add(EditUserbtn);
		   
		   user_username_label = new JLabel("Username: ");
		   gbceu.anchor = GridBagConstraints.EAST;
		   gbceu.gridx = 1;  
		   gbceu.gridy = 0	;
		   gbceu.weightx = 1.0;
		   add(user_username_label, gbceu);
		   
		   user_username_txtfld = new PlaceholderTextField("Username to Edit", 20);
		   gbceu.anchor = GridBagConstraints.WEST;
		   gbceu.gridx = 2; 
		   gbceu.gridy = 0	;
		   gbceu.weightx = 1.0;
		   add(user_username_txtfld, gbceu);
		   
		   user_password_label = new JLabel("Password: ");
		   gbceu.anchor = GridBagConstraints.EAST;
		   gbceu.gridx = 1;  
		   gbceu.gridy = 1	;
		   gbceu.weightx = 1.0;
		   add(user_password_label, gbceu);
		   
		   user_password_txtfld = new PlaceholderTextField("Password", 20);
		   gbceu.anchor = GridBagConstraints.WEST;
		   gbceu.gridx = 2;  
		   gbceu.gridy = 1	;
		   gbceu.weightx = 1.0;
		   add(user_password_txtfld, gbceu);
	   }
	   
	   revalidate();
	   repaint();
   };
   
   
   
   private void createUsers() {
	   getContentPane().removeAll();
	   
	   displayMainScreenMenu();
	   
	   setLayout(new GridBagLayout());
	   gbccu = new GridBagConstraints();
	   
	   
	   if (currentUser.getPermissions().getPermission(Permissions.CREATEUSER) == 1) {
		   createUserbtn = new JButton("Create User");
		   createUserbtn.addActionListener(createUserButtonListener);
		   createUserbtn.setPreferredSize(new Dimension(165, 24));
		   createUserbtn.setMaximumSize(new Dimension(165, 24));
		   gbccu.gridx = 0; 
		   gbccu.gridy = 0	;
		   gbccu.weightx = 1.0;
		   add(createUserbtn);
		   
		   user_username_label = new JLabel("Username: ");
		   gbccu.anchor = GridBagConstraints.EAST;
		   gbccu.gridx = 1; 
		   gbccu.gridy = 0	;
		   gbccu.weightx = 1.0;
		   add(user_username_label, gbccu);
		   
		   user_username_txtfld = new PlaceholderTextField("Username", 20);
		   gbccu.anchor = GridBagConstraints.WEST;
		   gbccu.gridx = 2; 
		   gbccu.gridy = 0	;
		   gbccu.weightx = 1.0;
		   add(user_username_txtfld, gbccu);
		   
		   user_password_label = new JLabel("Password: ");
		   gbccu.anchor = GridBagConstraints.EAST;
		   gbccu.gridx = 1; 
		   gbccu.gridy = 1	;
		   gbccu.weightx = 1.0;
		   add(user_password_label, gbccu);
		   
		   user_password_txtfld = new PlaceholderTextField("Password", 20);
		   gbccu.anchor = GridBagConstraints.WEST;
		   gbccu.gridx = 2;  
		   gbccu.gridy = 1	;
		   gbccu.weightx = 1.0;
		   add(user_password_txtfld, gbccu);
	   }
	   
	   revalidate();
	   repaint();
   }
   
   private ActionListener createUsersButtonListener = new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   createUsers();
	   }
   };
   
   private void editCustomers() {
getContentPane().removeAll();
	   
	   displayMainScreenMenu();
	   
	   setLayout(new GridBagLayout());
	   gbcce = new GridBagConstraints();
	   
	   if (currentUser.getPermissions().getPermission(Permissions.EDITCUSTOMERDETAILS) == 1) {
		   
		   editCustomerbtn = new JButton("Edit Customer");
		   editCustomerbtn.addActionListener(editCustomerButtonListener);
		   editCustomerbtn.setPreferredSize(new Dimension(165, 24));
		   editCustomerbtn.setMaximumSize(new Dimension(165, 24));
		   gbcce.gridx = 0;  
		   gbcce.gridy = 0	;
		   gbcce.weightx = 1.0;
		   add(editCustomerbtn);
		   
		   CustomerNumlabel = new JLabel("Customer: ");
		   gbcce.anchor = GridBagConstraints.EAST;
		   gbcce.gridx = 1;  
		   gbcce.gridy = 0;
		   gbcce.weightx = 1.0;
		   add(CustomerNumlabel, gbcce);
		   
		   customerNumtxtfld = new PlaceholderTextField("Customer id", 20);
		   gbcce.anchor = GridBagConstraints.WEST;
		   gbcce.gridx = 2;  
		   gbcce.gridy = 0	;
		   gbcce.weightx = 1.0;
		   add(customerNumtxtfld, gbcce);
		   
		   fullNametxtfld = new PlaceholderTextField("Fullname", 20);
		   gbcce.anchor = GridBagConstraints.WEST;
		   gbcce.gridx = 2;  
		   gbcce.gridy = 1	;
		   gbcce.weightx = 1.0;
		   add(fullNametxtfld, gbcce);
		   
		   customerFullNamelbl = new JLabel("Fullname: ");
		   gbcce.anchor = GridBagConstraints.EAST;
		   gbcce.gridx = 1;  
		   gbcce.gridy = 1;
		   gbcce.weightx = 1.0;
		   add(customerFullNamelbl, gbcce);
		   
		   birth_date_label = new JLabel("Birth Date: ");
		   gbcce.anchor = GridBagConstraints.EAST;
		   gbcce.gridx = 1; 
		   gbcce.gridy = 2;
		   gbcce.weightx = 1.0;
		   add(birth_date_label, gbcce);
		   
		   UtilDateModel model = new UtilDateModel();
	        Properties p = new Properties();
	        p.put("text.today", "Today");
	        p.put("text.month", "Month");
	        p.put("text.year", "Year");
	        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
	        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	        gbcce.anchor = GridBagConstraints.WEST;
			gbcce.gridx = 2;  
			gbcce.gridy = 2;
			gbcce.weightx = 1.0;
	        add(datePicker, gbcce);
		   
		   strt_addr_label = new JLabel("Street Address: ");
		   gbcce.anchor = GridBagConstraints.EAST;
		   gbcce.gridx = 1;  
		   gbcce.gridy = 3	;
		   gbcce.weightx = 1.0;
		   add(strt_addr_label, gbcce);
		   
		   customerStreetAddresstxtfld = new PlaceholderTextField("Street Address", 20);
		   gbcce.anchor = GridBagConstraints.WEST;
		   gbcce.gridx = 2;  
		   gbcce.gridy = 3	;
		   gbcce.weightx = 1.0;
		   add(customerStreetAddresstxtfld, gbcce);
		   
		   dln_label = new JLabel("Driving License Number: ");
		   gbcce.anchor = GridBagConstraints.EAST;
		   gbcce.gridx = 1;  
		   gbcce.gridy = 4	;
		   gbcce.weightx = 1.0;
		   add(dln_label, gbcce);
		   
		   dlntxtfld = new PlaceholderTextField("Driving License Number", 20);
		   gbcce.anchor = GridBagConstraints.WEST;
		   gbcce.gridx = 2;  
		   gbcce.gridy = 4	;
		   gbcce.weightx = 1.0;
		   add(dlntxtfld, gbcce);
		   
	   }
	   
	   
	   revalidate();
		repaint();
   }
   
	private ActionListener editCustomersButtonListener = new ActionListener() {
		@Override
		   public void actionPerformed(ActionEvent e) {
			   editCustomers();
		   }
	};
   
   private void newApplication() {
	   getContentPane().removeAll();
	   
	   displayMainScreenMenu();
	   
	   setLayout(new GridBagLayout());
	   gbcna = new GridBagConstraints();
	   
	   if (currentUser.getPermissions().getPermission(Permissions.CREATEAPPLICATION) == 1) {
		   
		   newApplicationbtn = new JButton("Create Application");
		   newApplicationbtn.addActionListener(createApplicationButtonListener);
		   newApplicationbtn.setPreferredSize(new Dimension(165, 24));
		   newApplicationbtn.setMaximumSize(new Dimension(165, 24));
		   gbcna.gridx = 0;  
		   gbcna.gridy = 0	;
		   gbcna.weightx = 1.0;
		   add(newApplicationbtn);
		   
		   customerFullNamelbl = new JLabel("Fullname: ");
		   gbcna.anchor = GridBagConstraints.EAST;
		   gbcna.gridx = 1;  
		   gbcna.gridy = 0	;
		   gbcna.weightx = 1.0;
		   add(customerFullNamelbl, gbcna);
		   
		   fullNametxtfld = new PlaceholderTextField("Fullname", 20);
		   gbcna.anchor = GridBagConstraints.WEST;
		   gbcna.gridx = 2;  
		   gbcna.gridy = 0	;
		   gbcna.weightx = 1.0;
		   add(fullNametxtfld, gbcna);
		   
		   ApplicationDetailslbl = new JLabel("Details: ");
		   gbcna.anchor = GridBagConstraints.EAST;
		   gbcna.gridx = 1;  
		   gbcna.gridy = 1	;
		   gbcna.weightx = 1.0;
		   add(ApplicationDetailslbl, gbcna);
		   
		   ApplicationDetailstxtfld = new PlaceholderTextField("Details", 20);
		   gbcna.anchor = GridBagConstraints.WEST;
		   gbcna.gridx = 2;  
		   gbcna.gridy = 1	;
		   gbcna.weightx = 1.0;
		   add(ApplicationDetailstxtfld, gbcna);
	   }
	   
	   
	   revalidate();
		repaint();
	   
   }
   
   private ActionListener newApplicationButtonListener = new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   newApplication();
	   }
   };
   
   private ActionListener cancelApplicationButtonListener = new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   getContentPane().removeAll();
		   
		   displayMainScreenMenu();
		   
		   setLayout(new GridBagLayout());
		   gbcca = new GridBagConstraints();
		   
		   if (currentUser.getPermissions().getPermission(Permissions.CREATEAPPLICATION) == 1) {
			   
			   cancelApplicationbtn = new JButton("Cancel Application");
			   cancelApplicationbtn.addActionListener(deleteApplicationButtonListener);
			   cancelApplicationbtn.setPreferredSize(new Dimension(165, 24));
			   cancelApplicationbtn.setMaximumSize(new Dimension(165, 24));
			   gbcca.gridx = 0;  
			   gbcca.gridy = 0	;
			   gbcca.weightx = 1.0;
			   add(cancelApplicationbtn);
			   
			   deleteApplicationlabel = new JLabel("Application number: ");
			   gbcca.anchor = GridBagConstraints.EAST;
			   gbcca.gridx = 1;  
			   gbcca.gridy = 0	;
			   gbcca.weightx = 1.0;
			   add(deleteApplicationlabel, gbcca);
			   
			   ApplicationNumtxtfld = new PlaceholderTextField("Number", 20);
			   gbcca.anchor = GridBagConstraints.WEST;
			   gbcca.gridx = 2;  
			   gbcca.gridy = 0	;
			   gbcca.weightx = 1.0;
			   add(ApplicationNumtxtfld, gbcca);
		   }
		   
		   revalidate();
			repaint();
	   }
   };
   
   private ActionListener renewApplicationButtonListener = new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {}
   };
   
   public void viewUsers() {
	   getContentPane().removeAll();
	   
	   displayMainScreenMenu();
	   
	   setLayout(new GridBagLayout());
	   gbcvu = new GridBagConstraints();
	   
	   buttonPanel = new JPanel();
	   buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
	   
	   int i = 0;
	   if (currentUser.getPermissions().getPermission(Permissions.GETCUSTOMERDETAILS) == 1) {
		   for (User user: UserList) {
		    	JButton button = new JButton(user.getName());
		    	button.setPreferredSize(new Dimension(132, 24));
		    	button.setMaximumSize(new Dimension(132, 24));
		    	button.addActionListener(UserButtonListener);
		    	buttonPanel.add(button);
		    	
		    	++i;
		    }
	   }	
	    
	    // Set a preferred size for the button panel to ensure proper scrolling
	    buttonPanel.setPreferredSize(new Dimension(132, 24*UserList.size())); // Adjust dimensions as needed
	   
	    JScrollPane scrollPane = new JScrollPane(buttonPanel);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane.setPreferredSize(new Dimension(150, 300)); // Adjust dimensions as needed
	    
	    // Add the scroll pane to the frame with appropriate layout constraints
	    gbcvu.gridx = 0;  
	    gbcvu.gridy = 0;
	    gbcvu.gridheight = 7;
	    gbcvu.anchor = GridBagConstraints.CENTER;
	    add(scrollPane, gbcvu);
	    
	    user_username_label = new JLabel("Username: -");
	    gbcvu.gridx = 1;  
	    gbcvu.gridy = 1;
	    gbcvu.gridheight = 1;
	    gbcvu.weightx = 1.0;
	    gbcvu.insets = new Insets(0, 100, 10, 0);
	    gbcvu.anchor = GridBagConstraints.WEST;
	    add(user_username_label, gbcvu);
	    
	    user_password_label = new JLabel("Password: -");
	    gbcvu.gridx = 1;  
	    gbcvu.gridy = 2;
	    gbcvu.gridheight = 1;
	    gbcvu.weightx = 1.0;
	    add(user_password_label, gbcvu);
	   
	   revalidate();
	   repaint();
   }
   
   private ActionListener viewUsersButtonListener = new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   viewUsers();
	   }
   };
   
   private ActionListener viewCustomersButtonListener = new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   getContentPane().removeAll();
		   
		   displayMainScreenMenu();
		   
		   setLayout(new GridBagLayout());
		   gbcvc = new GridBagConstraints();
		   
		   buttonPanel = new JPanel();
		   buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		   
		   if (currentUser.getPermissions().getPermission(Permissions.GETCUSTOMERDETAILS) == 1) {
			   for (Customer customer: currentUser.getAllCustomersList()) {
			    	JButton button = new JButton("Cust " + customer.getCustomerNumber().toString());
			    	button.setPreferredSize(new Dimension(132, 24));
			    	button.setMaximumSize(new Dimension(132, 24));
			    	button.addActionListener(CustomerButtonListener);
			    	buttonPanel.add(button);
			    }
		   }	
		    

		    // Set a preferred size for the button panel to ensure proper scrolling
		    buttonPanel.setPreferredSize(new Dimension(132, 24*currentUser.getAllApplicationsList().size())); // Adjust dimensions as needed
		   
		    JScrollPane scrollPane = new JScrollPane(buttonPanel);
		    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		    scrollPane.setPreferredSize(new Dimension(150, 300)); // Adjust dimensions as needed
		    
		    // Add the scroll pane to the frame with appropriate layout constraints
		    gbcvc.gridx = 0;  
		    gbcvc.gridy = 0;
		    gbcvc.gridheight = 7;
		    gbcvc.anchor = GridBagConstraints.CENTER;
		    add(scrollPane, gbcvc);
		    
		    CustomerNumlabel = new JLabel("Customer: -");
		    gbcvc.gridx = 1; 
		    gbcvc.gridy = 0;
		    gbcvc.gridheight = 1;
		    gbcvc.weightx = 1.0;
		    gbcvc.insets = new Insets(0, 100, 10, 0);
		    gbcvc.anchor = GridBagConstraints.WEST;
		    add(CustomerNumlabel, gbcvc);
		    
		    customer_name_label = new JLabel("Fullname: -");
		    gbcvc.gridx = 1;  
		    gbcvc.gridy = 1;
		    gbcvc.gridheight = 1;
		    gbcvc.weightx = 1.0;
		    add(customer_name_label, gbcvc);
		    
		    birth_date_label = new JLabel("Birth Date: -");
		    gbcvc.gridx = 1; 
		    gbcvc.gridy = 2;
		    gbcvc.gridheight = 1;
		    gbcvc.weightx = 1.0;
		    add(birth_date_label, gbcvc);
		    
		    strt_addr_label = new JLabel("Street Address: -");
		    gbcvc.gridx = 1;  
		    gbcvc.gridy = 3;
		    gbcvc.weightx = 1.0;
		    add(strt_addr_label, gbcvc);
		    
		    dln_label = new JLabel("Driving License Number: -");
		    gbcvc.gridx = 1;
		    gbcvc.gridy = 4;
		    gbcvc.weightx = 1.0;
		    add(dln_label, gbcvc);
		   
		   revalidate();
		   repaint();
	   }
   };
   
private ActionListener UserButtonListener = new ActionListener() {
	@Override
    public void actionPerformed(ActionEvent e) {
		   JButton clickedButton = (JButton) e.getSource(); // Get the button that was clicked
		   String btn_name = clickedButton.getText();
        for (User user: UserList) {
        	if (user.getName().equals(btn_name)) {
            	user_username_label .setText("Username: " + user.getName());
            	user_password_label.setText("Password: " + user.getPassword());
        	}
        }
	}
};
   
   private ActionListener CustomerButtonListener = new ActionListener() {
	   @Override
       public void actionPerformed(ActionEvent e) {
		   JButton clickedButton = (JButton) e.getSource(); // Get the button that was clicked
		   Integer btn_index = -1 + Character.getNumericValue(clickedButton.getText().charAt(clickedButton.getText().length() - 1));
           Customer customer = currentUser.getAllCustomersList().get(btn_index); // Get the application associated with the clicked button
           if (customer != null) {
        	   CustomerNumlabel.setText("Customer: " + customer.getCustomerNumber());
        	   customer_name_label.setText("Fullname: " + customer.getCustomerFullName());
        	   birth_date_label.setText("Birth Date: " + customer.getCustomerBirthDate());
               strt_addr_label.setText("Street Address: " + customer.getCustomerStreetAddress());
               dln_label.setText("Driving License Number: " + customer.getDrivingLicenseNumber());
           }
	   }  
   };
   
   private ActionListener ApplicationButtonListener = new ActionListener() {
	   @Override
       public void actionPerformed(ActionEvent e) {
		   JButton clickedButton = (JButton) e.getSource(); // Get the button that was clicked
		   Integer btn_index = -1 + Character.getNumericValue(clickedButton.getText().charAt(clickedButton.getText().length() - 1));
           Application application = currentUser.getAllApplicationsList().get(btn_index); // Get the application associated with the clicked button
           if (application != null) {
        	   applicationNumlabel.setText("Application: " + application.getApplicationNumber());
        	   customer_name_label.setText("Fullname: " + application.getCustomerFullName());
               date_label.setText("Date: " + application.getsubmitionDate());
               time_label.setText("Time: " + application.getsubmitionTime());
               status_label.setText("Status: " + application.getStatus());
               details_label.setText("Details: " + application.getApplicationDetails());
           }
	   }
   };
   
   void displayMainScreenMenu() {
	   menuBar = new JMenuBar();
	   ApplicationsMenu = new JMenu("Applications");
	   CustomersMenu = new JMenu("Customers");
	   
	   // Applications Menu
	   if (currentUser.getPermissions().getPermission(Permissions.CREATEAPPLICATION) == 1) {
		   JMenuItem newApplicationItem = new JMenuItem("New Application");
		   newApplicationItem.addActionListener(newApplicationButtonListener);
		   ApplicationsMenu.add(newApplicationItem);
	   }
	   if (currentUser.getPermissions().getPermission(Permissions.CANCELAPPLICATION) == 1) {
		   JMenuItem cancelApplicationItem = new JMenuItem("Cancel Application");
		   cancelApplicationItem.addActionListener(cancelApplicationButtonListener);
		   ApplicationsMenu.add(cancelApplicationItem);
	   }
	   if (currentUser.getPermissions().getPermission(Permissions.RENEWAPPLICATION) == 1) {
		   JMenuItem renewApplicationItem = new JMenuItem("Renew Application");
		   renewApplicationItem.addActionListener(renewApplicationButtonListener);
		   ApplicationsMenu.add(renewApplicationItem);   
	   }
	   
	   JMenuItem viewApplicationsItem = new JMenuItem("View Applications");
	   viewApplicationsItem.addActionListener(viewApplicationButtonListener);
	   ApplicationsMenu.addSeparator();
	   ApplicationsMenu.add(viewApplicationsItem);
	   
	   if (currentUser.getPermissions().getPermission(Permissions.CREATEAPPLICATION) == 1) {
		   JMenuItem viewmyApplicationsItem = new JMenuItem("View My Applications");
		   viewmyApplicationsItem.addActionListener(viewmyApplicationButtonListener);
		   ApplicationsMenu.add(viewmyApplicationsItem);
	   }
	   
	   menuBar.add(ApplicationsMenu);
	   
	   // Customers Menu
	   if (currentUser.getPermissions().getPermission(Permissions.CREATECUSTOMER) == 1) {
		   JMenuItem NewCustomersItem = new JMenuItem("New Customers");
		   NewCustomersItem.addActionListener(createCustomersButtonListener);
		   CustomersMenu.add(NewCustomersItem);
	   }
	   if (currentUser.getPermissions().getPermission(Permissions.EDITCUSTOMERDETAILS) == 1) {
		   JMenuItem EditCustomersItem = new JMenuItem("Edit Customer Details");
		   EditCustomersItem.addActionListener(editCustomersButtonListener);
		   CustomersMenu.add(EditCustomersItem);
	   }
	   if (currentUser.getPermissions().getPermission(Permissions.GETCUSTOMERDETAILS) == 1) {
		   JMenuItem CustomersItem = new JMenuItem("View Customers");
		   CustomersItem.addActionListener(viewCustomersButtonListener);
		   CustomersMenu.addSeparator();
		   CustomersMenu.add(CustomersItem);
	   }
	   menuBar.add(CustomersMenu);
	    
	   // Users Menu
	   if (currentUser.getPermissions().getPermission(Permissions.ISADMIN) == 1) {
		   UsersMenu = new JMenu("Users");
		   
		   if (currentUser.getPermissions().getPermission(Permissions.CREATEUSER) == 1) {
			   JMenuItem createUsersItem = new JMenuItem("Create Users");
			   createUsersItem.addActionListener(createUsersButtonListener);
			   UsersMenu.add(createUsersItem);
		   }
		   if (currentUser.getPermissions().getPermission(Permissions.EDITUSER) == 1) {
			   JMenuItem editUsersItem = new JMenuItem("Edit Users");
			   editUsersItem.addActionListener(editUsersButtonListener);
			   UsersMenu.add(editUsersItem);
		   }
		   if (currentUser.getPermissions().getPermission(Permissions.DELETEUSER) == 1) {
			   JMenuItem deleteUsersItem = new JMenuItem("Delete Users");
			   deleteUsersItem.addActionListener(deleteUsersButtonListener);
			   UsersMenu.add(deleteUsersItem);
		   }
		   
		   JMenuItem UsersItem = new JMenuItem("View Users");
		   UsersItem.addActionListener(viewUsersButtonListener);
		   UsersMenu.addSeparator();
		   UsersMenu.add(UsersItem);

		   menuBar.add(UsersMenu);
	   }
	   
	   setJMenuBar(menuBar);
   }
   
   void initMainScreen() {
	   setLayout(new GridBagLayout());  // super JPanel
	   GridBagConstraints gbcmc = new GridBagConstraints();
	   
	   displayMainScreenMenu();
	   
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
		setTitle("Main Screen"); // "super" JFrame sets title
		setSize(900, 600);         // "super" JFrame sets initial size
		//setLocationRelativeTo(null);
		setVisible(true);
		   
		revalidate();
		repaint();
   }
   
   void initLoginScreen() {
	   setLayout(new GridBagLayout());  // super JPanel
	   GridBagConstraints gbc = new GridBagConstraints();

      // Define constraints for individual components
	   username_label = new JLabel("Username");
	   gbc.insets = new Insets(10, 0, 0, 10);
	   gbc.gridx = 0;  // column 0 (first column)
	   gbc.gridy = 0;  // row 0 (first row)
	   add(username_label, gbc);  // add and apply constraints
	   
	   username_textfield = new PlaceholderTextField("username", 20);
	   gbc.gridx = 1;
	   gbc.gridy = 0;
	   gbc.insets = new Insets(10, 0, 0, 0);
	   add(username_textfield, gbc);
	   
	   username_label = new JLabel("Password");
	   gbc.insets = new Insets(0, 0, 0, 10);
	   gbc.gridx = 0;  // column 0 (first column)
	   gbc.gridy = 1;  // row 0 (first row)
	   add(username_label, gbc);  // add and apply constraints
	   
	   password_textfield = new PlaceholderTextField("password", 20);
	   gbc.gridx = 1;
	   gbc.gridy = 1;
	   gbc.insets = new Insets(0, 0, 0, 0);
	   add(password_textfield, gbc);

	   JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       login_btn = new JButton("Login");
       login_btn.addActionListener(loginButtonListener);
       buttonPanel.add(login_btn);
       gbc.gridx = 0;      
       gbc.gridy = 2;      
       gbc.gridwidth = 2;  
       gbc.anchor = GridBagConstraints.CENTER; // align at the center of the space
       gbc.weighty = 1.0;  // request any extra vertical space
       add(buttonPanel, gbc);
      
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	   setTitle("Login Screen"); 
	   setSize(600, 300);        
	   setLocationRelativeTo(null);
	   setVisible(true);
   }

}
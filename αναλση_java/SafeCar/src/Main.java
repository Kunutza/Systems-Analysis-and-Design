import java.util.ArrayList;
import java.util.List;

public class Main {
	

	public static void main(String[] args) {
		ArrayList<User> UserList = new ArrayList<>();
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
		System.out.println(UserList.get(1).getUserApplicationsList().get(0).getApplicationNumber());
		System.out.println(UserList.get(0).getAllApplicationsList().get(1).getApplicationNumber());
	}

}

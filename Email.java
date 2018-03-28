package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailBoxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "anyCompany.com";
	
	Scanner in = new Scanner(System.in);
	//constructor to receive the first name and last name 
	public Email() {
		this.firstName = setFirstName();
		this.lastName = setLastName();		
		
		// Call a method asking for the department - returns the department
		this.department = setDepartment();
		
		// Call a method that creates a random  password
		
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: "+ this.password);
		
		// Combine elements to generate email
		
		email = firstName.toLowerCase()+"." + lastName.toLowerCase()+"@"+ department +"."+ companySuffix;
	}
	//Ask for firstName
	private String setFirstName() {
		System.out.println("Enter your first Name: ");
		Scanner in = new Scanner(System.in);
		String first = in.nextLine();
		return first;
	}
	
	private String setLastName() {
		System.out.println("Enter your last Name: ");
		Scanner in = new Scanner(System.in);
		String last = in.nextLine();
		return last;
	}
	// Ask for the department
	private String setDepartment() {
		System.out.println("New worker: "+firstName +"\nDepartments Codes:\n1 for sales\n2 for Development\n3 for Accounting\n0for none\nEnter department code: ");
		
		int depChoice = in.nextInt();
		if(depChoice == 1) {return "Sales";}
		else if(depChoice == 2) {return "dev";}
		else if(depChoice == 3) { return "acct";}
		else { return "";}
	}
	
	// Generate a random password 
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345678!@#$%";
		char[] password = new char[length];
		for(int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;
	}
	
	// Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() { return mailBoxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() { return password; }
	
	
	// Prints the results 
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " "+lastName+ "."+
				"\nCOMPANY EMAIL: " + email + 
				"\nMAILBOX CAPACITY: "+ mailBoxCapacity + "MB"; 
	}
	
	
	
}

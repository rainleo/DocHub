package docHub;


public class Patient {
	private int patientId;
	private String firstName;
	private String lastName;
	private String gender;
	private String emailId;
	private String password;
	private String dateOfBirth;
	private String phoneNum;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private String insurance;
	private String insuranceId;

	private String securityQuestion;
	private String securityAnswer;
	
	public void setFirstname(String firstName){
		 this.firstName=firstName;
	}
	
	public void setLastname(String lastName){
		 this.lastName=lastName;
	}
	
	public void setGender(String gender){
		 this.gender=gender;
	}
	
	public void setEmailId(String emailId){
		 this.emailId=emailId;
	}
	
	public void setPassword(String password){
		 this.password=password;
	}
	
	public void setPatientId(int patientId){
		 this.patientId=patientId;
	}
	
	public void setDateOfBirth(String dateOfBirth){
		 this.dateOfBirth=dateOfBirth;
	}

	
	public void setPhoneNumber(String phoneNum){
		 this.phoneNum=phoneNum;
	}
	
	public void setAddress1(String addressLine1){
		 this.addressLine1=addressLine1;
	}
	
	public void setAddress2(String addressLine2){
		 this.addressLine2=addressLine2;
	}
	
	public void setCity(String city){
		 this.city=city;
	}
	
	public void setCountry(String country){
		 this.country=country;
	}
	
	public void setState(String state){
		 this.state=state;
	}
	
	public void setZipCode(String zipCode){
		 this.zipCode=zipCode;
	}
	
	public void setInsurance(String insurance){
		 this.insurance=insurance;
	}
	
	public void setInsuranceId(String insuranceId){
		 this.insuranceId=insuranceId;
	}
	
	public void setSecurityQuestion(String securityQuestion){
		 this.securityQuestion=securityQuestion;
	}
	
	public void setSecurityAnswer(String securityAnswer){
		 this.securityAnswer=securityAnswer;
	}
	
	public String getFirstname(){
		return this.firstName;
	}
	
	public String getLastname(){
		return this.lastName;
	}
	
	public String getGender(){
		return this.gender;
	}
	
	public String getEmailId(){
		return this.emailId;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public int getPatientId(){
		return this.patientId;
	}
	
	public String getDateOfBirth(){
		return this.dateOfBirth;
	}
	
	public String getPhoneNum(){
		return this.phoneNum;
	}
	
	public String getAddress1(){
		return this.addressLine1;
	}
	
	public String getAddress2(){
		return this.addressLine2;
	}
	
	public String getCity(){
		return this.city;
	}
	
	public String getState(){
		return this.state;
	}
	
	public String getCountry(){
		return this.country;
	}
	
	public String getZipCode(){
		return this.zipCode;
	}
	
	public String getInsurance(){
		return this.insurance;
	}
	
	public String getInsuranceId(){
		return this.insuranceId;
	}
	
	public String getSecurityQuestion(){
		return this.securityQuestion;
	}
	
	public String getSecurityAnswer(){
		return this.securityAnswer;
	}
}

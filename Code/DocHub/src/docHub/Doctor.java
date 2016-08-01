package docHub;


public class Doctor {

	private int doctorId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String emailId;
	private String password;	
	private String phoneNum;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private String insuranceCovered;
	private String licenseNum;
	private String specialization;
	private String securityQuestion;
	private String securityAnswer;
	
	public void setFirstname(String firstName){
		 this.firstName=firstName;
	}
	
	public void setLastname(String lastName){
		 this.lastName=lastName;
	}
	
	public void setDateOfBirth(String dateOfBirth){
		 this.dateOfBirth=dateOfBirth;
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
	
	public void setDoctorId(int doctorId){
		 this.doctorId=doctorId;
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
	
	public void setInsuranceCovered(String insuranceCovered){
		 this.insuranceCovered=insuranceCovered;
	}
	
	public void setLicenseNumber(String licenseNum){
		 this.licenseNum=licenseNum;
	}
	
	public void setSpecialization(String specialization){
		this.specialization=specialization;
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
	
	public String getDateOfBirth(){
		return this.dateOfBirth;
	}
	
	public String getEmailId(){
		return this.emailId;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public int getDoctorId(){
		return this.doctorId;
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
	
	public String getInsuranceCovered(){
		return this.insuranceCovered;
	}
	
	public String getSpecialization(){
		return this.specialization;
	}
	
	public String getLicenseNumber(){
		return this.licenseNum;
	}
	
	public String getSecurityQuestion(){
		return this.securityQuestion;
	}
	
	public String getSecurityAnswer(){
		return this.securityAnswer;
	}
}


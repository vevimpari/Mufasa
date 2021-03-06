import java.util.Calendar;

public class MufasaAccount {
	String steetAddress;
	String city;
	String postcode;
	String country;
	
	String mufasaPassword;
	
	String cardHolderName;
	String cardType;
	int cardNumber;
	ExpiryDate expiryDate;

	int cvc;
	
	BankAccount bankAccount;
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public String getMufasaPassword() {
		return mufasaPassword;
	}
	public void setMufasaPassword(String mufasaPassword) {
		this.mufasaPassword = mufasaPassword;
	}
	public int getCvc() {
		return cvc;
	}
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	
	public String getSteetAddress() {
		return steetAddress;
	}
	public void setSteetAddress(String steetAddress) {
		this.steetAddress = steetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		if(city.matches(".*[a-zA-Z]+.*")) {
			this.city = city;
		}
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		
		this.postcode = postcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public ExpiryDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(ExpiryDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public boolean checkCardExpiry(ExpiryDate expiryDate) {
		boolean isValid = true;
		
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		
		if (expiryDate.getExpYear() < currentYear) {
			isValid = false;
		} else if (expiryDate.getExpYear() < currentYear && expiryDate.getExpMonth() < currentMonth) {
			isValid = false;
		}
		return isValid;
	}
}

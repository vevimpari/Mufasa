
public class Mufasa {
	public void MufasaSystem(MufasaAccount account) {
		validateCVC(account.getCvc());
	}

	public boolean validateCVC(int cvc) {

		boolean isValid = true;
		
		System.out.println(cvc);
		
		if (String.valueOf(cvc).length() != 3) {
			isValid = false;
		}
			
		return isValid;
	}
		
}

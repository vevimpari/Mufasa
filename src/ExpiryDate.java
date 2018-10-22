
public class ExpiryDate {
	private int expYear;
	private int expMonth;
	
	ExpiryDate(int year, int month) {
		this.expYear = year;
		this.expMonth = month;
	}

	public int getExpYear() {
		return expYear;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	public int getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(int expMonth) {
		if (expMonth >= 1 && expMonth <= 12) {
			this.expMonth = expMonth;
		}
	}
}


public class BankAccountAction {
		
	public void deduction(BankAccount bAccount) {
		double balance = bAccount.getBalance();		
		bAccount.setBalance(balance-0.01);
	}
	
	public void refund(BankAccount bAccount) {
		double balance = bAccount.getBalance();
		bAccount.setBalance(balance+0.01);
	}
}

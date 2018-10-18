
public class BankAccountAction {
	
	BankAccount bank;
	
	public void deduction() {
		double balance = bank.getBalance();
		bank.setBalance(balance-0.01);
	}
	
	public void refund() {
		double balance = bank.getBalance();
		bank.setBalance(balance+0.01);
	}
}

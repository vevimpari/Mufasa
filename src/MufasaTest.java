import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;


public class MufasaTest {
	
	Bank bank;
	User user;
	MufasaAccount mAccount;
	BankAccount bAccount;
	Mufasa mufasa;
	
	
	@Before
	public void setup(){
		user = new User();
		
		//Mock create
		bank = EasyMock.createMock(Bank.class);
	}
	
	@Test
	public void testCardExpired() {
		
		mAccount = new MufasaAccount();
		mAccount.setCardHolderName("Seppo");
		mAccount.setCardType("VISA");
		mAccount.setCardNumber(123456789);
		ExpiryDate expDate = new ExpiryDate(2002, 02);
		mAccount.setExpiryDate(expDate);

		boolean isValid = mAccount.checkCardExpiry(mAccount.getExpiryDate());
		
		assertEquals(isValid, false);
		
	}
	
	@Test
	public void testCardUnExpired() {
		
		mAccount = new MufasaAccount();
		mAccount.setCardHolderName("Seppo");
		mAccount.setCardType("VISA");
		mAccount.setCardNumber(123456789);
		ExpiryDate expDate = new ExpiryDate(2020, 02);
		mAccount.setExpiryDate(expDate);

		boolean isValid = mAccount.checkCardExpiry(mAccount.getExpiryDate());
		
		assertEquals("shouldn't  be expired", true, isValid);
		
	}
	
	@Test
	public void testInvalidCVC() {
		
		mAccount = new MufasaAccount();
		mAccount.setCardHolderName("Seppo");
		mAccount.setCardType("VISA");
		mAccount.setCardNumber(123456789);
		ExpiryDate expDate = new ExpiryDate(2020, 02);
		mAccount.setExpiryDate(expDate);
		mAccount.setCvc(4321);

		// Mock set expectations
		EasyMock.expect(bank.bankTransaction(mAccount)).andReturn(true); //recording the expected behaviour
		
		mufasa = new Mufasa();
		boolean isValid = mufasa.validateCVC(mAccount.getCvc());
		
		assertEquals("shouldn't  be valid cvc", false, isValid);
	}
	
	public void testValidCVC() {
		
		mAccount = new MufasaAccount();
		mAccount.setCardHolderName("Seppo");
		mAccount.setCardType("VISA");
		mAccount.setCardNumber(123456789);
		ExpiryDate expDate = new ExpiryDate(2020, 02);
		mAccount.setExpiryDate(expDate);
		mAccount.setCvc(321);

		// Mock set expectations
		EasyMock.expect(bank.bankTransaction(mAccount)).andReturn(true); //recording the expected behaviour
		
		mufasa = new Mufasa();
		boolean isValid = mufasa.validateCVC(mAccount.getCvc());
		
		assertEquals("shouldn't  be valid cvc", true, isValid);
	}
	
	@Test
	public void testMufasaBankTransactionDeduction() {
		
		mAccount = new MufasaAccount();
		mAccount.setCardHolderName("Seppo");
		mAccount.setCardType("VISA");
		mAccount.setCardNumber(123456789);
		ExpiryDate expDate = new ExpiryDate(2020, 02);
		mAccount.setExpiryDate(expDate);
		mAccount.setCvc(321);
		double balance = 50.00;
		BankAccount bankAccount = new BankAccount(balance);
		mAccount.setBankAccount(bankAccount);
		
		// Mock set expectations
		EasyMock.expect(bank.bankTransaction(mAccount)).andReturn(true);
		
		//Mock ready
		EasyMock.replay(bank);
		
		BankAccountAction testBank = new BankAccountAction();
		testBank.deduction(mAccount.getBankAccount());
		assertEquals(balance-0.01, mAccount.getBankAccount().getBalance(), 0.0);
		
	}
	
	@Test
	public void testMufasaBankTransactionRefund() {
		
		mAccount = new MufasaAccount();
		mAccount.setCardHolderName("Seppo");
		mAccount.setCardType("VISA");
		mAccount.setCardNumber(123456789);
		ExpiryDate expDate = new ExpiryDate(2020, 02);
		mAccount.setExpiryDate(expDate);
		mAccount.setCvc(321);
		double balance = 50.00;
		BankAccount bankAccount = new BankAccount(balance);
		mAccount.setBankAccount(bankAccount);
		
		// Mock set expectations
		EasyMock.expect(bank.bankTransaction(mAccount)).andReturn(true); //recording the expected behaviour
		
		//Mock ready
		EasyMock.replay(bank);
		
		BankAccountAction testBank = new BankAccountAction();
		testBank.deduction(mAccount.getBankAccount());
		assertEquals(balance-0.01, mAccount.getBankAccount().getBalance(), 0.0);
		testBank.refund(mAccount.getBankAccount());	
		assertEquals(balance, mAccount.getBankAccount().getBalance(), 0.0);
		
	}
	
	@Test
	public void testMufasaBankTransactionInterface_TransactionSuccesful() {
		mAccount = new MufasaAccount();
		mAccount.setCardHolderName("Seppo");
		mAccount.setCardType("VISA");
		mAccount.setCardNumber(123456789);
		ExpiryDate expDate = new ExpiryDate(2020, 02);
		mAccount.setExpiryDate(expDate);
		mAccount.setCvc(321);

		// Mock set expectations
		EasyMock.expect(bank.bankTransaction(mAccount)).andReturn(true); //recording the expected behaviour
	
		assertEquals(true, bank.bankTransaction(mAccount));
	}
	
	@Test
	public void testMufasaBankTransactionInterface_TransactionFails() {
		mAccount = new MufasaAccount();
		mAccount.setCardHolderName("Seppo");
		mAccount.setCardType("VISA");
		mAccount.setCardNumber(123456789);
		ExpiryDate expDate = new ExpiryDate(2020, 02);
		mAccount.setExpiryDate(expDate);
		mAccount.setCvc(321123123);

		// Mock set expectations
		EasyMock.expect(bank.bankTransaction(mAccount)).andReturn(false); //recording the expected behaviour
		
		assertEquals(false, bank.bankTransaction(mAccount));
	}
}

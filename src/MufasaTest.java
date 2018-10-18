import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;


public class MufasaTest {
	
	Bank bank;
	User user;
	MufasaAccount mAccount;
	Mufasa mufasa;
	BankAccountAction testBank;
	
	
	@Before
	public void setup(){
		//sqatPortfolio = new Portfolio();
		//sqatPortfolio.setName("SQaTLab Portfolio");
		
		//Mock create
		//nasdaq = EasyMock.createMock(StockMarket.class);
		//sqatPortfolio.setMarket(nasdaq); //passing market object to portfolio
		
		user = new User();
		
		//Mock create
		bank = EasyMock.createMock(Bank.class);
		testBank = EasyMock.createMock(BankAccountAction.class);
	}
	
/*	@Test //verifying external dependency
	public void theTotalValueOfTheStocksAreReturnedAccordingToTheStockmarketPrice() {
		//Mock set expectations
		EasyMock.expect(nasdaq.getPrice("MS")).andReturn(25.50); //recording the expected behaviour
		EasyMock.expect(nasdaq.getPrice("N0")).andReturn(5.50);
		//Mock ready
		EasyMock.replay(nasdaq); //activating the expected behaviour
		Stock microsoft = new Stock("MS", 4);
		Stock nokia = new Stock("N0", 100);
		sqatPortfolio.addStock(microsoft);
		sqatPortfolio.addStock(nokia);
		sqatPortfolio.setMarket(nasdaq);
		//imitating the expected collaborations and verifying our own unit's method
		assertEquals(25.50*4+5.50*100, sqatPortfolio.getTotalValue(),0.0); //0.0 is to avoid issues 
																		//with floating point rounding
																		//for comparing two double objects
	}*/
	
	@Test //verifying external dependency
	public void testMufasaBankTransactionDeduction() {
		/*
		String steetAddress;
		String city;
		int postcode;
		String country;
		
		String password;
		
		String cardHolderName;
		String cardType;
		int cardNumber;
		Date expiryDate;
		
		User user;
		*/
		
		mAccount = new MufasaAccount();
		mAccount.setCardHolderName("Seppo");
		mAccount.setCardType("VISA");
		mAccount.setCardNumber(123456789);
		mAccount.setExpiryDate("02/2020");
		mAccount.setCvc(321);
		
		BankAccount bankAccount = new BankAccount(50);
		mAccount.setBankAccount(bankAccount);
		
		// Mock set expectations
		EasyMock.expect(bank.bankTransaction(mAccount)).andReturn(true); //recording the expected behaviour
		
		//Mock ready
		EasyMock.replay(bank); //activating the expected behaviour
		boolean isValid = true;
		
		
		assertEquals(isValid, true);
		
		
	}
	
}

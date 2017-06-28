package daotests;

import java.util.logging.Logger;

import org.junit.Test;

import business.customersubsystem.CustomerSubsystemFacade;
import business.externalinterfaces.Address;
import business.externalinterfaces.CartItem;
import business.externalinterfaces.CustomerProfile;
import business.externalinterfaces.CustomerSubsystem;
import business.externalinterfaces.ShoppingCart;
import business.externalinterfaces.ShoppingCartSubsystem;
import business.shoppingcartsubsystem.DbClassShoppingCart;
import business.shoppingcartsubsystem.ShoppingCartSubsystemFacade;
import junit.framework.TestCase;
import middleware.exceptions.DatabaseException;

public class DbClassShoppingCartTest<DbClassShoppingCart> extends TestCase{
	public static final int DEFAULT_CUST_ID=1;
	static Logger log=Logger.getLogger(DbClassShoppingCartTest.class.getName());
	
	@Test
	public void testCartItemRead(){

		
		CustomerSubsystem customerFacade= new CustomerSubsystemFacade();
		CustomerProfile customerProfile=customerFacade.getGenericCustomerProfile();
		customerProfile.setCustId(DEFAULT_CUST_ID);
	
		ShoppingCartSubsystem shoppingCartFacade=new ShoppingCartSubsystemFacade();
		ShoppingCart shoppingCart=shoppingCartFacade.getEmptyCartForTest();
		
		DbClassShoppingCartTest dbShoppingCart=(DbClassShoppingCartTest) shoppingCartFacade.getGenericShoppingCart();
		
		( dbShoppingCart).callSaveCart(customerProfile, shoppingCart);
		
		
			
	}

	private void callSaveCart(CustomerProfile customerProfile, ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		
	}
}
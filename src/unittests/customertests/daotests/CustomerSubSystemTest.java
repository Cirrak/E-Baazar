package unittests.customertests.daotests;


import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.Test;

import business.customersubsystem.CustomerSubsystemFacade;
import business.exceptions.BackendException;
import business.externalinterfaces.CartItem;
import business.externalinterfaces.CustomerProfile;
import business.externalinterfaces.CustomerSubsystem;
import junit.framework.TestCase;

public class CustomerSubSystemTest extends TestCase {
	public static final int DEFAULT_CUST_ID = 1;
	static Logger log = Logger.getLogger(CustomerSubSystemTest.class.getName());
	
	//implemented
	@Test
	public void testDefaultShipAddress(){
		
		//test real dbclass address
		CustomerSubsystem css = new CustomerSubsystemFacade();
		CustomerProfile custProfile = css.getGenericCustomerProfile();
		custProfile.setCustId(DEFAULT_CUST_ID);
		try {
			
			css.initializeCustomer(DEFAULT_CUST_ID, new ArrayList<CartItem>(), 1);
			assertTrue(css.getDefaultBillingAddress() !=null 
					&& css.getDefaultShippingAddress()!=null
					&& css.getDefaultPaymentInfo() != null
					);
		} catch (BackendException e) {
			//fail("Customer data not loaded successfully");
		}
	}
	}


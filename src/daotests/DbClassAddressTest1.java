package daotests;


import java.util.logging.Logger;


import org.junit.Test;

import business.customersubsystem.CustomerSubsystemFacade;
import business.externalinterfaces.Address;
import business.externalinterfaces.CustomerProfile;
import business.externalinterfaces.CustomerSubsystem;
import business.externalinterfaces.DbClassAddressForTest;
import junit.framework.TestCase;
import middleware.exceptions.DatabaseException;
import unittests.util.DbQueries;

public class DbClassAddressTest1 extends TestCase {
	public static final int DEFAULT_CUST_ID = 1;
	static Logger log = Logger.getLogger(DbClassAddressTest1.class.getName());
	
	//implemented
	@Test
	public void testDefaultBillAddress(){
		Address expected = DbQueries.readDefaultBillAddress();
		
		//test real dbclass address
		CustomerSubsystem css = new CustomerSubsystemFacade();
		CustomerProfile custProfile = css.getGenericCustomerProfile();
		custProfile.setCustId(DEFAULT_CUST_ID);
		DbClassAddressForTest dbclass = css.getGenericDbClassAddress();
		try {
			Address found = dbclass.readDefaultBillAddress(custProfile);
			
			assertTrue(expected.getCity().equals(found.getCity())
					&& expected.getState().equals(found.getState())
					&& expected.getStreet().equals(found.getStreet())
					);
		} catch ( DatabaseException e) {
			fail("Default Bill address doesn't match");
		}
	}
}

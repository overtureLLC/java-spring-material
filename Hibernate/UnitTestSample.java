/*
 * Test Case
 */
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class UserDaoTest {
    UserDao userDao= new UserDao();

    @Test
    public void testSave() {
    }

    @Ignore
    @Test
    public void testUpdateUser() {
    }
}

public class AddressDaoTest {
    AddressDao addressDao= new AddressDao();

    @Test
    public void testSave() {
    }

    @Test
    public void testUpdateAddress() {
    }
}

/*
 * Test Suite
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   UserDao.class,
   AddressDao.class
})
public class JunitTestSuite {   
}  

/*
 * Test Runner 
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public final static Logger logger = Logger.getLogger(TestRunner.class);
    public static void main(String[] args) {
        /*
        Result result = JUnitCore.runClasses(UserDao.class);

        for (Failure failure : result.getFailures()) {
            logger.error(failure.toString());
        }
		
        logger.info(result.wasSuccessful());

        result = JUnitCore.runClasses(AddressDao.class);

        for (Failure failure : result.getFailures()) {
            logger.error(failure.toString());
        }
		
        logger.info(result.wasSuccessful());
        */

        Result result = JUnitCore.runClasses(JunitTestSuite.class);

        for (Failure failure : result.getFailures()) {
            logger.error(failure.toString());
        }
		
        logger.info(result.wasSuccessful());
    }
}
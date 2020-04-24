package runner;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import tests.b_splitengineers.BaseEngineerATest;
import tests.b_splitengineers.ExecuteTestATest;
import tests.b_splitengineers.InstabilityATest;

@RunWith(Suite.class)
@Suite.SuiteClasses({BaseEngineerATest.class, ExecuteTestATest.class, InstabilityATest.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JUnit4Runner {
}







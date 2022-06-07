package stepDefinitions;

import apiEngine.EndPoints;
import cucumber.ScenarioContext;
import cucumber.TestContext;

public class BaseSteps {

	//protected static final String USER_ID = "fc6fb320-444c-4e61-9351-63d61733c328";
    protected static final String USERNAME = "prateekgour18";
	protected static final String PASSWORD = "Pass@123";
    private EndPoints endPoints;
    private ScenarioContext scenarioContext;


    public BaseSteps(TestContext testContext) {
    	endPoints = testContext.getEndPoints();
    	scenarioContext = testContext.getScenarioContext();

    }

    public EndPoints getEndPoints() {
        return endPoints;
    }
    
    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
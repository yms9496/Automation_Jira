package stepDefinitions;

import apiEngine.model.requests.*;
import cucumber.TestContext;
import io.cucumber.java.en.Given;

public class AccountSteps extends BaseSteps {

    public AccountSteps(TestContext testContext){
    	super(testContext);
    }

    @Given("^I am an authorized user$")
    public void iAmAnAuthorizedUser() {
        AuthorizationRequest authRequest = new AuthorizationRequest(USERNAME, PASSWORD);
        getEndPoints().authenticateUser(authRequest);
    }

}
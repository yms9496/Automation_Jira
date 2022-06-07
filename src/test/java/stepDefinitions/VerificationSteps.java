package stepDefinitions;

import org.junit.Assert;

import apiEngine.IRestResponse;
import apiEngine.model.response.DeleteBook;
import apiEngine.model.response.UserAccount;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;

public class VerificationSteps extends BaseSteps {

	    public VerificationSteps(TestContext testContext) {
	        super(testContext);
	    }
	    
	    @Then("The book is added")
		public void bookIsAdded() {
			Assert.assertEquals(201, ((IRestResponse<UserAccount>)(getScenarioContext().getContext(Context.USER_ACCOUNT_RESPONSE))).getStatusCode());

//			UserAccount userAccount = response.getBody().as(UserAccount.class); 
//			
//			Assert.assertEquals(USER_ID, userAccount.userID); 
//			Assert.assertEquals(book.isbn, userAccount.books.get(0).isbn);
		}
	    
	    @Then("The book is removed")
		public void bookIsRemoved() {
			
			IRestResponse<DeleteBook> deleteBookResponse = (IRestResponse<DeleteBook>)(getScenarioContext().getContext(Context.BOOK_REMOVE_RESPONSE));
			Assert.assertEquals(204, deleteBookResponse.getStatusCode());

//			 userAccountResponse = EndPoints.getUserAccount(USER_ID, tokenResponse.token);
//		     Assert.assertEquals(200, userAccountResponse.getStatusCode());
//		        
//	        Assert.assertEquals(0, userAccountResponse.getBody().books.size());
			

			// UserAccount_Del_Response userAccountd =
			// response.getBody().as(UserAccount_Del_Response.class);
//			Assert.assertEquals(0, userAccountd.books.size());
		}

}

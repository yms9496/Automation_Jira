package stepDefinitions;

import org.junit.Assert;

import apiEngine.EndPoints;
import apiEngine.IRestResponse;
import apiEngine.model.requests.AddBooksRequest;
import apiEngine.model.requests.ISBN;
import apiEngine.model.requests.RemoveBookRequest;
import apiEngine.model.response.Book;
import apiEngine.model.response.Books;
import apiEngine.model.response.DeleteBook;
import apiEngine.model.response.Token;
import apiEngine.model.response.UserAccount;
import configs.ConfigReader;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class BooksSteps extends BaseSteps {

	    public BooksSteps(TestContext testContext){
	    	super(testContext);
	    }
	   

		@Given("A list of books are available")
		public void listOfBooksAreAvailable() {

			
			IRestResponse<Books> booksResponse = getEndPoints().getBooks();
			Book book = booksResponse.getBody().books.get(0);
	        getScenarioContext().setContext(Context.BOOK, book);
		}

		@When("I add a book to my reading list")
		public void addBookInList() {
			
			Book book = (Book) getScenarioContext().getContext(Context.BOOK);
			ISBN isbn = new ISBN((String)book.isbn);
	        String userId = (String)getScenarioContext().getContext(Context.USER_ID);
			
			AddBooksRequest addBooksRequest = new AddBooksRequest(userId, isbn);
	        IRestResponse<UserAccount> userAccountResponse = getEndPoints().addBook(addBooksRequest);
	        getScenarioContext().setContext(Context.USER_ACCOUNT_RESPONSE, userAccountResponse);
		}

//		@Then("The book is added")
//		public void bookIsAdded() {
//			Assert.assertEquals(201, ((IRestResponse<UserAccount>)(getScenarioContext().getContext(Context.USER_ACCOUNT_RESPONSE))).getStatusCode());
//
////			UserAccount userAccount = response.getBody().as(UserAccount.class); 
////			
////			Assert.assertEquals(USER_ID, userAccount.userID); 
////			Assert.assertEquals(book.isbn, userAccount.books.get(0).isbn);
//		}

		@When("I remove the book from my reading list")
		public void removeBookFromList() {

			Book book = (Book) getScenarioContext().getContext(Context.BOOK);
			RemoveBookRequest removeBookRequest = new RemoveBookRequest(ConfigReader.getInstance().getUserID(), (String)(book.isbn));
			IRestResponse<DeleteBook> deleteBookResponse = getEndPoints().removeBook(removeBookRequest);
	        getScenarioContext().setContext(Context.BOOK_REMOVE_RESPONSE, deleteBookResponse);

		}

//		@Then("The book is removed")
//		public void bookIsRemoved() {
//			
//			IRestResponse<DeleteBook> deleteBookResponse = (IRestResponse<DeleteBook>)(getScenarioContext().getContext(Context.BOOK_REMOVE_RESPONSE));
//			Assert.assertEquals(204, deleteBookResponse.getStatusCode());
//
////			 userAccountResponse = EndPoints.getUserAccount(USER_ID, tokenResponse.token);
////		     Assert.assertEquals(200, userAccountResponse.getStatusCode());
////		        
////	        Assert.assertEquals(0, userAccountResponse.getBody().books.size());
//			
//
//			// UserAccount_Del_Response userAccountd =
//			// response.getBody().as(UserAccount_Del_Response.class);
////			Assert.assertEquals(0, userAccountd.books.size());
//		}
	}

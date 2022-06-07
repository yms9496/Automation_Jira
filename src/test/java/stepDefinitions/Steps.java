package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import apiEngine.EndPoints;
import apiEngine.IRestResponse;
import apiEngine.model.requests.AddBooksRequest;
import apiEngine.model.requests.AuthorizationRequest;
import apiEngine.model.requests.ISBN;
import apiEngine.model.requests.RemoveBookRequest;
import apiEngine.model.response.Book;
import apiEngine.model.response.Books;
import apiEngine.model.response.DeleteBook;
import apiEngine.model.response.Token;
import apiEngine.model.response.UserAccount;
import apiEngine.model.response.UserAccount_Del_Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Steps {

	/*private static final String USER_ID = "fc6fb320-444c-4e61-9351-63d61733c328";
	private static final String USERNAME = "prateekgour18";
	private static final String PASSWORD = "Pass@123";
	 private final String BaseUrl = "https://bookstore.toolsqa.com";
	    private EndPoints endPoints;

	private static Response response;
	private static String jsonString;
	private static String bookId;
	private static Token tokenResponse;
	private static Book book;
	public static DeleteBook deletedBook;
	private static IRestResponse<DeleteBook> deleteBookResponse;
	private static IRestResponse<UserAccount> userAccountResponse;

	@Given("I am an authorized user")
	public void iAmAnAuthorizedUser() {
		
		endPoints = new EndPoints(BaseUrl);

		AuthorizationRequest authRequest = new AuthorizationRequest(USERNAME, PASSWORD);
		tokenResponse =endPoints.authenticateUser(authRequest).getBody();

	}

	@Given("A list of books are available")
	public void listOfBooksAreAvailable() {

		IRestResponse<Books> booksResponse = endPoints.getBooks();
		book = booksResponse.getBody().books.get(0);
	}

	@When("I add a book to my reading list")
	public void addBookInList() {
		ISBN isbn = new ISBN(book.isbn);
		AddBooksRequest addBooksRequest = new AddBooksRequest(USER_ID, isbn);
		userAccountResponse = endPoints.addBook(addBooksRequest,tokenResponse.token);
	}

	@Then("The book is added")
	public void bookIsAdded() {
		Assert.assertEquals(201, userAccountResponse.getStatusCode());

//		UserAccount userAccount = response.getBody().as(UserAccount.class); 
//		
//		Assert.assertEquals(USER_ID, userAccount.userID); 
//		Assert.assertEquals(book.isbn, userAccount.books.get(0).isbn);
	}

	@When("I remove the book from my reading list")
	public void removeBookFromList() {

		RemoveBookRequest removeBookRequest = new RemoveBookRequest(USER_ID, book.isbn);
		deleteBookResponse = endPoints.removeBook(removeBookRequest,tokenResponse.token);
		deletedBook =  endPoints.removeBook(removeBookRequest,tokenResponse.token).getBody();

	}

	@Then("The book is removed")
	public void bookIsRemoved() {
		Assert.assertEquals(204, deleteBookResponse.getStatusCode());

//		 userAccountResponse = EndPoints.getUserAccount(USER_ID, tokenResponse.token);
//	     Assert.assertEquals(200, userAccountResponse.getStatusCode());
//	        
//        Assert.assertEquals(0, userAccountResponse.getBody().books.size());
		

		// UserAccount_Del_Response userAccountd =
		// response.getBody().as(UserAccount_Del_Response.class);
//		Assert.assertEquals(0, userAccountd.books.size());
	}
*/
}

//{
//	  "userID": "fc6fb320-444c-4e61-9351-63d61733c328",
//	  "username": "prateekgour18",
//	  "password": "Pass@123"
//	}
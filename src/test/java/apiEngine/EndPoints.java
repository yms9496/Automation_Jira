package apiEngine;

import apiEngine.model.requests.AddBooksRequest;
import apiEngine.model.requests.AuthorizationRequest;
import apiEngine.model.requests.RemoveBookRequest;
import apiEngine.model.response.Books;
import apiEngine.model.response.DeleteBook;
import apiEngine.model.response.Token;
import apiEngine.model.response.UserAccount;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndPoints {
	
	private final RequestSpecification request;

    public EndPoints(String baseUrl) {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }

	public void authenticateUser(AuthorizationRequest authRequest) {
		
		 Response response = request.body(authRequest).post(Route.generateToken());
	        if (response.statusCode() != 200)
	            throw new RuntimeException("Authentication Failed. Content of failed Response: " + response.toString() + " , Status Code : " + response.statusCode());

	        Token tokenResponse = response.body().jsonPath().getObject("$", Token.class);
	        request.header("Authorization", "Bearer " + tokenResponse.token);

	}

	public IRestResponse<Books> getBooks() {

		Response response = request.get(Route.books());
		return new RestResponse(Books.class, response);
	}

	public IRestResponse<UserAccount> addBook(AddBooksRequest addBooksRequest) {

		Response response = request.body(addBooksRequest).post(Route.books());
		return new RestResponse(UserAccount.class, response);
	}

	public IRestResponse<UserAccount> getUserAccount(String userId, String token) {

		Response response = request.get(Route.userAccount(userId));
		return new RestResponse(UserAccount.class, response);
	}

	public IRestResponse<DeleteBook> removeBook(RemoveBookRequest removeBookRequest) {

		Response response = request.body(removeBookRequest).delete(Route.book());
		return new RestResponse(DeleteBook.class, response);
	}

}

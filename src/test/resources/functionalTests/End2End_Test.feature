Feature: End to Ent test for Book Store API
Description: Cover end to end happy flow for customer. 

Book Store Swagger URL: https://demoqa.com/swagger/#/

Background: User generates a token for Authorization
	Given I am an authorized user
	
Scenario: Authorized user is able to add and remove a book. 
	Given A list of books are available
	When I add a book to my reading list
	Then The book is added
	When I remove the book from my reading list
	Then The book is removed 
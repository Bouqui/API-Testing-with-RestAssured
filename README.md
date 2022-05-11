# API-Testing-with-RestAssured

# How to run the code
1. Install Java, Intellij or Eclipse, TestNG and RestAssured dependencies
2. Clone or download the project from this reprository
3. Set up other dependencies as we have it in the pom.xml file 
    - For BDD purpose, hamcrest libraries were imported 
4. To run all the tests, you can run the testng.xml file
5. To run individual test, navigate to each test file and run the class or the method for each test

Note - For FavQuote.class file, a session has to be created before some tests can be run
Also, getListOfQuotes scenario should be run before getListOfQuotesByAuthor scenario 

Feature: Register New Customer and place an order of most expensive Dress

  Background: User is on signon page
    Given user is on Application landing page
  
  Scenario Outline: As a new customer, Create an account and place order of more expensive Dress
    When user enter "<email address>" and click on create an account button
    When user select title "<title>"
    And user type first name "<first name>"
    And user type sur name "<sur name>"
    And user enter password "<password>"
    And user enter address "<address>"
    And user enter city "<city>"
    And user select the state "<state>"
    And user enter the zip "<zip>"
    And user select the country "<country>"
    And user enter mobile phone "<mobile phone>"
    And user enter address alias "<address alias>"
    When click on Register Button
    Then user logged in and navigate to my account page
    When user clicks on "Dresses" tab
    Then user clicks on dropdown tab
    And  user clicks on productname
    Then user product added to the cart
    Then user clicks on proceed to checout tab
    And user validate the product name
    And user clicks on cart icon
    #Then user clicks on signout Button
    
    Examples: 
      | email address         | title | first name | sur name | password | address | city      | state | zip   | country       | mobile phone | address alias |
      | balb255@gxbs.com      | mr    | Balaji     | Rao      | Pass1wrd | x1 lane | salt lake | Ohio  | 84044 | United States |   9834398090 | X1list        |
    
   
  Scenario Outline: Registered user logged in and can see the most expensive dress in cart
    When user enters "<email id>" on signin page   
    Then user enters "<password>" and click on signin Button
    And user clicks on cart icon
    #Then user clicks on signout Button

   Examples: 
      | email id            | password |
      | balb255@gxbs.com    | Pass1wrd |


#Scenario: Registered user logged in and can see the most expensive dress in cart
    #When user enters email Id
    #Then user enters "<password>" and click on signin Button
    #And user clicks on cart icon
    #Then user clicks on signout Button


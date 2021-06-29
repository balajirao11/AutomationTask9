Feature: Register New Customer and place an order from T-shirts tab

  Scenario Outline: As a new customer, Create an account and place order from T-shirts tab
    Given user is on Signon page
    #When user validate fields
    #When user enter "<email address>" and click on continue button
    #When user enter "<password>" and click on signin button
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
    #When user clicks on "T-shirts" tab
    When user clicks on "Dresses" tab
    Then user clicks on dropdown tab
    Then user product added to the cart
    Then user clicks on proceed to checout tab
    Then user clicks on signout button
    #Then user clicks on checkout
    
    #Examples: 
    # | email address         | password|
    #  | balajirao11@gmail.com | Jay9sre$|



    Examples: 
      | email address         | title | first name | sur name | password | address | city      | state | zip   | country       | mobile phone | address alias |
      | balajirao11@gmail.com | mr    | firstxa    | lastxa   | Pawd1    | x1 lane | salt lake | Ohio  | 84044 | United States |   9834398090 | X1list        |


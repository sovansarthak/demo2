@tag

  Feature: Adding product to cart 
  
  Background:
  
  Given I have landed on the landing page

  @tag2
  Scenario Outline: Successfull order placement on the webpage
    Given Logged in with <email> and <password> 
    When I add <productname> to cart 
    And Checkout <productname> and confirm order
    Then "THANKYOU FOR THE ORDER." is displayed on the page

    Examples: 
      | email         | password       | productname     |
      | abcd@abcd.com | March@2021     | ADIDAS ORIGINAL |
      

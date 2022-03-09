Feature: Product Page
  @productpage @Positive
  Scenario Outline: As user i want buy the product
    Given the user is on login pages
    When the user enter valid email "<email>"
    And hits selanjutnya
    When the user entered valid password "<password>"
    And hits masuk
    When user enter keyword on search "<keyword>"
    And user click on 1st list
    And user click on Beli button
    Then verify label Checkout is displayed
    Examples:
      | email                     | password           | keyword      |
      | yourvalidemail1@email.com | yourvalidpassword1 | yourkeyword1 |
      | yourvalidemail2@email.com | yourvalidpassword2 | yourkeyword2 |
      | yourvalidemail3@email.com | yourvalidpassword3 | yourkeyword3 |

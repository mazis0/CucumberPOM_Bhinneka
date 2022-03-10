Feature: Checkout Page
  @checkout
  Scenario Outline: As customer i want to checkout the product
    Given the user is on login pages
    When the user enter valid email "<email>"
    And hits selanjutnya
    When the user entered valid password "<password>"
    And hits masuk
    When user enter keyword on search "<keyword>"
    And user click on 1st list
    And user click on Beli button
    And choose JNE Regular Service for shipping
    Then verify subtotal and total is same
    And click on Lanjut Pembayaran
    Then verify Metode Pembayaran frame is displayed

    Examples:
      | email                     | password           | keyword      |
      | muhammadajis445@gmail.com | Az!s1234           | payung       |
      | yourvalidemail2@email.com | yourvalidpassword2 | yourkeyword2 |
      | yourvalidemail3@email.com | yourvalidpassword3 | yourkeyword3 |
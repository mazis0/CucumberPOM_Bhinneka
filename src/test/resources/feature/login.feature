Feature: Web Login
  @login @Positive
  Scenario Outline: User should be able to login with valid credentials

    Given the user is on login pages
    When the user enter valid email "<email>"
    And hits selanjutnya
    When the user entered valid password "<password>"
    And hits masuk
    Then The user should be login Successfully
    And verify profile is displayed
    Examples:

      | email                | password      |
      | muhammadajis445@gmail.com | Az!s1234 |
      | youremail2@gmail.com | yourpassword2 |
      | youremail3@gmail.com | yourpassword3 |

  @Negative
   Scenario Outline: Verify error message "email belum terdaftar" displayed when user input not registered email
    Given the user is on login pages
    When the user enter not registered email "<email>"
    And hits selanjutnya
    Then error message email belum terdaftar should be displayed

    Examples:

      | email                | password      |
      | youremail1@gmail.com | yourpassword1 |


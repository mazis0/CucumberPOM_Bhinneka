Feature: Search
  @searching
  Scenario Outline: Verify that the response fetched for a particular keyword is correct and related to the keyword, containing links to the particular webpage
    Given The user is on Home page
    When user enter keyword on search "<search>"
    And user click on 1st list
    Then user should be successfully move to product page 1st list
    Examples:
      | search |
      | payung |
      | sendal |

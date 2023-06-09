Feature: ITWORX assignment

  Scenario: The given test case
    Given User is logged in to WINJIGO website
    When User creates new course
    And User search for the created course
    Then Created course should be returned in the list
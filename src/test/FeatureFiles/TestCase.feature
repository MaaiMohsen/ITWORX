Feature: ITWORX assignment

  Scenario: Create new course 
    Given User is logged in to WINJIGO website
    When User creates new course
    And User search for the created course
    Then Created course should be returned in the list
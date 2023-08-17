Feature: Validate HowOldAreYou With Diff Data

  Scenario Outline: Verifies User able to get the Age by providing DOB
    Given Home page is displayed
    When Input credentials to Name "<Name>" and Date of birth "<DOB>"
    And Click submit button
    Then user should be able view message according to the  "<Name>" and "<DOB>"
    
    Examples: 
      | Name         | DOB           | 
      | Charu        | 13/10/2000    |
      | Jain         | 13/10/1900    |
      | Charu123     | 15/10/2023    |
      | Jain123      | 17/08/2023    |
      | Charu Jain   | 17/08/1890    |
      | Charu Jain12   | 11/06/2023   |
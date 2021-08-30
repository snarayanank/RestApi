@Regression
Feature: Enroll new student, update student and delete student
  As a user, I can create enroll, update and delete student

  Background:

  @TC_01
  Scenario Outline: Enroll new students
    Given Enter the details of the students to enroll
    And Submit the entry
    Then Verify Student is enrolled successfully
    And Verify the Id of the new user

    Examples:
      id      | firstName      | lastName          | class            | Nationality     |
      1       | Student1       | Student1LN        | Class1           | Indian          |
      2       | Student2       | Student2LN        | Class2           | Singapore       |
      3       | Student3       | Student3LN        | Class3           | Malaysia        |
      4       | Student4       | Student4LN        | Class4           | Indian          |
      5       | Student5       | Student5LN        | Class5           | Indian          |

  @TC_02
  Scenario: Update existing student
    Given Fetch the details of an existing student
    And Change the class of the student and submit
    Then Verify Student class is updated successfully
    And Verify other details of the user is not changed

  @TC_03
  Scenario: Delete existing student
    Given Fetch the details of an existing student
    And Delete the student
    Then Verify Student class is deleted successfully
    And Verify the deleted user is not searchable
#Author: cristian.agu14@gmail.com
@login
Feature: Login in the DYDU app

  @tag1
  Scenario: Login in the portal web with user and password
    Given the user open the portal
    When the user write the user and password
    Then the user see the homepage

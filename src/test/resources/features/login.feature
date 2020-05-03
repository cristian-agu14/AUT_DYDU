#Author: your.email@your.domain.com
@login
Feature: Login in the DYDU app

  @tag1
  Scenario: Login in the portal web with user and password
    Given the user open the portal
    When the user enter the user and password
    Then the user see the homepage

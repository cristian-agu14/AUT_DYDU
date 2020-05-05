#Author: cristian.agu14@gmail.com
@create-bots
Feature: Create a bot for test this functionality

  Background: 
    Given the user open the portal
    When the user write the user and password

  @create-bot
  Scenario Outline: Feature for test the create bots
    Given the user see the homepage
    When the user start to create the bot
    When enter <nameBot> and <language> for the user
    Then the user can to see the bot created with the name <nameBot>

    Examples: 
      | nameBot      | language |
      | bot_test_qa3 | Espagnol |

#Author: cristian.agu14@gmail.com
@create-know
Feature: Create a know for a bot

  Background: 
    Given the user open the portal
    When the user write the user and password

  @create-know-to-bot-created
  Scenario Outline: how user create a know, i want to create to a bot created
    Given the user see the homepage
    When the user select a bot created with <nameBot>
    When the user write a <question> in the bot select
    When the user configure a <answer> for the question created
    When test the know to created
    Then user can to see the <answer> to the <question>

    Examples: 
      | nameBot      | question | answer |
      | bot_test_qa3 | Espagnol |        |

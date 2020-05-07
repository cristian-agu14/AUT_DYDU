#Author: cristian.agu14@gmail.com
@create-know
Feature: Create a know for a bot

  Background: 
    Given the user open the portal
    When the user write the user and password

  @create-know-to-bot-created
  Scenario Outline: how user create a Knowledge, i want to create this Knowledge to a bot created
    Given the user see the homepage
    When the user select a bot created with <nameBot>
    When the user write a question <question> in the bot select
    When the user configure a answer <answer> for the question created
    When test the know to created with the question <question>
    Then user can to see the <answer> is correct

    Examples: 
      | nameBot      | question                        | answer                                   |
      | bot_test_qa3 | ¿Cuantas veces puedo descargar? | Hola, hasta 5 descargas diarias. Saludos |

  @create-a-bot-with-a-Knowledge
  Scenario Outline: how user create a Knowledge, i want to create this Knowledge to a bot created
    Given the user see the homepage
    When the user start to create the bot
    When enter <nameBot> and <language> for the user
    When the user can to see the bot created with the name <nameBot>
    When the user select a bot created with <nameBot>
    When the user write a question <question> in the bot select
    When the user configure a answer <answer> for the question created
    When test the know to created with the question <question>
    Then user can to see the <answer> is correct

    Examples: 
      | nameBot      | language | question                                  | answer                                   |
      | bot_test_qa5 | Spanish  | ¿Cuantas veces puedo descargar un driver? | Hola, hasta 5 descargas diarias. Saludos |

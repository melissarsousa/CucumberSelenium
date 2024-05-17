Feature: Cadastro
    Scenario: Cadastro com sucesso
        Given User is on Homepage
        And User clicks on the login button
        When User enters the an email on email field
        And User enter the password on password field
        Then User should be redirectioned to SignUp page

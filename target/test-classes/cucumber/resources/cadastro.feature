Feature: Cadastro
    Scenario: Cadastro com sucesso
        Given User is on Homepage
        And User clicks on the login button
        When User enters a name on name field
        And User enters an email on email field
        Then User should be redirectioned to SignUp page

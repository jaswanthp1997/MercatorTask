Feature:Testing the sample task

  @sample
  Scenario Outline:Adding product with high value
    Given User navigates to the application
    And   User logins with "<userid>" and "<password>"
    And  Select the highest value product to add to cart
    And  User navigates to the checkout page to complete transaction
    Then Order confirmation is displayed

    Examples:
    |userid            |password           |
    |standard_user     |  secret_sauce     |

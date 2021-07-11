Feature: Making a transaction

  Scenario: User is buying "Hummingbird Printed Sweater"

    Given User is logged in to the shop

    And User is on Presta shop homepage

    When User uses shop search engine to find "Hummingbird Printed Sweater"

    And User checks if "Hummingbird Printed Sweater" is on discount

    And User clicks on the "Hummingbird printed sweater" box

    And User chooses item size "M"

    And User chooses quantity of item "5"

    And User is adding items to his shopping cart

    And User opens checkout page

    And User chooses address

    And User chooses PrestaShop "pick up in store" shipping method

    And User chooses "Pay by Check" payment method

    And User checks "terms of service" box

    And User clicks "order with an obligation to pay" button

    Then User sees confirmation page

    And User goes to order history page

    And User checks order history

Feature: Adding new address to users account

  Scenario Outline: logging to users account and adding new address

    Given User is logged in to Presta shop

    When User goes to NewAddressesPage

    And User adds a new Alias "<Alias>"

    And User adds a new Address "<Address>"

    And User adds name of the city "<City>"

    And User adds new Postal Code "<postalCode>"

    And User saves information

    Then User checks the new address

    And User deletes new address

    Examples:
      | Alias       | Address       | City     | postalCode |
      | kopacz      | Matowiecka 14 | Poznań   | 14-451     |
      | Warka       | Koperska 55   | Katowice | 99-999     |
      | 12_Makarena | Malinowa 819  | Berlin   | 10115      |




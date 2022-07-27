Feature: Detail Contact
  Look up contact detail

  Scenario Outline: A proper contact shows under Contact Detail page
    Given Search page is displayed
    When I search for <firstName>
    And  I click on contact in search result
    Then I see full name <fullName> is correct
    Examples:
      | firstName | fullName      |
      | "Sara"    | "Sara Alston" |

  Scenario Outline: Contact has a proper phone number
    Given Search page is displayed
    When I search for <firstName>
    And  I click on contact in search result
    Then I see contact phone <contactPhone> is correct
    Examples:
      | firstName | contactPhone      |
      | "Sara"    | "+1(343)-4779854" |

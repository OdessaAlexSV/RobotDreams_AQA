Feature: Search Contact
  Look for a contact

  Scenario Outline: Contact found in search result by FirstName
    Given Search page is displayed
    When I search for <firstName>
    Then I see <fullName> in search result
    Examples:
      | firstName | fullName      |
      | "Sara"    | "Sara Alston" |

  Scenario Outline: Contact found in search result by LastName
    Given Search page is displayed
    When I search for <lastName>
    Then I see <fullName> in search result
    Examples:
      | lastName | fullName      |
      | "Alston" | "Sara Alston" |

  Scenario Outline: No Contact found in search result
    Given Search page is displayed
    When I search for <anyText>
    Then I see <expectedResultNotification> under screen
    Examples:
      | anyText   | expectedResultNotification                   |
      | "Test"    | "No contacts found with \"Test\" in the name"|
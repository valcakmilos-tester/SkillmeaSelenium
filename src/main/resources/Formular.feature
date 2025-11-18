Feature: Formular.feature

  Scenario: Kontrola radiobutton u pohlavia
    Given Uzivatel je na stranke s formularom
    When Uzivatel napise do input meno "Milos Valcak"
    And Uzivatel napise do input email "email@email.com"
    And Uzivatel klikne na radiobutton male
    And Uzivatel klikne na radiobutton female
    Then Uzivatel vidi zaskrtnuty radiobutton female
    # And Uzivatel vidi odskrtnuty radiobutton male

  Scenario: Novy Test
    Given Uzivatel je na stranke s formularom
    When Uzivatel napise do input meno "Peter Novak"
    And Uzivatel klikne na radiobutton female
    Then Uzivatel vidi odskrtnuty radiobutton male

  Scenario Outline: Novy test pomocou scenario outline
    Given Uzivatel je na stranke s formularom
    When Uzivatel napise do input meno "<meno>"
    And Uzivatel napise do input email "<email>"
    And Uzivatel klikne na radiobutton male
    And Uzivatel klikne na radiobutton female
    Then Uzivatel vidi zaskrtnuty radiobutton female

    Examples:
    |meno   |email            |
    |Petra  |petra@email.com  |
    |Katka  |katka@email.com  |
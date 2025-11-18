Feature: Formular.feature

  Scenario: Kontrola radiobutton u pohlavia
    Given Uzivatel je na stranke s formularom
    When Uzivatel napise do input meno "Milos Valcak"
    And Uzivatel napise do input email "email@email.com"
    And Uzivatel klikne na radiobutton male
    And Uzivatel klikne na radiobutton female
    Then Uzivatel vidi zaskrtnuty radiobutton female
    And Uzivatel vidi odskrtnuty radiobutton female
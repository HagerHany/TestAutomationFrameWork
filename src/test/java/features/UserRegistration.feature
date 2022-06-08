Feature: User Registration
  I want to check that the user can register in our e-commerce website
  Scenario Outline: : User Registration
    Given the user go to Registration page
    When I enter "<Gender>", "<firstname>", "<lastname>", "<e-mail>", "<password>"
    Then the registration page displayed successfully

 Examples:

         |Gender | firstname | lastname | e-mail | password |
         | male | ahmed| hany | ahmedhany@gmail.com |123456789|
         | male |ahmed | hany | modyhany@gmail.com|123456789|
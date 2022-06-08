$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("UserRegistration.feature");
formatter.feature({
  "line": 1,
  "name": "User Registration",
  "description": "I want to check that the user can register in our e-commerce website",
  "id": "user-registration",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": ": User Registration",
  "description": "",
  "id": "user-registration;:-user-registration",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the user go to Registration page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I enter \"\u003cGender\u003e\", \"\u003cfirstname\u003e\", \"\u003clastname\u003e\", \"\u003ce-mail\u003e\", \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the registration page displayed successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "user-registration;:-user-registration;",
  "rows": [
    {
      "cells": [
        "Gender",
        "firstname",
        "lastname",
        "e-mail",
        "password"
      ],
      "line": 10,
      "id": "user-registration;:-user-registration;;1"
    },
    {
      "cells": [
        "male",
        "ahmed",
        "hany",
        "ahmedhany@gmail.com",
        "123456789"
      ],
      "line": 11,
      "id": "user-registration;:-user-registration;;2"
    },
    {
      "cells": [
        "male",
        "ahmed",
        "hany",
        "modyhany@gmail.com",
        "123456789"
      ],
      "line": 12,
      "id": "user-registration;:-user-registration;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": ": User Registration",
  "description": "",
  "id": "user-registration;:-user-registration;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the user go to Registration page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I enter \"male\", \"ahmed\", \"hany\", \"ahmedhany@gmail.com\", \"123456789\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the registration page displayed successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserRegistration.the_user_go_to_Registration_page()"
});
formatter.result({
  "duration": 7064769400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "male",
      "offset": 9
    },
    {
      "val": "ahmed",
      "offset": 17
    },
    {
      "val": "hany",
      "offset": 26
    },
    {
      "val": "ahmedhany@gmail.com",
      "offset": 34
    },
    {
      "val": "123456789",
      "offset": 57
    }
  ],
  "location": "UserRegistration.i_enter(String,String,String,String,String)"
});
formatter.result({
  "duration": 1987221600,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistration.the_registration_page_displayed_successfully()"
});
formatter.result({
  "duration": 78721600,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": ": User Registration",
  "description": "",
  "id": "user-registration;:-user-registration;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the user go to Registration page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I enter \"male\", \"ahmed\", \"hany\", \"modyhany@gmail.com\", \"123456789\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the registration page displayed successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserRegistration.the_user_go_to_Registration_page()"
});
formatter.result({
  "duration": 2665709500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "male",
      "offset": 9
    },
    {
      "val": "ahmed",
      "offset": 17
    },
    {
      "val": "hany",
      "offset": 26
    },
    {
      "val": "modyhany@gmail.com",
      "offset": 34
    },
    {
      "val": "123456789",
      "offset": 56
    }
  ],
  "location": "UserRegistration.i_enter(String,String,String,String,String)"
});
formatter.result({
  "duration": 1965448900,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistration.the_registration_page_displayed_successfully()"
});
formatter.result({
  "duration": 64746000,
  "status": "passed"
});
});
# Frontend Automated Test Task

__Problem Statement Reads:__
- How would you test search UI functionality of your favourite website (e.g. https://medium.com, https://www.google.de )? Choose your favourite website which has search functionality.
    1. Document several test cases.
    2. Implement one or two automated tests based on the test cases

__Solution at High Level:__
- Selected https://www.google.co.in as AUT for Identifying and Automating Tests around, explaining below the further implementation of the solution.

### Tests Identified
 1. Navigate to https://www.google.co.in site
 2. Google Search bar should displayed and it should be enabled
 3. User should be able to enter text into search bar
 4. Upon entering text to search bar, google should populate Auto Suggested list
 5. On click of search button, application should show results
 6. Verify if application shows dictionary for searched word
 7. The result page should contain Menu bar with options like Map, Images etc.
 8. On click of any of the item from above mentioned Menu bar, it should open relevant results. e.g. On click of Images, the result containing images relevant to search query should be displayed
 9. On click of settings dropdown containing multiple setting options should be displayed
 10. On click of Languages under Settings, user should get redirected to Language specific settings to select preferred language

### Tests Automated
 1. Navigate to https://www.google.co.in site
 2. User should be able to enter text into search bar
 3. Upon entering text to search bar, google should populate Auto Suggested list
 4. Verify if application shows dictionary for searched word


### Prerequisites

Project repository is cloned to your drive using following command
```
git clone <git URL of this project>
```
Chromedriver needed to be do downloaded on your machine.
It can be downloaded from: http://chromedriver.chromium.org/downloads

### Setting Driver to Chromedriver

Help WebDriver find the downloaded ChromeDriver executable, any of the following steps should do the trick:
1. Include the ChromeDriver location in your PATH environment variable
2. Specify its location via the webdriver.chrome.driver system property (see sample below)

_Setting chromedriver path in this project:_
- Under src/test/java go to package com.thoughtworks.gauge.maven.utils and open BaseDriverClass file
- Under BaseDriverClass constructor uncomment the code and provide path to downloaded chromedriver

```
System.setProperty("webdriver.chrome.driver","/path/to/driver/file");
```

## Running the tests

```
$> ./mvn test
```

## Test Report

Test Reports could be found at:
```
./reports/html-report/index.html
```

## About the Test Framework Used

After analysing the problem statement and time availability, decided to go for test framework which will be easy to setup and quick to start with.

### Why Guage?
- Guage is the Test Framework which can be quickly setup and can start working with.
- Guage provides way to write tests in user understandable plain English so any stakeholder can understands the report of execution easily.
- Gauge has a robust plugin architecture and plugin ecosystem. You can easily extend Gauge to add support for IDEs, drivers, datasources, text execution events or your favourite programming language.
- Gauge supports data-driven testing. Keep your data sets out of your test scripts to run them repeatedly against multiple data sets. Easily test with large data sets, while keeping specifications highly readable.
- Guage support Maven To build and manage project dependencies.
- Guage has functionality to take screenshots as and when required, it save time of debugging by taking screenshots on failure by default.
- Guage reports show the time taken by each step to execute and can help in understanding performance as well.
- Gauge works with multiple languages, IDEs, CI/CD tools and automation drivers.

## Built With

* [Guage](https://docs.gauge.org/latest/index.html) - The test framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Selenium](https://www.seleniumhq.org/docs/) - Used for Web-Browser Automation



## Allure Marathon Example

### Getting Started

To generate Allure Test Results you should perform following steps:

```bash
$ git clone git@github.com:allure-examples/allure-marathon-example.git
$ ./gradlew clean marathonDebugAndroidTest
```

Test results will be generated to `app/build/reports/marathon/debugAndroidTest/allure-results` folder. To generate the report you can use the following command of allure commandline:

```bash
$ allure serve app/build/reports/marathon/debugAndroidTest/allure-results
```

There is another way of generating the report. The generated report can be opened here "allure-report/index.html". The command to generate the report is the following:

```bash
$ allure report app/build/reports/marathon/debugAndroidTest/allure-results
```

### Tests selective run (filtering)

This feature works when you are triggering a build from Allure TestOps by selecting separate test cases (not all in your project).

Allure TestOps agent creates **testplan.json** file  with the list of tests on CI, then the test framework adaptor reads the content and makes the selection of the tests to be executed.

#### Requirements

Allure framework libraries not earlier than 2.13.9

#### How to check locally

For this particular example you can create **testplan.json** file in the root project's folder. It can contain the following content :

```JSON
{
  "version": "1.0",
  "tests": [
    {
      "id": "777",
      "selector": "allure.example.marathon.IncrementButtonTest.shouldIncreaseValue"
    }
  ]
}
```
So, we expect only `shouldIncreaseValue` test to be executed.

##### Steps

In the terminal type the following:
```bash
export ALLURE_TESTPLAN_PATH=$PWD/testplan.json
# just to check the variable was created 
echo $ALLURE_TESTPLAN_PATH
# run your tests
./gradlew clean marathonDebugAndroidTest
```

Marathon will execute only one test of the two tests present in this example project.



### More

* [Documentation](https://docs.qameta.io/allure/2.0/)
* [Issue Tracking](https://github.com/allure-framework/allure2/issues?labels=&milestone=&page=1&state=open)
* Gitter chat room: [https://gitter.im/allure-framework/allure-core](https://gitter.im/allure-framework/allure-core)
* StackOverflow tag: [Allure](http://stackoverflow.com/questions/tagged/allure)

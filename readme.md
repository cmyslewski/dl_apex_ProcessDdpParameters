ProcessDdps sample
==================

Provides a Visualforce page that implements the Process DocGen Package component, and a corresponding Apex class that uses the ProcessDdpParameters class to process DocGen Packages for Salesforce accounts.

Overview
--------

The sample includes the following files:

* ProcessDdps.html

    A Visualforce page that implements the Process DocGen Package \(`loop:processddp`\) component and uses the ProcessDdpsExt class, included with the sample, to process DocGen Packages for Salesforce accounts. The page uses the Process DocGen Package component to display progress and information about each DocGen Package processed.

    Three query string parameters are used to pass information from the Visualforce page to the ProcessDdpsExt class:

    Parameter | Description
    --- | ---
    ids | A comma-delimited list of Salesforce account IDs, representing accounts on which the DocGen Package specified in ddpId is run.
    ddpId | The ID of the DocGen Package to be run on the Salesforce accounts specified in ids.
    deliveryOptionId | The ID of the Delivery Option to be used for the DocGen Package specified in ddpId.

    The Visual force page displays an Apex page block table component \(`apex:pageBlockTable`\), with a row for each Salesforce account, that contains two columns:

    Column | Description
    --- | ---
    Account Name | The name of the Salesforce account. The value in this column is provided by the AccountInfo instance for that row, provided to the Visualforce page by the ProcessDdpsExt class.
    DDP | The Process DocGen Package component that displays the status of the DocGen Package being processed for the Salesforce account. The Process DocGen Package component is configured using the ProcessDdpParameters instance for that row, also provided to the Visualforce page by the ProcessDdpsExt class.

* ProcessDdpsExt.java

    An Apex outer class, ProcessDdpsExt, and an Apex inner class, AccountInfo, which interacts with the Visualforce page and the Process DocGen Package component. The ProcessDdpsExt class serves as the custom controller for the Visualforce page.

    If the value for the ids query string parameter specified for the Visualforce page isn't empty, the ProcessDdpsExt class parses the value and retrieves the corresponding Account for each account ID from by executing an SOQL query.

    If at least one Account was returned by the SOQL query, the class then iterates through the query results and, for each Account, defines a ProcessDdpParameters instance that uses the DocGen Package specified in the ddpId query string parameter and the Delivery Option specified in the deliveryOptionId query string parameter to define a DocGen Package request for that account. The ProcessDdpsExt class ensures that the Process DocGen Package component for that account is displayed using the Bootstrap 3.2.0 style theme.

    The class then creates an AccountInfo instance, using the Account and the ProcessDdpParameters instances for that Salesforce account, and adds it to the list used to define the contents of the table in the Visualforce page.

    If the value for the ids query string parameter wasn't specified, or if at least one Account wasn't returned by the SOQL query, the class adds an error message to the Visualforce page indicating that at least one account ID must be specified in the ids query string parameter.

Implementing the sample
-----------------------

You need to first implement the ProcessDdpsExt and AccountInfo Apex classes in Salesforce by using the Developer Console, and then create the Visualforce page that references those Apex classes.

To implement the sample

1. Log into your Salesforce instance, using a Developer Edition account, and ensure that Visualforce development mode is enabled.
1. From your Salesforce instance, open the Developer Console.

    For more information about the Developer Console in Salesforce, see [Developer Console](https://developer.salesforce.com/page/Developer_Console).
1. From the Developer Console, create a new Apex class named ProcessDdpsExt.
1. In a text editor, open the sample file named ProcessDdpsExt.java, and paste the contents of that sample file into the Developer Console, overwriting the existing contents.
1. Save the new Apex class, and then close the Developer Console.
1. Create a Visualforce page using the following URL, replacing Salesforce_instance with the URL for your Salesforce instance:

    ```https://Salesforce_instance/apex/ProcessDdps```

    For more information about creating a Visualforce page, see [Creating Your First Page](https://developer.salesforce.com/docs/atlas.en-us.pages.meta/pages/pages_quick_start_hello_world.htm).

1. Open the Page Editor for the new Visualforce page.
1. In a text editor, open the sample file named ProcessDdps.html, and paste the contents of that sample file into the Page Editor, overwriting the existing contents for the new Visualforce page.
1. Save the new Visualforce page.

Using the sample
----------------

To use the sample, replace the variables in  the following URL and reload the page:

<https://Salesforce_instance/apex/ProcessDdps?ids=Account_IDs&ddpId=DdP_Id&deliveryOptionId=DeliveryOption_Id>

* _Salesforce_instance_ with the URL for your Salesforce instance.
* _AccountIds_ with a comma-delimited list of Salesforce account Ids.
* _DDP_Id_ with the Id of the DocGen Package to process.
* _DeliveryOption_Id_ with the Id of the Delivery Option to use for the DocGen Package.

When the Visualforce page loads, it will request a DocGen Package run for each Salesforce account, and the Process DocGen Package component for each Salesforce account displays the status of each DocGen Package run.

For more information

[Nintex Document Generation for Salesforce product assistance](https://help.nintex.com/en-US/docgen/docgen-portal.htm)

[Apex for Nintex DocGen for Salesforce](https://help.nintex.com/en-us/docgen/docservices/Default.htm#cshid=9032)

[](../T_ExternalData.htm)[ExternalData class](http://help.nintex.com/en-us/docgen/docservices/Default.htm#cshid=9057)

[](../I_IApexDataSource.htm)[IApexDataSource interface](https://help.nintex.com/en-us/docgen/docservices/Default.htm#cshid=9058)

ProcessDdp Lightning Component sample
==================

Provides a Lightning Component and corresponding Apex class to process DocGen Packages for Salesforce accounts.

Overview
--------

The sample includes the following files:

* GenerateDocument.cmp

   The Lightning Component displays progress and information about each DocGen Package processed. Four parameters pass information from the Lightning Component to the ProcessDdpsExt class:

    Parameter | Description
    --- | ---
    recordIds | A comma-delimited list of Salesforce account IDs, representing accounts on which the DocGen Package specified in ddpId is run.
    documentPackageId | The ID of the DocGen Package to be run on the Salesforce accounts specified in ids.
    deliveryOptionId | The ID of the Delivery Option to be used for the DocGen Package specified in ddpId.
    sObjectType | The type of record for recordIds.

* GenerateDocumentController.js

    The JavaScript controller for the Lightning Component passes the parameters to the Visualforce page.

* ProcessDdp.vfp

    A Visualforce page that implements the Process DocGen Package \(`loop:processddp`\) component and uses the ProcessDdpsExt class, included with the sample, to process DocGen Packages for Salesforce accounts.

* ProcessDdpsExt.apxc

    An Apex outer class, ProcessDdpsExt, and an Apex inner class, RecordInfo, which interacts with the Visualforce page. The ProcessDdpsExt class serves as the custom controller for the Visualforce page.

    If the value for the ids query string parameter specified for the Visualforce page isn't empty, the ProcessDdpsExt class parses the value and retrieves the corresponding Account for each account ID from by executing an SOQL query.

    If at least one Account was returned by the SOQL query, the class then iterates through the query results and, for each Account, defines a ProcessDdpParameters instance that uses the DocGen Package specified in the ddpId query string parameter and the Delivery Option specified in the deliveryOptionId query string parameter to define a DocGen Package request for that account. The ProcessDdpsExt class ensures that the Process DocGen Package component for that account is displayed using the Bootstrap 3.2.0 style theme.

    The class then creates an RecordInfo instance, using the Account and the ProcessDdpParameters instances for that Salesforce account, and adds it to the list used to define the contents of the table in the Visualforce page.

    If the value for the ids query string parameter wasn't specified, or if at least one Account wasn't returned by the SOQL query, the class adds an error message to the Visualforce page indicating that at least one account ID must be specified in the ids query string parameter.

Implementing the sample
-----------------------

First implement the ProcessDdpsExt class in Salesforce by using the Developer Console, and then create the Visualforce page that references that Apex class. Create the Lightning Component in the Developer Console, then add the JavaScript controller to the Lightning Component.

To implement the Apex class

1. Log into your Salesforce instance, using a Developer Edition account, and ensure that Visualforce development mode is enabled.
1. From your Salesforce instance, open the Developer Console.

    For more information about the Developer Console in Salesforce, see [Developer Console](https://developer.salesforce.com/page/Developer_Console).
1. From the Developer Console, create a new Apex class named ProcessDdpsExt.
1. In a text editor, open the sample file named ProcessDdpsExt.apxc, and paste the contents of that sample file into the Developer Console, overwriting the existing contents.
1. Save the new Apex class, and then close the Developer Console.

To implement the Visualforce page

1. Create a Visualforce page using the following URL, replacing Salesforce_instance with the URL for your Salesforce instance:

    ```https://Salesforce_instance/apex/ProcessDdp```

    For more information about creating a Visualforce page, see [Creating Your First Page](https://developer.salesforce.com/docs/atlas.en-us.pages.meta/pages/pages_quick_start_hello_world.htm).

1. Open the Page Editor for the new Visualforce page.
1. In a text editor, open the sample file named ProcessDdp.vfp, and paste the contents of that sample file into the Page Editor, overwriting the existing contents for the new Visualforce page.
1. Save the new Visualforce page.

To implement the Lightning Component

1. From your Salesforce instance, open the Developer Console.
1. From the Developer Console, create a new Lightning Component named GenerateDocument.
1. In a text editor, open the sample file named GenerateDocument.cmp, and paste the contents of that sample file into the Developer Console, overwriting the existing contents.
1. Save the new Lightning Component, and then in the sidebar click Controller to open a controller tab.
1. In a text editor, open the sample file named GenerateDocumentController.js, and paste the contents of the sample file into the controller tab, overwriting the existing contents.
1. Save the Lightning Component, and then close the Developer Console.

Using the sample
----------------

 Add the Lightning Component to the page, using the App Builder. Use the Lightning Component to generate a document.

To add the Lightning Component to the page

1. In your organization, navigate to a record from which you want to use an existing DocGen Package to generate a document.
1. Click the Setup icon and choose **Edit Page** to launch App Builder.
1. Drag your component from the Custom components list and drop it to the page.
1. Click **Save**.
1. Click **Activate** and the click **Assign as Org Default**.
1. Click **Save** and then click the **Back** link to return to the record page.

To use the sample

1. In the Lightning Component sample, enter values for each field, overwriting existing values:

   Field | Description 
   --- | --- 
    **Document Package ID** | Specify the Id of the DocGen Package to process.
      **Delivery Option ID** | Specify the Id of the Delivery Option to use for the DocGen Package.
   **Record IDs** |  Specify the Salesforce record Ids.
   **Record Type**|  Specify the type of record.
1. Click **Generate Document**.

For more information

* [Nintex Document Generation for Salesforce product assistance](https://help.nintex.com/en-US/docgen/docgen-portal.htm)
* [Apex for Nintex DocGen for Salesforce](https://help.nintex.com/en-us/docgen/docservices/Default.htm#cshid=9032)
* [ProcessDdpParameters class](http://help.nintex.com/en-us/docgen/docservices/Default.htm#cshid=9080)
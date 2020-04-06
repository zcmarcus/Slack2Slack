# Team Project: Slack2Slack
## Team Members: Kelly Palese, Sarah Schmitt, Zeph Marcus

* This repository serves as the central hub for development of 'Slack2Slack,' a team project produced for Enterprise Java (MATC - Spring Term, 2020)


### Problem Statement:
Many Slack users create Slack workspaces that are very similar, if not identical. For example, an instructor may have a separate Slack template for each semester or each section of a particular course. Some setup of these workspaces will be identical. They might have the same channels (name, topic, and description), template icons, settings/rules (for example, which channels everyone gets when they join the workplace), and the same creator's profile. However, each time the creator of these workspaces needs to create a new one, there is not a user-friendly way to quickly duplicate the template. Instead, they must go through the time-consuming steps of starting with a blank template and adding all of the setup from the very beginning.

Creators of Slack workspaces would be able to save a significant amount of time if they had the option to create a new channel using data they have already entered. This could be by "copying" select data from an existing Slack channel, or by using a template to create the new channel. This project will explore which option best meets users' needs while also complying with the data available on the Slack API. The project will then implement a solution to allow Slack template creators to quickly and easily create new workspaces. 

### Will offer users the following abilities:
* Enter a Slack template's setup only once (either in Slack, or in an external template)
* Create a new template that contains the pre-defined setup



### Similar Existing Technologies:
* Limited import/export of Slack Workspace Data (https://slack.com/help/articles/217872578-Import-data-from-one-template-to-another)

### Resources for Further Research and Potential Incorporation:
* Use of more advanced Slack API components (BlockKit for interactive UI elements within Slack application, user interactions): https://api.slack.com/web
* Allow user upload of workspace icon to [Amazon S3 bucket](https://aws.amazon.com/s3/).
* Remove the need for user log-in. Either a.) Allow export/import of .json data with template creation form or b.) Allow sign-in through existing Google account (or FB/Microsoft)

### Project Technologies/Techniques:
* JAX-RS - Provides useful annotations that aid in mapping resources as web resources in a Java web service.



### List of Planned Web Service Resources and Operations

_Retrieve all templates for a specific user:_

> GET <br>
@Produces JSON <br>
users/{userId}/templates


_Retrieve a specific template by id:_

> GET <br>
@Produces JSON <br>
templates/{templateId}

_Create new template:_

> POST <br>
@Produces JSON <br>
users/{userId}/templates

_Update an existing template:_

> PUT <br>
@Produces JSON <br>
users/{userId}/templates/{templateId}
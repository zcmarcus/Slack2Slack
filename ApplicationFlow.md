# Application Flow



### *User Prepares Own Slack Workspace 

_*__Note:__ This task must be done before all others_

    1. User creates new Slack workspace
    2. User installs our app to workspace.
    3. User enters slash command or clicks link to navigate to our app's page.


### User Sign Up

    1. User clicks "Sign Up" in navbar (link only present if not signed in)
    2. User completes sign-up form and submits.
    3. Sign-up servlet processes receives request and creates use in database.
    4. Servlet redirects user to home page with confirmation message.

### User Sign In

    1. User clicks "Log In" in navbar (link only present if not signed in)
    2. User enters username and password on form and submits.
    3. If user authenticated, server allows access to workspace template form.
       If user not successfully authenticated, show error page.


### Configure Workspace from New Template

    1. Only available to logged-in users.
    2. User navigates to "Configure Workspace from Template" form page.
    3. At top of form, user is presented with a drop-down menu containing
       any previously submitted forms. User selects _"Create New Template."_
    4.a) User fills in all desired attributes to add to workspace. 
      b) DECISION: For workspace icon, do we require user to type in url of image hosted externally, or
         do we allow image upload, which would require storage space? 
    5. User submits
       
### Configure Workspace from Existing Template
    
    1. Only available to logged-in users.
    2. User navigates to "Configure Workspace from Template" form page.
    3. At top of form, user is presented with a drop-down menu containing
       any previously submitted forms. User selects an _existing template_.
    4.a) User fills in all desired attributes to add to workspace. 
      b) DECISION: For workspace icon, do we require user to type in url of image hosted externally, or
         do we allow image upload, which would require storage space? 
    5. User submits

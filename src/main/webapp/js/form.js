// NOT CURRENTLY USED: max number of channels to display on page
// const maxChannels = 50;

// current count of number of channels displayed on page. Init at value is 2, since Channel 1 displayed by default on load
let channelCounter = 2;

const init = () => {
    // div containing all channels
    channelsContainer = document.querySelector("#channelsContainer");
    
    // Create event listener for "Add Another Channel" button
    let addChannel = document.querySelector("#addChannelButton");
    if(addChannel != null) {
        addChannel.addEventListener("click", addChannel);
    }

    // Create event listener for "Choose Template" select element

    let chooseTemplate = document.querySelector("#chooseTemplate");
    if(chooseTemplate != null) {
        chooseTemplate.addEventListener("click", chooseTemplate);
    }
};

/*
    Function appends a new set of channel form inputs beneath existing channels. 
 */
const addChannel = event => {

    channelsContainer = document.querySelector("#channelsContainer");

    // if (channelCounter > 50) {
    //     displayMaxChannelsReached();
    // } else {

        let channelDetails = document.createElement("div");
        channelDetails.classList.add("channelDetails", "border", "border-dark", "p-4", "mt-2", "mb-2");
        channelDetails.setAttribute("id", "channel" + channelCounter + "details");

        let channelNameFormGroup = document.createElement("div");
        channelNameFormGroup.classList.add("form-group");
        channelNameFormGroup.setAttribute("id", "channel" + channelCounter + "NameFormGroup");
        let channelNameLabel = document.createElement("label");
        channelNameLabel.setAttribute("for", "channel" + channelCounter + "Name");
        channelNameLabel.innerHTML = "Name";
        let channelNameInput = document.createElement("input");
        channelNameInput.setAttribute("type", "text");
        channelNameInput.classList.add("form-control");
        channelNameInput.setAttribute("id", "channel" + channelCounter + "Name");
        channelNameInput.setAttribute("name", "channel" + channelCounter + "Name");
        channelNameFormGroup.appendChild(channelNameLabel);
        channelNameFormGroup.appendChild(channelNameInput);


        let channelPurposeFormGroup = document.createElement("div");
        channelPurposeFormGroup.classList.add("form-group");
        channelNameFormGroup.setAttribute("id", "channel" + channelCounter + "PurposeFormGroup");
        let channelPurposeLabel = document.createElement("label");
        channelPurposeLabel.setAttribute("for", "channel" + channelCounter + "Purpose");
        channelPurposeLabel.innerHTML = "Purpose";
        let channelPurposeInput = document.createElement("input");
        channelPurposeInput.setAttribute("type", "text");
        channelPurposeInput.classList.add("form-control");
        channelPurposeInput.setAttribute("id", "channel" + channelCounter + "Purpose");
        channelPurposeInput.setAttribute("name", "channel" + channelCounter + "Purpose");
        channelPurposeFormGroup.appendChild(channelPurposeLabel);
        channelPurposeFormGroup.appendChild(channelPurposeInput);

        let channelTopicFormGroup = document.createElement("div");
        channelTopicFormGroup.classList.add("form-group");
        channelTopicFormGroup.setAttribute("id", "channel" + channelCounter + "TopicFormGroup");
        let channelTopicLabel = document.createElement("label");
        channelTopicLabel.setAttribute("for", "channel" + channelCounter + "Topic");
        channelTopicLabel.innerHTML = "Topic";
        let channelTopicInput = document.createElement("input");
        channelTopicInput.setAttribute("type", "text");
        channelTopicInput.classList.add("form-control");
        channelTopicInput.setAttribute("id", "channel" + channelCounter + "Topic");
        channelTopicInput.setAttribute("name", "channel" + channelCounter + "Topic");
        channelTopicFormGroup.appendChild(channelTopicLabel);
        channelTopicFormGroup.appendChild(channelTopicInput);

        deleteChannelButton = document.createElement("a");
        deleteChannelButton.setAttribute("id", "deleteChannel" + channelCounter + "Button");
        deleteChannelButton.classList.add("btn", "btn-danger");
        deleteChannelButton.innerHTML = "Delete Channel";
        // create event listener for this delete button  
        deleteChannelButton.addEventListener('click', deleteChannel, false);

        channelDetails.appendChild(channelNameFormGroup);
        channelDetails.appendChild(channelPurposeFormGroup);
        channelDetails.appendChild(channelTopicFormGroup);
        channelDetails.appendChild(deleteChannelButton);

        channelsContainer.appendChild(channelDetails);

        channelCounter++;
    // }

};


/*
    Function deletes the set of channel form inputs.
 */
const deleteChannel = event => {
    console.log(event.currentTarget.parentElement);
    let channelDetails = event.currentTarget.parentElement;
    channelDetails.innerHTML = "";
    channelDetails.style.display = "none";
};


const chooseTemplate = event => {

}




/*
    If max number of channels reached, function displays error message on page.
*/
// const displayMaxChannelsReached = () => {
//     let messageDiv = document.querySelector("#maxChannelsMessageDiv");
//     if (!messageDiv) {
//         let messageDiv = document.createElement("div");
//         messageDiv.setAttribute("id", "maxChannelsMessageDiv");
//         messageDiv.classList.add("alert", "alert-danger", "mt-2");
//         messageDiv.setAttribute("role", "alert");
//         messageDiv.innerHTML = "Maximum number of channels reached. Could not add channel."
//         channelsContainer.appendChild(messageDiv);
//     }





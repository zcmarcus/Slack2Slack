const init = () => {
    // create constant set to max number of channels a user can create in their template (25? 50?)
    // create counter variable to track number of channels

    // Create event listener for "Add Another Channel" button
    let addChannelListener = document.querySelector("addChannel");
    addChannelListener.addEventListener("click", addChannel);
}

/*
    If max number of channels has not been reached, creates a new set of channel inputs. Otherwise, displays message
    to user indicating that max number of channels have been reached.
 */

const addChannel = event => {

    /*

    check current count of channels

    IF (count of channels has reached max) {
        Don't create channel
        Display "Max channels" reached message
    } ELSE {
        Assign channels container div to variable
        Create new set of inputs for new channel
        Append set of channel inputs to channels container div
        Increase channel count by 1

    }

    */
}



<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="" method="POST" class="form">

        <div>
            <div>
                <h3>Workspace Details</h3>
            </div>

            <div class="form-group">
                <label for="ownerFirstName">Owner First Name</label>
                <input type="text" class="form-control" name="ownerFirstName" id="ownerFirstName" placeholder="First Name">
            </div>
            <div class="form-group">
                <label for="ownerLastName">Owner Last Name</label>
                <input type="text" class="form-control" name="ownerLastName" id="ownerLastName" placeholder="Last Name">
            </div>
            <div class="form-group">
                <label for="ownerDisplayName">Owner Display Name</label>
                <input type="text" class="form-control" name="ownerDisplayName" id="ownerDisplayName" placeholder="Desired Display Name">
            </div>
            // TODO: Either leave as is (require user to upload icon image elsewhere and type url here) OR allow file upload (use Amazon S3 bucket?)
            <div class="form-group">
                <label for="iconUrl">Workspace Icon</label>
                <input type="text" class="form-control" name="iconUrl" id="iconUrl" placeholder="Workspace Icon Url">
            </div>
        </div>

        <div>
            <div>
                <h3>
                    Channels
                </h3>
            </div>

            <div class="form-group">
                <label for="channel1Name">Channel Name</label>
                <input type="text" class="form-control" name="channel1Name" id="channel1Name" placeholder="Channel Name">
            </div>

            <div class="form-group">
                <label for="channel1Topic">Channel Topic</label>
                <input type="text" class="form-control" name="channel1Topic" id="channel1Topic" placeholder="Channel Topic">
            </div>
            <div class="form-group">
                <label for="channel1Purpose">Channel Purpose</label>
                <input type="text" class="form-control" name="channel1Purpose" id="channel1Purpose" placeholder="Channel Purpose">
            </div>

            <div>
                <button class="btn btn-secondary">Add Another Channel</button>
            </div>

            <%-- TODO: Either add all remaining inputs for channels (hide) and display programmatically with javascript OR add elements dynamically with javascript
            --%>

            <div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>


    </form>

</body>
</html>

package com.slack2slack.persistence;

import com.slack2slack.util.PropertiesLoader;
import org.junit.Ignore;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Properties;

/*
* Validates the OAuthDao
 */
public class OAuthDaoTest implements PropertiesLoader {
    @Ignore
    /*
     *  This test is being ignored because, now that the servlet logic is in place, it fails. This is due to the
     * temporary code only being allowed to be used once. Now that the servlet uses the temp code first, the test
     * can no longer use the code too.
     *
     * The assertEquals() uses the app_id, since the app_id is a static parameter.
     */
    void getOAuthResponseSuccess() {
        OAuthDao dao = new OAuthDao();

        String expectedApp_id = "";

        //Load the Slack authentication properties from the properties file
        try {
            Properties properties = loadProperties("/slack.secrets.properties");
            expectedApp_id = properties.getProperty("appId");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //IMPORTANT: Temporary slack code is generated after logging into Slack2Slack. You can find it in the url. It expires after 10 minutes.
        assertTrue(dao.getOAuthResponse("").isOk());
        assertEquals(expectedApp_id, dao.getOAuthResponse("").getAppId());
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ucu.edu.ua.task1.Facebookuser;
import ucu.edu.ua.task1.Facebookuseradapter;
import ucu.edu.ua.task1.Messagesender;
import ucu.edu.ua.task1.Twiteruser;
import ucu.edu.ua.task1.User;
import ucu.edu.ua.task1.Twiteruseradapter;


public class Tests {
    private static final String UKRAINE = "Ukraine";
    private static final String FRANCE = "France";
    private static final String ACTIVE_EMAIL = "first@gmail.com";
    private static final String INACTIVE_EMAIL = "second@gmail.com";
    private static final String DIFFERENT_COUNTRY_EMAIL =
                            "third@gmail.com";
    private static final long TWO_HOURS_IN_MILLIS = 7200000;

    private Messagesender messageSender;
    private User activeUser;
    private User inactiveUser;
    private User differentCountryUser;

    @BeforeEach
    void setUp() {
        messageSender = new Messagesender();

        Facebookuser activeFacebookUser = new Facebookuser(
            ACTIVE_EMAIL, UKRAINE, System.currentTimeMillis());
        activeUser = new Facebookuseradapter(activeFacebookUser);

        Facebookuser inactiveFacebookUser = new Facebookuser(
            INACTIVE_EMAIL, UKRAINE, 
                            System.currentTimeMillis() - TWO_HOURS_IN_MILLIS);
        inactiveUser = new Facebookuseradapter(inactiveFacebookUser);

        Twiteruser differentCountryTwitterUser = new Twiteruser(
            DIFFERENT_COUNTRY_EMAIL, FRANCE, System.currentTimeMillis());
        differentCountryUser = new Twiteruseradapter(
                                        differentCountryTwitterUser
                                        );
    }

    @Test
    void testSendMessageserActiveAndFromSameCountry() {
        String result = messageSender.send("Hello", activeUser, UKRAINE);
        Assertions.assertEquals(
        "Sending message: Hello to user with email: first@gmail.com", 
            result);
    }

    @Test
    void testSendMessageUserNotActive() {
        String result = messageSender.send("Hello", inactiveUser, UKRAINE);
        Assertions.assertEquals(
            "The user is not active or not from the same country", 
            result);
    }

    @Test
    void testSendMessageUserFromDifferentCountry() {
        String result = messageSender.send(
                                       "Hello",
                                            differentCountryUser,
                                            UKRAINE
                                            );
        Assertions.assertEquals(
            "The user is not active or not from the same country", 
            result);
    }
}

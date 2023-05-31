import org.junit.Test;


public class LoginTest extends BaseTest {

    @Test
    public void successLogin() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.pushLoginButton();

        dashboardPage.correctHeaderText();

    }

    @Test
    public void invalidPassword() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin972");
        loginPage.pushLoginButton();
        loginPage.checkErrorMessage("Invalid credentials");
    }
    @Test
    public void emptyInputFields() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.pushLoginButton();
        loginPage.emptyFieldsText("Required");

    }

    @Test
    public void emptyInputUsernameField() {
        loginPage.enterUsername("");
        loginPage.enterPassword("admin123");
        loginPage.pushLoginButton();
        loginPage.emptyFieldsText("Required");

    }
    @Test
    public void emptyInputPasswordField() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("");
        loginPage.pushLoginButton();
        loginPage.emptyFieldsText("Required");

    }
    @Test
    public void forgotPassword() {
        loginPage.followTheForgotPasswordLink();
        resetPasswordPage.checkResetPasswordTitle();
        resetPasswordPage.urlIsCorrect();
    }

    @Test
    public void elementsAreVisible() {
        loginPage.logoIsDiplayed();
        loginPage.credSectionIsDiplayed();
        loginPage.logoImageIsCorrect();
    }

    // написать тесты на проверку ссылок линков внизу страницы

    @Test
    public void checkAllLinks() {
        loginPage.checkLinkLinkedin();
        loginPage.checkLinkFacebook();
        loginPage.checkLinkTwitter();
        loginPage.checkLinkYoutube();
    }




}

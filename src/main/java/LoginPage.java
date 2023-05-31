import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private SelenideElement usernameField = $(byCssSelector("[name='username']"));

    private SelenideElement passwordField = $(byAttribute("placeholder", "Password"));

    private SelenideElement loginButton = $x("//button[@type='submit']");

    private SelenideElement errorMessage = $(byCssSelector("[class='oxd-text oxd-text--p oxd-alert-content-text']")); // xpath: //*[contains(@class, 'oxd-alert-content-text')] или "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"

  //  private SelenideElement textRequired = $x("(//*[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'])[1]");
    private List<SelenideElement> textMessages = (List<SelenideElement>) $$(byTagName("span"));

    private SelenideElement forgotPasswordLink = $(byClassName("orangehrm-login-forgot"));

    private SelenideElement logo = $(byAttribute("alt", "company-branding"));
    private SelenideElement credentionalsSection = $(byClassName("orangehrm-demo-credentials"));

    //private SelenideElement linkedin = $(byAttribute("href", "https://www.linkedin.com/company/orangehrm/mycompany/"));
    private SelenideElement linkedin = $(byXpath("((//*[@class='orangehrm-login-footer-sm'])/a)[1]"));
    private SelenideElement facebook = $(byXpath("((//*[@class='orangehrm-login-footer-sm'])/a)[2]"));
    private SelenideElement twitter = $(byXpath("((//*[@class='orangehrm-login-footer-sm'])/a)[3]"));
    private SelenideElement youtube = $(byXpath("((//*[@class='orangehrm-login-footer-sm'])/a)[4]"));

    public void enterUsername(String usernameValue) {
        usernameField.shouldBe(visible);
        usernameField.setValue(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        passwordField.setValue(passwordValue);
    }
    public void pushLoginButton() {
        loginButton.click();
    }
    public void checkErrorMessage(String expectedText) {
        errorMessage.shouldBe(visible);
        errorMessage.shouldHave(text(expectedText));
    }
    public void emptyFieldsText(String expectedText) {
        for (SelenideElement text : textMessages) {
            text.shouldHave(text(expectedText));
        }
    }
    public void followTheForgotPasswordLink() {
        forgotPasswordLink.shouldBe(visible);
        forgotPasswordLink.click();
    }
    public void logoIsDiplayed() {
        logo.shouldBe(visible);
        credentionalsSection.shouldBe(visible);
    }
    public void logoImageIsCorrect() {
        logo.shouldHave(attributeMatching("src", ".*branding.png.*"));
    }
    public void credSectionIsDiplayed() {
        credentionalsSection.shouldBe(visible);
    }

    public void checkLinkLinkedin() {
        linkedin.shouldHave(attributeMatching("href", ".*linkedin.com.*"));
    }
    public void checkLinkFacebook() {
        facebook.shouldHave(attributeMatching("href", ".*facebook.com.*"));
    }
    public void checkLinkTwitter() {
        twitter.shouldHave(attributeMatching("href", ".*twitter.com.*"));
    }
    public void checkLinkYoutube() {
        youtube.shouldHave(attributeMatching("href", ".*youtube.com.*"));
    }


}

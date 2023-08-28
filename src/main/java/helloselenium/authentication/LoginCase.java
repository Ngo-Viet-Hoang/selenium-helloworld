package helloselenium.authentication;

public interface LoginCase {
    void loginByUsernameAndPassword_GoodCase();
    void loginByUsernameAndPassword_BadCase_BlankUsername();
    void loginByUsernameAndPassword_BadCase_WrongUsername();
    void loginByUsernameAndPassword_BadCase_BlankPassword();
    void loginByUsernameAndPassword_BadCase_WrongPassword();
    void loginBySocial_Google_GoodCase();
    void loginBySocial_Facebook_GoodCase();
}

package fragments;

import static com.codeborne.selenide.Selenide.$$x;

public class RozetkaLoginFormFragment {

    public static void openRozetkaLoginFormFragment(){
        RozetkaLoginFormFragment rozetkaLoginFormFragment = new RozetkaLoginFormFragment();
        rozetkaLoginFormFragment
                .openRozetkaLoginForm();
    }

    private void openRozetkaLoginForm(){
        $$x("//button[contains(@class, 'header__button ng-star-inserted')]")
                .get(0)
                .click();
    }
}

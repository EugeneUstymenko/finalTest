package pages.rozetkapage;

import pages.BasePage;

import static fragments.RozetkaGoodsFragment.openRozetkaGoodsFragment;
import static fragments.RozetkaLoginFormFragment.openRozetkaLoginFormFragment;

public class RozetkaPage extends BasePage {

    public static void openRozetkaGoods(){
        setUpBasePage();
        openRozetkaGoodsFragment();
    }

    public static void openRozetkaLoginForm(){
        setUpBasePage();
        openRozetkaLoginFormFragment();
    }
}

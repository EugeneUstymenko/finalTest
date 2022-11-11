package fragments;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class RozetkaGoodsFragment {

    public static RozetkaGoodsFragment openRozetkaGoodsFragment(){
        RozetkaGoodsFragment rozetkaGoodsFragment = new RozetkaGoodsFragment();
        rozetkaGoodsFragment
                .waitUntilSearchFieldDisplayed()
                .pressClick()
                .setSearchText()
                .clickButtonSearch()
                .openPageGoods();
        return rozetkaGoodsFragment;
    }

    private RozetkaGoodsFragment waitUntilSearchFieldDisplayed(){
        $("[name='search']").shouldBe(visible);
        return this;
    }

    private RozetkaGoodsFragment pressClick(){
        $("[name='search']").click();
        return this;
    }

    private RozetkaGoodsFragment setSearchText(){
        $("[name='search']").setValue("сумки");
        return this;
    }

    private RozetkaGoodsFragment clickButtonSearch(){
        $(".button_color_green").click();
        return this;
    }

    private void openPageGoods(){
        $$x("//li[contains(@class, 'catalog-grid__cell')]").get(5).shouldBe(visible).click();
    }
}

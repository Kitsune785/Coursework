package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.date.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TransferPage {
    private static SelenideElement paymentCard = $x("//*[contains(text(),'Купить')]");
    private static SelenideElement paymentByCredit = $x("//*[contains(text(),'Купить в кредит')]");
    private static ElementsCollection fields = $$(".input__control");
    public static SelenideElement cardNumber = fields.get(0);
    public static SelenideElement cardMonth = fields.get(1);
    public static SelenideElement cardYear = fields.get(2);
    public static SelenideElement cardName = fields.get(3);
    public static SelenideElement cardCode = fields.get(4);
    private static ElementsCollection button = $$(".button");
    private static SelenideElement paymentButton = button.get(2);
    private static SelenideElement paymentAccepted = $(".notification_status_ok");
    private static SelenideElement paymentError = $(".notification_status_error");

    private static SelenideElement completionError = $(byText("Неверный формат"));
    private static SelenideElement monthError = $(byText("Неверно указан срок действия карты"));
    private static SelenideElement yearError = $(byText("Истёк срок действия карты"));

    private static SelenideElement requiredFieldError = $(byText("Поле обязательно для заполнения"));

    public static void setPaymentCard() {
        paymentCard.click();
    }

    public static void setPaymentByCredit() {
        paymentByCredit.click();
    }

    public static void setCardNumber(int id) {
        cardNumber.setValue(DataHelper.getCardNumber(id));
    }

    public static void getPay() {
        paymentButton.click();
    }

    public static void getApprove() {
        paymentAccepted.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public static void getError() {
        paymentError.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public static void completionErrors() {
        completionError.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public static void monthErrors() {
        monthError.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public static void yearErrors() {
        yearError.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public static void requiredFieldErrors() {
        requiredFieldError.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public static void cleaning() {
        cardNumber.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        cardMonth.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        cardYear.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        cardName.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        cardCode.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
    }
}

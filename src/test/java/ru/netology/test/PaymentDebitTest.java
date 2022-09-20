package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.date.DataHelper;
import ru.netology.page.TransferPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.date.SQLHelper.cleanDatabase;
import static ru.netology.page.TransferPage.*;

public class PaymentDebitTest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @AfterAll
    static void tearDown() {
        cleanDatabase();
    }

    @Test
    void shouldApprovePaymentByCardDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.getApprove();
    }

    @Test
    void shouldAdoptDoubleNameDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue("Ivan Ivanov-Sidorov");
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.getApprove();
    }

    @Test
    void shouldtNotAcceptCardPaymentDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(2);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.getError();
    }

    @Test
    void shouldNotAcceptLettersCardNumberDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        cardNumber.setValue(DataHelper.getIncorrectCardNumber(1));
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptEmptyCardNumberDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptCardNumberLettersDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        cardNumber.setValue(DataHelper.getIncorrectCardNumber(2));
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptSpecialCharactersCardNumberDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        cardNumber.setValue(DataHelper.getIncorrectCardNumber(3));
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptOneDigitCardNumberDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        cardNumber.setValue(DataHelper.getIncorrectCardNumber(0));
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptNonExistentMonthDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.generateIncorrectMonth(1));
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.monthErrors();
    }

    @Test
    void shouldNotAcceptSpecialCharactersMonthDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.generateIncorrectMonth(2));
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptEmptyMonthDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptOneDigitMonthDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.generateIncorrectMonth(3));
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptLettersMonthDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.generateIncorrectMonth(0));
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldReturnExpiredMonthDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.expiredDate(1));
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.monthErrors();
    }

    @Test
    void shouldReturnExpiredYearDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.expiredDate(0));
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.yearErrors();
    }

    @Test
    void shouldNotAcceptSpecialCharactersYearDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.generateIncorrectYear(2));
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptEmptyYearDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptOneDigitYearDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.generateIncorrectYear(3));
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptLettersYearDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.generateIncorrectYear(0));
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptLettersAndNumbersNameDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateIncorrectName(1));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptSpecialCharactersNameDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateIncorrectName(2));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptEmptyNameDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.requiredFieldErrors();
    }

    @Test
    void shouldNotAcceptOneLettersNameDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateIncorrectName(3));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptInCyrillicNameDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateIncorrectName(4));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptOverLettersNameDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateIncorrectName(0));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptSpecialCharactersCvcDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateIncorrectCvc(1));
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptEmptyCvcDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptOneDigitCvcDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateIncorrectCvc(2));
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldNotAcceptLettersCvcDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(1);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateIncorrectCvc(3));
        TransferPage.getPay();
        TransferPage.completionErrors();
    }

    @Test
    void shouldApproveIncorrectCardNumberDebit() {
        open("http://localhost:8080");
        TransferPage.setPaymentCard();
        TransferPage.cleaning();
        TransferPage.setCardNumber(0);
        cardMonth.setValue(DataHelper.getMonth());
        cardYear.setValue(DataHelper.getYear());
        cardName.setValue(DataHelper.generateName("en"));
        cardCode.setValue(DataHelper.generateCodeCvc());
        TransferPage.getPay();
        TransferPage.getError();
    }
}

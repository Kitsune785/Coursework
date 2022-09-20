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

public class PaymentCreditTest {

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
        void shouldApprovePaymentByCardCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldAdoptDoubleNameCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldtNotAcceptCardPaymentCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptLettersCardNumberCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptEmptyCardNumberCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
            TransferPage.cleaning();
            cardMonth.setValue(DataHelper.getMonth());
            cardYear.setValue(DataHelper.getYear());
            cardName.setValue(DataHelper.generateName("en"));
            cardCode.setValue(DataHelper.generateCodeCvc());
            TransferPage.getPay();
            TransferPage.completionErrors();
        }

        @Test
        void shouldNotAcceptCardNumberLettersCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptSpecialCharactersCardNumberCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptOneDigitCardNumberCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptNonExistentMonthCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptSpecialCharactersMonthCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptEmptyMonthCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
            TransferPage.cleaning();
            TransferPage.setCardNumber(1);
            cardYear.setValue(DataHelper.getYear());
            cardName.setValue(DataHelper.generateName("en"));
            cardCode.setValue(DataHelper.generateCodeCvc());
            TransferPage.getPay();
            TransferPage.completionErrors();
        }

        @Test
        void shouldNotAcceptOneDigitMonthCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptLettersMonthCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldReturnExpiredMonthCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldReturnExpiredYearCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptSpecialCharactersYearCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptEmptyYearCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
            TransferPage.cleaning();
            TransferPage.setCardNumber(1);
            cardMonth.setValue(DataHelper.getMonth());
            cardName.setValue(DataHelper.generateName("en"));
            cardCode.setValue(DataHelper.generateCodeCvc());
            TransferPage.getPay();
            TransferPage.completionErrors();
        }

        @Test
        void shouldNotAcceptOneDigitYearCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptLettersYearCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptLettersAndNumbersNameCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptSpecialCharactersNameCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptEmptyNameCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
            TransferPage.cleaning();
            TransferPage.setCardNumber(1);
            cardMonth.setValue(DataHelper.getMonth());
            cardYear.setValue(DataHelper.getYear());
            cardCode.setValue(DataHelper.generateCodeCvc());
            TransferPage.getPay();
            TransferPage.requiredFieldErrors();
        }

        @Test
        void shouldNotAcceptOneLettersNameCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptInCyrillicNameCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptOverLettersNameCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptSpecialCharactersCvcCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptEmptyCvcCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
            TransferPage.cleaning();
            TransferPage.setCardNumber(1);
            cardMonth.setValue(DataHelper.getMonth());
            cardYear.setValue(DataHelper.getYear());
            cardName.setValue(DataHelper.generateName("en"));
            TransferPage.getPay();
            TransferPage.completionErrors();
        }

        @Test
        void shouldNotAcceptOneDigitCvcCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldNotAcceptLettersCvcCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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
        void shouldApproveIncorrectCardNumberCredit() {
            open("http://localhost:8080");
            TransferPage.setPaymentByCredit();
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

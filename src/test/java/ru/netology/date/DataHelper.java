package ru.netology.date;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {

    public DataHelper() {
    }

    static Faker faker = new Faker((new Locale("en")));

    public static String getCardNumber(int id) {
        if (id == 1) {
            return "1111 2222 3333 4444";
        }
        if (id == 2) {
            return "5555 6666 7777 8888";
        } else {
            return "1111 2222 3333 4445";
        }
    }

    public static String getIncorrectCardNumber(int id) {
        if (id == 1) {
            return RandomStringUtils.randomAlphanumeric(16);
        }
        if (id == 2) {
            return RandomStringUtils.random(16, "zxcvbnmasdfghjklqwertyuiop");
        }
        if (id == 3) {
            return RandomStringUtils.random(16, "!№;%:?*()");
        } else {
            return faker.number().digit();
        }
    }

    public static String getMonth() {
        LocalDate date = LocalDate.now();
        return date.format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateIncorrectMonth(int id) {
        if (id == 1) {
            return RandomStringUtils.random(2, "23456789");
        }
        if (id == 2) {
            return RandomStringUtils.random(2, "!№;%:?*()");
        }
        if (id == 3) {
            return faker.number().digit();
        } else {
            return RandomStringUtils.random(2, "zxcvbnmasdfghjklqwertyuiop");
        }
    }

    public static String getYear() {
        LocalDate date = LocalDate.now();
        return date.format(DateTimeFormatter.ofPattern("uu"));
    }

    public static String generateIncorrectYear(int id) {
        if (id == 1) {
            return RandomStringUtils.random(2, "23456789");
        }
        if (id == 2) {
            return RandomStringUtils.random(2, "!№;%:?*()");
        }
        if (id == 3) {
            return faker.number().digit();
        } else {
            return RandomStringUtils.random(2, "zxcvbnmasdfghjklqwertyuiop");
        }
    }

    public static String expiredDate(int id) {
        if (id == 1) {
            LocalDate date = LocalDate.now().minusMonths(1);
            return date.format(DateTimeFormatter.ofPattern("MM"));
        } else {
            LocalDate date = LocalDate.now().minusYears(1);
            return date.format((DateTimeFormatter.ofPattern("uu")));
        }
    }

    public static String generateName(String locale) {
        return faker.name().fullName().toUpperCase();
    }

    public static String generateIncorrectName(int id) {
        if (id == 1) {
            return RandomStringUtils.random(15, "qazw sxedcr fvtgby hnujmiko l1234567890 ");
        }
        if (id == 2) {
            return RandomStringUtils.random(15, "!№;%:?*()");
        }
        if (id == 3) {
            return RandomStringUtils.random(1, "zxcvbnmasdfghjklqwertyuiop");
        }
        if (id == 4) {
            return RandomStringUtils.random(5, "абвг деёжзик лмно прстуффх цчшщ ьъэюя");
        } else {
            return RandomStringUtils.random(100, "zxcv bnmasdf ghjklqwer tyuiop");
        }
    }

    public static String generateCodeCvc() {
        return String.valueOf(faker.number().numberBetween(100, 998));
    }

    public static String generateIncorrectCvc(int id) {
        if (id == 1) {
            return RandomStringUtils.random(3, "!№;%:?*()");
        }
        if (id == 2) {
            return faker.number().digit();
        } else {
            return RandomStringUtils.random(3, "zxcvbnmasdfghjklqwertyuiop");
        }
    }
}

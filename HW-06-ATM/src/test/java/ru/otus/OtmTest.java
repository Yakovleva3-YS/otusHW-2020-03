package ru.otus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OtmTest {

    @DisplayName("ввести деньги в банкомат ")
    @Test
    void takeBanknotes() {
        int money = 123232323;
        Otm otm = new Otm();
        otm.takeBanknotes(money);
        assertThat(otm.getBalance() == money);
    }

    @DisplayName("выдать деньги ")
    @Test
    void giveOutBanknotes() {
        int moneyTake = 16990;
        int moneyGetOut = 15500;
        Otm otm = new Otm();
        otm.takeBanknotes(moneyTake);
        otm.takeBanknotes(moneyGetOut);
        assertThat(otm.getBalance() == (moneyTake - moneyGetOut));
    }

    @DisplayName("выдать деньги: недостаточно денег в банкомате ")
    @Test
    void giveOutBanknotesNotEnough() {
        int moneyTake = 16990;
        int moneyGetOut = 100000;
        Otm otm = new Otm();
        otm.takeBanknotes(moneyTake);
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    otm.giveOutBanknotes(moneyGetOut);
                });
    }

    @DisplayName("выдать деньги: недостаточно необходимых для выдачи бкупюр в банкомате ")
    @Test
    void giveOutBanknotesNotEnoughBanknotes() {
        int moneyTake = 16900;
        int moneyGetOut = 14990;
        Otm otm = new Otm();
        otm.takeBanknotes(moneyTake);
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    otm.giveOutBanknotes(moneyGetOut);
                });
    }

    @DisplayName("получить баланс ")
    @Test
    void getBalance() {
        int money = 9500000;
        Otm otm = new Otm();
        otm.takeBanknotes(money);
        assertThat(otm.getBalance() == money);
    }
}

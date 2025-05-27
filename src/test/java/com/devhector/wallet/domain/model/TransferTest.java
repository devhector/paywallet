package com.devhector.wallet.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.devhector.wallet.domain.model.exceptions.TransferNotAllowedForUserTypeException;

public class TransferTest {
  public static final BigDecimal AMOUNT = new BigDecimal(10);
  public static final BigDecimal BALANCE_PAYER = new BigDecimal(20);
  public static final BigDecimal BALANCE_PAYEE = new BigDecimal(10);

  private User payer;
  private User payee;
  private Wallet payerWallet;
  private Wallet payeeWallet;

  @Test
  void whenUserIsRegularAndTransferOccurShouldSubtractAmountFromPayerAndAddToPayee() {
    Mockito.when(payer.type()).thenReturn(UserType.REGULAR);

    Transfer.execute(payer, payee, AMOUNT);

    assertEquals(new BigDecimal(10), payerWallet.balance());
    assertEquals(new BigDecimal(20), payeeWallet.balance());
  }

  @Test
  void whenUserIsShopkeeperAndPayerShouldThrowsExceptionTranferNotAllowed() {
    Mockito.when(payer.type()).thenReturn(UserType.SHOPKEEPER);

    assertThrows(TransferNotAllowedForUserTypeException.class, () -> Transfer.execute(payer, payee, AMOUNT));
  }

  @BeforeEach
  void setup() {
    this.payer = Mockito.mock(User.class);
    this.payee = Mockito.mock(User.class);

    this.payerWallet = new Wallet(1L, BALANCE_PAYER);
    this.payeeWallet = new Wallet(2L, BALANCE_PAYEE);

    Mockito.when(payer.wallet()).thenReturn(payerWallet);
    Mockito.when(payee.wallet()).thenReturn(payeeWallet);

    Mockito.when(payer.cpfCnpj()).thenReturn("123");
    Mockito.when(payee.cpfCnpj()).thenReturn("456");
  }
}

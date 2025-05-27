package com.devhector.wallet.infrastructure.persistence;

import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TransactionEntity {

  @Id
  @Column(name = "id", nullable = false)
  private String id;
  @Column(name = "payer_id", nullable = false)
  private String payerId;
  @Column(name = "payee_id", nullable = false)
  private String payeeId;
  @Column(name = "amount", nullable = false)
  private BigDecimal amount;
  @Column(name = "current_time", nullable = false, columnDefinition = "TIMESTAMP")
  private Instant currentTime;

  public TransactionEntity(String id, String payerId, String payeeId, BigDecimal amount, Instant currentTime) {
    this.id = id;
    this.payerId = payerId;
    this.payeeId = payeeId;
    this.amount = amount;
    this.currentTime = currentTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPayerId() {
    return payerId;
  }

  public void setPayerId(String payerId) {
    this.payerId = payerId;
  }

  public String getPayeeId() {
    return payeeId;
  }

  public void setPayeeId(String payeeId) {
    this.payeeId = payeeId;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Instant getCurrentTime() {
    return currentTime;
  }

  public void setCurrentTime(Instant currentTime) {
    this.currentTime = currentTime;
  }

}

package com.devhector.wallet.domain.model;

public class User {
  private String cpfCnpj;
  private String email;
  private String name;
  private String password;
  private Wallet wallet;
  private UserType type;

  public User(String cpfCnpj, String email, String name, String password, Wallet wallet, UserType type) {
    this.cpfCnpj = cpfCnpj;
    this.email = email;
    this.name = name;
    this.password = password;
    this.wallet = wallet;
    this.type = type;
  }

  public String name() {
    return name;
  }

  public String email() {
    return email;
  }

  public String password() {
    return password;
  }

  public Wallet wallet() {
    return wallet;
  }

  public String cpfCnpj() {
    return cpfCnpj;
  }

  public UserType type() {
    return type;
  }

}

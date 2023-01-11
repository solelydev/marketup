package com.solelydev.marketup.companies;

import java.util.Date;
import java.util.UUID;
import lombok.Value;

@Value
public class Company {
  UUID id;
  Name name;
  Date createdAt;
  Date updatedAt;
  CompanyAuth companyAuth;

  private Company(UUID id, Name name, Date createdAt, Date updatedAt, CompanyAuth companyAuth) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.companyAuth = companyAuth;
  }

  public static Company create(Name name, CompanyAuth companyAuth) {
    return new Company(UUID.randomUUID(), name, new Date(), new Date(), companyAuth);
  }

  public Company changeName(Name name) {
    return new Company(id, name, createdAt, updatedAt, companyAuth);
  }

  public Company changeAuth(CompanyAuth auth) {
    return new Company(id, name, createdAt, updatedAt, auth);
  }

  @Value
  public static class Name {
    String value;

    private Name(String value) {
      this.value = value;
    }

    public static Name from(String value) {
      return new Name(value);
    }
  }
}

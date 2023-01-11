package com.solelydev.marketup.usecase.companies.impl;

import com.solelydev.marketup.companies.Company;
import com.solelydev.marketup.companies.CompanyAuth;
import com.solelydev.marketup.usecase.companies.ChangeCompanyAuth;
import com.solelydev.marketup.usecase.companies.CompanyExtractor;
import com.solelydev.marketup.usecase.companies.CompanySaver;
import java.util.UUID;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChangeCompanyAuthUseCase implements ChangeCompanyAuth {
  private final CompanyExtractor companyExtractor;
  private final CompanySaver companySaver;

  @Override
  public Company execute(String id, CompanyAuth auth) {
    // TODO validate auth
    return companyExtractor
        .getById(UUID.fromString(id))
        .map(company -> company.changeAuth(auth))
        .map(companySaver::save)
        .orElseThrow(() -> new RuntimeException("Not found"));
  }
}

package com.solelydev.marketup.usecase.companies.impl;

import com.solelydev.marketup.companies.Company;
import com.solelydev.marketup.usecase.companies.ChangeCompanyName;
import com.solelydev.marketup.usecase.companies.CompanyExtractor;
import com.solelydev.marketup.usecase.companies.CompanySaver;
import java.util.UUID;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChangeCompanyNameUseCase implements ChangeCompanyName {
  private final CompanyExtractor companyExtractor;
  private final CompanySaver companySaver;

  @Override
  public Company execute(String id, String name) {
    return companyExtractor
        .getById(UUID.fromString(id))
        .map(company -> company.changeName(Company.Name.from(name)))
        .map(companySaver::save)
        .orElseThrow(() -> new RuntimeException("Not found"));
  }
}

package com.solelydev.marketup.usecase.companies.impl;

import com.solelydev.marketup.companies.Company;
import com.solelydev.marketup.usecase.companies.AddCompany;
import com.solelydev.marketup.usecase.companies.CompanySaver;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddCompanyUseCase implements AddCompany {

  private final CompanySaver companySaver;

  @Override
  public Company execute(AddCompanyRequest request) {
    return companySaver.save(
        Company.create(Company.Name.from(request.getCompanyName()), request.getCompanyAuth()));
  }
}

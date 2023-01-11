package com.solelydev.marketup.usecase.companies.impl;

import com.solelydev.marketup.companies.Company;
import com.solelydev.marketup.usecase.companies.CompanyExtractor;
import com.solelydev.marketup.usecase.companies.GetAllCompanies;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAllCompaniesUseCase implements GetAllCompanies {

  private final CompanyExtractor companyExtractor;

  @Override
  public List<Company> execute() {
    return companyExtractor.getALl();
  }
}

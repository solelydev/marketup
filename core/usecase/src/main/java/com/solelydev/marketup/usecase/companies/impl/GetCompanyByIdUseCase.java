package com.solelydev.marketup.usecase.companies.impl;

import com.solelydev.marketup.companies.Company;
import com.solelydev.marketup.usecase.companies.CompanyExtractor;
import com.solelydev.marketup.usecase.companies.GetCompanyById;
import java.util.UUID;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetCompanyByIdUseCase implements GetCompanyById {

  private final CompanyExtractor companyExtractor;

  @Override
  public Company execute(UUID id) {
    return companyExtractor.getById(id).orElseThrow(() -> new RuntimeException("not found"));
  }
}

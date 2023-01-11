package com.solelydev.marketup.usecase.companies.impl;

import com.solelydev.marketup.usecase.companies.CompanyRemover;
import com.solelydev.marketup.usecase.companies.DeleteCompany;
import java.util.UUID;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteCompanyUseCase implements DeleteCompany {
  private final CompanyRemover companyRemover;

  @Override
  public void execute(UUID id) {
    companyRemover.remove(id);
  }
}

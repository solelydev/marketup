package com.solelydev.marketup.usecase.companies;

import com.solelydev.marketup.companies.Company;
import com.solelydev.marketup.companies.CompanyAuth;
import lombok.Value;

public interface AddCompany {
  Company execute(AddCompanyRequest request);

  @Value
  class AddCompanyRequest {
    String companyName;
    CompanyAuth companyAuth;
  }
}

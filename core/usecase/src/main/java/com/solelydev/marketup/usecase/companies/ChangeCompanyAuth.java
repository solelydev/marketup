package com.solelydev.marketup.usecase.companies;

import com.solelydev.marketup.companies.Company;
import com.solelydev.marketup.companies.CompanyAuth;

public interface ChangeCompanyAuth {
  Company execute(String id, CompanyAuth auth);
}

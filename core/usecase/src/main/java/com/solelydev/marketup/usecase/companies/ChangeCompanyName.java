package com.solelydev.marketup.usecase.companies;

import com.solelydev.marketup.companies.Company;

public interface ChangeCompanyName {
  Company execute(String id, String name);
}

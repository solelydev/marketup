package com.solelydev.marketup.usecase.companies;

import com.solelydev.marketup.companies.Company;
import java.util.UUID;

public interface GetCompanyById {
  Company execute(UUID id);
}

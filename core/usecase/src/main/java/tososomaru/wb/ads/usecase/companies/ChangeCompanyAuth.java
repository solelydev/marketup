package tososomaru.wb.ads.usecase.companies;

import tososomaru.wb.ads.companies.Company;
import tososomaru.wb.ads.companies.CompanyAuth;

public interface ChangeCompanyAuth {
  Company execute(String id, CompanyAuth auth);
}

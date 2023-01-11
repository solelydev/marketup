package tososomaru.wb.ads.usecase.companies;

import lombok.Value;
import tososomaru.wb.ads.companies.Company;
import tososomaru.wb.ads.companies.CompanyAuth;

public interface AddCompany {
  Company execute(AddCompanyRequest request);

  @Value
  class AddCompanyRequest {
    String companyName;
    CompanyAuth companyAuth;
  }
}

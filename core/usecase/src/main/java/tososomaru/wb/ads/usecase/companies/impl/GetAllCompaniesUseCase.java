package tososomaru.wb.ads.usecase.companies.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import tososomaru.wb.ads.companies.Company;
import tososomaru.wb.ads.usecase.companies.CompanyExtractor;
import tososomaru.wb.ads.usecase.companies.GetAllCompanies;

@AllArgsConstructor
public class GetAllCompaniesUseCase implements GetAllCompanies {

  private final CompanyExtractor companyExtractor;

  @Override
  public List<Company> execute() {
    return companyExtractor.getALl();
  }
}

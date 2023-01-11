package tososomaru.wb.ads.usecase.companies.impl;

import java.util.UUID;
import lombok.AllArgsConstructor;
import tososomaru.wb.ads.companies.Company;
import tososomaru.wb.ads.usecase.companies.ChangeCompanyName;
import tososomaru.wb.ads.usecase.companies.CompanyExtractor;
import tososomaru.wb.ads.usecase.companies.CompanySaver;

@AllArgsConstructor
public class ChangeCompanyNameUseCase implements ChangeCompanyName {
  private final CompanyExtractor companyExtractor;
  private final CompanySaver companySaver;

  @Override
  public Company execute(String id, String name) {
    return companyExtractor
        .getById(UUID.fromString(id))
        .map(company -> company.changeName(Company.Name.from(name)))
        .map(companySaver::save)
        .orElseThrow(() -> new RuntimeException("Not found"));
  }
}

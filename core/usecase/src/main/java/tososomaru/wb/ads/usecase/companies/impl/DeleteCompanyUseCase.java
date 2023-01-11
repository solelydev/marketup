package tososomaru.wb.ads.usecase.companies.impl;

import java.util.UUID;
import lombok.AllArgsConstructor;
import tososomaru.wb.ads.usecase.companies.CompanyRemover;
import tososomaru.wb.ads.usecase.companies.DeleteCompany;

@AllArgsConstructor
public class DeleteCompanyUseCase implements DeleteCompany {
  private final CompanyRemover companyRemover;

  @Override
  public void execute(UUID id) {
    companyRemover.remove(id);
  }
}

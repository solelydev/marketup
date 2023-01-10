package tososomaru.wb.ads.usecase.companies.impl;

import lombok.AllArgsConstructor;
import tososomaru.wb.ads.usecase.companies.CompanyRemover;
import tososomaru.wb.ads.usecase.companies.DeleteCompany;

import java.util.UUID;

@AllArgsConstructor

public class DeleteCompanyUseCase implements DeleteCompany {
    private final CompanyRemover companyRemover;
    @Override
    public void execute(UUID id) {
        companyRemover.remove(id);
    }
}

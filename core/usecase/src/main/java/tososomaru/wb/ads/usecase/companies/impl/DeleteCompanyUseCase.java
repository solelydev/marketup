package tososomaru.wb.ads.usecase.companies.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.usecase.companies.CompanyRemover;
import tososomaru.wb.ads.usecase.companies.DeleteCompany;

import java.util.UUID;

@AllArgsConstructor
@Component
public class DeleteCompanyUseCase implements DeleteCompany {
    private final CompanyRemover companyRemover;
    @Override
    public void execute(UUID id) {
        companyRemover.remove(id);
    }
}

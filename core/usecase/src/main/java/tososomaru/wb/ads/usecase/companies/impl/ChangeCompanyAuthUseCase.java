package tososomaru.wb.ads.usecase.companies.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.companies.Company;
import tososomaru.wb.ads.companies.CompanyAuth;
import tososomaru.wb.ads.usecase.companies.ChangeCompanyAuth;
import tososomaru.wb.ads.usecase.companies.CompanyExtractor;
import tososomaru.wb.ads.usecase.companies.CompanySaver;

import java.util.UUID;

@AllArgsConstructor
@Component
public class ChangeCompanyAuthUseCase implements ChangeCompanyAuth {
    private final CompanyExtractor companyExtractor;
    private final CompanySaver companySaver;
    @Override
    public Company execute(String id, CompanyAuth auth) {
        // TODO validate auth
        return companyExtractor.getById(UUID.fromString(id))
                .map(company -> company.changeAuth(auth))
                .map(companySaver::save)
                .orElseThrow(() -> new RuntimeException("Not found"))
                ;
    }
}

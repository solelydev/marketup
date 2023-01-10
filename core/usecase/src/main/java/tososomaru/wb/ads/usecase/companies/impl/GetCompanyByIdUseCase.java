package tososomaru.wb.ads.usecase.companies.impl;

import lombok.AllArgsConstructor;
import tososomaru.wb.ads.companies.Company;
import tososomaru.wb.ads.usecase.companies.CompanyExtractor;
import tososomaru.wb.ads.usecase.companies.GetCompanyById;

import java.util.UUID;


@AllArgsConstructor
public class GetCompanyByIdUseCase implements GetCompanyById {

    private final CompanyExtractor companyExtractor;

    @Override
    public Company execute(UUID id) {
        return companyExtractor.getById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}

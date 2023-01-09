package tososomaru.wb.ads.usecase.companies.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.companies.Company;
import tososomaru.wb.ads.usecase.companies.CompanyExtractor;
import tososomaru.wb.ads.usecase.companies.GetAllCompanies;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllCompaniesUseCase implements GetAllCompanies {

    private final CompanyExtractor companyExtractor;

    @Override
    public List<Company> execute() {
        return companyExtractor.getALl();
    }
}

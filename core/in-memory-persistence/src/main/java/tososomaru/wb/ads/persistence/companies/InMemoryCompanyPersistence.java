package tososomaru.wb.ads.persistence.companies;

import tososomaru.wb.ads.companies.Company;
import tososomaru.wb.ads.usecase.companies.CompanyExtractor;
import tososomaru.wb.ads.usecase.companies.CompanyRemover;
import tososomaru.wb.ads.usecase.companies.CompanySaver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InMemoryCompanyPersistence implements
        CompanySaver, CompanyExtractor, CompanyRemover {

    private final List<Company> companies = new ArrayList<>();

    @Override
    public Optional<Company> getById(UUID id) {
        return companies.stream()
                .filter(company -> company.getId().equals(id))
                .findFirst();
    }

    @Override
    public void remove(UUID id) {
        getById(id).ifPresent(companies::remove);
    }

    @Override
    public Company save(Company company) {
        companies.add(company);
        return company;
    }
}

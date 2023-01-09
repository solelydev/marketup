package tososomaru.wb.ads.usecase.companies;

import tososomaru.wb.ads.companies.Company;

import java.util.Optional;
import java.util.UUID;

public interface CompanyExtractor {
    Optional<Company> getById(UUID id);
}

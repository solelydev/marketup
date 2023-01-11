package tososomaru.wb.ads.usecase.companies;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import tososomaru.wb.ads.companies.Company;

public interface CompanyExtractor {
  Optional<Company> getById(UUID id);

  List<Company> getALl();
}

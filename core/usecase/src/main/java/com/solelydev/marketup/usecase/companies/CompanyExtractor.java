package com.solelydev.marketup.usecase.companies;

import com.solelydev.marketup.companies.Company;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyExtractor {
  Optional<Company> getById(UUID id);

  List<Company> getALl();
}

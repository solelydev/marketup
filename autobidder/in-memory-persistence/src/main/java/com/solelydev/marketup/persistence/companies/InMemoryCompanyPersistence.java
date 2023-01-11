package com.solelydev.marketup.persistence.companies;

import com.solelydev.marketup.companies.Company;
import com.solelydev.marketup.usecase.companies.CompanyExtractor;
import com.solelydev.marketup.usecase.companies.CompanyRemover;
import com.solelydev.marketup.usecase.companies.CompanySaver;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InMemoryCompanyPersistence implements CompanySaver, CompanyExtractor, CompanyRemover {

  private final List<Company> companies = new ArrayList<>();

  @Override
  public Optional<Company> getById(UUID id) {
    return companies.stream().filter(company -> company.getId().equals(id)).findFirst();
  }

  @Override
  public List<Company> getALl() {
    return companies;
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

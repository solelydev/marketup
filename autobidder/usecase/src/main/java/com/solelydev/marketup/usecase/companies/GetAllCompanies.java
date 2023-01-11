package com.solelydev.marketup.usecase.companies;

import com.solelydev.marketup.companies.Company;
import java.util.List;

public interface GetAllCompanies {
  List<Company> execute();
}

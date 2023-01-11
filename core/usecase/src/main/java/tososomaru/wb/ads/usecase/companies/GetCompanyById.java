package tososomaru.wb.ads.usecase.companies;

import java.util.UUID;
import tososomaru.wb.ads.companies.Company;

public interface GetCompanyById {
  Company execute(UUID id);
}

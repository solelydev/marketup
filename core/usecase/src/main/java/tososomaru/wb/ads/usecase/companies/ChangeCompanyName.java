package tososomaru.wb.ads.usecase.companies;

import tososomaru.wb.ads.companies.Company;

import java.util.UUID;

public interface ChangeCompanyName {
    Company execute(String id, String name);
}

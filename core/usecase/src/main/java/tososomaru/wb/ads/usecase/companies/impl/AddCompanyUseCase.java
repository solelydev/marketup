package tososomaru.wb.ads.usecase.companies.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.companies.Company;
import tososomaru.wb.ads.usecase.companies.AddCompany;
import tososomaru.wb.ads.usecase.companies.CompanySaver;

@Component
@AllArgsConstructor
public class AddCompanyUseCase implements AddCompany {

    private final CompanySaver companySaver;

    @Override
    public Company execute(AddCompanyRequest request) {
        return companySaver.save(
                Company.create(
                        Company.Name.from(request.getCompanyName()),
                        request.getCompanyAuth()
                )
        );
    }
}

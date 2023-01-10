package tososomaru.wb.ads.usecase.campaigns.impl;

import lombok.AllArgsConstructor;
import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.companies.Company;
import tososomaru.wb.ads.usecase.campaigns.CampaignSaver;
import tososomaru.wb.ads.usecase.campaigns.CreateCampaign;
import tososomaru.wb.ads.usecase.companies.CompanyExtractor;

@AllArgsConstructor

public class CreateCampaignUseCase implements CreateCampaign {

    private final CampaignSaver campaignSaver;
    private final CompanyExtractor companyExtractor;

    @Override
    public Campaign execute(CreateCampaignRequest request) {
        Company company = companyExtractor.getById(request.getCompanyId())
                .orElseThrow(() -> new RuntimeException("not found"));

        // TODO создать компанию в wb
        return campaignSaver.save(
                Campaign.create(
                        0,
                        request.getCompanyId(),
                        request.getName(),
                        request.getSKUs(),
                        request.getAdsType(),
                        request.getCampaignType()
                )
        );
    }
}

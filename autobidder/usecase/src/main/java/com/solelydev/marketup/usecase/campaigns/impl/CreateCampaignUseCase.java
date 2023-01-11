package com.solelydev.marketup.usecase.campaigns.impl;

import com.solelydev.marketup.campaigns.Campaign;
import com.solelydev.marketup.companies.Company;
import com.solelydev.marketup.usecase.campaigns.CampaignSaver;
import com.solelydev.marketup.usecase.campaigns.CreateCampaign;
import com.solelydev.marketup.usecase.companies.CompanyExtractor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCampaignUseCase implements CreateCampaign {

  private final CampaignSaver campaignSaver;
  private final CompanyExtractor companyExtractor;

  @Override
  public Campaign execute(CreateCampaignRequest request) {
    Company company =
        companyExtractor
            .getById(request.getCompanyId())
            .orElseThrow(() -> new RuntimeException("not found"));

    // TODO создать компанию в wb
    return campaignSaver.save(
        Campaign.create(
            0,
            request.getCompanyId(),
            request.getName(),
            request.getSKUs(),
            request.getAdsType(),
            request.getCampaignType()));
  }
}

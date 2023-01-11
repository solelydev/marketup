package com.solelydev.marketup.usecase.campaigns.impl;

import com.solelydev.marketup.campaigns.Campaign;
import com.solelydev.marketup.usecase.campaigns.CampaignExtractor;
import com.solelydev.marketup.usecase.campaigns.GetAllCampaigns;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAllCampaignsUseCase implements GetAllCampaigns {

  private final CampaignExtractor campaignExtractor;

  @Override
  public List<Campaign> execute() {
    return campaignExtractor.getAll();
  }
}

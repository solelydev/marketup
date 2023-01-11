package com.solelydev.marketup.usecase.campaigns.impl;

import com.solelydev.marketup.campaigns.Campaign;
import com.solelydev.marketup.usecase.campaigns.CampaignExtractor;
import com.solelydev.marketup.usecase.campaigns.GetCampaignById;
import java.util.UUID;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetCampaignByIdUseCase implements GetCampaignById {

  private final CampaignExtractor campaignExtractor;

  @Override
  public Campaign execute(UUID id) {
    return campaignExtractor.getById(id).orElseThrow(() -> new RuntimeException("not found"));
  }
}

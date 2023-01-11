package com.solelydev.marketup.usecase.campaigns.impl;

import com.solelydev.marketup.campaigns.Campaign;
import com.solelydev.marketup.usecase.campaigns.CampaignExtractor;
import com.solelydev.marketup.usecase.campaigns.CampaignSaver;
import com.solelydev.marketup.usecase.campaigns.ResumeCampaign;
import java.util.UUID;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResumeCampaignUseCase implements ResumeCampaign {
  private final CampaignExtractor campaignExtractor;
  private final CampaignSaver campaignSaver;

  @Override
  public void execute(String id) {
    campaignExtractor
        .getById(UUID.fromString(id))
        .map(Campaign::resume)
        .ifPresent(campaignSaver::save);
  }
}

package com.solelydev.marketup.usecase.campaigns.impl;

import com.solelydev.marketup.usecase.campaigns.CampaignRemover;
import com.solelydev.marketup.usecase.campaigns.DeleteCampaign;
import java.util.UUID;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteCampaignUseCase implements DeleteCampaign {
  private final CampaignRemover campaignRemover;

  @Override
  public void execute(String id) {
    campaignRemover.execute(UUID.fromString(id));
  }
}

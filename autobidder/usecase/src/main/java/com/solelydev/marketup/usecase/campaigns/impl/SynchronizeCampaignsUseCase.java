package com.solelydev.marketup.usecase.campaigns.impl;

import com.solelydev.marketup.campaigns.Campaign;
import com.solelydev.marketup.usecase.campaigns.CampaignExtractor;
import com.solelydev.marketup.usecase.campaigns.SynchronizeCampaigns;
import com.solelydev.marketup.wbapi.WbApi;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SynchronizeCampaignsUseCase implements SynchronizeCampaigns {
  private final WbApi wbApi;
  private final CampaignExtractor campaignExtractor;

  @Override
  public List<Campaign> execute() {
    throw new UnsupportedOperationException();
  }
}

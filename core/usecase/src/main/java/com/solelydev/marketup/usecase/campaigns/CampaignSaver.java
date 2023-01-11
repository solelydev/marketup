package com.solelydev.marketup.usecase.campaigns;

import com.solelydev.marketup.campaigns.Campaign;

public interface CampaignSaver {
  Campaign save(Campaign campaign);
}

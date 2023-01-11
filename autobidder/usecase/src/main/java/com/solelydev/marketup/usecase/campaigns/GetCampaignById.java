package com.solelydev.marketup.usecase.campaigns;

import com.solelydev.marketup.campaigns.Campaign;
import java.util.UUID;

public interface GetCampaignById {
  Campaign execute(UUID id);
}

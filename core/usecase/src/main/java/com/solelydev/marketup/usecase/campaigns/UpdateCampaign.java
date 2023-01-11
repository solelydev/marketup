package com.solelydev.marketup.usecase.campaigns;

import com.solelydev.marketup.campaigns.Campaign;
import java.util.UUID;
import lombok.Value;

public interface UpdateCampaign {
  Campaign execute(UpdateCampaignRequest request);

  @Value
  class UpdateCampaignRequest {
    UUID id;
  }
}

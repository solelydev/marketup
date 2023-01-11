package com.solelydev.marketup.usecase.campaigns;

import com.solelydev.marketup.campaigns.Campaign;
import com.solelydev.marketup.campaigns.CampaignType;
import com.solelydev.marketup.common.AdsType;
import java.util.List;
import java.util.UUID;
import lombok.Value;

public interface CreateCampaign {
  Campaign execute(CreateCampaignRequest request);

  @Value
  class CreateCampaignRequest {
    UUID companyId;
    String name;
    List<Integer> SKUs;
    AdsType adsType;
    CampaignType campaignType;
  }
}

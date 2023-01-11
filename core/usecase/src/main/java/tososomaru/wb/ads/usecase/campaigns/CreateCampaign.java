package tososomaru.wb.ads.usecase.campaigns;

import java.util.List;
import java.util.UUID;
import lombok.Value;
import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.campaigns.CampaignType;
import tososomaru.wb.ads.common.AdsType;

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

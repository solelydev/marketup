package tososomaru.wb.ads.usecase.campaigns;

import java.util.UUID;
import lombok.Value;
import tososomaru.wb.ads.campaigns.Campaign;

public interface UpdateCampaign {
  Campaign execute(UpdateCampaignRequest request);

  @Value
  class UpdateCampaignRequest {
    UUID id;
  }
}

package tososomaru.wb.ads.usecase.campaigns;

import lombok.Value;
import tososomaru.wb.ads.campaigns.Campaign;

import java.util.UUID;

public interface UpdateCampaign {
    Campaign execute(UpdateCampaignRequest request);

    @Value
    class UpdateCampaignRequest {
        UUID id;
    }
}

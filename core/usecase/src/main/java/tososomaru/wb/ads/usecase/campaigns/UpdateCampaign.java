package tososomaru.wb.ads.usecase.campaigns;

import tososomaru.wb.ads.campaigns.Campaign;

public interface UpdateCampaign {
    Campaign execute(UpdateCampaignRequest request);

    class UpdateCampaignRequest {

    }
}

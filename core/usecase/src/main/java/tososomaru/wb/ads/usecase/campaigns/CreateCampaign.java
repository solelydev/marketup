package tososomaru.wb.ads.usecase.campaigns;

import lombok.Value;
import tososomaru.wb.ads.bids.AdsType;
import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.campaigns.CampaignType;

import java.util.List;
import java.util.UUID;

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

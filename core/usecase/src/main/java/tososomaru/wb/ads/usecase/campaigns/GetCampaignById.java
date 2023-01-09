package tososomaru.wb.ads.usecase.campaigns;

import tososomaru.wb.ads.campaigns.Campaign;

import java.util.UUID;

public interface GetCampaignById {
    Campaign execute(UUID id);
}

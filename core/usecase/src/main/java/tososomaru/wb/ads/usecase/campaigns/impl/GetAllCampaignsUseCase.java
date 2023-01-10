package tososomaru.wb.ads.usecase.campaigns.impl;

import lombok.AllArgsConstructor;
import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.usecase.campaigns.CampaignExtractor;
import tososomaru.wb.ads.usecase.campaigns.GetAllCampaigns;

import java.util.List;


@AllArgsConstructor
public class GetAllCampaignsUseCase implements GetAllCampaigns {

    private final CampaignExtractor campaignExtractor;

    @Override
    public List<Campaign> execute() {
        return campaignExtractor.getAll();
    }
}

package tososomaru.wb.ads.usecase.campaigns.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.usecase.campaigns.CampaignExtractor;
import tososomaru.wb.ads.usecase.campaigns.GetAllCampaigns;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllCampaignsUseCase implements GetAllCampaigns {

    private final CampaignExtractor campaignExtractor;

    @Override
    public List<Campaign> execute() {
        return campaignExtractor.getAll();
    }
}

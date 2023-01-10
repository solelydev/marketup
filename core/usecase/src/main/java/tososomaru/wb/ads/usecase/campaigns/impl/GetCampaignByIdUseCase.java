package tososomaru.wb.ads.usecase.campaigns.impl;

import lombok.AllArgsConstructor;
import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.usecase.campaigns.CampaignExtractor;
import tososomaru.wb.ads.usecase.campaigns.GetCampaignById;

import java.util.UUID;


@AllArgsConstructor
public class GetCampaignByIdUseCase implements GetCampaignById {

    private final CampaignExtractor campaignExtractor;

    @Override
    public Campaign execute(UUID id) {
        return campaignExtractor.getById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}

package tososomaru.wb.ads.usecase.campaigns.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.usecase.campaigns.CampaignExtractor;
import tososomaru.wb.ads.usecase.campaigns.GetCampaignById;

import java.util.UUID;

@Component
@AllArgsConstructor
public class GetCampaignByIdUseCase implements GetCampaignById {

    private final CampaignExtractor campaignExtractor;

    @Override
    public Campaign execute(UUID id) {
        return campaignExtractor.getById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}

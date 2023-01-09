package tososomaru.wb.ads.usecase.campaigns.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.usecase.campaigns.CampaignExtractor;
import tososomaru.wb.ads.usecase.campaigns.CampaignSaver;
import tososomaru.wb.ads.usecase.campaigns.SuspendCampaign;

import java.util.UUID;

@AllArgsConstructor
@Component
public class SuspendCampaignUseCase implements SuspendCampaign {
    private final CampaignExtractor campaignExtractor;
    private final CampaignSaver campaignSaver;
    @Override
    public void execute(String id) {
        campaignExtractor.getById(UUID.fromString(id))
                .map(Campaign::suspend)
                .ifPresent(campaignSaver::save);
    }
}

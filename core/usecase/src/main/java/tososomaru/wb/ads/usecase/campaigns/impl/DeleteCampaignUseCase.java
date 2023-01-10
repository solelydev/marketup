package tososomaru.wb.ads.usecase.campaigns.impl;

import lombok.AllArgsConstructor;
import tososomaru.wb.ads.usecase.campaigns.CampaignRemover;
import tososomaru.wb.ads.usecase.campaigns.DeleteCampaign;

import java.util.UUID;

@AllArgsConstructor

public class DeleteCampaignUseCase implements DeleteCampaign {
    private final CampaignRemover campaignRemover;
    @Override
    public void execute(String id) {
        campaignRemover.execute(UUID.fromString(id));
    }
}

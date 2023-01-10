package tososomaru.wb.ads.usecase.campaigns.impl;

import io.vavr.NotImplementedError;
import lombok.AllArgsConstructor;
import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.usecase.campaigns.UpdateCampaign;

@AllArgsConstructor

public class UpdateCampaignUseCase implements UpdateCampaign {
    @Override
    public Campaign execute(UpdateCampaignRequest request) {
        throw new UnsupportedOperationException();
    }
}

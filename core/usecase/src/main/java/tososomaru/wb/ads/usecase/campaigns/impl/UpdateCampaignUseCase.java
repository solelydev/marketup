package tososomaru.wb.ads.usecase.campaigns.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.usecase.campaigns.UpdateCampaign;

@AllArgsConstructor
@Component
public class UpdateCampaignUseCase implements UpdateCampaign {
    @Override
    public Campaign execute(UpdateCampaignRequest request) {
        return null;
    }
}

package tososomaru.wb.ads.usecase.campaigns.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.usecase.campaigns.SynchronizeCampaigns;

import java.util.List;

@AllArgsConstructor
@Component
public class SynchronizeCampaignsUseCase implements SynchronizeCampaigns {
    @Override
    public List<Campaign> execute() {
        return null;
    }
}

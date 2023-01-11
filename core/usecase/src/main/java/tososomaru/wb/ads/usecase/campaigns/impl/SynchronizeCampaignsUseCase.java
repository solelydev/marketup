package tososomaru.wb.ads.usecase.campaigns.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.usecase.campaigns.CampaignExtractor;
import tososomaru.wb.ads.usecase.campaigns.SynchronizeCampaigns;
import tososomaru.wb.ads.wbapi.WbApi;

@AllArgsConstructor
public class SynchronizeCampaignsUseCase implements SynchronizeCampaigns {
  private final WbApi wbApi;
  private final CampaignExtractor campaignExtractor;

  @Override
  public List<Campaign> execute() {
    throw new UnsupportedOperationException();
  }
}

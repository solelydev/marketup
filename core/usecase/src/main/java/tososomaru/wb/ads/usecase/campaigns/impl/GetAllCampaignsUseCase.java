package tososomaru.wb.ads.usecase.campaigns.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.usecase.campaigns.CampaignExtractor;
import tososomaru.wb.ads.usecase.campaigns.GetAllCampaigns;

@AllArgsConstructor
public class GetAllCampaignsUseCase implements GetAllCampaigns {

  private final CampaignExtractor campaignExtractor;

  @Override
  public List<Campaign> execute() {
    return campaignExtractor.getAll();
  }
}

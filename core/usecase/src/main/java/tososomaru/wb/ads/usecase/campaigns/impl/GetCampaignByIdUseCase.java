package tososomaru.wb.ads.usecase.campaigns.impl;

import java.util.UUID;
import lombok.AllArgsConstructor;
import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.usecase.campaigns.CampaignExtractor;
import tososomaru.wb.ads.usecase.campaigns.GetCampaignById;

@AllArgsConstructor
public class GetCampaignByIdUseCase implements GetCampaignById {

  private final CampaignExtractor campaignExtractor;

  @Override
  public Campaign execute(UUID id) {
    return campaignExtractor.getById(id).orElseThrow(() -> new RuntimeException("not found"));
  }
}

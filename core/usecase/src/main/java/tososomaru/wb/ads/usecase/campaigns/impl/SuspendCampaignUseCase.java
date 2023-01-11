package tososomaru.wb.ads.usecase.campaigns.impl;

import java.util.UUID;
import lombok.AllArgsConstructor;
import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.usecase.campaigns.CampaignExtractor;
import tososomaru.wb.ads.usecase.campaigns.CampaignSaver;
import tososomaru.wb.ads.usecase.campaigns.SuspendCampaign;

@AllArgsConstructor
public class SuspendCampaignUseCase implements SuspendCampaign {
  private final CampaignExtractor campaignExtractor;
  private final CampaignSaver campaignSaver;

  @Override
  public void execute(String id) {
    campaignExtractor
        .getById(UUID.fromString(id))
        .map(Campaign::suspend)
        .ifPresent(campaignSaver::save);
  }
}

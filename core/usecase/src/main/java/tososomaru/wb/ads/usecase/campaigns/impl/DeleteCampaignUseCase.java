package tososomaru.wb.ads.usecase.campaigns.impl;

import java.util.UUID;
import lombok.AllArgsConstructor;
import tososomaru.wb.ads.usecase.campaigns.CampaignRemover;
import tososomaru.wb.ads.usecase.campaigns.DeleteCampaign;

@AllArgsConstructor
public class DeleteCampaignUseCase implements DeleteCampaign {
  private final CampaignRemover campaignRemover;

  @Override
  public void execute(String id) {
    campaignRemover.execute(UUID.fromString(id));
  }
}

package tososomaru.wb.ads.usecase.campaigns;

import java.util.UUID;
import tososomaru.wb.ads.campaigns.Campaign;

public interface GetCampaignById {
  Campaign execute(UUID id);
}

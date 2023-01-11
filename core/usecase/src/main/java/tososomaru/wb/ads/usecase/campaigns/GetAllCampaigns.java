package tososomaru.wb.ads.usecase.campaigns;

import java.util.List;
import tososomaru.wb.ads.campaigns.Campaign;

public interface GetAllCampaigns {
  List<Campaign> execute();
}

package com.solelydev.marketup.usecase.campaigns;

import com.solelydev.marketup.campaigns.Campaign;
import java.util.List;

public interface GetAllCampaigns {
  List<Campaign> execute();
}

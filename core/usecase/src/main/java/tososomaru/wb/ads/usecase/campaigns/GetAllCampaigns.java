package tososomaru.wb.ads.usecase.campaigns;

import tososomaru.wb.ads.campaigns.Campaign;

import java.util.List;

public interface GetAllCampaigns {
    List<Campaign> execute();
}
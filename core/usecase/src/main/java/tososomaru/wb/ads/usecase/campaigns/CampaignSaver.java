package tososomaru.wb.ads.usecase.campaigns;

import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.companies.Company;

public interface CampaignSaver {
    Campaign save(Campaign campaign);
}

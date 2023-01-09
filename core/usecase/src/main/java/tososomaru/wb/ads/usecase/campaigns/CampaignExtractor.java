package tososomaru.wb.ads.usecase.campaigns;

import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.companies.Company;

import java.util.Optional;
import java.util.UUID;

public interface CampaignExtractor {
    Optional<Campaign> getById(UUID id);
}

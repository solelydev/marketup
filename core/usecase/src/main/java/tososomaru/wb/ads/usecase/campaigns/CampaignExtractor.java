package tososomaru.wb.ads.usecase.campaigns;

import tososomaru.wb.ads.campaigns.Campaign;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CampaignExtractor {
    Optional<Campaign> getById(UUID id);

    List<Campaign> getAll();
}

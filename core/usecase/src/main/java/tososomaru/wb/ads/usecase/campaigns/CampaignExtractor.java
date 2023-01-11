package tososomaru.wb.ads.usecase.campaigns;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import tososomaru.wb.ads.campaigns.Campaign;

public interface CampaignExtractor {
  Optional<Campaign> getById(UUID id);

  List<Campaign> getAll();
}

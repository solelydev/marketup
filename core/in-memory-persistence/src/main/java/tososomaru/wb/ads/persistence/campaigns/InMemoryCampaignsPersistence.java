package tososomaru.wb.ads.persistence.campaigns;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import tososomaru.wb.ads.campaigns.Campaign;
import tososomaru.wb.ads.usecase.campaigns.CampaignExtractor;
import tososomaru.wb.ads.usecase.campaigns.CampaignRemover;
import tososomaru.wb.ads.usecase.campaigns.CampaignSaver;

public class InMemoryCampaignsPersistence
    implements CampaignSaver, CampaignExtractor, CampaignRemover {

  private final List<Campaign> campaigns = new ArrayList<>();

  @Override
  public Optional<Campaign> getById(UUID id) {
    return campaigns.stream().filter(campaign -> campaign.getId().equals(id)).findFirst();
  }

  @Override
  public List<Campaign> getAll() {
    return campaigns;
  }

  @Override
  public void execute(UUID id) {
    getById(id).ifPresent(campaigns::remove);
  }

  @Override
  public Campaign save(Campaign campaign) {
    campaigns.add(campaign);
    return campaign;
  }
}

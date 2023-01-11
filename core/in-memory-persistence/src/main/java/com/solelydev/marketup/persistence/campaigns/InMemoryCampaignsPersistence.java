package com.solelydev.marketup.persistence.campaigns;

import com.solelydev.marketup.campaigns.Campaign;
import com.solelydev.marketup.usecase.campaigns.CampaignExtractor;
import com.solelydev.marketup.usecase.campaigns.CampaignRemover;
import com.solelydev.marketup.usecase.campaigns.CampaignSaver;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

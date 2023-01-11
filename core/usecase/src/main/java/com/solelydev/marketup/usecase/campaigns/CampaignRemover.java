package com.solelydev.marketup.usecase.campaigns;

import java.util.UUID;

public interface CampaignRemover {
  void execute(UUID id);
}

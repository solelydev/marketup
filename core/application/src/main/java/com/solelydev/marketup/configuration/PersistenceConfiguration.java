package com.solelydev.marketup.configuration;

import com.solelydev.marketup.persistence.bids.InMemoryBidRequestsHistoryPersistence;
import com.solelydev.marketup.persistence.campaigns.InMemoryCampaignsPersistence;
import com.solelydev.marketup.persistence.companies.InMemoryCompanyPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {

  @Bean
  public InMemoryBidRequestsHistoryPersistence InMemoryBidRequestsHistoryPersistence() {
    return new InMemoryBidRequestsHistoryPersistence();
  }

  @Bean
  public InMemoryCompanyPersistence inMemoryCompanyPersistence() {
    return new InMemoryCompanyPersistence();
  }

  @Bean
  public InMemoryCampaignsPersistence inMemoryCampaignsPersistence() {
    return new InMemoryCampaignsPersistence();
  }
}

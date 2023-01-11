package com.solelydev.marketup.listener;

import com.solelydev.marketup.usecase.campaigns.SynchronizeCampaigns;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

  private final SynchronizeCampaigns synchronizeCampaigns;

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    //        synchronizeCampaigns.execute();
  }
}

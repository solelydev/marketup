package tososomaru.wb.ads.listener;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.usecase.campaigns.SynchronizeCampaigns;

@AllArgsConstructor
@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

    private final SynchronizeCampaigns synchronizeCampaigns;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        synchronizeCampaigns.execute();
    }
}

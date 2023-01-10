package tososomaru.wb.ads.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tososomaru.wb.ads.wbapi.WbMenuIdStore;
import tososomaru.wb.ads.wbapi.WbApi;

@Configuration
@Import({
        PersistenceConfiguration.class,
        UseCaseConfiguration.class
})
public class AppConfiguration {

    @Bean
    public WbApi wbApi() {
        return new WbApi();
    }

    @Bean
    public WbMenuIdStore menuIdStore(WbApi wbApi) {
        return new WbMenuIdStore(wbApi);
    }

}

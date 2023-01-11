package com.solelydev.marketup.configuration;

import com.solelydev.marketup.wbapi.WbApi;
import com.solelydev.marketup.wbapi.WbMenuIdStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistenceConfiguration.class, UseCaseConfiguration.class})
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

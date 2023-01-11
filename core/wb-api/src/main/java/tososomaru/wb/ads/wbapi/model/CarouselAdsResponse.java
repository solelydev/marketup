package tososomaru.wb.ads.wbapi.model;

import java.util.ArrayList;
import lombok.Value;

public class CarouselAdsResponse extends ArrayList<CarouselAdsResponse.Ads> {

  @Value
  public static class Ads {
    Integer nmId;
    Integer advertId;
    Integer position;
    Integer cpm;
    Integer subjectId;
    Integer brandId;
    Integer kindId;
    String code;
  }
}

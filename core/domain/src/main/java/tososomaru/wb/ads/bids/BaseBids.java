package tososomaru.wb.ads.bids;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import tososomaru.wb.ads.common.AdsType;

@AllArgsConstructor
@Getter
public abstract class BaseBids implements Bids {
  List<CurrentBid> bids;
  String request;
  AdsType adsType;
}

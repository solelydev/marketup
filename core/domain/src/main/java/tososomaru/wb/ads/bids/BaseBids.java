package tososomaru.wb.ads.bids;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tososomaru.wb.ads.common.AdsType;

import java.util.List;

@AllArgsConstructor
@Getter
public abstract class BaseBids implements Bids {
    List<CurrentBid> bids;
    String request;
    AdsType adsType;
}

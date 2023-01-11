package com.solelydev.marketup.bids;

import com.solelydev.marketup.common.AdsType;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class BaseBids implements Bids {
  List<CurrentBid> bids;
  String request;
  AdsType adsType;
}

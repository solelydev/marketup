package com.solelydev.marketup.bids;

import lombok.Value;

@Value
public class CurrentBid {
  Integer rank;
  /*
  test
   */
  String previewLink;
  // https://images.wbstatic.net/big/new/134410000/134417179-1.jpg
  Integer itemNumber;
  Integer position;
  Integer page;
  Integer cpm;
  Integer deliveryTime;
  Integer categoryId;

  public CurrentBid(
      Integer rank,
      Integer itemNumber,
      Integer position,
      Integer page,
      Integer cpm,
      Integer deliveryTime,
      Integer categoryId) {
    this.rank = rank;
    this.previewLink = buildPreviewLink(itemNumber);
    this.itemNumber = itemNumber;
    this.position = position;
    this.page = page;
    this.cpm = cpm;
    this.deliveryTime = deliveryTime;
    this.categoryId = categoryId;
  }

  private static String buildPreviewLink(Integer itemNumber) {
    var itemNumberStr = itemNumber.toString();
    return String.format(
        "https://images.wbstatic.net/big/new/%s0000/%s-1.jpg",
        itemNumberStr.substring(0, itemNumberStr.length() - 4), itemNumber);
  }

  public BidPreview toPreview() {
    return new BidPreview(cpm, itemNumber, rank, previewLink);
  }
}

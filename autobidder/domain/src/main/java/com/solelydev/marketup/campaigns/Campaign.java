package com.solelydev.marketup.campaigns;

import com.solelydev.marketup.common.AdsType;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(access = AccessLevel.PRIVATE, toBuilder = true)
public class Campaign {
  UUID id;
  Integer wbCompanyId;
  Date createdAt;
  Date updatedAt;
  UUID companyId;
  String name;
  List<Integer> SKUs;
  AdsType adsType;
  CampaignType campaignType;
  boolean isSuspend;

  private Campaign(
      UUID id,
      Integer wbCompanyId,
      Date createdAt,
      Date updatedAt,
      UUID companyId,
      String name,
      List<Integer> SKUs,
      AdsType adsType,
      CampaignType campaignType,
      boolean isSuspend) {
    this.id = id;
    this.wbCompanyId = wbCompanyId;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.companyId = companyId;
    this.name = name;
    this.SKUs = SKUs;
    this.adsType = adsType;
    this.campaignType = campaignType;
    this.isSuspend = isSuspend;
  }

  public static Campaign create(
      Integer wbCompanyId,
      UUID companyId,
      String name,
      List<Integer> SKUs,
      AdsType adsType,
      CampaignType campaignType) {
    return new Campaign(
        UUID.randomUUID(),
        wbCompanyId,
        new Date(),
        new Date(),
        companyId,
        name,
        SKUs,
        adsType,
        campaignType,
        true);
  }

  public Campaign suspend() {
    return this.toBuilder().isSuspend(true).build();
  }

  public Campaign resume() {
    return this.toBuilder().isSuspend(false).build();
  }
}

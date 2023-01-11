package com.solelydev.marketup.configuration;

import com.solelydev.marketup.usecase.bids.CategoryAdsToBidsMapper;
import com.solelydev.marketup.usecase.bids.GetBidsByAdsType;
import com.solelydev.marketup.usecase.bids.GetCarouselBids;
import com.solelydev.marketup.usecase.bids.GetCategoryBids;
import com.solelydev.marketup.usecase.bids.GetSearchBids;
import com.solelydev.marketup.usecase.bids.SearchAdsToBidsMapper;
import com.solelydev.marketup.usecase.bids.history.AddBidRequestToHistory;
import com.solelydev.marketup.usecase.bids.history.BidRequestsHistoryExtractor;
import com.solelydev.marketup.usecase.bids.history.BidRequestsHistorySaver;
import com.solelydev.marketup.usecase.bids.history.GetAllBidRequestHistory;
import com.solelydev.marketup.usecase.bids.history.GetRequestBidsFromHistoryById;
import com.solelydev.marketup.usecase.bids.history.GetTop5BidRequestHistory;
import com.solelydev.marketup.usecase.bids.history.UpdateBidsFromHistory;
import com.solelydev.marketup.usecase.bids.history.impl.AddBidRequestToHistoryUseCase;
import com.solelydev.marketup.usecase.bids.history.impl.GetAllBidRequestHistoryUseCase;
import com.solelydev.marketup.usecase.bids.history.impl.GetRequestBidsFromHistoryByIdUseCase;
import com.solelydev.marketup.usecase.bids.history.impl.GetTop5BidRequestHistoryUseCase;
import com.solelydev.marketup.usecase.bids.history.impl.UpdateBidsFromHistoryUseCase;
import com.solelydev.marketup.usecase.bids.impl.GetBidsByAdsTypeUseCase;
import com.solelydev.marketup.usecase.bids.impl.GetCarouselBidsUseCase;
import com.solelydev.marketup.usecase.bids.impl.GetCategoryBidsUseCase;
import com.solelydev.marketup.usecase.bids.impl.GetSearchBidsUseCase;
import com.solelydev.marketup.usecase.campaigns.CampaignExtractor;
import com.solelydev.marketup.usecase.campaigns.CampaignRemover;
import com.solelydev.marketup.usecase.campaigns.CampaignSaver;
import com.solelydev.marketup.usecase.campaigns.CreateCampaign;
import com.solelydev.marketup.usecase.campaigns.DeleteCampaign;
import com.solelydev.marketup.usecase.campaigns.GetAllCampaigns;
import com.solelydev.marketup.usecase.campaigns.GetCampaignById;
import com.solelydev.marketup.usecase.campaigns.ResumeCampaign;
import com.solelydev.marketup.usecase.campaigns.SuspendCampaign;
import com.solelydev.marketup.usecase.campaigns.impl.CreateCampaignUseCase;
import com.solelydev.marketup.usecase.campaigns.impl.DeleteCampaignUseCase;
import com.solelydev.marketup.usecase.campaigns.impl.GetAllCampaignsUseCase;
import com.solelydev.marketup.usecase.campaigns.impl.GetCampaignByIdUseCase;
import com.solelydev.marketup.usecase.campaigns.impl.ResumeCampaignUseCase;
import com.solelydev.marketup.usecase.campaigns.impl.SuspendCampaignUseCase;
import com.solelydev.marketup.usecase.campaigns.impl.SynchronizeCampaignsUseCase;
import com.solelydev.marketup.usecase.campaigns.impl.UpdateCampaignUseCase;
import com.solelydev.marketup.usecase.companies.AddCompany;
import com.solelydev.marketup.usecase.companies.ChangeCompanyAuth;
import com.solelydev.marketup.usecase.companies.ChangeCompanyName;
import com.solelydev.marketup.usecase.companies.CompanyExtractor;
import com.solelydev.marketup.usecase.companies.CompanyRemover;
import com.solelydev.marketup.usecase.companies.CompanySaver;
import com.solelydev.marketup.usecase.companies.DeleteCompany;
import com.solelydev.marketup.usecase.companies.GetAllCompanies;
import com.solelydev.marketup.usecase.companies.GetCompanyById;
import com.solelydev.marketup.usecase.companies.impl.AddCompanyUseCase;
import com.solelydev.marketup.usecase.companies.impl.ChangeCompanyAuthUseCase;
import com.solelydev.marketup.usecase.companies.impl.ChangeCompanyNameUseCase;
import com.solelydev.marketup.usecase.companies.impl.DeleteCompanyUseCase;
import com.solelydev.marketup.usecase.companies.impl.GetAllCompaniesUseCase;
import com.solelydev.marketup.usecase.companies.impl.GetCompanyByIdUseCase;
import com.solelydev.marketup.wbapi.WbApi;
import com.solelydev.marketup.wbapi.WbMenuIdStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

  @Bean
  public CategoryAdsToBidsMapper categoryAdsToBidsMapper() {
    return new CategoryAdsToBidsMapper();
  }

  @Bean
  public SearchAdsToBidsMapper searchAdsToBidsMapper() {
    return new SearchAdsToBidsMapper();
  }

  @Bean
  public GetBidsByAdsType getBidsByAdsType(
      GetCarouselBids getCarouselBids,
      GetCategoryBids getCategoryBids,
      GetSearchBids getSearchBids,
      AddBidRequestToHistory addBidRequestToHistory) {
    return new GetBidsByAdsTypeUseCase(
        getCarouselBids, getCategoryBids, getSearchBids, addBidRequestToHistory);
  }

  @Bean
  public GetCarouselBids getCarouselBids(WbApi wbApi) {
    return new GetCarouselBidsUseCase(wbApi);
  }

  @Bean
  public GetCategoryBids getCategoryBids(
      CategoryAdsToBidsMapper categoryAdsToBidsMapper, WbApi wbApi, WbMenuIdStore wbMenuIdStore) {
    return new GetCategoryBidsUseCase(categoryAdsToBidsMapper, wbApi, wbMenuIdStore);
  }

  @Bean
  public GetSearchBids getSearchBids(WbApi wbApi, SearchAdsToBidsMapper searchAdsToBidsMapper) {
    return new GetSearchBidsUseCase(wbApi, searchAdsToBidsMapper);
  }

  @Bean
  public AddBidRequestToHistory addBidRequestToHistory(
      BidRequestsHistorySaver bidRequestsHistorySaver) {
    return new AddBidRequestToHistoryUseCase(bidRequestsHistorySaver);
  }

  @Bean
  public GetAllBidRequestHistory getAllBidRequestHistory(
      BidRequestsHistoryExtractor bidRequestsHistoryExtractor) {
    return new GetAllBidRequestHistoryUseCase(bidRequestsHistoryExtractor);
  }

  @Bean
  public GetRequestBidsFromHistoryById getRequestBidsFromHistoryById(
      BidRequestsHistoryExtractor bidRequestsHistoryExtractor) {
    return new GetRequestBidsFromHistoryByIdUseCase(bidRequestsHistoryExtractor);
  }

  @Bean
  public GetTop5BidRequestHistory getTop5BidRequestHistory(
      BidRequestsHistoryExtractor bidRequestsHistoryExtractor) {
    return new GetTop5BidRequestHistoryUseCase(bidRequestsHistoryExtractor);
  }

  @Bean
  public UpdateBidsFromHistory updateBidsFromHistory(
      GetBidsByAdsType getBidsByAdsType,
      GetRequestBidsFromHistoryById getRequestBidsFromHistoryById) {
    return new UpdateBidsFromHistoryUseCase(getBidsByAdsType, getRequestBidsFromHistoryById);
  }

  @Bean
  public CreateCampaign createCampaign(
      CompanyExtractor companyExtractor, CampaignSaver campaignSaver) {
    return new CreateCampaignUseCase(campaignSaver, companyExtractor);
  }

  @Bean
  public DeleteCampaign deleteCampaign(CampaignRemover campaignRemover) {
    return new DeleteCampaignUseCase(campaignRemover);
  }

  @Bean
  public GetAllCampaigns getAllCampaigns(CampaignExtractor campaignExtractor) {
    return new GetAllCampaignsUseCase(campaignExtractor);
  }

  @Bean
  public GetCampaignById getCampaignById(CampaignExtractor campaignExtractor) {
    return new GetCampaignByIdUseCase(campaignExtractor);
  }

  @Bean
  public ResumeCampaign resumeCampaign(
      CampaignExtractor campaignExtractor, CampaignSaver campaignSaver) {
    return new ResumeCampaignUseCase(campaignExtractor, campaignSaver);
  }

  @Bean
  public SuspendCampaign suspendCampaign(
      CampaignExtractor campaignExtractor, CampaignSaver campaignSaver) {
    return new SuspendCampaignUseCase(campaignExtractor, campaignSaver);
  }

  @Bean
  public SynchronizeCampaignsUseCase synchronizeCampaignsUseCase(
      WbApi wbApi, CampaignExtractor campaignExtractor) {
    return new SynchronizeCampaignsUseCase(wbApi, campaignExtractor);
  }

  @Bean
  public UpdateCampaignUseCase updateCampaignUseCase() {
    return new UpdateCampaignUseCase();
  }

  @Bean
  public AddCompany addCompany(CompanySaver companySaver) {
    return new AddCompanyUseCase(companySaver);
  }

  @Bean
  public ChangeCompanyName changeCompanyName(
      CompanyExtractor companyExtractor, CompanySaver companySaver) {
    return new ChangeCompanyNameUseCase(companyExtractor, companySaver);
  }

  @Bean
  public ChangeCompanyAuth changeCompanyAuth(
      CompanyExtractor companyExtractor, CompanySaver companySaver) {
    return new ChangeCompanyAuthUseCase(companyExtractor, companySaver);
  }

  @Bean
  public DeleteCompany deleteCompany(CompanyRemover companyRemover) {
    return new DeleteCompanyUseCase(companyRemover);
  }

  @Bean
  public GetAllCompanies getAllCompanies(CompanyExtractor companyExtractor) {
    return new GetAllCompaniesUseCase(companyExtractor);
  }

  @Bean
  public GetCompanyById getCompanyById(CompanyExtractor companyExtractor) {
    return new GetCompanyByIdUseCase(companyExtractor);
  }
}

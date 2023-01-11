package tososomaru.wb.ads.usecase.bids;

public class BidsNotFoundException extends RuntimeException {
  public BidsNotFoundException(String message) {
    super(message);
  }
}

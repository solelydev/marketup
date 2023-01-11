package com.solelydev.marketup.usecase.bids;

public class BidsNotFoundException extends RuntimeException {
  public BidsNotFoundException(String message) {
    super(message);
  }
}

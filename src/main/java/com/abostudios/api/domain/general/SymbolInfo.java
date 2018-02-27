package com.abostudios.api.domain.general;

import com.abostudios.api.domain.OrderType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;
import java.util.Optional;

/**
 * Symbol information (base/quote).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SymbolInfo {

  private String symbol;

  private SymbolStatus status;

  private String baseAsset;

  private Integer baseAssetPrecision;

  private String quoteAsset;

  private Integer quotePrecision;

  private List<OrderType> orderTypes;

  private boolean icebergAllowed;

  private List<SymbolFilter> filters;

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public SymbolStatus getStatus() {
    return status;
  }

  public void setStatus(SymbolStatus status) {
    this.status = status;
  }

  public String getBaseAsset() {
    return baseAsset;
  }

  public void setBaseAsset(String baseAsset) {
    this.baseAsset = baseAsset;
  }

  public Integer getBaseAssetPrecision() {
    return baseAssetPrecision;
  }

  public void setBaseAssetPrecision(Integer baseAssetPrecision) {
    this.baseAssetPrecision = baseAssetPrecision;
  }

  public String getQuoteAsset() {
    return quoteAsset;
  }

  public void setQuoteAsset(String quoteAsset) {
    this.quoteAsset = quoteAsset;
  }

  public Integer getQuotePrecision() {
    return quotePrecision;
  }

  public void setQuotePrecision(Integer quotePrecision) {
    this.quotePrecision = quotePrecision;
  }

  public List<OrderType> getOrderTypes() {
    return orderTypes;
  }

  public void setOrderTypes(List<OrderType> orderTypes) {
    this.orderTypes = orderTypes;
  }

  public boolean isIcebergAllowed() {
    return icebergAllowed;
  }

  public void setIcebergAllowed(boolean icebergAllowed) {
    this.icebergAllowed = icebergAllowed;
  }

  public List<SymbolFilter> getFilters() {
    return filters;
  }

  public void setFilters(List<SymbolFilter> filters) {
    this.filters = filters;
  }

  /**
   * @param filterType filter type to filter for.
   * @return symbol filter information for the provided filter type.
   */
  public SymbolFilter getSymbolFilter(FilterType filterType) {
    Optional<SymbolFilter> optional = filters.stream()
            .filter(symbolFilter -> symbolFilter.getFilterType() == filterType)
            .findFirst();

    return optional.isPresent() ? optional.get() : null;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("symbol", symbol)
        .append("status", status)
        .append("baseAsset", baseAsset)
        .append("baseAssetPrecision", baseAssetPrecision)
        .append("quoteAsset", quoteAsset)
        .append("quotePrecision", quotePrecision)
        .append("orderTypes", orderTypes)
        .append("icebergAllowed", icebergAllowed)
        .append("filters", filters)
        .toString();
  }
}
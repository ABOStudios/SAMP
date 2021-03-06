package com.abostudios.api.exchanges.binance.examples;

import com.abostudios.api.exchanges.binance.BinanceApiClientFactory;
import com.abostudios.api.exchanges.ExchangeApiRestClient;
import com.abostudios.api.domain.market.AggTrade;
import com.abostudios.api.domain.market.BookTicker;
import com.abostudios.api.domain.market.Candlestick;
import com.abostudios.api.domain.market.CandlestickInterval;
import com.abostudios.api.domain.market.OrderBook;
import com.abostudios.api.domain.market.TickerPrice;
import com.abostudios.api.domain.market.TickerStatistics;
import com.abostudios.api.exchanges.ExchangeApiException;

import java.util.List;

/**
 * Examples on how to get market data information such as the latest price of a symbol, etc.
 */
public class MarketDataEndpointsExample {

  public static void main(String[] args) {
    BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance();
    ExchangeApiRestClient client = factory.newRestClient();

    // Getting depth of a symbol
    OrderBook orderBook = client.getOrderBook("NEOETH", 10);
    System.out.println(orderBook.getAsks());

    // Getting latest price of a symbol
    TickerStatistics tickerStatistics = client.get24HrPriceStatistics("NEOETH");
    System.out.println(tickerStatistics);

    // Getting all latest prices
    List<TickerPrice> allPrices = client.getAllPrices();
    System.out.println(allPrices);

    // Getting agg trades
    List<AggTrade> aggTrades = client.getAggTrades("NEOETH");
    System.out.println(aggTrades);

    // Weekly candlestick bars for a symbol
    List<Candlestick> candlesticks = client.getCandlestickBars("NEOETH", CandlestickInterval.WEEKLY);
    System.out.println(candlesticks);

    // Getting all book tickers
    List<BookTicker> allBookTickers = client.getBookTickers();
    System.out.println(allBookTickers);

    // Exception handling
    try {
      client.getOrderBook("UNKNOWN", 10);
    } catch (ExchangeApiException e) {
      System.out.println(e.getError().getCode()); // -1121
      System.out.println(e.getError().getMsg());  // Invalid symbol
    }
  }
}

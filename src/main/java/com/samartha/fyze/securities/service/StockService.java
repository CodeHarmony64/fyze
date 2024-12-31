package com.samartha.fyze.securities.service;

import com.samartha.fyze.securities.model.Stock;
import com.samartha.fyze.securities.repo.StockRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

	private final StockRepo repo;

	StockService(StockRepo repo) {
		this.repo = repo;
	}

	public Stock saveStock(Stock stock) {
		return repo.saveAndFlush(stock);
	}

	public Optional<Stock> getStock(Long stockId) {
		return repo.findById(stockId);
	}

	public List<Stock> getAllStocks(int page, int size) {
		return repo.findAll(PageRequest.of(page, size)).getContent();
	}

	public List<Stock> searchStock(String searchTerm) {
		return repo.searchStocks(searchTerm);
	}

}

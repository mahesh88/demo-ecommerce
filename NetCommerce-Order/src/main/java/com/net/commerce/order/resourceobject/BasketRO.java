package com.net.commerce.order.resourceobject;

import java.util.ArrayList;
import java.util.List;

import com.net.commerce.order.basket.jpa.Basket;
import com.net.commerce.order.basket.jpa.BasketItem;

public class BasketRO {
	
    private List<BasketItemRO> basketItems;
   
	private long totalValue;
	
	private long tax;
	
	private long totalPayableAmount;
	
	public BasketRO(Basket basket,List<BasketItem> items) {
		 totalValue = basket.getTotalValue();
		 tax = basket.getTax();
		 totalPayableAmount = basket.getTotalPayableAmount();
		 calculateItems(items);
	}
	
	private void calculateItems(List<BasketItem> items) {
		basketItems = new ArrayList<BasketItemRO>();
		  for(BasketItem item:items) {
			  basketItems.add(new BasketItemRO(item));
		  }
	}

	public List<BasketItemRO> getItems() {
		return basketItems;
	}

	public void setItems(List<BasketItemRO> basketItems) {
		this.basketItems = basketItems;
	}

	public long getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(long totalValue) {
		this.totalValue = totalValue;
	}

	public long getTax() {
		return tax;
	}

	public void setTax(long tax) {
		this.tax = tax;
	}

	public long getTotalPayableAmount() {
		return totalPayableAmount;
	}

	public void setTotalPayableAmount(long totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}
 
}

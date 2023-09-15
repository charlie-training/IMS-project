package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Orderline {

	private Long id;
	private Long item_id;
	//private Long order_id;
	private int amount;
	private float line_total;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Orderline orderline = (Orderline) o;
		return amount == orderline.amount && Float.compare(line_total, orderline.line_total) == 0 && Objects.equals(id, orderline.id) && Objects.equals(item_id, orderline.item_id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, item_id, amount, line_total);
	}

	public Orderline(Long item_id, int amount, float line_total) {
		this.setItemId(item_id);
		this.setAmount(amount);

	}

	public Orderline(Long id, Long item_id, int amount, float line_total) {
		this.setItemId(item_id);
		this.setAmount(amount);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemId() {
		return item_id;
	}

	public void setItemId(Long item_id) {
		this.item_id = item_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getLineTotal() {
		return line_total;
	}

	public void setLineTotal(float line_total) {
		this.line_total = line_total;
	}

	// public Long getOrderId() {
	// 	return order_id;
	// }

	// public void setOrderId(Long order_id) {
	// 	this.order_id = order_id;
	//}

	@Override
	public String toString() {
		return "id: " + id + " | item ID: " + item_id + " | amount: " + amount + " | line total: " + line_total;
	}

}

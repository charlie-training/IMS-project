package com.qa.ims.persistence.domain;

public class Orderline {

	private Long id;
	private Long item_id;
	private Long order_id;
	private int amount;
	private float line_total;

	public Orderline(Long item_id, int amount, float line_total, Long order_id) {
		this.setItemId(item_id);
		this.setAmount(amount);
		this.setOrderId(order_id);
	}

	public Orderline(Long id, Long item_id, int amount, float line_total, Long order_id) {
		this.setItemId(item_id);
		this.setAmount(amount);
		this.setOrderId(order_id);
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

	public Long getOrderId() {
		return order_id;
	}

	public void setOrderId(Long order_id) {
		this.order_id = order_id;
	}

	@Override
	public String toString() {
		return "id: " + id + " item ID: " + item_id + " amount: " + amount + "line total: " + line_total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orderline other = (Orderline) obj;
		if (getOrderId() == null) {
			if (other.getOrderId() != null)
				return false;
		} else if (!getOrderId().equals(other.getOrderId()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (getItemId() == null) {
			if (other.getItemId() != null)
				return false;
		} else if (!getItemId().equals(other.getItemId()))
			return false;
		return true;
	}

}

package com.qa.ims.persistence.domain;

public class Order {

	private Long id;
	private Long orderline_id;
	private float total;

	public Order(Long id, Long orderline_id) {
		this.setOrderline_id(orderline_id);
	}

	public Order(Long id, Long orderline_i, float total) {
		this.setOrderline_id(orderline_id);
	}

	public Order(Long id) {
		this.setId(id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderline_id() {
		return orderline_id;
	}

	public void setOrderline_id(Long orderline_id) {
		this.orderline_id = orderline_id;
	}

	public float getTotal() {
		return this.total;
	}

	public void setTotal() {

	}

	@Override
	public String toString() {
		return "id: " + id + " | orderline ID: " + orderline_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderline_id == null) ? 0 : orderline_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Order other = (Order) obj;
		if (getOrderline_id() == null) {
			if (other.getOrderline_id() != null)
				return false;
		} else if (!getOrderline_id().equals(other.getOrderline_id()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

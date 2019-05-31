package com.myretailcompany.dataaccesslayer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.myretailcompany.util.BillStatus;

/**
 * @author Tushar Malhotra
 *
 */
@Entity
@Table(name = "BILLS")

public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long billId;

	private String custId;

	private int noOfItems;
	private double totalCost;

	private double totalTax;

	private double totalValue;
	
	private double totalDiscount;

	@NotNull
	@Enumerated(EnumType.STRING)
	private BillStatus billStatus;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<LineItem> lineItems;

	public Bill() {
		super();
	}

	public Bill(String custId,double totalValue, int noOfItems, BillStatus billStatus) {
		super();
		this.custId = custId;
		this.totalValue = totalValue;
		this.noOfItems = noOfItems;
		this.billStatus = billStatus;
	}

	public Bill(List<LineItem> lineItems) {
		super();
		this.lineItems = lineItems;
	}

	public BillStatus getBillStatus() {
		return billStatus;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setBillStatus(BillStatus billStatus) {
		this.billStatus = billStatus;
	}

	public long getBillId() {
		return billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

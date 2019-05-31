package com.myretailcompany;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.myretailcompany.dataaccesslayer.entity.Bill;
import com.myretailcompany.rest.controller.bill.beans.BillUpdateInfo;
import com.myretailcompany.rest.controller.bill.beans.ProductInfoForBill;
import com.myretailcompany.rest.controller.product.beans.ProductInfo;
import com.myretailcompany.service.BillService;
import com.myretailcompany.service.ProductService;
import com.myretailcompany.util.BillStatus;
import com.myretailcompany.util.ProductCategory;

/**
 * @author Tushar Malhotra
 *
 */
@Component
public class SampleDataSetupRunner implements CommandLineRunner {

	@Autowired
	private BillService billService;

	final Logger logger = LogManager.getLogger(getClass());

	@Autowired
	private ProductService productService;

	@Override
	public void run(String... arg0) throws Exception {
		logger.info("Inside Runner..");
		setUpProductData();
		setupBillData();
		logger.info("Exiting Runner.. ");
	}

	public void setupBillData() {

		// create a new Bill to update information.
		Bill o1 = billService.createBill(new Bill("XXXX",0.0, 0, BillStatus.IN_PROGRESS));

		Long billId = o1.getBillId();
		BillUpdateInfo billUpdateInfo = new BillUpdateInfo();
		List<ProductInfoForBill> productsToBeAdded = new ArrayList<>();
		List<ProductInfoForBill> productsToBeRemoved = new ArrayList<>();

		productsToBeAdded.add(new ProductInfoForBill("ABC-abc-0001", 2));
		productsToBeAdded.add(new ProductInfoForBill("ABC-abc-0002", 2));
		productsToBeAdded.add(new ProductInfoForBill("ABC-abc-0003", 2));
		productsToBeAdded.add(new ProductInfoForBill("ABC-abc-0004", 2));
		productsToBeAdded.add(new ProductInfoForBill("ABC-abc-0005", 2));
		billUpdateInfo.setProductsToBeAdded(productsToBeAdded);
		billUpdateInfo.setProductsToBeRemoved(productsToBeRemoved);
		billUpdateInfo.setStatus(BillStatus.RELEASED);

		logger.info("billUpdateInfo = " + billUpdateInfo);
		billService.updateBill(billUpdateInfo, billId);
		Bill retrieveUpdatedbill = billService.getBillById(o1.getBillId());
		logger.info("retrieveUpdatedbill = " + retrieveUpdatedbill.getNoOfItems() + "  value ="
				+ retrieveUpdatedbill.getTotalValue());

	}

	private void setUpProductData() {
		productService.createProduct(new ProductInfo("ABC-abc-0001", 20.0, "Tomato", ProductCategory.GROCERIES));
		productService.createProduct(new ProductInfo("ABC-abc-0002", 30.0, "Onion", ProductCategory.GROCERIES));
		productService.createProduct(new ProductInfo("ABC-abc-0003", 40.0, "Potato", ProductCategory.GROCERIES));
		productService.createProduct(new ProductInfo("ABC-abc-0004", 50.0, "Bread", ProductCategory.GROCERIES));
		productService.createProduct(new ProductInfo("ABC-abc-0005", 60.0, "Apples", ProductCategory.GROCERIES));
		productService.createProduct(new ProductInfo("ABC-abc-0006", 70.0, "Banana", ProductCategory.GROCERIES));
		productService.createProduct(new ProductInfo("ABC-abc-0007", 80.0, "Strawberry", ProductCategory.GROCERIES));
		productService.createProduct(new ProductInfo("ABC-abc-0008", 90.0, "Apricot", ProductCategory.GROCERIES));
		productService.createProduct(new ProductInfo("ABC-abc-0009", 100.0, "Raisins", ProductCategory.NON_GROCERIES));
		productService.createProduct(new ProductInfo("ABC-abc-0010", 110.0, "CashewNut", ProductCategory.NON_GROCERIES));
	}
}

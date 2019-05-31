package com.myretailcompany;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myretailcompany.dataaccesslayer.entity.Product;
import com.myretailcompany.dataaccesslayer.repository.ProductRepository;
import com.myretailcompany.util.ProductCategory;

/**
 * @author Tushar Malhotra
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RetailStoreApplicationTests {

	@Autowired
	private ProductRepository productMasterRepo;

	@Test
	public void contextLoads() {
	}

	public void testProductSetup() {
		productMasterRepo.save(new Product("ABC-abc-1234", 20.0, "Tomato", ProductCategory.GROCERIES));
		productMasterRepo.save(new Product("ABC-abc-1235", 40.0, "Onion", ProductCategory.GROCERIES));
		productMasterRepo.save(new Product("ABC-abc-1236", 50.0, "Potato", ProductCategory.GROCERIES));
		productMasterRepo.save(new Product("ABC-abc-1237", 35.0, "Bread", ProductCategory.GROCERIES));
		productMasterRepo.save(new Product("ABC-abc-1238", 100.0, "Apples", ProductCategory.GROCERIES));
		productMasterRepo.save(new Product("ABC-abc-1239", 49.0, "Banana", ProductCategory.GROCERIES));
		assertThat(productMasterRepo.count()).isEqualTo(6);
	}

}

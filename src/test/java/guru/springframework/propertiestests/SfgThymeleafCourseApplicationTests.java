package guru.springframework.propertiestests;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import guru.springframework.base.SfgThymeleafUnitTests;
import guru.springframework.domain.JmsBroker;
import guru.springframework.domain.Product;
import guru.springframework.propertiestests.config.ExternalPropsPropertySourceTestConfig;
import guru.springframework.services.ProductService;


//@TestPropertySource("/application-testing.properties")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { ExternalPropsPropertySourceTestConfig.class })
public class SfgThymeleafCourseApplicationTests implements SfgThymeleafUnitTests {
	
	@Autowired
	private JmsBroker jmsBroker;
	
	@Mock
	ProductService mockProductService;
	
	@Test
	public void jmsBrokerTest() {
		Assert.assertEquals("10.11.12.13", jmsBroker.getJmsServer());
		Assert.assertEquals(new Integer(1234), jmsBroker.getJmsPort());
		Assert.assertEquals("test", jmsBroker.getJmsUser());
		Assert.assertEquals("test", jmsBroker.getJmsPassword());
	}
	
	@Test
	public void testGetProduct(){
		//local vars and dummy data generation
		int numberOfProducts = 5;
		List<Product> products = createProducts(numberOfProducts);
		
		//setup mock behavior
		Mockito.doReturn(products.get(0)).when(mockProductService).getProduct(Mockito.anyInt());
		Mockito.doReturn(products).when(mockProductService).listProducts(null);
		
		//perform calls on mocks
		Product actualProduct = mockProductService.getProduct(1);
		List<Product> actualProductList = mockProductService.listProducts(null);
		
		//assertions
		Assert.assertEquals("TEST COURSE1", actualProduct.getCourseName());
		
		Assert.assertEquals("TEST COURSE" + numberOfProducts, actualProductList.get(numberOfProducts - 1).getCourseName());
		Assert.assertEquals(numberOfProducts, actualProductList.size());
	}
	
	@Ignore
	public List<Product> createProducts(int count){
		return IntStream
				.rangeClosed(1,count) //from 1 to the count [inclusive]
				.mapToObj(i-> createProduct(i)) //map the int to a Product
				.collect(Collectors.toList()); //to list
	}
	
	@Ignore
	public Product createProduct(int index){
		Product product = new Product();
		product.setId(index);
		product.setCourseName("TEST COURSE" + index);
		return product;
	}

}

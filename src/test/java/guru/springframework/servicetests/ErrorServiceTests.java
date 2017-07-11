package guru.springframework.servicetests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import guru.springframework.base.SfgThymeleafUnitTests;
import guru.springframework.services.ErrorService;

@RunWith(SpringJUnit4ClassRunner.class)
public class ErrorServiceTests implements SfgThymeleafUnitTests {

	@Mock
	private ErrorService errorService;
	
	@Before
	public void beforeTests(){
		errorService = new ErrorService();
	}
	
	@Test
	public void getErrorByStatusTest(){
		Assert.assertEquals(errorService.getErrorByStatus(401).getMsg(), "Unauthorized");
		Assert.assertEquals(errorService.getErrorByStatus(403).getMsg(), "Unauthorized");
		Assert.assertEquals(errorService.getErrorByStatus(404).getMsg(), "Page not be found");
		Assert.assertEquals(errorService.getErrorByStatus(500).getMsg(), "Internal Server Error");
	}
	
}

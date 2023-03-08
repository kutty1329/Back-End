package BikeService.ZealousBikeServiceProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ZealousBikeServiceProjectApplicationTests {
  @MockBean
  BikeserviceRepositary jpa;
  @Autowired
  BikeServiceService service;
  
	@Test
	public void test1()
	{
		
		Date date = new Date(2022,10,10);
		BikeDetails bike1= new BikeDetails (1,"TN 54,U 9515",7904201927L,"Pradeep","pradeep@gmail.com",date,null);
		
		
		when(jpa.findAll()).thenReturn(Stream.of(bike1).collect(Collectors.toList()));
		assertNotNull(service.MakeFetchAll());
		assertSame(date, service.MakeFetchAll().get(0).getCusDatepurchase());
	}
	
	@Test
	public void testread()
	{
		Date date = new Date(2022,10,10);
		Optional<BikeDetails> bike1=Optional.of(new BikeDetails(1,"TN 54,U 9515",7904201927L,"Pradeep","pradeep@gmail.com",date,null));
		
		when(jpa.findById(1)).thenReturn(bike1);
		
		
		
		assertEquals(bike1, service.MakeFetchOne(1));
	}
}

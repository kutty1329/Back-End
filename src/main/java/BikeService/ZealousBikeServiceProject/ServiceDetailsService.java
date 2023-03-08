package BikeService.ZealousBikeServiceProject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDetailsService 
{
	
	@Autowired
	ServiceDetailsRepositary srepo;
	
	public ServiceDetails newservice(ServiceDetails service)
	{
		return srepo.save(service);
	}
	public List<ServiceDetails>gettingone(BikeDetails bike)
	{
		return srepo.findAllByBikeDetails1(bike);
	}
	public Optional<ServiceDetails> Exactoneservice(int jobcard)
	{
		return srepo.findById(jobcard);
	}
	public List<ServiceDetails>Exacttypeofservice(String typeofservice)
	{
	   return srepo.findAllByBikeTypeofservice(typeofservice);
	}
	

}

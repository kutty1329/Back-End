package BikeService.ZealousBikeServiceProject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bikeservicecontroller 
{
	
	@Autowired
	BikeServiceService service;
	
	@PostMapping("/createbikedetails")
	public String newcreatebike(@RequestBody BikeDetails bike)
	{
		return service.create(bike).getCusName()+"has been added successfully";
	}
	
	@PutMapping("/Updatebikedetails")
	public String updatebike(@RequestBody BikeDetails bike)
	{
		BikeDetails temp=service.create(bike);
		return temp.getCusName()+"has been updated Successfully";
	}
	
	@GetMapping("/Listallbikedetails")
	
	public List<BikeDetails> listallbikedetails()
	{
		return service.MakeFetchAll();
	}
	@GetMapping("/Listonebikedetails/{id}")
	public Optional<BikeDetails> listonebikedetails(@PathVariable("id") int id)
	{
		return service.MakeFetchOne(id);
	}
	@GetMapping("/Listallbikeno/{cusBikeno}")
	public Optional<BikeDetails>listallbikeno(@PathVariable("cusBikeno") String cusBikeno)
	{
		return service.MakeFetchone1(cusBikeno);
	}
	
	@GetMapping("/listallemailid/{cusEmailid}")
	public Optional<BikeDetails>listallemailid(@PathVariable("cusEmailid") String cusEmailid)
	{
		return service.getemailid(cusEmailid);
	}
	
	@DeleteMapping("/deletebikedetails/{id}")
	public String deletebikedetail(@PathVariable("id") int id)
	{
		return service.deletebyid(id);
	}
	
	///SERVICEDETAILS IMPLEMENTS
	@Autowired
	ServiceDetailsService sservice;
	
	@PostMapping("/createnewservice")
	
	public String newservicedetails(@RequestBody ServiceDetails serv)
	{
		BikeDetails temp=service.gettingexactone(serv.getBikedetails1().getCusId());
		
		if(serv.getBikeTypeofservice()=="free")
		{
			int total=serv.getBikeNewproductcost()+(serv.getBikeLabourcharge()*18/100);
			serv.setBikeFinalamount(total);
		}
		else
		{
			int total=serv.getBikeNewproductcost()+serv.getBikeLabourcharge();
			total+=(total)*18/100;
			serv.setBikeFinalamount(total);
		}
		temp.getMyservicedetails().add(serv);
		serv.setBikedetails1(temp);
		sservice.newservice(serv);
		return serv.getBikeJobcardno()+"has been service details is added";
	}
	@PutMapping("/UpdateServicedetails")
	public String updateServiceDetails(@RequestBody ServiceDetails serv)
	{
		ServiceDetails temp=sservice.newservice(serv);
		return temp.getBikeJobcardno()+"has been updated Successfully";
	}
    @GetMapping("/gettingoneobject/{cusId}")
    public List<ServiceDetails>findAll(@PathVariable("cusId") int cusId)
    {
    	BikeDetails temp=service.gettingexactone(cusId);
    	return sservice.gettingone(temp);
    }
    @GetMapping("/exactoneservice/{jobcardno}")
	public Optional<ServiceDetails> findoneservice(@PathVariable("jobcardno")int jobcardno)
	{
		return sservice.Exactoneservice(jobcardno);
	}
    @GetMapping("/gettingonefreeservice/{typeofservice}")
    public List<ServiceDetails>freeservice1(@PathVariable("typeofservice") String typeofservice)
    {
    	 return sservice.Exacttypeofservice(typeofservice);
    	
    }



}

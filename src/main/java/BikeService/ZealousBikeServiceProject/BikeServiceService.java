package BikeService.ZealousBikeServiceProject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeServiceService 
{
	@Autowired
    BikeserviceRepositary repo;
	public BikeDetails create(BikeDetails bike)
	
	{
		return repo.save(bike);
	}
	
	public List<BikeDetails> MakeFetchAll()
	{
		return repo.findAll();
	}
	
	public Optional<BikeDetails> MakeFetchOne(int id)
	{
		return repo.findById(id);
	}
	public String deletebyid(int id)
	{
		BikeDetails temp=repo.findById(id).orElse(new BikeDetails());
		repo.delete(temp);
		return temp.getCusName()+"has been added successfully";
	}
	public BikeDetails gettingexactone(int cusid)
	{
		return repo.findById(cusid).orElse(new BikeDetails());
	}
	public Optional<BikeDetails> MakeFetchone1(String bikeno)
	{
		return repo.findAllBycusBikeno(bikeno);
	}
	
	public Optional<BikeDetails>getemailid(String emailid)
	{
		return repo.findAllBycusEmailid(emailid);
	}
	

}

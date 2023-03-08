package BikeService.ZealousBikeServiceProject;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeserviceRepositary extends JpaRepository<BikeDetails,Integer>
{
  public Optional<BikeDetails>findAllBycusBikeno(String bikeno);
  
  public Optional<BikeDetails>findAllBycusEmailid(String emailid);
}


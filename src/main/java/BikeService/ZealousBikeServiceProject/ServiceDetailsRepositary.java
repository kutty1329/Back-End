package BikeService.ZealousBikeServiceProject;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDetailsRepositary extends JpaRepository<ServiceDetails, Integer>
{
      public List<ServiceDetails> findAllByBikeDetails1(BikeDetails bike);
	public List<ServiceDetails> findAllByBikeTypeofservice(String typeofservice);
}

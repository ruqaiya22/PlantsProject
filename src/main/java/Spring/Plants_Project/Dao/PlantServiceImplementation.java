package Spring.Plants_Project.Dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Spring.Plants_Project.Module.Plants;
import Spring.Plants_Project.Repository.PlantRepository;
import jakarta.persistence.EntityManager;

@Service
public class PlantServiceImplementation implements PlantService{
	
	private PlantRepository plantRepository;
	EntityManager entityManager;
	
	
	@Autowired
	public PlantServiceImplementation (PlantRepository thePlantRepository, EntityManager entityManager) {
		plantRepository = thePlantRepository;
		entityManager= this.entityManager;
	}


	@Override
	public List<Plants> findAll() {
		// TODO Auto-generated method stub
		return plantRepository.findAll();
	}

	@Override
	public Plants findById(int theId) {
Optional <Plants> result =plantRepository.findById(theId);
		
        Plants thePlants= null;
		
		if (result.isPresent()) {
			thePlants = result.get();
		}
		
		else {
			// we didn't find the customer
			throw new RuntimeException("Did not find customer id - " + theId);
		}
		
		return thePlants;
	}

	@Override
	public void save(Plants thePlants) {
		// TODO Auto-generated method stub
		plantRepository.save(thePlants);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		plantRepository.deleteById(theId);
	}

}

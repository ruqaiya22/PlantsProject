package Spring.Plants_Project.Dao;

import java.util.List;

import Spring.Plants_Project.Module.Plants;

public interface PlantService {
	
	List<Plants > findAll();
	
	Plants findById(int theId);
	
	void save (Plants thePlants);
	
	void deleteById (int theId);

}

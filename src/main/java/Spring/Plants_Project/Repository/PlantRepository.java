package Spring.Plants_Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Spring.Plants_Project.Module.Plants;

public interface PlantRepository extends JpaRepository<Plants, Integer> {

}

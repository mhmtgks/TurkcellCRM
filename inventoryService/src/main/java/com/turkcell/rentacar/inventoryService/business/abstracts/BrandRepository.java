//package com.turkcell.rentacar.inventoryService.business.abstracts;
package com.turkcell.rentacar.inventoryService.business.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import com.turkcell.rentacar.inventoryService.concretes.Brand;
public interface BrandRepository extends JpaRepository<Brand,Integer> {
        Optional<Brand> findByNameIgnoreCase(String brand);//hibernate bunu arka planda çeviriyo

        void deleteByName(String name);


}

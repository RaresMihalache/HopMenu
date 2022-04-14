package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.DTOs.RestaurantDTO;
import ro.sd.a2.DTOs.UserDTO;
import ro.sd.a2.entity.Restaurant;
import ro.sd.a2.repository.RestaurantRepository;

@Service
public class RestaurantService {
    
    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantDTO findByEmail(String email){
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        Restaurant restaurant = restaurantRepository.findByEmail(email);
        if(restaurant != null){
            restaurantDTO = restaurantDTO.convertFromRestaurantToRestaurantDTO(restaurant);
            return  restaurantDTO;
        }
        return null;
    }

    public String createRestaurant(RestaurantDTO newRestaurantDTO, String confirmPassword){
        if(newRestaurantDTO.getPassword().equals(confirmPassword) == false)
            return "-1"; // passwords don't match
        RestaurantDTO checkEmailRestaurants = findByEmail(newRestaurantDTO.getEmail());
        if(checkEmailRestaurants == null){
            Restaurant newRestaurant = new Restaurant();
            newRestaurant = newRestaurant.convertFromRestaurantDTOToRestaurant(newRestaurantDTO);
            restaurantRepository.save(newRestaurant);
            return "1"; // success -> account created successfully
        }
        return "-2"; // restaurant with given email found
    }
}

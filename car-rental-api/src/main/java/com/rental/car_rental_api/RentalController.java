package com.rental.car_rental_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

interface CarRepository extends JpaRepository<Car, Long> {}
interface ReservationRepository extends JpaRepository<Reservation, Long> {}
interface MessageRepository extends JpaRepository<ContactMessage, Long> {} // Idinagdag para sa messages

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RentalController {

    @Autowired private CarRepository carRepo;
    @Autowired private ReservationRepository resRepo;
    @Autowired private MessageRepository msgRepo; // Idinagdag para sa messages

    // -- CARS & RESERVATIONS ENDPOINTS --

    @GetMapping("/cars")
    public List<Car> getCars() {
        return carRepo.findAll();
    }

    @PostMapping("/rent")
    public String rentCar(@RequestBody Reservation res) {
        Car car = carRepo.findById(res.getCarId()).orElse(null);
        if (car != null && car.getAvailableUnits() > 0) {
            car.setAvailableUnits(car.getAvailableUnits() - 1);
            carRepo.save(car);
            resRepo.save(res);
            return "Reservation Successful!";
        }
        return "Failed: Car is out of stock.";
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        return resRepo.findAll();
    }

    // BAGO: Endpoint para ibalik ang sasakyan at mag-add ng +1 sa stock
    @PostMapping("/reservations/{id}/return")
    public String returnCar(@PathVariable Long id) {
        Reservation res = resRepo.findById(id).orElse(null);
        if (res != null && !res.getStatus().equals("Returned")) {
            res.setStatus("Returned");
            resRepo.save(res);

            Car car = carRepo.findById(res.getCarId()).orElse(null);
            if (car != null) {
                car.setAvailableUnits(car.getAvailableUnits() + 1);
                carRepo.save(car);
            }
            return "Car marked as returned successfully!";
        }
        return "Failed to return car.";
    }

    // -- MESSAGES ENDPOINTS --

    // BAGO: Para ma-save ang message mula sa contact form ng client
    @PostMapping("/messages")
    public String sendMessage(@RequestBody ContactMessage msg) {
        msgRepo.save(msg);
        return "Message sent successfully!";
    }

    // BAGO: Para kunin lahat ng messages at ipakita sa Admin
    @GetMapping("/messages")
    public List<ContactMessage> getMessages() {
        return msgRepo.findAll();
    }
}
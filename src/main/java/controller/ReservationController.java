package controller;

import com.example.spring092023.entities.*;
import com.example.spring092023.services.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {
    private ReservationService reservationService;

    @PutMapping("/newreserv/{idetud}/{idchambre}")
    public Reservation addReservation(@RequestBody Reservation reservation, @PathVariable(name = "idetud") Long idEtudiant , @PathVariable(name = "idchambre") Long idChambre) {
        return reservationService.addReservation(reservation, idEtudiant,idChambre);
    }
    @GetMapping("/byyear")
    public List<Reservation> getReservationParAnneeUniversitaire(@RequestParam(name = "dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
                                                                 @RequestParam(name = "dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        return reservationService.getReservationParAnneeUniversitaire(dateDebut, dateFin);
    }

    @PutMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

}

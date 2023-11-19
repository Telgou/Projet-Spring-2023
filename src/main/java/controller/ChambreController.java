package controller;

import com.example.spring092023.entities.Bloc;
import com.example.spring092023.entities.Chambre;
import com.example.spring092023.entities.TypeChambre;
import com.example.spring092023.services.ChambreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/chambres")
public class ChambreController {
    private ChambreService chambreService;

    @PostMapping("/setchambres/{nombloc}")
    public Bloc setchambres(@PathVariable("nombloc") String nombloc, @RequestBody Map<String, List<Long>> requestBody) {
        List<Long> numchambre = requestBody.get("numchambre");
        return chambreService.affecterChambresABloc(numchambre,nombloc);
    }
    @PostMapping("/chambresbyblocnom/{nombloc}")
    public List<Chambre> getchambresparnombloc(@PathVariable("nombloc") String nombloc) {
        return chambreService.getChambresParNomBloc(nombloc);
    }

    @PostMapping("/numchambres/{idbloc}/{type}")
    public long getnumberofchambres(@PathVariable("idbloc") long idbloc,@PathVariable("type") TypeChambre type) {
        return chambreService.nbChambreParTypeEtBloc(type,idbloc);
    }

    @PostMapping("/reservachambre/{idchambre}/{idreservation}")
    public Chambre affecterReservationAChambre(@PathVariable("idchambre") long idchambre,@PathVariable("idreservation") String idreservation) {
        return chambreService.affecterReservationAChambre(idchambre,idreservation);
    }



}

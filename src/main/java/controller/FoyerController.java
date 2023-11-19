package controller;

import com.example.spring092023.entities.Foyer;
import com.example.spring092023.services.FoyerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyers")
public class FoyerController {
    private final FoyerService foyerService;

    @GetMapping
    public List<Foyer> getAllFoyers() {
        return foyerService.retrieveAllFoyers();
    }

    @GetMapping("/{id}")
    public Foyer getFoyer(@PathVariable Long id) {
        return foyerService.retrieveFoyer(id);
    }

    @PostMapping
    public Foyer createFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @PostMapping("/{id}")
    public Foyer updateFoyer(@PathVariable Long id, @RequestBody Foyer foyer) {
        foyer.setIdFoyer(id);
        return foyerService.updateFoyer(foyer);
    }

    @DeleteMapping("/{id}")
    public void deleteFoyer(@PathVariable Long id) {
        foyerService.removeFoyer(id);
    }

    @PostMapping("/{id}/archive")
    public void archiveFoyer(@PathVariable Long id) {
        foyerService.archiverFoyer(id);
    }

    @PostMapping("/addfoyerbloc")
    public Foyer addFoyerwithBloc(@RequestBody Foyer foyer) {
        return foyerService.addFoyerwithBloc(foyer);
    }

}

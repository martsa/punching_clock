package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Kunden;
import ch.zli.m223.punchclock.service.KundenService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/kunden")
public class KundenController {

    private KundenService kundenService;

    public KundenController(KundenService kundenService){this.kundenService = kundenService;}

    /**
     * Gibt eine Liste aller Category Datensätze zurück
     * @return List<Category>
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Kunden> getAllCategories() {
        return kundenService.findAll();
    }

    /**
     * Erzeugt einen neuen category Datensatz
     * @param
     * @return category
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kunden createKunden(@Valid @RequestBody Kunden kunden) { return kundenService.createKunden(kunden);
    }

    /**
     * Löscht einen bestehenden category Datensatz anhand der ID
     * @param id
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable("id") Long id){ kundenService.deleteCategory(id);}

    /**
     * Aktualisiert einen bestehenden category Datensatz
     * @param
     * @return category
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Kunden updateCategory(@Valid @RequestBody Kunden kunden){ return kundenService.updateCategory(kunden);}


}

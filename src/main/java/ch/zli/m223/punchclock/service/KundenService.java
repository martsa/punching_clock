package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Kunden;
import ch.zli.m223.punchclock.repository.KundenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KundenService {

    private KundenRepository kundenRepository;

    public KundenService(KundenRepository kundenRepository) {
        this.kundenRepository = kundenRepository;
    }


    public Kunden createKunden(Kunden kunden) { return kundenRepository.saveAndFlush(kunden);
    }

    public Kunden findById(Long id){ return kundenRepository.getOne(id);}

    public void deleteCategory(Long id){kundenRepository.deleteById(id);}

    public Kunden updateCategory(Kunden category){
        if (kundenRepository.findById(category.getId()).isPresent()){
            return kundenRepository.save(category);
        }
        return null;
    }
    public List<Kunden> findAll() {

        return kundenRepository.findAll();
    }


}

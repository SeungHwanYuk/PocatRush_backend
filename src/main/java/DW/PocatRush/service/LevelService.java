package DW.PocatRush.service;

import DW.PocatRush.model.Level;
import DW.PocatRush.repository.LevelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LevelService {
    private LevelRepository levelRepository;

    @Autowired
    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    public List<Level> getLevelList(){
        return levelRepository.findAll().stream().sorted(Comparator.comparing(Level::getLevelUpExpHighLimit)).collect(Collectors.toList());
    }
}

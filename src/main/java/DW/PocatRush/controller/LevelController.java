package DW.PocatRush.controller;

import DW.PocatRush.model.Level;
import DW.PocatRush.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/level")
public class LevelController {

    private LevelService levelService;

    @Autowired
    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @GetMapping("/medallist")
    public List<Level> getLevelList(){
        return levelService.getLevelList();
    }
}

package DW.PocatRush.service;

import DW.PocatRush.model.LikeNPCTest;
import DW.PocatRush.repository.LikeNPCTestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LikeNPCTestService {

    LikeNPCTestRepository likeNPCTestRepository;

    @Autowired
    public LikeNPCTestService(LikeNPCTestRepository likeNPCTestRepository) {
        this.likeNPCTestRepository = likeNPCTestRepository;
    }

    public LikeNPCTest putLikeNPC(LikeNPCTest likeNPCTest){
        return likeNPCTestRepository.save(likeNPCTest);
    }
}

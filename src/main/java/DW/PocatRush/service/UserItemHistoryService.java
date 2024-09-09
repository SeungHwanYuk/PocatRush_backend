package DW.PocatRush.service;

import DW.PocatRush.dto.UserItemHistoryDto;
import DW.PocatRush.exception.ResourceNotFoundException;
import DW.PocatRush.model.Character;
import DW.PocatRush.model.Items;
import DW.PocatRush.model.UserItemHistory;
import DW.PocatRush.repository.CharacterRepository;
import DW.PocatRush.repository.ItemsRepository;
import DW.PocatRush.repository.UserItemHistoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserItemHistoryService {

    UserItemHistoryRepository userItemHistoryRepository;
    CharacterRepository characterRepository;

    ItemsRepository itemsRepository;

    @Autowired
    public UserItemHistoryService(UserItemHistoryRepository userItemHistoryRepository, CharacterRepository characterRepository, ItemsRepository itemsRepository) {
        this.userItemHistoryRepository = userItemHistoryRepository;
        this.characterRepository = characterRepository;
        this.itemsRepository = itemsRepository;
    }


    public UserItemHistory userItemUpdate(UserItemHistoryDto userItemHistoryDto) {
        Optional<Character> characterOptional = characterRepository.findById(userItemHistoryDto.getCharNickName());
        Optional<Items> itemsOptional = itemsRepository.findById(userItemHistoryDto.getItemId());
        if (characterOptional.isPresent() && itemsOptional.isPresent()) {
            Optional<UserItemHistory> userItemHistoryOptional = userItemHistoryRepository.findAll()
                            .stream()
                    .filter(userItemHistory -> characterOptional.get().equals(userItemHistory.getCharNickName()))
                    .filter(userItemHistory -> itemsOptional.get().equals(userItemHistory.getItemId()))
                    .findFirst();
            if (userItemHistoryOptional.isPresent()) {
                if (userItemHistoryOptional.get().getItemId() == itemsOptional.get()) {
                    userItemHistoryOptional.get().setItemValue(userItemHistoryDto.getItemValue());
                    userItemHistoryRepository.save(userItemHistoryOptional.get());
                }
                return userItemHistoryOptional.get();
            } else {
                UserItemHistory userItemHistory = new UserItemHistory();
                userItemHistory.setCharNickName(characterOptional.get());
                userItemHistory.setItemId(itemsOptional.get());
                userItemHistory.setItemValue(userItemHistoryDto.getItemValue());
                userItemHistoryRepository.save(userItemHistory);
                return userItemHistory;
            }
        } else {
            throw new ResourceNotFoundException("CharNickName", "ID", userItemHistoryDto.getCharNickName());
        }
    }
}


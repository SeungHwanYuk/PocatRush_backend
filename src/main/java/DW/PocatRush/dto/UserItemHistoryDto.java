package DW.PocatRush.dto;

import DW.PocatRush.model.UserItemHistory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserItemHistoryDto {

    private String charNickName;
    private String itemId;
    private int itemValue;

    public static List<UserItemHistoryDto> toDtoFromUserItemHistory(List<UserItemHistory> userItemHistoryList) {

        List<UserItemHistoryDto> userItemHistoryDtoList = new ArrayList<>();
        for (UserItemHistory history : userItemHistoryList) {
            UserItemHistoryDto dto = new UserItemHistoryDto();
            dto.setCharNickName(history.getCharNickName().getCharNickName());
            dto.setItemId(history.getItemId().getItemId());
            dto.setItemValue(history.getItemValue());
            userItemHistoryDtoList.add(dto);
        }
        return userItemHistoryDtoList;
    }
}

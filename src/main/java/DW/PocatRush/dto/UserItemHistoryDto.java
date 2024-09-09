package DW.PocatRush.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserItemHistoryDto {

    private String charNickName;
    private String itemId;
    private int itemValue;
}

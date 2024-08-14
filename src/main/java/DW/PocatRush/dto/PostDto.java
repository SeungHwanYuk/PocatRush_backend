package DW.PocatRush.dto;

import DW.PocatRush.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PostDto {
    private String postTitle;
    private String postText;
    private String userId;
    private String postImage;
    private long boardNumber;


    public PostDto toPostDtoFromPost(Post post) {
        PostDto postDto = new PostDto();
        postDto.setPostTitle(getPostTitle());
        postDto.setPostText(getPostText());
        postDto.setUserId(getUserId());
        postDto.setPostImage(getPostImage());
        postDto.setBoardNumber(getBoardNumber());

        return postDto;
    }
}

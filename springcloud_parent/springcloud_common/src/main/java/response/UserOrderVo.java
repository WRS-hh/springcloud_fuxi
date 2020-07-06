package response;

import lombok.Data;

import java.util.List;

@Data
public class UserOrderVo {

    private String username;
    private String nickName;
    private String headPic;
    private String sex;
    private List<OrderVo> orderList;
}
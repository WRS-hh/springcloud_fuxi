package response;

import lombok.Data;

@Data
public class OrderVo {

    private String id;
    private Integer totalNum;
    private Integer payMoney;
    private String orderStatus;
}

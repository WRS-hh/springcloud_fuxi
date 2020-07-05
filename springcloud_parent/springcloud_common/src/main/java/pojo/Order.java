package pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_order")
public class Order {

    @Id   // 主键
    private String id;

    private Integer totalNum;

    private Integer payMoney;

    private String payType;

    private Date createTime;

    private String username;

    private String receiverContact;

    private String receiverMobile;

    private String receiverAddress;

    private String sourceType;

    private String orderStatus;

    private String payStatus;

    private String isDelete;

    private static final long serialVersionUID = 1L;
}

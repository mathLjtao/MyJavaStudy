package ljtao.test.trace;

import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 批次桶数据
 * </p>
 *
 * @author 广东跑合中药材有限公司 linjintao
 * @since 2021-07-14
 */
@Data
public class BatchBarrelInfo extends OperateEntity {


    private Long id;

    /**
     * 批次实例ID
     */
    private Long batchId;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 原料代码
     */
    private String materialCode;

    /**
     * 桶号
     */
    private String barrelCode;

    /**
     * 毛重
     */
    private BigDecimal grossWeight;

    /**
     * 桶重
     */
    private BigDecimal barrelWeight;

    /**
     * 净重
     */
    private BigDecimal netWeight;

    /**
     * 单位
     */
    private String barrelUnit;

    /**
     * PDA包装端领料领取状态（0：未领、1：已领）
     */
    private String barrelStatus;

    /**
     * PDA包装端领料审核状态（W：未审核，Y：审核成功，N：审核不通过）
     */
    private String checkStatus;
}

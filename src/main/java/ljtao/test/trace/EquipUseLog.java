package ljtao.test.trace;

import java.time.LocalDateTime;

/**
 * TODO
 *
 * @Author 黄芝民
 * @Date 2021/3/31 9:49
 * @Version V1.0
 * @Copyright 广东跑合中药材有限公司 Copyright (c) 2020
 **/
public class EquipUseLog  extends OperateEntity{

    //设备校验ID
    private Long useLogId;

    /**
     * 关联ID
     */
    private String relaId;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 设备ID
     */
    private Long equipmentId;

    /**
     * 设备编号
     */
    private String equipmentCode;

    /**
     * 确认结果
     */
    private String confirmResult;

    /**
     * 确认时间
     */
    private LocalDateTime confirmTime;

    /**
     * 记录设备检查项目信息,json存储
     */
    private String confirmItemInfo;

    /**
     * 操作记录
     */
    private String operRecord;

    /**
     * 关联类型:生产、包装
     */
    private String relaType;

    /**
     * 事项
     */
    private String useReason;

    /**
     * 使用时间
     */
    private LocalDateTime useTime;

    /**
     * 使用人账号
     */
    private String useAccount;

    /**
     * 使用者名称
     */
    private String useName;

    /**
     * 备注
     */
    private String remarks;


}

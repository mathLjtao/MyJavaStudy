package ljtao.test.trace;

import java.time.LocalDateTime;

/**
 * <p>
 * 审批数据
 * </p>
 *
 * @author 广东跑合中药材有限公司 linjintao
 * @since 2021-07-14
 */
public class ApprovalInfo extends OperateEntity {


    private Long approvalId;

    /**
     * 关联ID
     */
    private String relaId;

    /**
     * 原料代码
     */
    private String materialCode;

    /**
     * 审批结论
     */
    private String approvalResult;

    /**
     * 审批详情
     */
    private String approvalDesc;

    /**
     * 状态
     */
    private String status;

    /**
     * 审批人
     */
    private String approvalPer;

    /**
     * 审批时间
     */
    private LocalDateTime approvalTime;

    /**
     * 关联类型，1:生产工序批次,2:生产工序,3:生产工序原料代码
     */
    private String relaType;

    public Long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }

    public String getRelaId() {
        return relaId;
    }

    public void setRelaId(String relaId) {
        this.relaId = relaId;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getApprovalResult() {
        return approvalResult;
    }

    public void setApprovalResult(String approvalResult) {
        this.approvalResult = approvalResult;
    }

    public String getApprovalDesc() {
        return approvalDesc;
    }

    public void setApprovalDesc(String approvalDesc) {
        this.approvalDesc = approvalDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovalPer() {
        return approvalPer;
    }

    public void setApprovalPer(String approvalPer) {
        this.approvalPer = approvalPer;
    }

    public LocalDateTime getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(LocalDateTime approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getRelaType() {
        return relaType;
    }

    public void setRelaType(String relaType) {
        this.relaType = relaType;
    }
}

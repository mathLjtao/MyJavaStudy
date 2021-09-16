package ljtao.test.trace;

/**
 * <p>
 * 流程工序实例表
 * </p>
 *
 * @author 广东跑合中药材有限公司 linjintao
 * @since 2021-07-28
 */
public class ProcedureInstInfo extends OperateEntity{


    /**
     * 工序ID
     */
    private Long procedureInstId;

    /**
     * 配置流程ID
     */
    private Long processConfigId;

    /**
     * 工序ID
     */
    private Long procedureId;

    /**
     * 工序类型
     */
    private String procedureType;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 状态： S,待提交，W,待审核，Y审核通过,N审核不通过
     */
    private String status;

    public Long getProcedureInstId() {
        return procedureInstId;
    }

    public void setProcedureInstId(Long procedureInstId) {
        this.procedureInstId = procedureInstId;
    }

    public Long getProcessConfigId() {
        return processConfigId;
    }

    public void setProcessConfigId(Long processConfigId) {
        this.processConfigId = processConfigId;
    }

    public Long getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(Long procedureId) {
        this.procedureId = procedureId;
    }

    public String getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(String procedureType) {
        this.procedureType = procedureType;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package ljtao.test.trace;

/**
 * <p>
 * 品种原料实例表，关联流程工序数据
 * </p>
 *
 * @author 广东跑合中药材有限公司 linjintao
 * @since 2021-07-28
 */
public class VarietyMaterialInst extends OperateEntity{


    /**
     * 品种原料实例ID
     */
    private Long vmInstId;

    /**
     * 工序实例ID
     */
    private Long procedureInstId;

    /**
     * 品种原料ID
     */
    private Long varietyMaterialId;

    /**
     * 原料代号
     */
    private String materialCode;

    /**
     * 状态：S,待提交，W,待审核，Y审核通过,N审核不通过
     */
    private String status;

    public Long getVmInstId() {
        return vmInstId;
    }

    public void setVmInstId(Long vmInstId) {
        this.vmInstId = vmInstId;
    }

    public Long getProcedureInstId() {
        return procedureInstId;
    }

    public void setProcedureInstId(Long procedureInstId) {
        this.procedureInstId = procedureInstId;
    }

    public Long getVarietyMaterialId() {
        return varietyMaterialId;
    }

    public void setVarietyMaterialId(Long varietyMaterialId) {
        this.varietyMaterialId = varietyMaterialId;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

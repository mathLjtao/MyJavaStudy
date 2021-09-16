package ljtao.test.trace;

/**
 * <p>
 * 批次关联数据
 * </p>
 *
 * @author 广东跑合中药材有限公司 linjintao
 * @since 2021-07-14
 */
public class BatchRelaInfo{


    private Long batchRelaId;

    /**
     * 批次ID
     */
    private Long batchId;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 对应来源批次实例ID
     */
    private Long sourceBatchId;

    /**
     * 对应来源批次号
     */
    private String sourceBatchNo;

    /**
     * 步骤名称
     */
    private String stepName;

    /**
     * 步骤关联模板表名称
     */
    private String tableName;

    /**
     * 实例表数据id
     */
    private Long tebleInstId;

    /**
     * 关联类型:批次来源数据、步骤实例数据
     */
    private String relaType;

    public Long getBatchRelaId() {
        return batchRelaId;
    }

    public void setBatchRelaId(Long batchRelaId) {
        this.batchRelaId = batchRelaId;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Long getSourceBatchId() {
        return sourceBatchId;
    }

    public void setSourceBatchId(Long sourceBatchId) {
        this.sourceBatchId = sourceBatchId;
    }

    public String getSourceBatchNo() {
        return sourceBatchNo;
    }

    public void setSourceBatchNo(String sourceBatchNo) {
        this.sourceBatchNo = sourceBatchNo;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getTebleInstId() {
        return tebleInstId;
    }

    public void setTebleInstId(Long tebleInstId) {
        this.tebleInstId = tebleInstId;
    }

    public String getRelaType() {
        return relaType;
    }

    public void setRelaType(String relaType) {
        this.relaType = relaType;
    }
}

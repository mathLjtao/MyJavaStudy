package ljtao.test.trace;

import lombok.Data;

/**
 * TODO
 *
 * @Author 黄芝民
 * @Date 2021/4/14 16:28
 * @Version V1.0
 * @Copyright 广东跑合中药材有限公司 Copyright (c) 2020
 **/
@Data
public class BatchInfo extends OperateEntity {

    private Long batchId; // 批次号ID

    /**
     * 生产线
     */
    private String prodLine;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 父批次ID
     */
    private Long parentBatchId;

    /**
     * 原料代码
     */
    private String materialCode;

    /**
     * 品种ID
     */
    private String varietyId;

    /**
     * 品种编号
     */
    private String varietyCode;

    /**
     * 品种名称
     */
    private String varietyName;

    /**
     * 添加人
     */
    private String addUserName;

    /**
     * 使用状态，Y使用，N未使用
     */
    private String useStatus;

    /**
     * 领料位置
     */
    private String sourceMatPos;

    /**
     * 存放位置
     */
    private String leaveMatPos;

    /**
     * 生产流程-工序实例数据ID
     */
    private Long procedureInstId;

    /**
     * 生产流程-工序数据ID
     */
    private Long procedureId;

    /**
     * 工序类型:称配、处理、混合1（2、3...）、...
     */
    private String procedureType;

    /**
     * 状态： S,待提交，W,待审核，Y审核通过,N审核不通过
     */
    private String curProcedureStatus;

    /**
     * 审批数据ID
     */
    private Long approvalId;

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public String getProdLine() {
        return prodLine;
    }

    public void setProdLine(String prodLine) {
        this.prodLine = prodLine;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Long getParentBatchId() {
        return parentBatchId;
    }

    public void setParentBatchId(Long parentBatchId) {
        this.parentBatchId = parentBatchId;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getVarietyId() {
        return varietyId;
    }

    public void setVarietyId(String varietyId) {
        this.varietyId = varietyId;
    }

    public String getVarietyCode() {
        return varietyCode;
    }

    public void setVarietyCode(String varietyCode) {
        this.varietyCode = varietyCode;
    }

    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    public String getAddUserName() {
        return addUserName;
    }

    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    public String getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }

    public String getSourceMatPos() {
        return sourceMatPos;
    }

    public void setSourceMatPos(String sourceMatPos) {
        this.sourceMatPos = sourceMatPos;
    }

    public String getLeaveMatPos() {
        return leaveMatPos;
    }

    public void setLeaveMatPos(String leaveMatPos) {
        this.leaveMatPos = leaveMatPos;
    }

    public Long getProcedureInstId() {
        return procedureInstId;
    }

    public void setProcedureInstId(Long procedureInstId) {
        this.procedureInstId = procedureInstId;
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

    public String getCurProcedureStatus() {
        return curProcedureStatus;
    }

    public void setCurProcedureStatus(String curProcedureStatus) {
        this.curProcedureStatus = curProcedureStatus;
    }

    public Long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }
}

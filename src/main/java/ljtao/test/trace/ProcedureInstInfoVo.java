package ljtao.test.trace;

import java.util.List;

/**
 * @author linjintao
 * @date 2021/7/28
 */
public class ProcedureInstInfoVo extends ProcedureInstInfo {
    //批次数据
    private List<BatchInfoVo> batchInfoVoList;
    //原料代码实例数据
    private List<VarietyMaterialInstVo> varietyMaterialInstVoList;
    //审批数据
    private ApprovalInfo approvalInfo;

    public List<BatchInfoVo> getBatchInfoVoList() {
        return batchInfoVoList;
    }

    public void setBatchInfoVoList(List<BatchInfoVo> batchInfoVoList) {
        this.batchInfoVoList = batchInfoVoList;
    }

    public List<VarietyMaterialInstVo> getVarietyMaterialInstVoList() {
        return varietyMaterialInstVoList;
    }

    public void setVarietyMaterialInstVoList(List<VarietyMaterialInstVo> varietyMaterialInstVoList) {
        this.varietyMaterialInstVoList = varietyMaterialInstVoList;
    }

    public ApprovalInfo getApprovalInfo() {
        return approvalInfo;
    }

    public void setApprovalInfo(ApprovalInfo approvalInfo) {
        this.approvalInfo = approvalInfo;
    }
}

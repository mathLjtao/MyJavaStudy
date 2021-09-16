package ljtao.test.trace;

import java.util.List;

/**
 * @author linjintao
 * @date 2021/7/28
 */
public class VarietyMaterialInstVo extends VarietyMaterialInst {
    private ApprovalInfo approvalInfo;
    //原料代码实例下的批次数据
    private List<BatchInfoVo> batchInfoVoList;

    public ApprovalInfo getApprovalInfo() {
        return approvalInfo;
    }

    public void setApprovalInfo(ApprovalInfo approvalInfo) {
        this.approvalInfo = approvalInfo;
    }

    public List<BatchInfoVo> getBatchInfoVoList() {
        return batchInfoVoList;
    }

    public void setBatchInfoVoList(List<BatchInfoVo> batchInfoVoList) {
        this.batchInfoVoList = batchInfoVoList;
    }
}

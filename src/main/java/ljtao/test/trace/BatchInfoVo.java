package ljtao.test.trace;

import java.util.List;

/**
 * TODO
 *
 * @Author 黄芝民
 * @Date 2021/4/14 16:49
 * @Version V1.0
 * @Copyright 广东跑合中药材有限公司 Copyright (c) 2020
 **/
public class BatchInfoVo extends BatchInfo {

    private List<String> batchNoList;
    //关联审批数据
    private ApprovalInfo approvalInfo;
    //关联桶数据
    private List<BatchBarrelInfo> batchBarrelInfoList;
    //关联批次来源数据、步骤实例数据
    private List<BatchRelaInfo> batchRelaInfoList;
    //设备数据
    private List<EquipUseLogVo> equipUseLogVoList;
    //查询条件：状态
    private List<String> statusIn;

    public List<String> getBatchNoList() {
        return batchNoList;
    }

    public void setBatchNoList(List<String> batchNoList) {
        this.batchNoList = batchNoList;
    }

    public ApprovalInfo getApprovalInfo() {
        return approvalInfo;
    }

    public void setApprovalInfo(ApprovalInfo approvalInfo) {
        this.approvalInfo = approvalInfo;
    }

    public List<BatchBarrelInfo> getBatchBarrelInfoList() {
        return batchBarrelInfoList;
    }

    public void setBatchBarrelInfoList(List<BatchBarrelInfo> batchBarrelInfoList) {
        this.batchBarrelInfoList = batchBarrelInfoList;
    }

    public List<BatchRelaInfo> getBatchRelaInfoList() {
        return batchRelaInfoList;
    }

    public void setBatchRelaInfoList(List<BatchRelaInfo> batchRelaInfoList) {
        this.batchRelaInfoList = batchRelaInfoList;
    }

    public List<EquipUseLogVo> getEquipUseLogVoList() {
        return equipUseLogVoList;
    }

    public void setEquipUseLogVoList(List<EquipUseLogVo> equipUseLogVoList) {
        this.equipUseLogVoList = equipUseLogVoList;
    }

    public List<String> getStatusIn() {
        return statusIn;
    }

    public void setStatusIn(List<String> statusIn) {
        this.statusIn = statusIn;
    }
}

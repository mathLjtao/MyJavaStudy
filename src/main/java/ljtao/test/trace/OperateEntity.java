package ljtao.test.trace;

import java.util.Date;

/**
 * TODO
 *
 * @Author 黄芝民
 * @Date 2021/3/26 9:48
 * @Version V1.0
 * @Copyright 广东跑合中药材有限公司 Copyright (c) 2020
 **/
public class OperateEntity {

    private String aliveFlag; // 逻辑状态标识，N:失效,Y:启用

    private Long addUserId;// 添加人

    private Date addTime;// 添加时间

    private Long oprUserId;// 修改人

    private Date oprTime;// 修改时间

    public String getAliveFlag() {
        return aliveFlag;
    }

    public void setAliveFlag(String aliveFlag) {
        this.aliveFlag = aliveFlag;
    }

    public Long getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(Long addUserId) {
        this.addUserId = addUserId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Long getOprUserId() {
        return oprUserId;
    }

    public void setOprUserId(Long oprUserId) {
        this.oprUserId = oprUserId;
    }

    public Date getOprTime() {
        return oprTime;
    }

    public void setOprTime(Date oprTime) {
        this.oprTime = oprTime;
    }
}

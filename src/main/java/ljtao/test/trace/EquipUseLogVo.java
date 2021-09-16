package ljtao.test.trace;

import java.util.Date;

/**
 * @author linjintao
 * @date 2021/7/20
 */
public class EquipUseLogVo extends EquipUseLog {
    //页面状态，add 新增，update 更新，delete 删除
    private String pageStatus;

    //设备名称
    private String equipmentName;
    //设备有效期
    private Date validTime;

    public String getPageStatus() {
        return pageStatus;
    }

    public void setPageStatus(String pageStatus) {
        this.pageStatus = pageStatus;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }
}

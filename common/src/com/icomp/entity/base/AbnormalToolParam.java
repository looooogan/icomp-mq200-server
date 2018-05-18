package com.icomp.entity.base;

/**
 * 临时传参类
 * @ClassName: AbnormalToolParam 
 * @author Taoyy
 * @date 2014-10-31 下午03:09:41
 */
public class AbnormalToolParam {
	//工具盘ID
	private String toolShelfID;
	//工具盘位置id
	private String toolShelfPlaceNumber;
	//处理原因
	private String toolState;
	//刀具入库编码
	private String knifeInventoryCode;
	public String getToolShelfID() {
		return toolShelfID;
	}
	public void setToolShelfID(String toolShelfID) {
		this.toolShelfID = toolShelfID;
	}
	public String getToolShelfPlaceNumber() {
		return toolShelfPlaceNumber;
	}
	public void setToolShelfPlaceNumber(String toolShelfPlaceNumber) {
		this.toolShelfPlaceNumber = toolShelfPlaceNumber;
	}
	public String getToolState() {
		return toolState;
	}
	public void setToolState(String toolState) {
		this.toolState = toolState;
	}
	public String getKnifeInventoryCode() {
		return knifeInventoryCode;
	}
	public void setKnifeInventoryCode(String knifeInventoryCode) {
		this.knifeInventoryCode = knifeInventoryCode;
	}
	
	
}

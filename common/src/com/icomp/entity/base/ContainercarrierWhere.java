/*
 * 工具自动生成：容器表条件实体类
 * 生成时间    : 2016/03/11 13:10:44
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;

import java.math.BigDecimal;


/**
 * 容器表条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/11 13:10:44
 * 创建者  ：工具自动生成
 * 
 */
public class ContainercarrierWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 容器ID	*/ 
	private String containerCarrierIDWhere;

	/**
	 * 容器ID取得
	 * @return containerCarrierIDWhere
	 */
	public String getContainerCarrierIDWhere () {
		return containerCarrierIDWhere;
	}

	/**
	 * 容器ID设定
	 * @param containerCarrierIDWhere
	 */
	public void setContainerCarrierIDWhere (String containerCarrierIDWhere) {
		this.containerCarrierIDWhere = containerCarrierIDWhere;
	}

	/* 容器编码	*/ 
	private String containerCarrierCodeWhere;

	/**
	 * 容器编码取得
	 * @return containerCarrierCodeWhere
	 */
	public String getContainerCarrierCodeWhere () {
		return containerCarrierCodeWhere;
	}

	/**
	 * 容器编码设定
	 * @param containerCarrierCodeWhere
	 */
	public void setContainerCarrierCodeWhere (String containerCarrierCodeWhere) {
		this.containerCarrierCodeWhere = containerCarrierCodeWhere;
	}

	/* 容器名称	*/ 
	private String containerCarrierNameWhere;

	/**
	 * 容器名称取得
	 * @return containerCarrierNameWhere
	 */
	public String getContainerCarrierNameWhere () {
		return containerCarrierNameWhere;
	}

	/**
	 * 容器名称设定
	 * @param containerCarrierNameWhere
	 */
	public void setContainerCarrierNameWhere (String containerCarrierNameWhere) {
		this.containerCarrierNameWhere = containerCarrierNameWhere;
	}

	/* 容器类别（0.一次性报废 2.待分拣容器 3.厂内待刃磨 4.厂外待刃磨 5.刃磨完毕 6.刃磨报废 7.待涂层 8.库房报废 9.其他）	*/ 
	private String containerCarrierTypeWhere;

	/**
	 * 容器类别（0.一次性报废 2.待分拣容器 3.厂内待刃磨 4.厂外待刃磨 5.刃磨完毕 6.刃磨报废 7.待涂层 8.库房报废 9.其他）取得
	 * @return containerCarrierTypeWhere
	 */
	public String getContainerCarrierTypeWhere () {
		return containerCarrierTypeWhere;
	}

	/**
	 * 容器类别（0.一次性报废 2.待分拣容器 3.厂内待刃磨 4.厂外待刃磨 5.刃磨完毕 6.刃磨报废 7.待涂层 8.库房报废 9.其他）设定
	 * @param containerCarrierTypeWhere
	 */
	public void setContainerCarrierTypeWhere (String containerCarrierTypeWhere) {
		this.containerCarrierTypeWhere = containerCarrierTypeWhere;
	}

	/* rfid载体ID	*/ 
	private BigDecimal rfidContainerIDWhere;

	/**
	 * rfid载体ID取得
	 * @return rfidContainerIDWhere
	 */
	public BigDecimal getRfidContainerIDWhere () {
		return rfidContainerIDWhere;
	}

	/**
	 * rfid载体ID设定
	 * @param rfidContainerIDWhere
	 */
	public void setRfidContainerIDWhere (BigDecimal rfidContainerIDWhere) {
		this.rfidContainerIDWhere = rfidContainerIDWhere;
	}

	/* 负责人	*/ 
	private String personWhere;

	/**
	 * 负责人取得
	 * @return personWhere
	 */
	public String getPersonWhere () {
		return personWhere;
	}

	/**
	 * 负责人设定
	 * @param personWhere
	 */
	public void setPersonWhere (String personWhere) {
		this.personWhere = personWhere;
	}

	/* 备注	*/ 
	private String noteWhere;

	/**
	 * 备注取得
	 * @return noteWhere
	 */
	public String getNoteWhere () {
		return noteWhere;
	}

	/**
	 * 备注设定
	 * @param noteWhere
	 */
	public void setNoteWhere (String noteWhere) {
		this.noteWhere = noteWhere;
	}
}


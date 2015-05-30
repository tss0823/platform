package com.usefullc.platform.remote.freight.dto;

	import com.usefullc.platform.domain.BaseDomain;

/**
	 * 站点信息表
	 * @author tangss
	 *
	 * @2014-05-06 18
	 */
	public class BasicStationDto extends BaseDomain {
		
		private static final long serialVersionUID = 1L;
		
		/**  ID * */
		private java.lang.Long id;
			
		/**  站点名称 * */
		private java.lang.String stationName;
			
		/**  站点编码 * */
		private java.lang.String stationCode;
			
		/**  站点类型 * */
		private java.lang.String stationType;
			
		/**  详细地址 * */
		private java.lang.String address;
			
		/**  管理机构 * */
		private java.lang.Long manageAgencyId;
		
		private java.lang.String manageAgencyName;
		
		/**  删除状态（0：已删除；1：未删除） * */
		private java.lang.Boolean delState;
			
		/**  创建部门 * */
		private java.lang.Long createDeptId;
			
		/**  创建人 * */
		private java.lang.Long createUserId;
			
		/**  创建机构 * */
		private java.lang.Long createAgencyId;
			
		/**  创建时间 * */
		private java.util.Date gmtCreate;
			
		/**  修改时间 * */
		private java.util.Date gmtModify;
			
		
		public BasicStationDto(){
		}

		public void setId(java.lang.Long value) {
			this.id = value;
		}
		
		public java.lang.Long getId() {
			return this.id;
		}
		public void setStationName(java.lang.String value) {
			this.stationName = value;
		}
		
		public java.lang.String getStationName() {
			return this.stationName;
		}
		public void setStationCode(java.lang.String value) {
			this.stationCode = value;
		}
		
		public java.lang.String getStationCode() {
			return this.stationCode;
		}
		public void setStationType(java.lang.String value) {
			this.stationType = value;
		}
		
		public java.lang.String getStationType() {
			return this.stationType;
		}
		public void setAddress(java.lang.String value) {
			this.address = value;
		}
		
		public java.lang.String getAddress() {
			return this.address;
		}
		public void setManageAgencyId(java.lang.Long value) {
			this.manageAgencyId = value;
		}
		
		public java.lang.Long getManageAgencyId() {
			return this.manageAgencyId;
		}
		public void setDelState(java.lang.Boolean value) {
			this.delState = value;
		}
		
		public java.lang.Boolean getDelState() {
			return this.delState;
		}
		public void setCreateDeptId(java.lang.Long value) {
			this.createDeptId = value;
		}
		
		public java.lang.Long getCreateDeptId() {
			return this.createDeptId;
		}
		public void setCreateUserId(java.lang.Long value) {
			this.createUserId = value;
		}
		
		public java.lang.Long getCreateUserId() {
			return this.createUserId;
		}
		public void setCreateAgencyId(java.lang.Long value) {
			this.createAgencyId = value;
		}
		
		public java.lang.Long getCreateAgencyId() {
			return this.createAgencyId;
		}
		public void setGmtCreate(java.util.Date value) {
			this.gmtCreate = value;
		}
		
		public java.util.Date getGmtCreate() {
			return this.gmtCreate;
		}
		public void setGmtModify(java.util.Date value) {
			this.gmtModify = value;
		}
		
		public java.util.Date getGmtModify() {
			return this.gmtModify;
		}

		public java.lang.String getManageAgencyName() {
			return manageAgencyName;
		}

		public void setManageAgencyName(java.lang.String manageAgencyName) {
			this.manageAgencyName = manageAgencyName;
		}
		



	}


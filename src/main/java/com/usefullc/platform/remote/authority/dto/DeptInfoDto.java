package com.usefullc.platform.remote.authority.dto;

	import com.usefullc.platform.domain.BaseDomain;

	/**
	 * 部门
	 * @author admin
	 *
	 * @2014-05-06 18
	 */
	public class DeptInfoDto extends BaseDomain {
		
		private static final long serialVersionUID = 1L;
		
		/**  ID * */
		private java.lang.Long id;
			
		/**  创建时间 * */
		private java.util.Date gmtCreate;
			
		/**  修改时间 * */
		private java.util.Date gmtModify;
			
		/**  删除状态（0：已删除；1：未删除） * */
		private java.lang.Boolean delState;
			
		/**  部门名称 * */
		private java.lang.String deptName;
			
		/**  部门简称 * */
		private java.lang.String easyName;
			
		/**  上级部门 * */
		private java.lang.Long parentId;
		
		/**  上级部门名称 **/
		private java.lang.String parentName;
			
		/**  部门类型 * */
		private java.lang.String deptType;
			
		/**  办公电话 * */
		private java.lang.String phone;
			
		/**  传真 * */
		private java.lang.String fax;
			
		/**  删除人 * */
		private java.lang.Long delUserId;
		
		/** 排序  **/
		private java.lang.Integer orderby;
			
		
		public DeptInfoDto(){
		}

		public void setId(java.lang.Long value) {
			this.id = value;
		}
		
		public java.lang.Long getId() {
			return this.id;
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
		public void setDelState(java.lang.Boolean value) {
			this.delState = value;
		}
		
		public java.lang.Boolean getDelState() {
			return this.delState;
		}
		public void setDeptName(java.lang.String value) {
			this.deptName = value;
		}
		
		public java.lang.String getDeptName() {
			return this.deptName;
		}
		public void setEasyName(java.lang.String value) {
			this.easyName = value;
		}
		
		public java.lang.String getEasyName() {
			return this.easyName;
		}
		public void setParentId(java.lang.Long value) {
			this.parentId = value;
		}
		
		public java.lang.Long getParentId() {
			return this.parentId;
		}		
		
		public java.lang.String getParentName() {
			return parentName;
		}

		public void setParentName(java.lang.String parentName) {
			this.parentName = parentName;
		}

		public void setDeptType(java.lang.String value) {
			this.deptType = value;
		}
		
		public java.lang.String getDeptType() {
			return this.deptType;
		}
		public void setPhone(java.lang.String value) {
			this.phone = value;
		}
		
		public java.lang.String getPhone() {
			return this.phone;
		}
		public void setFax(java.lang.String value) {
			this.fax = value;
		}
		
		public java.lang.String getFax() {
			return this.fax;
		}
		public void setDelUserId(java.lang.Long value) {
			this.delUserId = value;
		}
		
		public java.lang.Long getDelUserId() {
			return this.delUserId;
		}

		public java.lang.Integer getOrderby() {
			return orderby;
		}

		public void setOrderby(java.lang.Integer orderby) {
			this.orderby = orderby;
		}
		



	}


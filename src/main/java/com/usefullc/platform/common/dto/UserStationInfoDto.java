package com.usefullc.platform.common.dto;

	import com.usefullc.platform.domain.BaseDomain;

	/**
	 * 站点权限
	 * @author admin
	 *
	 * @2014-05-16 14
	 */
	public class UserStationInfoDto extends BaseDomain {
		
		private static final long serialVersionUID = 1L;
		
		/**  ID * */
		private java.lang.Long id;
			
		/**  用户ID * */
		private java.lang.Long userId;
			
		/**  站点ID * */
		private java.lang.Long stationId;
		
		private java.lang.String stationName;
		
		private java.lang.Long manageAgencyId;
			
		
		public UserStationInfoDto(){
		}

		public void setId(java.lang.Long value) {
			this.id = value;
		}
		
		public java.lang.Long getId() {
			return this.id;
		}
		public void setUserId(java.lang.Long value) {
			this.userId = value;
		}
		
		public java.lang.Long getUserId() {
			return this.userId;
		}
		public void setStationId(java.lang.Long value) {
			this.stationId = value;
		}
		
		public java.lang.Long getStationId() {
			return this.stationId;
		}

		public java.lang.String getStationName() {
			return stationName;
		}

		public void setStationName(java.lang.String stationName) {
			this.stationName = stationName;
		}

		public java.lang.Long getManageAgencyId() {
			return manageAgencyId;
		}

		public void setManageAgencyId(java.lang.Long manageAgencyId) {
			this.manageAgencyId = manageAgencyId;
		}
		



	}



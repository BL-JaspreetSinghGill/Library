package com.bridgelabz.cclibrary.enums;

import com.bridgelabz.cclibrary.dto.UserDetails;

public enum Stage {

	OTP_VERIFICATION_PENDING {
		@Override
		public StageTemplateType getTemplateType() {
			return StageTemplateType.TEMPLATE_1;
		}

		@Override
		public String getUrl(UserDetails userDetails, String basicUrl) {
			String url = basicUrl + "&token=" + userDetails.getToken() + "&campaignId=" + userDetails.getCampaignId() 
			+ "&type="+ userDetails.getType();
			return url;
		}
	},
	
	START_TEST_PENDING {
		@Override
		public StageTemplateType getTemplateType() {
			return StageTemplateType.TEMPLATE_2;
		}

		@Override
		public String getUrl(UserDetails userDetails, String basicUrl) {
			String url = basicUrl + "&campaignId=" + userDetails.getCampaignId() + "&userId=" + userDetails.getUserId()
					+ "&username=" + userDetails.getName().replace(" ", "%20") 
					+"&currentPinCode="+userDetails.getCurrentPinCode()+ "&token=" + userDetails.getToken() 
					+ "&type=" + userDetails.getType();
			return url;
		}
	},
	
	END_TEST_PENDING{
		@Override
		public StageTemplateType getTemplateType() {
			return StageTemplateType.TEMPLATE_3;
		}

		@Override
		public String getUrl(UserDetails userDetails, String basicUrl) {
			String url = basicUrl + "&token=" + userDetails.getToken() + "&campaignId=" + userDetails.getCampaignId() 
			+ "&type="+userDetails.getType();
			return url;
		}
	},
	
	ADDTIONAL_INFORMATION_PENDING {
		@Override
		public StageTemplateType getTemplateType() {
			return StageTemplateType.TEMPLATE_4;
		}

		@Override
		public String getUrl(UserDetails userDetails, String basicUrl) {
			String url = basicUrl + "&campaignId=" + userDetails.getCampaignId() + "&userId=" + userDetails.getUserId()
					+ "&username=" + userDetails.getName().replace(" ", "%20") 
					+"&currentPinCode="+userDetails.getCurrentPinCode()+ "&token=" + userDetails.getToken()
					+"&type="+userDetails.getType();
			return url;
		}
	},
	
	 RETRY_TEST_PENDING {
		@Override
		public StageTemplateType getTemplateType() {
			return StageTemplateType.TEMPLATE_5;
		}

		@Override
		public String getUrl(UserDetails userDetails, String basicUrl) {
			String url = basicUrl + "&token=" + userDetails.getToken() + "&campaignId=" + userDetails.getCampaignId() 
			+ "&type="+userDetails.getType();
			return url;
		}
	};
	 
	/*
	 * CERTIFICATION_PENDING {
	 * 
	 * @Override public StageTemplateType getTemplateType() { return
	 * StageTemplateType.TEMPLATE_6; } };
	 */

	public abstract StageTemplateType getTemplateType();
	
	public abstract String getUrl(UserDetails userDetails, String basicUrl); 

}

package com.bridgelabz.cclibrary.enums;

public enum StageTemplateType {

	TEMPLATE_1 {

		@Override
		public SubTemplateType getSubTemplateType(int count) {
			switch (count) {
			case 0:
				return SubTemplateType.TEMPLATE_11;
				
			case 1:
				return SubTemplateType.TEMPLATE_12;
				
			case 2: 
				return SubTemplateType.TEMPLATE_13;
			
			default :
				return null;
			}
		}

	},
	TEMPLATE_2{
		
		@Override
		public SubTemplateType getSubTemplateType(int count) {
			switch (count) {
			case 0:
				return SubTemplateType.TEMPLATE_21;
				
			case 1:
				return SubTemplateType.TEMPLATE_22;
				
			case 2: 
				return SubTemplateType.TEMPLATE_23;
			
			default :
				return null;
			}
		}
		
	}, TEMPLATE_3 {
		
		@Override
		public SubTemplateType getSubTemplateType(int count) {
			switch (count) {
			case 0:
				return SubTemplateType.TEMPLATE_31;
				
			case 1:
				return SubTemplateType.TEMPLATE_32;
				
			case 2: 
				return SubTemplateType.TEMPLATE_33;
				
			default :
				return null;
			}
		}
	}, TEMPLATE_4{
		
		@Override
		public SubTemplateType getSubTemplateType(int count) {
			switch (count) {
			case 0:
				return SubTemplateType.TEMPLATE_41;
				
			case 1:
				return SubTemplateType.TEMPLATE_42;
				
			case 2: 
				return SubTemplateType.TEMPLATE_43;
				
			default :
				return null;
			}
		}
	}, TEMPLATE_5{
		
		@Override
		public SubTemplateType getSubTemplateType(int count) {
			switch (count) {
			case 0:
				return SubTemplateType.TEMPLATE_51;
				
			case 1:
				return SubTemplateType.TEMPLATE_52;
				
			case 2: 
				return SubTemplateType.TEMPLATE_53;
				
			default :
				return null;
			}
		}
	};
//	, TEMPLATE_6{
//		
//		@Override
//		public SubTemplateType getSubTemplateType(int count) {
//			switch (count) {
//			case 0:
//				return SubTemplateType.TEMPLATE_61;
//				
//			case 1:
//				return SubTemplateType.TEMPLATE_62;
//				
//			case 2: 
//				return SubTemplateType.TEMPLATE_63;
//				
//			default :
//				return null;
//			}
//		}
//	};

	public abstract SubTemplateType getSubTemplateType(int count);
}


enum SubTemplateType {

	TEMPLATE_11, TEMPLATE_12, TEMPLATE_13, 
	TEMPLATE_21, TEMPLATE_22, TEMPLATE_23, 
	TEMPLATE_31, TEMPLATE_32, TEMPLATE_33, 
	TEMPLATE_41, TEMPLATE_42, TEMPLATE_43,
	TEMPLATE_51, TEMPLATE_52, TEMPLATE_53,
	TEMPLATE_61, TEMPLATE_62, TEMPLATE_63;
}

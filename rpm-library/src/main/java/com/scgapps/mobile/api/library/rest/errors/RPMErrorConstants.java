package com.scgapps.mobile.api.library.rest.errors;

public class RPMErrorConstants {
        private RPMErrorConstants() { }
        private static String commonError = "Something went wrong. Please try again later.";
        public static final ErrorInfo commonErrorMsg = new ErrorInfo("B003",commonError);
        public static final ErrorInfo feignClientErrorMsg = new ErrorInfo("F001",commonError);
}

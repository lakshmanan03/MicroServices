package com.scgapps.mobile.api.accounts.web.rest.errors;

import com.scgapps.mobile.api.library.rest.errors.ErrorInfo;

public class ErrorConstants {
        private ErrorConstants() { }
        public static final ErrorInfo accountNotFoundError = new ErrorInfo("A001", "Account Summary Information Not found.");
        public static final  ErrorInfo contactNotFoundError = new ErrorInfo("C001", "Contact Summary Information Not found.");
        public static final ErrorInfo addressNotFoundError = new ErrorInfo("AD001", "Address Not Found");
        public static final ErrorInfo notesContactMissingError = new ErrorInfo("N001","ContactIds required.");
}

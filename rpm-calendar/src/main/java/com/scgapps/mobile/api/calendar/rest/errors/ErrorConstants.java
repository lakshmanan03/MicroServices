package com.scgapps.mobile.api.calendar.rest.errors;

import com.scgapps.mobile.api.library.rest.errors.ErrorInfo;

public class ErrorConstants {
        private ErrorConstants() { }
        public static final ErrorInfo taskNotFoundError = new ErrorInfo("T001", "Task  Information Not found.");
        public static final ErrorInfo noCalendarEvents = new ErrorInfo("C001", "No Calendar Events Available for the given Date Range");
}

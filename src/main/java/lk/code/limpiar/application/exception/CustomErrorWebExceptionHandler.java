//package com.example.jumble.application.exception;
//
//import org.springframework.beans.factory.annotation.Value;
//
//import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
//import org.springframework.boot.web.reactive.error.ErrorAttributes;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.function.*;
//
//import java.util.Map;
//
//@Component
//@Order(-2)
//public class CustomErrorWebExceptionHandler extends DefaultErrorWebExceptionHandler {
//
//// get value from environment properties
//@Value("${debug:false}")
//private boolean isDebug;
//
//@Override
//protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
//	return super.getRoutingFunction(errorAttributes);
//}
//
///**
// * Render the error response
// *
// * @param request request
// * @return repose
// */
//private Object<ServerResponse> renderErrorResponse(final ServerRequest request) {
//
//	// show stack trace when running in debug mode
//	final Map<String, Object> errorPropertiesMap = (request, isDebug);
//
//	return ServerResponse.status(this.getStatusByError(getError(request)))
//			       .contentType(MediaType.APPLICATION_JSON_UTF8)
//			       .body(BodyInserters.fromObject(errorPropertiesMap));
//}
//
///**
// * Get HTTP response code by error type
// *
// * @param error error
// * @return HTTP response code
// */
//private HttpStatus getStatusByError(Throwable error) {
//
//	switch (error.getClass().getSimpleName()) {
//		case "ValidationException":
//			return HttpStatus.UNPROCESSABLE_ENTITY;
//		case "FilterException":
//		case "DomainException":
//		case "WebClientException":
//			return HttpStatus.BAD_REQUEST;
//		default:
//			return HttpStatus.INTERNAL_SERVER_ERROR;
//	}
//}
//}
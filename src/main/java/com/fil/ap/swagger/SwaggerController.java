package com.fil.ap.swagger;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fil.ap.rabbitmq.pojo.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(value = "/ee/memberaccountscheme", 
	description = "gets some data from a servlet", 
	consumes="application/json")
@RestController
@RequestMapping(value = "/ee/memberaccountscheme")
public class SwaggerController {

	@ApiOperation(value = "Get notification history", response = User.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 600, message = "Invalid ID supplied"),
	      	@ApiResponse(code = 604, message = "Pet not found") 
	    })
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "APP_ID", value = "app id", required = true, dataType = "string", paramType = "header"),
	    @ApiImplicitParam(name = "HKID_PP_NO", value = "hkid", required = false, dataType = "string", paramType = "query")
	  })
	@RequestMapping(value = "/notificationhistory", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(
			
		@RequestHeader(required = false, value = "APP_ID") String appId,
		
		@RequestParam(required = true, value = "HKID_PP_NO") String hkid
	) {
		
		return null;
	}
}

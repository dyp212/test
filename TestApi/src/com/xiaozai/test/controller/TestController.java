package com.xiaozai.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.xiaozai.test.controller.param.User;

@Api(hidden=false, value = "a1", description="蝇在")
@Controller
@RequestMapping(value="/a/sys", method = RequestMethod.GET)
public class TestController {

	@RequestMapping(
			value = "queryUserById", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public void queryUserById( @RequestParam String userId, HttpServletResponse response){
		System.out.println("request param:"+userId);
		String responseStr = "/queryUserById response: 测试成功！" ;
		writeObject(responseStr, response);
	}
	
	@RequestMapping(value = "updateStudent", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ApiOperation(value = "修改学生信息", httpMethod = "POST", notes = "学生信息以json格式传递", response = String.class)
	public  void updateStudent(@ApiParam(required = true) @RequestParam String postData, HttpServletResponse response)
	{
		System.out.println("request /updateStudent param: "+ postData);
		String responseStr = "/updateStudent response: 测试成功！" ;
		writeObject(responseStr, response);
	}
	
	@RequestMapping(value="testParamObj", method=RequestMethod.POST)
	@ResponseBody
	public String testParamObj(@RequestBody User user, HttpServletResponse response){
		String responseStr = "/updateStudent response: 测试成功！" ;
		System.out.println("request param :"+user.getUserId());
//		writeObject(responseStr, response);
		return responseStr;
	}
	
	private void writeObject(Object obj, HttpServletResponse response){
		String jsonString = JSON.toJSONString(obj);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(jsonString);
			out.flush();
		} catch (IOException e) {
		}finally{
			if(out != null){
				out.close();
			}
		}
	}
}

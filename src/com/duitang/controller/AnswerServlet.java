package com.duitang.controller;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Product of Array Except Self
 * @author zhangzhiyong
 * 16/6/22
 */
@WebServlet("/answer/")
public class AnswerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String inputString = request.getParameter("I");//获取输入参数
		String outputString;//输出字符串
		
		if(inputString != null && !"".equals(inputString)){//对输入参数进行初步校验
			String[] inputArr = inputString.split(",");//按逗号分隔
			int[] outputArr = productExceptSelf(stringArrToIntArr(inputArr));//计算
			outputString = intArrToString(outputArr);//toString
		}else{
			outputString = "please give legal param";
		}
		
		//设置编码，输出
		response.setContentType("application/json;charset=UTF-8");
		Writer writer = response.getWriter();
		writer.write(outputString);
		writer.flush();
		writer.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	
	/**
	 * 根据指定int数组返回一个新的数组，该数组每个元素为数组其他元素乘积。
	 * @param nums 指定int数组
	 * @return 计算后的数组
	 */
    public int[] productExceptSelf(int[] nums) {
        int output[] = new int[nums.length];
        int left = 1;//从左到右累乘的开始数
        int right = 1;//从右到左累乘的开始数
        //从左到右累乘，数组每个元素存放的值为它左边的所有数的累乘值。（由于第一个的左边和最后一个元素的右边没有元素，所以让其乘1，即left和right）
        for(int i = 0;i < nums.length;i++){
            output[i] = left;
            left = left * nums[i];
        }
        //同理，从右到左让数组的每一个元素累乘它右边的元素。
        for(int j = nums.length - 1;j >= 0;j--){
            output[j] = output[j] * right;
            right = right * nums[j];
        }
        return output;
    }
    
    /**
     * String数组转为Int数组
     * @param stringArr String数组
     * @return 转化后的Int数组
     */
    public int[] stringArrToIntArr(String[] stringArr){
    	int[] intArr = new int[stringArr.length];
    	for(int i = 0;i < stringArr.length;i++){  
    		intArr[i] = Integer.parseInt(stringArr[i]);
    	}
    	return intArr;
    }
    
    /**
     * 将一个int数组转为一个字符串，每个元素用逗号分隔。
     * @param intArr
     * @return
     */
    public String intArrToString(int[] intArr){
	StringBuffer sb = new StringBuffer();
	for(int i = 0;i < intArr.length;i++){  
		if(i != intArr.length - 1)
			sb.append(String.valueOf(intArr[i] + ","));
		else
			sb.append(String.valueOf(intArr[i]));
	}
	return sb.toString();
    }
    
}


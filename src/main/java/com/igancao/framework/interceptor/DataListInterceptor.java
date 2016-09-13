package com.igancao.framework.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;

/**
 * 
 * @author 诃子
 *
 */
public class DataListInterceptor implements HandlerInterceptor {

	private static final int PAGE_ROWS = 15;

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3) {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) {
	}

	// 数据列表分页处理
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) {
		// 当前页数
		String page = arg0.getParameter("page");
		PageHelper.startPage(
				Integer.parseInt(StringUtils.isNotEmpty(page) ? page : "1"),
				PAGE_ROWS);
		return true;
	}

}

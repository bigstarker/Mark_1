
package cn.w.factory;

import cn.w.service.IDeptService;
import cn.w.service.impl.DeptServiceImpl;

public class ServiceFactory {
	public static IDeptService getIDeptServiceInstance(){
		return new DeptServiceImpl();
	}
}

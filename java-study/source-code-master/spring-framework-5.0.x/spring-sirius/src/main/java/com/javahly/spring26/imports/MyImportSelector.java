package com.javahly.spring26.imports;

import com.javahly.spring26.dao.IndexDao;
import com.javahly.spring26.dao.UserDao;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/4
 * @QQ :1136513099
 * @desc :
 */
public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{IndexDao.class.getName(), UserDao.class.getName()};
	}
}

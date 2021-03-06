package com.dbkj.meet.model;

import com.dbkj.meet.model.base.BaseEmployee;
import com.dbkj.meet.utils.SqlUtil;
import com.jfinal.plugin.activerecord.Db;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Employee extends BaseEmployee<Employee> {
	public static final Employee dao = new Employee();

	public int deleteByCompanyId(long id){
		return Db.update(SqlUtil.getSql("deleteByCompanyId",this),id);
	}

	public int deleteByDepartmentId(long id){
		return Db.update(SqlUtil.getSql("deleteByDepartmentId",this),id);
	}

	public int deleteBatchByUserId(int[] ids){
		if(ids!=null&&ids.length>0){
			StringBuilder sb=new StringBuilder(20);
			sb.append(" (");
			for(int i=0;i<ids.length;i++){
				sb.append(ids[i]);
				if(i!=ids.length-1){
					sb.append(",");
				}
			}
			sb.append("))");
			int count = Db.update(SqlUtil.getSql("deleteBatchByUserId",this)+sb.toString());
			return count;
		}
		return 0;
	}
}

package com.rds.platform.web.common;

import java.util.ArrayList;
import java.util.List;

import com.rds.platform.model.common.RdsPlatformTreeNodeModel;

public class TreeNodeUtils {
	
	/**
	 * 列表转树形
	 * 
	 * @param menuList
	 * @return
	 */
	public static List<RdsPlatformTreeNodeModel> getTreeNodes(List<RdsPlatformTreeNodeModel> menuList){
		List<RdsPlatformTreeNodeModel> nodeList = new ArrayList<RdsPlatformTreeNodeModel>();  
		for(RdsPlatformTreeNodeModel node1 : menuList){  
		    boolean mark = false;  
		    for(RdsPlatformTreeNodeModel node2 : menuList){  
		        if(node1.getParentid()!=null && node1.getParentid().equals(node2.getId())){  
		            mark = true;  
		            if(node2.getChildren() == null)  
		                node2.setChildren(new ArrayList<RdsPlatformTreeNodeModel>());  
		            node2.getChildren().add(node1);   
		            break;  
		        }  
		    }  
		    if(!mark){  
		        nodeList.add(node1);   
		    }  
		}
		return nodeList;
	}

}

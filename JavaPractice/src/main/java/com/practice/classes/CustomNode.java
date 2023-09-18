package com.practice.classes;

import java.util.ArrayList;
import java.util.List;

public class CustomNode {
	 String name;
	 public CustomNode Parent;
	    List<CustomNode> children;

	    public CustomNode(String name, CustomNode parent) {
	        this.name = name;
	        this.Parent = parent;
	        this.children = new ArrayList<>();
	        if(Parent!=null)
	             this.children.add(this);
	    }
}

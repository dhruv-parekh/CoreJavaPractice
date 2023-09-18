package com.practice.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B  extends A{


    public static String getShortestUniqueQualifier(CustomNode root) {
        if (root == null) {
            return null;
        }
        
        Queue<CustomNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            CustomNode current = queue.poll();

            if (isUnique(root, current)) {
                return current.name;
            }

            queue.addAll(current.children);
        }

        return null;
    }

    private static boolean isUnique(CustomNode root, CustomNode target) {
        return countOccurrences(root, target.name) == 1;
    }

    private static int countOccurrences(CustomNode node, String targetName) {
        if (node == null) {
            return 0;
        }

        int count = node.name.equals(targetName) ? 1 : 0;

        for (CustomNode child : node.children) {
            count += countOccurrences(child, targetName);
        }

        return count;
    }
	
	
	public static void main(String[] args) {
		 CustomNode root = new CustomNode("Root", null);
		    CustomNode userData = new CustomNode("UserData", root);
		    CustomNode ud_browser = new CustomNode("Browser", userData);
		    CustomNode ud_word = new CustomNode("Word", userData);
		    CustomNode priv = new CustomNode("Private", userData);
		    CustomNode priv_word = new CustomNode("Word", priv);
		    
		    CustomNode windows = new CustomNode("Windows", root);
		    CustomNode programs = new CustomNode("Programs", root);
		    CustomNode notepad = new CustomNode("Notepad", programs);
		    CustomNode prog_word = new CustomNode("Word", programs);
		    CustomNode prog_browser = new CustomNode("Browser", programs);

	        root.children.add(programs);
	        programs.children.add(notepad);

	        String shortestQualifier = getShortestUniqueQualifier(notepad);
	        System.out.println("Shortest unique qualifier: " + shortestQualifier); // Should print "Notepad"
	    }
	}
	


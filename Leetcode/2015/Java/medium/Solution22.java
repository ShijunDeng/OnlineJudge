package com.whitedew.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution22 {
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	public class Solution {
		public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        if (node==null){
	            return null;
	        }
	        HashMap<Integer, UndirectedGraphNode> checker=new HashMap<Integer, UndirectedGraphNode>();
	        return clone(node, checker);
	    }
	    
		private UndirectedGraphNode clone(UndirectedGraphNode node,
				HashMap<Integer, UndirectedGraphNode> checker) {
			if (checker.containsKey(node.label)) {
				return checker.get(node.label);
			}

			UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
			checker.put(newNode.label, newNode);

			for (UndirectedGraphNode tempNode : node.neighbors) {

				newNode.neighbors.add(clone(tempNode, checker));
			}

			return newNode;
		}
	}
}

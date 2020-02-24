package com.akadatsky.tags;

import com.akadatsky.entities.TreeNode;

import java.util.*;

public class Tree {

    public List<List<TreeNode>> bfsTraversal1(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<TreeNode>> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    private void dfs(TreeNode root, int level, List<List<TreeNode>> list) {
        if (root == null) {
            return;
        }
        if (level >= list.size()) {
            List<TreeNode> subList = new ArrayList<>();
            subList.add(root);
            list.add(subList);
        } else {
            list.get(level).add(root);
        }
        dfs(root.left, level + 1, list);
        dfs(root.right, level + 1, list);
    }

    public List<TreeNode> bfsTraversal2(TreeNode root) {
        if (root == null) {
            return null;
        }
        return bfs(root);
    }

    private List<TreeNode> bfs(TreeNode root) {
        int curNum = 1;
        int nextNum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node);
            curNum--;
            if (node.left != null) {
                queue.add(node.left);
                nextNum++;
            }

            if (node.right != null) {
                queue.add(node.right);
                nextNum++;
            }

            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
            }
        }
        return res;
    }

    public List<TreeNode> Bfs_tree(TreeNode root){
        Queue<TreeNode> myq = new LinkedList<>();
        List<TreeNode> res = new ArrayList<>();
        if(root==null) return null;
        myq.add(root);
        while(!myq.isEmpty()){
            int len = myq.size();
            for(int i=0;i<len;i++){
                if(myq.peek().left!=null) myq.add(myq.peek().left);
                if(myq.peek().right!=null) myq.add(myq.peek().right);
                res.add(myq.poll());
            }
        }
        return res;
    }

    // DFS
    List<TreeNode> mRes = new ArrayList<>();

    public List<TreeNode> dfsTraversal(TreeNode root) {
        dfs(root);
        return mRes;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            //preOrder
            mRes.add(root);
            dfs(root.left);
            dfs(root.right);
        }
    }

    private List<TreeNode> traversal(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            res.add(node);
            stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author Steven
 * @version 2011.11.28
 */
public class MyBinarySearchTree extends MyBinaryTree {
    
    public MyBinarySearchTree()
    {
        root=null;
    }
    
    public void insert(Object newItem)
    {
        root=insertHelper(root,new MyBinaryTreeNode(newItem));
    }
    
    private MyBinaryTreeNode insertHelper(MyBinaryTreeNode rt, MyBinaryTreeNode newNode)
    {
        if(rt==null){
            rt=newNode;
            return rt;
        }
        if(newNode.compareTo(rt)<0){
            rt.left=insertHelper(rt.left,newNode);
        }
        else{
            rt.right=insertHelper(rt.right,newNode);
        }
        return rt;
    }
    
    public Object max()
    {
        if(root==null)return null;
        return maxHelper(root).data;
    }
    
    private MyBinaryTreeNode maxHelper(MyBinaryTreeNode rt)
    {
        return(rt.right==null)?rt:maxHelper(rt.right);
    }
    
    public Object min()
    {
        if(root==null)return null;
        return minHelper(root).data;
    }
    
    private MyBinaryTreeNode minHelper(MyBinaryTreeNode rt)
    {
        return(rt.left==null)?rt:minHelper(rt.left);
    }
    
    public MyBinaryTreeNode find(Object target)
    {
        return findHelper(root, new MyBinaryTreeNode(target));
    }
    
    private MyBinaryTreeNode findHelper(MyBinaryTreeNode rt, MyBinaryTreeNode target)
    {
        if(rt==null)return null;
        if(target.compareTo(rt)<0)
            return findHelper(rt.left,target);
        if(target.compareTo(rt)>0)
            return findHelper(rt.right, target);
        return rt;
    }
    
    private MyBinaryTreeNode findParent(MyBinaryTreeNode rt, MyBinaryTreeNode targetNode)
    {
        if(targetNode.compareTo(rt)<0){
            if(rt.left==null)return null;
            else if(targetNode.compareTo(rt.left)==0){
                return rt;
            }
            else{
                return findParent(rt.left,targetNode);
            }
        }
        else{
            if(rt.right==null){
                return null;
            }
            else if(targetNode.compareTo(rt.right)==0){
                return rt;
            }
            else{
                return findParent(rt.right, targetNode);
            }
        }
    }
    
    private MyBinaryTreeNode successorParent(MyBinaryTreeNode rt)
    {
        if(rt==null)
            return null;
        if(rt.right==null)
            return null;
        if(rt.right.left==null)
            return rt;
        MyBinaryTreeNode temp=rt.right;
        while(temp.left.left!=null){
            temp=temp.left;
        }
        return temp;
    }
    
    public void remove(Object target)
    {
        if(root==null)return;
        MyBinaryTreeNode targetNode = new MyBinaryTreeNode(target);
        if(root.compareTo(targetNode)==0){
            MyBinaryTreeNode sp1 = successorParent(root);
            if(sp1==null && root != null){
                root=root.left;
            }
            else if(sp1==root){
                sp1.right.left=root.left;
                root=root.right;
            }
            else{
                MyBinaryTreeNode rightChildOfSucc = sp1.left.right;
                sp1.left.left=root.left;
                sp1.left.right=root.right;
                root=sp1.left;
                sp1.left=rightChildOfSucc;
            }
            return;
        }
        MyBinaryTreeNode targetParent= findParent(root,targetNode);
        if(targetParent==null)return;
        if(targetParent.left!=null){
            if(targetParent.left.compareTo(targetNode)==0){
                MyBinaryTreeNode rNode = targetParent.left;
                MyBinaryTreeNode sp2 = successorParent(rNode);
                if(rNode.left==null&&rNode.right==null){
                    targetParent.left=null;
                }
                else if(sp2==null && rNode!=null){
                    targetParent.left=targetParent.left.left;
                }
                else if(sp2==rNode){
                    sp2.right.left=rNode.left;
                    targetParent.left=sp2.right;
                }
                else{
                    MyBinaryTreeNode rightChildOfSucc=sp2.left.right;
                    sp2.left.left=rNode.left;
                    sp2.left.right=rNode.right;
                    targetParent.left=sp2.left;
                    sp2.left=rightChildOfSucc;
                }
            }
        }
        if(targetParent.right!=null){
            if(targetParent.right.compareTo(targetNode)==0){
                MyBinaryTreeNode rNode = targetParent.right;
                MyBinaryTreeNode sp3 = successorParent(rNode);
                if(rNode.left==null&&rNode.right==null){
                    targetParent.right=null;
                }
                else if(sp3==null && rNode!=null){
                    targetParent.right=rNode.left;
                }
                else if(sp3==rNode){
                    sp3.right.left=sp3.left;
                    targetParent.right=sp3.right;
                }
                else{
                    MyBinaryTreeNode rightChildOfSucc = sp3.left.right;
                    sp3.left.left=rNode.left;
                    sp3.left.right=rNode.right;
                    targetParent.right=sp3.left;
                    sp3.left=rightChildOfSucc;
                }
            }
        }
    }
}

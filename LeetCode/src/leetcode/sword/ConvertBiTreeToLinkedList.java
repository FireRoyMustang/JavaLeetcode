package leetcode.sword;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/3 9:04
 *@Version V1.0
 **/
public class ConvertBiTreeToLinkedList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        TreeNode tmpNode = null;
        if (pRootOfTree.left != null)
            tmpNode = Convert(pRootOfTree.left);
        if (pRootOfTree.right != null) {
            TreeNode tmp = Convert(pRootOfTree.right);
            pRootOfTree.right = tmp;
            tmp.left = pRootOfTree;
        }
        TreeNode head = tmpNode;
        if (tmpNode != null) {
            while (tmpNode.right != null) {
                tmpNode = tmpNode.right;
            }
            pRootOfTree.left = tmpNode;
            tmpNode.right = pRootOfTree;
            return head;
        } else
            return pRootOfTree;
    }

//    public TreeNode Convert(TreeNode pRootOfTree) {
//        if(pRootOfTree == null){
//            return null;
//        }
//        ArrayList<TreeNode> list = new ArrayList<>();
//        Convert(pRootOfTree, list);
//        return Convert(list);
//
//    }
//    //中序遍历，在list中按遍历顺序保存
//    public void Convert(TreeNode pRootOfTree, ArrayList<TreeNode> list){
//        if(pRootOfTree.left != null){
//            Convert(pRootOfTree.left, list);
//        }
//
//        list.add(pRootOfTree);
//
//        if(pRootOfTree.right != null){
//            Convert(pRootOfTree.right, list);
//        }
//    }
//    //遍历list，修改指针
//    public TreeNode Convert(ArrayList<TreeNode> list){
//        for(int i = 0; i < list.size() - 1; i++){
//            list.get(i).right = list.get(i + 1);
//            list.get(i + 1).left = list.get(i);
//        }
//        return list.get(0);
//    }
}

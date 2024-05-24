/* Creates a basic class for a Binary Search Tree*/


public class BinTree { //changed to char throughout code
  private TreeNode root;
  
 public BinTree() { root = null; }

 public BinTree(char charVal)
 {
   root = new TreeNode(charVal);
 }


/* Subclass for Nodes */


 public class TreeNode {
   private char value;
   private TreeNode left;
   private TreeNode right;

   public TreeNode(char initValue)
   {
     value = initValue;
     left = null;
     right = null;
   }


   public TreeNode(char initValue, TreeNode initLeft, TreeNode initRight)
   {
     value = initValue;
     left = initLeft;
     right = initRight;
   }


   public char getValue() { return value; }


   public TreeNode getLeft() { return left; }


   public TreeNode getRight() { return right; }


   public void setValue (char newVal) { value = newVal; }


   public void setLeft (TreeNode newLeft) { left = newLeft; }


   public void setRight (TreeNode newRight) { right = newRight; }
 }


 private void recInsertItem (TreeNode current, TreeNode toInsert, String code)
 {   
   if (code.charAt(0) == '.') {//if first char of code is . goes left
     if (current.left == null) {//if null, adds to tree, otherwise moves on recursivly
       current.left = toInsert;
       return;
     }
     else 
       recInsertItem (current.left, toInsert, code.substring(1));
   }
   else if (code.charAt(0) == '-')//if first char of code is - goes right
   {
     if (current.right == null) {//if null, adds to tree, otherwise moves on recursivly
       current.right = toInsert;
       return;
     }
     else recInsertItem(current.right, toInsert, code.substring(1));
   }
 }


 public void InsertItem(char letter, String code) //takes in letter and location(code)
 {
   // TreeNode temp = new TreeNode (item);
   if (root == null) {
     root = new TreeNode('&'); //placeholder in root
     //return;
   }
  recInsertItem (root, new TreeNode(letter), code); //runs recursive with root
 }


 public void InOrder() { InOrder(root); }


 private void InOrder (TreeNode toStart)
 {
   if (toStart != null) {
     if (toStart.left != null)
       InOrder(toStart.left);
    
     System.out.print((char)toStart.value);//modified to print correctly


     if (toStart.right != null)
       InOrder(toStart.right);
   }
 }


 public void PreOrder() { PreOrder(root); }


 private void PreOrder(TreeNode toStart)
 {
   if (toStart != null)
   {
     System.out.print((char)toStart.value);
    
     if (toStart.left != null)
       PreOrder(toStart.left);
     if (toStart.right != null)
       PreOrder(toStart.right);
   }
 }
  public void PostOrder() { PostOrder(root); }


 private void PostOrder(TreeNode toStart)
 {
   if (toStart != null)
   {
     if (toStart.left != null)
       PostOrder(toStart.left);
     if (toStart.right != null)
       PostOrder(toStart.right);
    
     System.out.print((char)toStart.value);
   }
 }


 public boolean isThere (int toFind)
 {
   TreeNode current = root;
   boolean bFound = ( (root != null) && current.value == toFind);


   while (current != null && !bFound)
   {
     if (current.value < toFind)
       current = current.right;
     else
       current = current.left;
     bFound = ( (current != null) && current.value == toFind);
   }


   return bFound;
 }


 private int minValue(TreeNode tempRoot)
 {
   int iMin = tempRoot.value;
   while (tempRoot.left != null)
   {
     iMin = tempRoot.left.value;
     tempRoot = tempRoot.left;
   }
   return iMin;
 }
///////////////////////////////////////////////////

 private char recGetLetter (TreeNode current, String code)
 { 
   if (code.equals("")){//if string is empty, location is found
     return current.value;//returns char
   }
   if (code.charAt(0) == '.') {//moves left
       return recGetLetter (current.left, code.substring(1));
        
   }
   else //moves right
   {
     return recGetLetter(current.right,code.substring(1));
     
   }
   
 }


 public char getLetter(String code)//takes in code
 {
   return recGetLetter (root, code);//runs recursive with root
 } 
}





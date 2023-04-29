package easy;

//Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
      val = x;
      next = null;
  }
}

public class Easy160 {

    // Solution that does not compare len
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // If either null return null
        ListNode a = headA;
        ListNode b = headB;

        // iterate throuhg both, join the start of the next list if null
        // At some point both will intersect or be null
        while(a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;

    }


    // Soluton which compares len
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        if(headA==headB) return headA;

        // Get lengths of both linked lists
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        // Iterate through the shorter list until same starting point
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }

        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }

        // Check for match
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public static int getLength(ListNode n){

        int counter = 0;
        while(n != null){
            n = n.next;
            counter++;
        }

        return counter;
    }


    public static void main(String[] args) {
// Create two linked lists that intersect at node with value 5
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

// List 1: 1 -> 2 -> 3 -> 5 -> 6 -> 7 -> null
        node1.next = node2;
        node2.next = node3;
        node3.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

// List 2: 4 -> 5 -> 6 -> 7 -> null
        node4.next = node5;

        // Test your getIntersectionNode method
        Easy160 easy = new Easy160();
        ListNode result = easy.getIntersectionNode(node1, node4);
        if (result == null) {
            System.out.println("No intersection found");
        } else {
            System.out.println("Intersection found at node with value " + result.val);
        }
    }

}

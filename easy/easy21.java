package easy;


public class easy21 {

    // With recursion
    public static ListNode mergeTwoListsRec(ListNode list1, ListNode list2) {

        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode nextNewNode;

        if(list1.val < list2.val){
            nextNewNode = list1;
            nextNewNode.next = mergeTwoListsRec(list1.next, list2);
        } else {
            nextNewNode = list2;
            nextNewNode.next = mergeTwoListsRec(list1, list2.next);
        }

        return nextNewNode;
    }

    // With iteration
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode newListHead = new ListNode(0);
        ListNode newNextNode = newListHead;


        // While neither of the lists is null pop the smallest head
        while(list1 != null && list2 != null){
            if (list1.val <= list2.val) {
                newNextNode.next = list1;
                list1 = list1.next;
            } else {
                newNextNode.next = list2;
                list2 = list2.next;
            }
            newNextNode = newNextNode.next;
        }

        // If either list is now null add the other list and return
        if(list1 == null) newNextNode.next = list2;
        if(list2 == null) newNextNode.next = list1;
        return newListHead.next;

    }

    public static void main(String[] args) {

        System.out.println("Starting...");
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;

        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(4);
        ListNode n9 = new ListNode(4);
        n7.next = n8;
        n8.next = n9;

        ListNode result = mergeTwoListsRec(n1, n7);
        while(result != null){
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println("\nFinished...");

    }

}

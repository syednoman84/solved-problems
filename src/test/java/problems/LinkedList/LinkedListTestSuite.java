package problems.LinkedList;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    ReverseLinkedListTest.class,
    MergeTwoLinkedListTest.class,
    AddTwoNumbersTest.class,
    ReorderListTest.class,
    RemoveNthNodeFromEndOfTheListTest.class,
    CopyListWithRandomPointerTest.class,
    LinkedListCycleTest.class,
    FindDuplicateNumberTest.class,
    LRUCacheTest.class,
    MergeKSortedListsTest.class,
    ReverseNodesInKGroupTest.class
})
public class LinkedListTestSuite {
}
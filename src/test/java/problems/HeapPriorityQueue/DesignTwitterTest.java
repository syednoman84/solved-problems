package problems.HeapPriorityQueue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

class DesignTwitterTest {

    @Test
    void testDesignTwitter() {
        // Test case 1: Basic functionality
        DesignTwitter twitter1 = new DesignTwitter();
        twitter1.postTweet(1, 5);
        List<Integer> feed1 = twitter1.getNewsFeed(1);
        assertEquals(Arrays.asList(5), feed1);
        
        twitter1.follow(1, 2);
        twitter1.postTweet(2, 6);
        List<Integer> feed2 = twitter1.getNewsFeed(1);
        assertEquals(Arrays.asList(6, 5), feed2);
        
        twitter1.unfollow(1, 2);
        List<Integer> feed3 = twitter1.getNewsFeed(1);
        assertEquals(Arrays.asList(5), feed3);
        
        // Test case 2: Multiple users and tweets
        DesignTwitter twitter2 = new DesignTwitter();
        twitter2.postTweet(1, 1);
        twitter2.postTweet(2, 2);
        twitter2.postTweet(1, 3);
        
        List<Integer> feed4 = twitter2.getNewsFeed(1);
        assertEquals(Arrays.asList(3, 1), feed4);
        
        twitter2.follow(1, 2);
        List<Integer> feed5 = twitter2.getNewsFeed(1);
        assertEquals(Arrays.asList(3, 2, 1), feed5);
        
        // Test case 3: No tweets
        DesignTwitter twitter3 = new DesignTwitter();
        List<Integer> feed6 = twitter3.getNewsFeed(1);
        assertTrue(feed6.isEmpty());
        
        // Test case 4: Self-following
        DesignTwitter twitter4 = new DesignTwitter();
        twitter4.postTweet(1, 10);
        twitter4.follow(1, 1);
        List<Integer> feed7 = twitter4.getNewsFeed(1);
        assertEquals(Arrays.asList(10), feed7);
        
        // Test case 5: Multiple follows and unfollows
        DesignTwitter twitter5 = new DesignTwitter();
        twitter5.postTweet(1, 1);
        twitter5.postTweet(2, 2);
        twitter5.postTweet(3, 3);
        
        twitter5.follow(1, 2);
        twitter5.follow(1, 3);
        
        List<Integer> feed8 = twitter5.getNewsFeed(1);
        assertEquals(3, feed8.size());
        assertTrue(feed8.contains(1));
        assertTrue(feed8.contains(2));
        assertTrue(feed8.contains(3));
    }
}
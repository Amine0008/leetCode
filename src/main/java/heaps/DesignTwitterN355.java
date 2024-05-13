package heaps;

import java.lang.reflect.Array;
import java.util.*;

public class DesignTwitterN355 {
     class Tweet {

         int tweetid;
         int time;
         public Tweet(int time, int tweetid) {
             this.time = time;
             this.tweetid = tweetid;
         }
    }

     class UserInfo {
        Set<Integer> following = new HashSet<>();
        Queue<Tweet> tweets = new LinkedList<>();
    }

    class Twitter {

        Map<Integer, UserInfo> userInfoMap;
        int time;

        public Twitter() {
            userInfoMap = new HashMap<>();
            time = 0;
        }

        public void postTweet(int userId, int tweetId) {
            initializeUser(userId);
            Queue<Tweet> userTweets = userInfoMap.get(userId).tweets;
            if(userTweets.size() == 10)
                userTweets.poll();
            userTweets.add(new Tweet(time, tweetId));
            time++;
        }

        public List<Integer> getNewsFeed(int userId) {
            initializeUser(userId);

            PriorityQueue<Tweet> minHeap = new PriorityQueue<>((a,b)-> a.time - b.time);
            for(int followingId: this.userInfoMap.get(userId).following){
                for(Tweet tweet: this.userInfoMap.get(followingId).tweets){
                    minHeap.add(tweet);
                    if(minHeap.size() > 10)
                        minHeap.poll();
                }
            }
            ArrayList<Integer> newsFeed = new ArrayList<>();
            while(!minHeap.isEmpty()){
                newsFeed.add(minHeap.remove().tweetid);
            }
            Collections.reverse(newsFeed);;
            return newsFeed;
        }

        public void follow(int followerId, int followeeId) {
            initializeUser(followerId);
            initializeUser(followeeId);

            this.userInfoMap.get(followerId).following.add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            initializeUser(followerId);
            initializeUser(followeeId);
            this.userInfoMap.get(followerId).following.remove(followeeId);
        }

        private void initializeUser(int userId) {
            if(!userInfoMap.containsKey(userId)){
                userInfoMap.put(userId, new UserInfo());
                userInfoMap.get(userId).following.add(userId);
            }
        }
    }


}

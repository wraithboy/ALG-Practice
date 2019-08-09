package string;

// We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order and no URL was visited more than once per person.

// Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

// Sample input:

// user0 = ["/start.html", "/pink.php", "/register.asp", "/orange.html", "/red.html"]
// user1 = ["/start.html", "/green.html", "/blue.html", "/pink.php", "/register.asp", "/orange.html"]
// user2 = ["/red.html", "/green.html", "/blue.html", "/pink.php", "/register.asp"]
// user3 = ["/blue.html", "/logout.php"]

// Sample output:

// findContiguousHistory(user0, user1)
//    /pink.php
//    /register.asp
//    /orange.html

// findContiguousHistory(user1, user2)
//    /green.html
//    /blue.html
//    /pink.php
//    /register.asp

// findContiguousHistory(user0, user3)
//    (empty)

// findContiguousHistory(user2, user3)
//    /blue.html

// findContiguousHistory(user3, user3)
//    /blue.html
//    /logout.php



import java.io.*;
import java.util.*;


class Solution {
    public static void main(String[] args) {
        List<String> user0 = Arrays.asList("/start.html", "/pink.php", "/register.asp", "/orange.html", "/red.html");
        List<String> user1 = Arrays.asList("/start.html", "/green.html", "/blue.html", "/pink.php", "/register.asp", "/orange.html");
        List<String> user2 = Arrays.asList("/red.html", "/green.html", "/blue.html", "/pink.php", "/register.asp");
        List<String> user3 = Arrays.asList("/blue.html", "/logout.php");

    }

    public List<String> findContiguousHistory(List<String> user1,List<String> user2) {
            return null;
    }

}
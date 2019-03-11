package implementation;

//Given two strings s and t, write a function to determine if t is an anagram of s.

//For example,
//s = "anagram", t = "nagaram", return true.
//s = "rat", t = "car", return false.
//You may assume the string contains only lowercase alphabets.
public class ValidAnagram {
	
	public static void main(String args[])
	{
		System.out.println(isAnagram("dafd","adf"));
	}
	
	public static boolean isAnagram(String s, String t)
	{
		  if(s.length()!=t.length()){
	            return false;
	        }
	        int[] count = new int[26];
	        for(int i=0;i<s.length();i++){
	            count[s.charAt(i)-'a']++;
	            count[t.charAt(i)-'a']--;
	        }
	        for(int i:count){
	            if(i!=0){
	                return false;
	            }
	        }
	        return true;
	}
	
}

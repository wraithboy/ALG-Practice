package amazonOA;

import java.util.*;

public class FavouriteGenres {

    /**
     * Time Complexity: O(u * s) where u is number of users and s is the number of songs
     * Space Complexity: O(s) where s is the number of songs in the list
     */
    public Map<String, List<String>> getFavouriteGenres(
            Map<String, List<String>> userSongs,
            Map<String, List<String>> songGenres) {

        Map<String,List<String>> result = new HashMap<>();

        Map<String,String> songToGenMap = new HashMap<>();

        songGenres.forEach((genres,songs)->songs.forEach(song->songToGenMap.put(song,genres)));

        for(String user : userSongs.keySet())
        {
            Map<String,Integer> count = new HashMap<>();

            int max = 0;

            result.put(user,new ArrayList<>());

            List<String> songs = userSongs.get(user);

            for(String song: songs)
            {
                if(songToGenMap.containsKey(song))
                {
                    String genre = songToGenMap.get(song);
                    int cnt=count.getOrDefault(genre,0)+1;
                    count.put(genre,cnt);
                    max=Math.max(max,cnt);
                }
            }

            for(String genre: count.keySet())
            {
                if(count.get(genre)==max)
                {
                    result.get(user).add(genre);
                }
            }
        }

        return result;
    }

    /*Test Cases*/
    public static void main(String[] args) {
        /* User has more than one favourite genre */
        Map<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

        Map<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep", Collections.singletonList("song7"));
        songGenres.put("Techno", Arrays.asList("song2", "song4"));
        songGenres.put("Pop", Arrays.asList("song5", "song6"));
        songGenres.put("Jazz", Arrays.asList("song8", "song9"));
        System.out.println(new FavouriteGenres().getFavouriteGenres(userSongs, songGenres));

        /* User has only one favourite genre */
        userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8", "song10"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

        songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList("song1", "song3", "song10"));
        songGenres.put("Dubstep", Collections.singletonList("song7"));
        songGenres.put("Techno", Arrays.asList("song2", "song4"));
        songGenres.put("Pop", Arrays.asList("song5", "song6"));
        songGenres.put("Jazz", Arrays.asList("song8", "song9"));
        System.out.println(new FavouriteGenres().getFavouriteGenres(userSongs, songGenres));

        /* When there is no genre info */
        userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2"));
        userSongs.put("Emma", Arrays.asList("song3", "song4"));
        System.out.println(new FavouriteGenres().getFavouriteGenres(userSongs, Collections.emptyMap()));

        /* When there are no song and genre info */
        System.out.println(new FavouriteGenres().getFavouriteGenres(Collections.emptyMap(), Collections.emptyMap()));
    }


}

package unionfind;

import java.util.*;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String,String> root = new HashMap<>();
        Map<String,String> emailToName=new HashMap<>();


        for(List<String> account:accounts)
        {
            String name = account.get(0);

            for(int i=1;i<account.size();i++)
            {
                root.put(account.get(i),account.get(i));
                emailToName.put(account.get(i),name);
            }
        }

        for(List<String> account:accounts)
        {
            String parent = find(account.get(1),root);

            for(int i=2;i<account.size();i++)
            {
                root.put(root.get(find(account.get(i),root)),parent);
            }
        }

        Map<String, TreeSet<String>> unions=new HashMap<>();

        for(List<String> account:accounts)
        {
            String parent = find(account.get(1),root);
            for(int i=1;i<account.size();i++)
            {
                if(!unions.containsKey(parent))
                {
                    unions.put(parent,new TreeSet<String>());
                }

                unions.get(parent).add((account.get(i)));
            }
        }

        List<List<String>> result = new ArrayList<>();

        for(String key:unions.keySet())
        {
            List<String> list = new ArrayList<>(unions.get(key));
            list.add(0,emailToName.get(key));
            result.add(list);
        }

        return result;

    }


    private String find(String email,Map<String,String> root)
    {
        if(email==null || email.length()==0)
            return null;

        String parent=root.get(email);

        if(parent.equals(email))
        {
            return parent;
        }
        else
        {
            return find(parent,root);
        }
    }

}

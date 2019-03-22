package graph;

import java.util.*;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        List<List<String>> result = new ArrayList<List<String>>();

        if(accounts==null || accounts.size()==0)
            return result;

        Map<String, ArrayList<String>> graph = new HashMap<>();
        Map<String,String> emailToName = new HashMap<>();

        buildGraph(graph,emailToName,accounts);

        //DFS
        Set<String> visited = new HashSet<>();

        for(String email:emailToName.keySet()) {
            if (!visited.contains(email)) {
                visited.add(email);
                Stack<String> stack = new Stack<>();
                stack.push(email);
                List<String> list = new ArrayList<>();
                while (!stack.isEmpty()) {
                    String cur = stack.pop();
                    list.add(cur);
                    visited.add(cur);
                    for (String nei : graph.get(cur)) {
                        if (!visited.contains(nei)) {
                            stack.push(nei);
                        }
                    }
                }

                Collections.sort(list);
                list.add(0, emailToName.get(email));
                result.add(list);
            }
        }
        return result;
    }

    private void buildGraph(Map<String, ArrayList<String>> graph,Map<String,String> emailToName,List<List<String>> accounts)
    {
        for(List<String> account: accounts)
        {
            String name=account.get(0);

            for(int i=1;i<account.size();i++)
            {
                String email = account.get(i);
                emailToName.put(email,name);

                graph.putIfAbsent(email,new ArrayList<>());

                if(i==1)
                    continue;
                graph.get(email).add(account.get(1));
                graph.get(account.get(1)).add(email);
            }
        }
    }

}

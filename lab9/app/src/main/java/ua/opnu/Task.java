package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i+1 < list.size(); i++) {
            if (list.get(i).length() <= list.get(i+1).length()) {
                list.remove(i);
            } else {
                list.remove(i+1);
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i+=2) {
            list.add(i,list.get(i));
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i+1 < list.size(); i+=2) {
            String temp = list.get(i);
            list.set(i,list.get(i+1));
            list.set(i+1,temp);
        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i-1))) {
                list.remove(i);
                i--;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length()==4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        Deque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            Integer value = queue.remove();
            stack.push(value);
            queue.add(value);
        }

        boolean result = true;

        for (int i = 0; i < size; i++) {
            Integer value = queue.remove();

            if (!value.equals(stack.pop())) {
                result=false;
            }

            queue.add(value);
        }

        return result;
    }

    public void reorder(Queue<Integer> queue) {
        Deque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        int positiveCount=0;

        for (int i = 0; i < size; i++) {
            int value = queue.remove();

            if (value<0) {
                stack.push(value);
            } else {
                queue.add(value);
                positiveCount++;
            }
        }

        for (int i = 0; i < positiveCount; i++) {
            stack.addLast(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        Deque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        int oddCount = 0;

        for (int i = 0; i < size; i++) {
            int value = queue.remove();

            if (value%2==0) {
                queue.add(value);
            } else {
                stack.push(value);
                oddCount++;
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.removeLast());
        }
    }

    public int maxLength(Set<String> set) {
        int max = 0;

        for (String value : set) {
            max = Math.max(max, value.length());
        }

        return max;
    }

    public void removeEvenLength(Set<String> set) {
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().length()%2 == 0) {
                iterator.remove();
            }
        }
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> common = new HashSet<>(list1);
        common.retainAll(list2);

        return common.size();
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<>();

        for (String value : map.values()) {
            if (!values.add(value)) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String,Integer> result = new HashMap<>();

        for (String key : map1.keySet()) {
            if (map2.containsKey(key) && Objects.equals(map1.get(key),map2.get(key))) {
                result.put(key,map1.get(key));
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public int rarest(Map<String, Integer> map) {
        Map<Integer,Integer> counts = new HashMap<>();

        for (Integer value : map.values()) {
            counts.put(value, counts.getOrDefault(value,0)+1);
        }

        int result = 0;
        int minCount = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            if (count < minCount || (count == minCount && value<result)) {
                minCount = count;
                result = value;
            }
        }
        return result;
    }

    public int maxOccurrences(List<Integer> list) {
        Map<Integer, Integer> counts = new HashMap<>();
        int max = 0;

        for (Integer value : list) {
            int count = counts.getOrDefault(value,0)+1;
            counts.put(value,count);
            max=Math.max(max,count);
        }
        return max;
    }

}

package com.anilstack.ds.graph;

import java.util.*;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class CourseScheduleII {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] courses = {
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i=0; i < numCourses; i++) {
            map.put(i,new HashSet<>());
        }

        for (int[] prereq:prerequisites) {
            int course = prereq[0];
            int dependingCourse = prereq[1];
            // forming a edge from dependingcourse towards the current course.
            map.get(dependingCourse).add(course);
            indegree[course]++;
        }
        //courseIds
        Queue<Integer> qu = new LinkedList<>();
        for (int i=0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                qu.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!qu.isEmpty()) {
            int size = qu.size();
            while (size-- > 0) {
                int head = qu.poll();
                if (indegree[head] == 0) {
                    order.add(head);
                }
            }
        }
return indegree;
    }


}

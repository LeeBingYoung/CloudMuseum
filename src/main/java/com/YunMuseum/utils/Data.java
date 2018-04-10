package com.YunMuseum.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
//协同过滤推荐算法
public class Data {
    static String[] types = new String[10];
    static String[] users = new String[50];
    static Map score = new HashMap();
    static Set userSet = new HashSet();
    static Set typeSet = new HashSet();
    static {
        for (String str : Data.users) {
            userSet.add(str);
        }
        for (String str : Data.types) {
            typeSet.add(str);
        }
        score = getScore();
    }

    public static void outNearbyUserList(String user) {
        Map scores = new HashMap();
        for (String tempUser : users) {
            if (tempUser.equalsIgnoreCase(user)) {
                continue;
            }
            double score = getOSScore(user, tempUser);
            scores.put(tempUser, score);
        }
        System.out.println(scores.toString());
    }

    private static Double getOSScore(String user1, String user2) {
        HashMap user1Score = (HashMap) score.get(user1);
        HashMap user2Score = (HashMap) score.get(user2);
        double totalscore = 0.0;
        Iterator it = user1Score.keySet().iterator();
        while (it.hasNext()) {
            String film = (String) it.next();
            int a1 = (Integer) user1Score.get(film);
            int a2 = (Integer) user1Score.get(film);
            int b1 = (Integer) user2Score.get(film);
            int b2 = (Integer) user2Score.get(film);
            int a = a1 * a2 - b1 * b2;
            //System.out.println(Math.abs(a));
            totalscore += Math.sqrt(Math.abs(a));
        }
        return totalscore;
    }

    private static Map getScore() {
        int i = 1;
        Map score = new HashMap();
        // aaa
        while (i <= 50){
            HashMap tempScore = new HashMap();
            for (int j = 0;j <= 4;j++){
                tempScore.put(types[j],2);
            }
            score.put(Data.users[i],tempScore);
            i++;
        }
        return score;
    }
}

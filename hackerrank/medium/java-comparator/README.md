# Java Comparator

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Comparators are used to compare two objects. In this challenge, you'll create a comparator and use it to sort an array.

The *Player* class is provided for you in your editor. It has $2$ fields: a $name$ String and a $score$ integer.

Given an array of $n$ *Player* objects, write a comparator that sorts them in order of decreasing score; if $2$ or more players have the same score, sort those players alphabetically by name. To do this, you must create a *Checker* class that implements the *Comparator* interface, then write an *int compare(Player a, Player b)* method implementing the [Comparator.compare(T o1, T o2)](https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html#compare(T,%20T)) method.

**Input Format**

Input from stdin is handled by the locked stub code in the *Solution* class.	

The first line contains an integer, $n$, denoting the number of players. 	
Each of the $n$ subsequent lines contains a player's $name$ and $score$, respectively.

**Constraints**

- $0 \le score \le 1000$
- $2$ players can have the same name.
- Player names consist of lowercase English letters.

**Output Format**

You are not responsible for printing any output to stdout. The locked stub code in *Solution* will create a *Checker* object, use it to sort the *Player* array, and print each sorted element.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-15T04:25:02.409Z  

```java
import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {

        // Higher score comes first
        if (a.score != b.score) {
            return b.score - a.score;
        }

        // If scores are equal, alphabetical order
        return a.name.compareTo(b.name);
    }
}

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();

            players[i] = new Player(name, score);
        }

        Arrays.sort(players, new Checker());

        for (Player player : players) {
            System.out.println(player.name + " " + player.score);
        }

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-comparator/problem)
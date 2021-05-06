package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        Zerg zerg1=new Zerg();
        zerg1.name="vad";
        Zerg zerg2=new Zerg();
        zerg2.name="dim";
        Zerg zerg3=new Zerg();
        zerg3.name="alex";
        Zerg zerg4=new Zerg();
        zerg4.name="alexa";
        Zerg zerg5=new Zerg();
        zerg5.name="dima";

        Protoss protoss1=new Protoss();
        protoss1.name="winter";
        Protoss protoss2=new Protoss();
        protoss2.name="spring";
        Protoss protoss3=new Protoss();
        protoss3.name="summer";

        Terran terran1=new Terran();
        terran1.name="luk";
        Terran terran2=new Terran();
        terran2.name="luka";
        Terran terran3=new Terran();
        terran3.name="lukash";
        Terran terran4=new Terran();
        terran4.name="lukashenka";//напишите тут ваш код

    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}

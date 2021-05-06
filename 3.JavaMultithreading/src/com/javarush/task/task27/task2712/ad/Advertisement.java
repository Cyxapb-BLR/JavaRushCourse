package com.javarush.task.task27.task2712.ad;

public class Advertisement implements Comparable<Advertisement> {
    private Object content;         //видео
    private String name;             //имя/название
    private long initialAmount;     //начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private int hits;                //количество оплаченных показов
    private int duration;            //продолжительность в секундах
    long amountPerOneDisplaying;

    public int getHits() {
        return hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if (hits > 0)
            this.amountPerOneDisplaying = initialAmount / hits;
    }

    public void revalidate() {
        if (hits <= 0)
            throw new UnsupportedOperationException();
        hits--;
    }

    @Override
    public int compareTo(Advertisement o) {
        long amountDifference = o.amountPerOneDisplaying - this.amountPerOneDisplaying;
        if (amountDifference != 0)
            return (int) amountDifference;
        else {
            // return o.duration - this.duration;
            int durationDifference = o.duration - this.duration;
            if (durationDifference != 0)
                return durationDifference;
            else return this.hits - o.hits;
        }
    }

    @Override
    public String toString() {
        return name + " is displaying... " + amountPerOneDisplaying + ", " + amountPerOneDisplaying * 1000 / duration;
        //return String.format("%s is displaying... %d, %d", name, amountPerOneDisplaying, amountPerOneDisplaying * 1000 / duration);

    }
}

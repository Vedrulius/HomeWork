package com.mihey.homework.interfaces;

interface Flying{
    int getMaxHeight();
    default int getDefaultHeigth(){
        return 1000;
    }

}

interface Diving{
    int getMaxDepth();
}

interface Launchable extends Flying{
static String getDefault() {
    return "It did not take off";
}
}

class Airplane implements Flying{
    @Override
    public int getMaxHeight() {
        return 10_000;
    }
}

class Whale implements Diving{
    @Override
    public int getMaxDepth() {
        return 2900;
    }
}

class FlyingFish implements Flying, Diving{

    @Override
    public int getMaxHeight() {
        return 5;
    }

    @Override
    public int getMaxDepth() {
        return 100;

    }
}
class Info{
    public static void main(String[] args) {
        Airplane a=new Airplane();
        Whale w=new Whale();
        System.out.println("Maximum fly height og airplane: "+a.getMaxHeight()+" meters.");
        System.out.println("Maximum whale immersion depth: "+w.getMaxDepth()+"meters.");
        System.out.println(Launchable.getDefault());
        System.out.println("Default heigth: "+a.getDefaultHeigth());
    }
}
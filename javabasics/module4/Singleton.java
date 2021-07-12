package javabasics.module4;

/*
 * @author db-ss
 * @email daniel.brashaw@smoothstack.com
**/

public class Singleton {

    private static volatile Singleton singleton = null;

    public Singleton getInstance() {
        if (singleton == null) {
            synchronized (this) {
                if (singleton == null)
                    singleton = new Singleton();
            }
        }
        return singleton;
    }
}
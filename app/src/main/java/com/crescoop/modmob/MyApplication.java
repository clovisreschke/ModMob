package com.crescoop.modmob;

import android.app.Application;
import android.content.res.Configuration;

import java.net.InetAddress;

public class MyApplication extends Application{

    private static final String TAG = "Singleton";
    private static MyApplication singleton = null;
    private InetAddress addr = null;
    private int port;
    private int slave_id;
    private int timeout;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public synchronized static MyApplication getInstance() {
        if (singleton == null) {
            singleton = new MyApplication();
        }
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public InetAddress getAddr() {
        return addr;
    }

    public void setAddr(InetAddress addr) {
        this.addr = addr;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getSlave_id() {
        return slave_id;
    }

    public void setSlave_id(int slave_id) {
        this.slave_id = slave_id;
    }

    public static MyApplication getSingleton() {
        return singleton;
    }

    public static void setSingleton(MyApplication singleton) {
        MyApplication.singleton = singleton;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getConfiguration(){

         return this.addr.toString()+"\n"+this.timeout+"\n"+this.port+"\n"+this.slave_id;

    }
}

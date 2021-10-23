package com.company;

import java.io.FileNotFoundException;

public abstract class Filter {
    public Pipe in;
    public Pipe out;
    public boolean is_start = false;

    public Filter(Pipe in, Pipe out) {
        this.in = in;
        this.out = out;
    }

    public void start() {
        if (!is_start) {
            is_start = true;
            final Thread thread = new Thread((Runnable) this);
        }
    }

    public void stop() {
        is_start = false;
    }

    public void run() {
        try {
            transform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    abstract protected void transform() throws Exception;
}

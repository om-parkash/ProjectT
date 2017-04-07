package com.nagarro.nagp.t;

import com.nagarro.nagp.q.QType;
import com.nagarro.nagp.r.RType;
import com.nagarro.nagp.s.SType;

public class TType {

    public void print() {
        System.out.println("TType");
        QType qType = new QType();
        qType.print();
        RType rType = new RType();
        rType.print();
        SType sType = new SType();
        sType.print();
    }
}

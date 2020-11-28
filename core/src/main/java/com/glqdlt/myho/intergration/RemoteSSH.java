package com.glqdlt.myho.intergration;

import com.jcraft.jsch.Session;

public interface RemoteSSH {
    Session getSession();
}

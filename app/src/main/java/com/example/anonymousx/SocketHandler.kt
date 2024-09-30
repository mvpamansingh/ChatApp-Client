package com.example.anonymousx

import io.socket.client.IO
import io.socket.client.Socket

class SocketHandler {

    private var socket :Socket = IO.socket("http://192.168.1.5:3000/")

    init {
        socket.connect()
    }
}

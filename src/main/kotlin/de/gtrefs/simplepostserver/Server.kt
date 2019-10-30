package de.gtrefs.simplepostserver

import org.http4k.core.Method
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Jetty
import org.http4k.server.asServer

fun main() {
    routes(
            "/" bind Method.POST to {
                println(it.toMessage())
                Response(OK)
            }
    ).asServer(Jetty(9000)).start()
}

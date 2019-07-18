import org.http4k.core.*
import org.http4k.server.Netty
import org.http4k.server.asServer

fun main() {

    val app: HttpHandler = { request: Request -> Response(Status.OK).body("Hello, ${request.query("name")}!") }

    app.asServer(Netty(9000)).start()
}

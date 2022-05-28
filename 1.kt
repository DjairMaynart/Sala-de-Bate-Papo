import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.request.*

fun main() {
    embeddedServer(Netty, port = 7654){
        routing{
            get("/teste.text"){
                call.respondText("testando")
            }
        }
    }.start(wait=true)
}

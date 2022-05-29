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
import java.io.*
import kotlin.io.*


class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {

    embeddedServer(Netty, port = 7654){
        routing{
                get("/"){
            
                call.respondText("""
                
                <html>
                <head>
                    <title>Minha 1ª página html</title> 
                </head>

                 <input type="text" size="100" placeholder="Insira seu texto" name="texto">
                 <input type="button" value="Enviar" name="botao"><br><br>
                 <button>ola</button>
                 </form>

                </html>

                
                                
                """,ContentType.Text.Html)
                val x = call.parameters["texto"]
            }
            static("/estatico/"){
                files("static/")
            }
        }
    }.start(wait=true)
}

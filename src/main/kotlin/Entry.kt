import java.nio.file.FileSystems
import java.nio.file.Files
import java.sql.Connection
import java.sql.DriverManager

fun main(args: Array<String>) {
    loadConfig()

    val sqlConnection = DriverManager.getConnection("jdbc:h2:mem:tack;DB_CLOSE_DELAY=-1")
}
import java.nio.file.FileSystems
import java.nio.file.Files

enum class ProjectLocationType {
    EXTERNAL,
    CONTAINED
}

fun loadConfig() {
    val configDirectory = "${System.getProperty("user.home")}\\.tack"
    val configPath = FileSystems.getDefault().getPath(configDirectory)

    println("$configDirectory -> exists? ${Files.exists(configPath)}")

    if (!Files.exists(configPath)) {
        Files.createDirectory(configPath)
    }

    val configFilePath = configPath.resolve("tackConfig.yaml")

    println("${configFilePath.toUri().path} -> exists? ${Files.exists(configFilePath)}")

    if (!Files.exists(configFilePath)) {
        Files.createFile(configFilePath)
    }
}

class Project(
        var locationType: ProjectLocationType,
        var projectId: String,
        var projectName: String,
        var projectDirectory: String
)

object AppConfig {
    var externalProjects = mutableListOf<Project>()
    var containedProjects = mutableListOf<Project>()

    fun hydrateConfig() {

    }
}
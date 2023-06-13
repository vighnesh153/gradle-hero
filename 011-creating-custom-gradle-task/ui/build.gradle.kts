import org.gradle.internal.enterprise.test.FileProperty
import com.vighnesh153.pokemon.FileDiffTask

plugins {
  `java-library`

  id("pokemon-conventions")
}


tasks.register<FileDiffTask>("fileDiff") {
  file1.set(project.file("src/main/resources/static/images/pikachu.png"))
  file2.set(project.file("src/main/resources/static/images/chikorita.png"))
}

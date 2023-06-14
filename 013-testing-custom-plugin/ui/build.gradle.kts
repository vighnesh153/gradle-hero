plugins {
    `java-library`

    id("pokemon-conventions")
    id("fileDiffPlugin")
}

fileDiff {
    file1.set(project.file("src/main/resources/static/images/pikachu.png"))
    file2.set(project.file("src/main/resources/static/images/treecko.png"))
}
